package com.iboot.demo.account.controller;

import com.iboot.demo.account.domain.AccountDemo;
import com.iboot.demo.account.service.AccountDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/demo/role")
public class AccountDemoController {

  @Autowired
  private AccountDemoService accountDemoService;

  @PostMapping()
  public AccountDemo save(@RequestBody AccountDemo accountDemo) {
    return accountDemoService.save(accountDemo);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") String accountId) {
    accountDemoService.deleteById(accountId);
  }

  @PutMapping("/{id}")
  public AccountDemo update(@PathVariable("id") String accountId, @RequestBody AccountDemo accountDemo) {
    accountDemo.setId(accountId);
    return accountDemoService.saveAndFlush(accountDemo);
  }


  @GetMapping("/list")
  public List<AccountDemo> getAccountList(){
    return accountDemoService.findAll();
  }

  @GetMapping("/{id}")
  public AccountDemo getAccountInfo(@PathVariable("id") String accountId) {
    Optional<AccountDemo> optional = accountDemoService.findById(accountId);
    return optional.orElseGet(AccountDemo::new); //找不到就返回新物件
  }

  @GetMapping("/name/{username}")
  public AccountDemo getAccountByName(@PathVariable("username") String userName){
    AccountDemo accountDemo = accountDemoService.findAccountByUsername(userName);
    return accountDemo;
  }

  @GetMapping("/sql/{username}")
  public AccountDemo findAccountByName(@PathVariable("username") String userName){
    AccountDemo accountDemo = accountDemoService.findAccountByName(userName);
    return accountDemo;
  }

  @GetMapping("/email/{email}")
  public AccountDemo findAccountByEmail(@PathVariable("email") String email){
    AccountDemo accountDemo = accountDemoService.findAccountByEmail(email);
    return accountDemo;
  }

  @GetMapping("/username/{username}")
  public AccountDemo getAccount(@PathVariable("username") String username){
    AccountDemo accountDemo = accountDemoService.getAccount(username);
    return accountDemo;
  }
}