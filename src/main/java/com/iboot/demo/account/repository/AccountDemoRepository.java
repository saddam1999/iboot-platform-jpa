package com.iboot.demo.account.repository;

import com.iboot.core.repository.BaseRepository;
import com.iboot.demo.account.domain.AccountDemo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDemoRepository extends BaseRepository<AccountDemo,String> {
  /**
   * Spring Data的規範，查詢方法以find | read | get 開頭，涉及條件查詢時，條件的屬性用條件關鍵字連接，
   * 要注意的是：條件屬性以首字母大寫。 比如說現在要按照account的名稱進行查詢
   * @param userName
   * @return
   */
  AccountDemo findAccountByUserName(String userName);

  @Query("select a from AccountDemo a where a.userName = :userName")
  AccountDemo findAccountByName(@Param("userName")String userName);

  @Query("select a from AccountDemo a where a.email = ?1")
  AccountDemo findAccountByEmail(String email);

  @Query(value = "select * from account_demo where username = :userName",nativeQuery = true)
  AccountDemo getAccount(@Param("userName")String userName);

//  @Query(value="select b.username, b.email,"
//      + "from account_demo b order by b.username desc limit :page,:pageSize",nativeQuery=true)
//  public List<Object[]> queryPageData(@Param("page") int page, @Param("pageSize") int pageSize);
}
