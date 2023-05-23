package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EntityScan(basePackages ={"content_mgmt","course_mgmt","subject_mgmt"})
@EnableJpaRepositories(basePackages ={ "content_mgmt","course_mgmt","subject_mgmt"})
@ComponentScan(basePackages ={"content_mgmt","course_mgmt","subject_mgmt"})
public class LMS_Content_Mgmt_Main extends SpringBootServletInitializer  
{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LMS_Content_Mgmt_Main.class);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(LMS_Content_Mgmt_Main.class, args);
	}
}