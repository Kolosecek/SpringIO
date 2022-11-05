package sk.stuba.fei.asos.asos_project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@SpringBootApplication
public class AsosProjectApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AsosProjectApplication.class, args);
		log.info("Open in browser: http://localhost:8080");
	}

	@Override
	public void run(String... args) throws Exception {

	}


}
