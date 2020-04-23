package com.iboot.core.idgenerator;

import java.util.ArrayList;
import java.util.List;

public class SnowflakeIdWorker2nd {
    /** 開始時間截 (2019-01-01) */
    private final long twepoch = 1587648704967L;

    /** 機器id所佔的位數 */
    private final long workerIdBits = 5L;

    /** 數據標識id所佔的位數 */
    private final long datacenterIdBits = 5L;

    /** 支持的最大機器id，結果是31 (這個移位算法可以很快的計算出幾位二進制數所能表示的最大十進制數) */
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);

    /** 支持的最大數據標識id，結果是31 */
    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);

    /** 序列在id中佔的位數 */
    private final long sequenceBits = 22L;

    /** 機器ID向左移22位 */
    private final long workerIdShift = sequenceBits;

    /** 數據標識id向左移27位(22+5) */
    private final long datacenterIdShift = sequenceBits + workerIdBits;

    /** 時間截向左移32位(5+5+22) */
    private final long timestampLeftShift = sequenceBits + workerIdBits
            + datacenterIdBits;

    /** 生成序列的掩碼，這裡為4194303 */
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    /** 工作機器ID(0~31) */
    private long workerId;

    /** 數據中心ID(0~31) */
    private long datacenterId;

    /** 秒內序列(0~4194303) */
    private long sequence = 0L;

    /** 上次生成ID的時間截 */
    private int lastTimestamp = -1;

    // ==============================Constructors=====================================
    /**
     * 構造函數
     *
     * @param workerId
     *            工作ID (0~31)
     * @param datacenterId
     *            數據中心ID (0~31)
     */
    public SnowflakeIdWorker2nd(long workerId, long datacenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format(
                    "worker Id can't be greater than %d or less than 0",
                    maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format(
                    "datacenter Id can't be greater than %d or less than 0",
                    maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    // ==============================Methods==========================================
    /**
     * 獲得下一個ID (該方法是線程安全的)
     *
     * @return SnowflakeId
     */
    public synchronized long nextId() {
        int timestamp = timeGen();

        // 如果當前時間小於上一次ID生成的時間戳，說明系統時鐘回退過這個時候應當拋出異常
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format(
                    "Clock moved backwards.  Refusing to generate id for %d milliseconds",
                    lastTimestamp - timestamp));
        }

        // 如果是同一時間生成的，則進行秒內序列
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            // 秒內序列溢出
            if (sequence == 0) {
                // 阻塞到下一個秒,獲得新的時間戳
                timestamp = tilNextMillis(lastTimestamp);
            }
        }
        // 時間戳改變，秒內序列重置
        else {
            sequence = 0L;
        }

        // 上次生成ID的時間截
        lastTimestamp = timestamp;

        // 移位並通過或運算拼到一起組成64位的ID
        return ((timestamp - twepoch) << timestampLeftShift) //
                | (datacenterId << datacenterIdShift) //
                | (workerId << workerIdShift) //
                | sequence;
    }

    /**
     * 阻塞到下一個秒，直到獲得新的時間戳
     *
     * @param lastTimestamp
     *            上次生成ID的時間截
     * @return 當前時間戳
     */
    protected int tilNextMillis(int lastTimestamp) {
        int timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 返回以秒為單位的當前時間
     *
     * @return 當前時間(秒)
     */
    protected int timeGen() {
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        return Integer.valueOf(timestamp);
    }

    // ==============================Test=============================================
    /** 測試 */
    public static void main(String[] args) {
        SnowflakeIdWorker2nd idWorker = new SnowflakeIdWorker2nd(0, 0);
        System.out.println(System.currentTimeMillis());
        long start = System.currentTimeMillis();
        int count = 0;
        List<Long> aa = new ArrayList<Long>();
        for (int i = 0; System.currentTimeMillis()-start<1000; i++,count=i) {
            long x = idWorker.nextId();
            System.out.println(x);
        }
        long end = System.currentTimeMillis()-start;
        System.out.println(aa);
        System.out.println(end);
        System.out.println(count);
    }
}
