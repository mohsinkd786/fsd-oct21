package com.mohsinkd786;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class SpringZuulProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringZuulProxyApplication.class, args);
	}
	// register the filters
}


// zuul filters
// Pre
// Post
// Route
// Error
