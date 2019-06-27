package com.elearning.program.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elearning.program.dto.RoleDTO;
import com.elearning.program.entity.Role;
import com.elearning.program.service.RoleService;

@Controller
@RequestMapping("admin/role")
public class AdminRoleController {

  @Autowired
  private RoleService roleService;

  @GetMapping("")
  public String index(ModelMap model) {
    model.addAttribute("roles", roleService.findAll());
    return "roleList";
  }

  @GetMapping("add")
  public String add(ModelMap model) {
    model.addAttribute("roles", roleService.findAll());
    model.addAttribute("role", new Role());
    return "roleAdd";
  }

  @PostMapping("add")
  public String add(ModelMap model, @Validated @ModelAttribute("role") RoleDTO role, BindingResult errors) {
    // Nếu có lỗi
    if (errors.hasErrors()) {
      model.addAttribute("roles", roleService.findAll());
      return "roleAdd";
    }
    roleService.save(role);
    return "redirect:/admin/role";
  }

  @GetMapping("edit/{id}")
  public String edit(@PathVariable String id, ModelMap model) {
    RoleDTO role = roleService.findById(id);
    model.addAttribute("roles", roleService.findAll());
    model.addAttribute("role", role);
    return "roleEdit";
  }

  @PostMapping("edit")
  public String edit(@ModelAttribute("role") RoleDTO role) {
    roleService.update(role);
    return "redirect:/admin/role";
  }

  @GetMapping("delete/{id}")
  public String delete(@PathVariable String id) {
    roleService.delete(id);
    return "redirect:/admin/role";
  }
}
