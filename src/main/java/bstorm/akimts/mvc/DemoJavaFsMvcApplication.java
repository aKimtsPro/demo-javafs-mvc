package bstorm.akimts.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoJavaFsMvcApplication {

	public static void main(String[] args) {
		ApplicationContext ctxt = SpringApplication.run(DemoJavaFsMvcApplication.class, args);

		String name = ctxt.getEnvironment().getProperty("spring.application.name");
		System.out.println(name);

	}

}
