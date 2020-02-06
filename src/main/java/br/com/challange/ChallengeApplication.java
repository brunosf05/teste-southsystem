package br.com.challange;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.challange.services.ReportService;

@SpringBootApplication
public class ChallengeApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ChallengeApplication.class, args);
		new ReportService().generateReportContent();
	}

}
