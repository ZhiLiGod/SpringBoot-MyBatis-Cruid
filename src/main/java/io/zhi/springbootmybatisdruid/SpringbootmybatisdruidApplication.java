package io.zhi.springbootmybatisdruid;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.pagehelper.PageHelper;

@SpringBootApplication
public class SpringbootmybatisdruidApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootmybatisdruidApplication.class, args);
	}
	
	//configure page helper
	@Bean
	public PageHelper pageHelper(){
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("offsetAsPageNum","true");
		properties.setProperty("rowBoundsWithCount","true");
		properties.setProperty("reasonable","true");
		properties.setProperty("dialect","mysql");    
		pageHelper.setProperties(properties);
		return pageHelper;
	}
}
