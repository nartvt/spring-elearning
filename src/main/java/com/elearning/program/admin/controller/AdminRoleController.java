package com.elearning.program.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
    List<RoleDTO> roles = roleService.findAll();
    if (roles == null) {
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

  @GetMapping("edit/{roleId}")
  public String edit(@PathVariable("roleId") String roleId, ModelMap model) {
    RoleDTO role = roleService.findById(roleId);
    model.addAttribute("role", role);
    return "userEdit";
  }

  @PostMapping("edit")
  public String edit(@ModelAttribute("role") RoleDTO role, ModelMap model) {
    roleService.update(role);
    return "redirect:/admin/role";
  }

  @GetMapping("delete/{roleId}")
  public String delete(@PathVariable("roleId") String roleId, ModelMap model) {
    roleService.delete(roleId);
    return "redirect:/admin/role";

  }

}
