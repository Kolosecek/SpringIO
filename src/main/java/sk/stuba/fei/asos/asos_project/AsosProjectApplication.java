package sk.stuba.fei.asos.asos_project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sk.stuba.fei.asos.asos_project.service.StudentService;

@Slf4j
@SpringBootApplication
public class AsosProjectApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AsosProjectApplication.class, args);
		log.info("Open in browser: http://localhost:8080");
	}

	@Bean
	public CommandLineRunner setup(StudentService studentService) {
		return (args) -> {
			log.info("Generating sample data");
			studentService.getAllStudents().forEach(student -> {
				log.info("STUDENTS --> " + student.id + ' ' + student.getName() + ' ' + student.getSurname() + ' ' + student.getAge());
			});

		};
	}


	@Override
	public void run(String... args) throws Exception {

	}
}
