package pro.scarlet.bootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pro.scarlet.bootdemo.relationaldataaccess.DataAccessApp;

@EnableScheduling
@RestController
@SpringBootApplication
// @SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class BootdemoApplication {
	private static final DataAccessApp dataAccessApp = new DataAccessApp();
	public static void main(String[] args) throws Exception {
		SpringApplication.run(BootdemoApplication.class, args);
		dataAccessApp.run();
		// SpringApplication.run(ConsumingRestApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
}
