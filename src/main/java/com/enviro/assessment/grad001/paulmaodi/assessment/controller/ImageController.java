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

/**
 * A Rest Controller that handles all the requests for the decoded image.
 * The @RequiredArgsConstructor annotation is used to inject the
 * AccountRepository dependency into the constructor. The @RestController
 * annotation is used to indicate that the class is a controller and
 * the @RequestMapping annotation is used to map the HTTP requests to the
 * controller methods.
 * 
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api/image")
public class ImageController {
    /**
     * The AccountRepository dependency is injected into the constructor.
     */
    private AccountRepository accRepo;

    @Autowired
    private ParseFile parseFile = new ParseFile(accRepo);

    /**
     * The constructor is used to inject the AccountRepository dependency.
     */
    public ImageController(AccountRepository accRepo) {
        this.accRepo = accRepo;
        this.parseFile = new ParseFile(accRepo);
    }

    /**
     * This method is used to get the decoded image from the database.
     * The @GetMapping annotation is used to map the HTTP GET requests to the
     * method, and the @PathVariable annotation is used to extract the name and
     * surname from the request URL.
     * 
     * @param name    The name of the account holder.
     * @param surname The surname of the account holder.
     * @return The decoded image.
     */
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

    /**
     * This method is used to parse the CSV file on startup.
     * The @PostConstruct annotation is used to indicate that the method should be
     * executed after the dependency injection is done to perform any
     * initialization.
     * 
     */
    @PostConstruct
    public void parseCSVOnStartup() {
        String csvFilePath = "1672815113084-GraduateDev_AssessmentCsv_Ref003.csv";
        try {
            parseFile.parseCSV(new File(csvFilePath));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}