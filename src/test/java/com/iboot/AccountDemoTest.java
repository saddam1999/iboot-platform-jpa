package com.iboot;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.iboot.demo.account.domain.AccountDemo;
import com.iboot.demo.account.repository.AccountDemoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class AccountDemoTest {
  private static final Logger log = LoggerFactory.getLogger(AccountDemoTest.class);
  private MockMvc mvc;

  @Autowired
  protected WebApplicationContext wac;

  @Autowired
  private AccountDemoRepository accountDemoRepository;

  @Before()  //這個方法在每個方法執行之前都會執行一遍
  public void setup() {
    mvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc對象
  }

  private String toJsonString(Object obj) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
    String requestJson = ow.writeValueAsString(obj);
    return requestJson;
  }

  @Test
  public void add() throws Exception {

    for(int i=1;i<3;i++){
      AccountDemo accountDemo = new AccountDemo();
      accountDemo.setEmail(i+"moder1122@gmail.com");
      accountDemo.setUserName(i+"moder");
      accountDemo.setPassWord(i+"password");
      String accountDemo2Json = toJsonString(accountDemo);
      // 1.添加
      mvc.perform(MockMvcRequestBuilders.post("/demo/role")
          .contentType(MediaType.APPLICATION_JSON).content(accountDemo2Json))
          .andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
    }

  }

  @Test
  public void testCase() throws Exception {

    log.info("================= /demo/role/list =================");
    mvc.perform(MockMvcRequestBuilders.get("/demo/role/list"))
        .andExpect(MockMvcResultMatchers.status().isOk())// 判斷響應狀態是否成功
        .andDo(MockMvcResultHandlers.print());
    log.info("=================");

    log.info("================= /demo/role/5 =================");
    mvc.perform(MockMvcRequestBuilders.get("/demo/role/5"))
        .andExpect(MockMvcResultMatchers.status().isOk())// 判斷響應狀態是否成功
        .andDo(MockMvcResultHandlers.print());
    log.info("=================");

    log.info("================= /demo/role/name/10moder =================");
    mvc.perform(MockMvcRequestBuilders.get("/demo/role/name/10moder"))
        .andExpect(MockMvcResultMatchers.status().isOk())// 判斷響應狀態是否成功
        .andDo(MockMvcResultHandlers.print());
    log.info("=================");

    log.info("================= /demo/role/sql/10moder =================");
    mvc.perform(MockMvcRequestBuilders.get("/demo/role/sql/10moder"))
        .andExpect(MockMvcResultMatchers.status().isOk())// 判斷響應狀態是否成功
        .andDo(MockMvcResultHandlers.print());
    log.info("=================");

    log.info("================= /demo/role/email/8moder1122@gmail.com =================");
    mvc.perform(MockMvcRequestBuilders.get("/demo/role/email/8moder1122@gmail.com"))
        .andExpect(MockMvcResultMatchers.status().isOk())// 判斷響應狀態是否成功
        .andDo(MockMvcResultHandlers.print());
    log.info("=================");

    log.info("================= /demo/role/username/20moder =================");
    mvc.perform(MockMvcRequestBuilders.get("/demo/role/username/20moder"))
        .andExpect(MockMvcResultMatchers.status().isOk())// 判斷響應狀態是否成功
        .andDo(MockMvcResultHandlers.print());
    log.info("=================");
  }

  @Test
  public void testRepositoryCase() throws Exception {
    StringBuffer sql = new StringBuffer("select username,email from account_demo");
    Page<Map<String,Object>> data = accountDemoRepository.queryPagingResultMap(sql,0,5, Sort.by("username"));
    System.out.println(JSON.toJSONString(data,true));
  }


  @Test
  public void testPageCase() throws Exception {
    StringBuffer sql = new StringBuffer("select * from account_demo");
    Page<AccountDemo> data = accountDemoRepository.queryPagingResultList(sql,0,5, Sort.by(Sort.Order.asc("username")));
    System.out.println(JSON.toJSONString(data,true));
  }

}
