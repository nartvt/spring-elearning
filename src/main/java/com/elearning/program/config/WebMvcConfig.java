package com.elearning.program.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.elearning.program.repository",
		"com.elearning.program.service", 
		"com.elearning.program.entity", 
		"com.elearning.program.controller", 
		"com.elearning.program.admin.controller","com.elearning.program.validator" })
public class WebMvcConfig implements WebMvcConfigurer {
//  public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {
//    viewResolverRegistry.jsp("/WEB-INF/views/", ".jsp");
//  }
  @Bean
  public TilesConfigurer tilesConfigurer() {
    TilesConfigurer tilesConfigurer = new TilesConfigurer();
    tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/tiles.xml" });
    tilesConfigurer.setCheckRefresh(true);
    return tilesConfigurer;
  }

  public void configureViewResolvers(ViewResolverRegistry registry) {
    TilesViewResolver tilesViewResolver = new TilesViewResolver();
    registry.viewResolver(tilesViewResolver);
  }

  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/statics/**").addResourceLocations("/resources/");
  }
//
//  @Bean
//  public UserRepository userRepository() {
//    return new UserRepositoryImpl();
//  }
//
//  @Bean
//  public UserService userService() {
//    return new UserServiceImpl();
//  }
//
//  @Bean
//  public RoleService roleService()  {
//    return new RoleServiceImpl();
//  }
//  
//  @Bean
//  public RoleRepository roleRepository() {
//    return new  RoleRepositoryImpl();
//  }
}
