package com.iboot.demo.account.repository;

import com.iboot.admin.domain.User;
import com.iboot.core.repository.BaseRepository;
import com.iboot.demo.account.domain.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends BaseRepository<Account,String> {
  /**
   * Spring Data的規範，查詢方法以find | read | get 開頭，涉及條件查詢時，條件的屬性用條件關鍵字連接，
   * 要注意的是：條件屬性以首字母大寫。 比如說現在要按照account的名稱進行查詢
   * @param username
   * @return
   */
  Account findAccountByUsername(String username);

  @Query("select a from Account a where a.username = :username")
  Account findAccountByName(@Param("username")String name);

  @Query("select a from Account a where a.email = ?1")
  Account findAccountByEmail(String email);

  @Query(value = "select * from account where username = ?1",nativeQuery = true)
  Account getAccount(String username);
}
