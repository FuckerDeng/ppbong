package com.df.ppbong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.df.ppbong.dao")
public class PpbongBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PpbongBackendApplication.class, args);
	}

}
