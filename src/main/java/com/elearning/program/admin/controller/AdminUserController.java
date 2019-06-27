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

import com.elearning.program.dto.UserDTO;
import com.elearning.program.entity.User;
import com.elearning.program.service.RoleService;
import com.elearning.program.service.UserService;
import com.elearning.program.validator.PassWordValidation;

@Controller
@RequestMapping("admin/user")
public class AdminUserController {

  @Autowired
  private UserService userService;

  @Autowired
  private RoleService roleService;

  @Autowired
  private PassWordValidation userValidator;

  @GetMapping("")
  public String index(ModelMap model) {
    model.addAttribute("users", userService.findAll());
    return "userList";
  }

  @GetMapping("add")
  public String add(ModelMap model) {
    model.addAttribute("roles", roleService.findAll());
    model.addAttribute("user", new User());
    return "userAdd";
  }

  @PostMapping("add")
  public String add(ModelMap model, @Validated @ModelAttribute("user") UserDTO user, BindingResult errors) {
    // Nếu có lỗi
    userValidator.validate(user, errors);
    if (errors.hasErrors()) {
      model.addAttribute("roles", roleService.findAll());
      return "userAdd";
    }
    userService.save(user);
    return "redirect:/admin/user";
  }

  // Lấy thông tin user theo id
  @GetMapping("edit/{id}")
  public String edit(@PathVariable String id, ModelMap model) {
    UserDTO user = userService.findById(id);
    model.addAttribute("roles", roleService.findAll());
    model.addAttribute("user", user);
    return "userEdit";
  }

  @PostMapping("edit")
  public String edit(@ModelAttribute("user") UserDTO user) {
    userService.update(user);
    return "redirect:/admin/user";
  }

  // Lấy thông tin user theo id
  @GetMapping("delete/{id}")
  public String delete(@PathVariable String id) {
    userService.delete(id);
    return "redirect:/admin/user";
  }
}
