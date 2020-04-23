package com.iboot.core.idgenerator;

public class SnowflakeIdWorker {
    /** 開始時間截 (這個用自己業務系統上線的時間) */
    private final long twepoch = 1587620333700L;

    /** 機器id所佔的位數 */
    private final long workerIdBits = 10L;

    /** 支持的最大機器id，結果是31 (這個移位算法可以很快的計算出幾位二進制數所能表示的最大十進制數) */
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);

    /** 序列在id中佔的位數 */
    private final long sequenceBits = 12L;

    /** 機器ID向左移12位 */
    private final long workerIdShift = sequenceBits;

    /** 時間截向左移22位(10+12) */
    private final long timestampLeftShift = sequenceBits + workerIdBits;

    /** 生成序列的掩碼，這裡為4095 (0b111111111111=0xfff=4095) */
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    /** 工作機器ID(0~1024) */
    private long workerId;

    /** 毫秒內序列(0~4095) */
    private long sequence = 0L;

    /** 上次生成ID的時間截 */
    private long lastTimestamp = -1L;

    //==============================Constructors=====================================
    /**
     * 構造函數
     * @param workerId 工作ID (0~1024)
     */
    public SnowflakeIdWorker(long workerId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("workerId can't be greater than %d or less than 0", maxWorkerId));
        }
        this.workerId = workerId;
    }

    // ==============================Methods==========================================
    /**
     * 獲得下一個ID (該方法是線程安全的)
     * @return SnowflakeId
     */
    public synchronized long nextId() {
        long timestamp = timeGen();

        //如果當前時間小於上一次ID生成的時間戳，說明系統時鐘回退過這個時候應當拋出異常
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(
                    String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        //如果是同一時間生成的，則進行毫秒內序列
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            //毫秒內序列溢出
            if (sequence == 0) {
                //阻塞到下一個毫秒,獲得新的時間戳
                timestamp = tilNextMillis(lastTimestamp);
            }
        }
        //時間戳改變，毫秒內序列重置
        else {
            sequence = 0L;
        }

        //上次生成ID的時間截
        lastTimestamp = timestamp;

        //移位並通過或運算拼到一起組成64位的ID
        return ((timestamp - twepoch) << timestampLeftShift) //
                | (workerId << workerIdShift) //
                | sequence;
    }

    /**
     * 阻塞到下一個毫秒，直到獲得新的時間戳
     * @param lastTimestamp 上次生成ID的時間截
     * @return 當前時間戳
     */
    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 返回以毫秒為單位的當前時間
     * @return 當前時間(毫秒)
     */
    protected long timeGen() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());

        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(1);

        long start = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; System.currentTimeMillis()-start<1000; i++,count=i) {
            System.out.println(idWorker.nextId());
        }
        long end = System.currentTimeMillis()-start;
        System.out.println(end);
        System.out.println(count);
    }
}
