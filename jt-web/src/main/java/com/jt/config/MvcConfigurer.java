package com.jt.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//该配置类,实质就是web.xml配置文件
@Configuration
public class MvcConfigurer implements WebMvcConfigurer{
	
	//开启匹配后缀型配置
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		//5.2.4以后不建议使用,但是加上依然有效果.
		configurer.setUseSuffixPatternMatch(true);
	}
}
