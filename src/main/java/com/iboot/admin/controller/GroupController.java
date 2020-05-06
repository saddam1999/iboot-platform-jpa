package com.iboot.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/group")
public class GroupController {

    final private String PREFIX_GROUP_PAGE = "/admin/group";

    @GetMapping("/")
    public String listGroup(){
      return PREFIX_GROUP_PAGE+"/group";
    }
}
