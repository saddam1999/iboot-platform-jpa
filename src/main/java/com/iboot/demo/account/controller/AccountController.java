package com.iboot.demo.account.controller;

import com.iboot.demo.account.domain.Account;
import com.iboot.demo.account.repository.AccountRepository;
import com.iboot.demo.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/role")
public class AccountController {

  @Autowired
  private AccountService accountService;

  @PostMapping()
  public Account save(@RequestBody Account account) {
    return accountService.save(account);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") String accountId) {
    accountService.deleteById(accountId);
  }

  @PutMapping("/{id}")
  public Account update(@PathVariable("id") String accountId, @RequestBody Account account) {
    account.setId(accountId);
    return accountService.saveAndFlush(account);
  }

  @GetMapping("/{id}")
  public Account getAccountInfo(@PathVariable("id") String accountId) {
    Optional<Account> optional = accountService.findById(accountId);
    return optional.orElseGet(Account::new); //找不到就返回新物件
  }

  @GetMapping("/name/{username}")
  public Account getAccountByName(@PathVariable("username") String userName){
    Account account = accountService.findAccountByUsername(userName);
    return account;
  }

  @GetMapping("/sql/{username}")
  public Account findAccountByName(@PathVariable("username") String userName){
    Account account = accountService.findAccountByName(userName);
    return account;
  }

  @GetMapping("/email/{email}")
  public Account findAccountByEmail(@PathVariable("email") String email){
    Account account = accountService.findAccountByEmail(email);
    return account;
  }

  @GetMapping("/username/{username}")
  public Account getAccount(@PathVariable("username") String username){
    Account account = accountService.getAccount(username);
    return account;
  }
}