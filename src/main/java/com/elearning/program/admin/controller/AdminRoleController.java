package com.elearning.program.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elearning.program.dto.RoleDTO;
import com.elearning.program.entity.Role;
import com.elearning.program.service.RoleService;

@Controller
@Transactional
@RequestMapping("admin/role")
public class AdminRoleController {

  @Autowired
  private RoleService roleService;

  @GetMapping("")
  public String index(ModelMap model) {
    List<RoleDTO> roles = roleService.findAll();
    if(roles==null) {
      roles = new ArrayList<RoleDTO>();
    }
    model.addAttribute("roles", roles);
    return "roleList";
  }

  @GetMapping("add")
  public String add(ModelMap model) {
    model.addAttribute("role", new Role());
    return "roleAdd";
  }

  @PostMapping("add")
  public String add(ModelMap model, @Valid @ModelAttribute("role") RoleDTO role, BindingResult error) {
    if (error.hasErrors()) {
      model.addAttribute("roles", roleService.findAll());
      return "roleAdd";
    }
    roleService.save(role);
    return "redirect:/admin/role";
  }

}
