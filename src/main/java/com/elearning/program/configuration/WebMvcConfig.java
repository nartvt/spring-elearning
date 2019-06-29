package com.elearning.program.configuration;

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
@ComponentScan(basePackages = { "com.elearning.program" })
public class WebMvcConfig implements WebMvcConfigurer {

//	public void configureViewResolvers(ViewResolverRegistry registry) {
//		registry.jsp("/WEB-INF/views/", ".jsp");
//	}

  @Bean
  public TilesConfigurer tilesViewResolver() {
    TilesConfigurer configurer = new TilesConfigurer();
    configurer.setDefinitions(new String[] { "/WEB-INF/tiles.xml" });
    configurer.setCheckRefresh(true);
    return configurer;
  }

  public void configureViewResolvers(ViewResolverRegistry registry) {
    TilesViewResolver resolver = new TilesViewResolver();
    registry.viewResolver(resolver);
  }

  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/statics/**").addResourceLocations("/resources/");
  }
}
