package com.enviro.assessment.grad001.paulmaodi.assessment.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.*;

import com.enviro.assessment.grad001.paulmaodi.assessment.entity.AccountProfile;
import com.enviro.assessment.grad001.paulmaodi.assessment.repository.AccountRepository;
import com.enviro.assessment.grad001.paulmaodi.assessment.service.ParseFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api/image")
public class ImageController {
    private AccountRepository accRepo;
    private ParseFile parseFile;
    private AccountProfile accProfile;
    private FileSystemResource fileSystemResource;

    @GetMapping(value = "/{name}/{surname}/{\\w\\.\\w}")
    public FileSystemResource gethttpImageLink(@PathVariable String name, @PathVariable String surname) {

        try {
            parseFile.setParsing();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        accProfile = accRepo.findBySurnameAndName(name, surname);
        fileSystemResource = new FileSystemResource(accProfile.getHttpImageLink().toString());
        if (accProfile == null)
            return null;
        else
            return fileSystemResource;

    }
}
