package com.enviro.assessment.grad001.paulmaodi.assessment;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.enviro.assessment.grad001.paulmaodi.assessment.service.ParseFile;

@SpringBootApplication
public class AssessmentApplication {

	public static void main(String[] args) {
		File csvFile = new File("C:\\Users\\dell\\Desktop\\PK Maodi\\1672815113084-GraduateDev_AssessmentCsv_Ref003.csv");
		ParseFile pf = new ParseFile();
		try {
			pf.parseCSV(csvFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SpringApplication.run(AssessmentApplication.class, args);
	}

}
