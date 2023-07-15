package com.enviro.assessment.grad001.paulmaodi.assessment.controller;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.*;

import com.enviro.assessment.grad001.paulmaodi.assessment.entity.AccountProfile;
import com.enviro.assessment.grad001.paulmaodi.assessment.repository.AccountRepository;
import com.enviro.assessment.grad001.paulmaodi.assessment.service.ParseFile;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api/image")
public class ImageController {

    private AccountRepository accRepo;

    @Autowired
    private ParseFile parseFile = new ParseFile(accRepo);

    public ImageController(AccountRepository accRepo) {
        this.accRepo = accRepo;
        this.parseFile = new ParseFile(accRepo);
    }

    @GetMapping(value = "/{name}/{surname}/{\\w\\.\\w}")
    public FileSystemResource getHttpImageLink(@PathVariable String name, @PathVariable String surname) {
        AccountProfile accProfile = accRepo.findBySurnameAndName(name, surname);
        if (accProfile == null) {
            return null;
        }
        URL httpImageLink = accProfile.getHttpImageLink();
        String imageFileName = httpImageLink.toString().substring(httpImageLink.toString().lastIndexOf("/") + 1);
        if (imageFileName == null) {
            return null;
        } else {
            return new FileSystemResource(accProfile.getHttpImageLink().toString());
        }

    }

    @PostConstruct
    public void parseCSVOnStartup() {
        String csvFilePath = "C:\\Users\\dell\\Desktop\\PK Maodi\\Assessment\\assessment\\src\\main\\resources\\1672815113084-GraduateDev_AssessmentCsv_Ref003.csv";
        try {
            parseFile.parseCSV(new File(csvFilePath));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
