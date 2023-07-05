package com.enviro.assessment.grad001.paulmaodi.assessment.controller;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessment.grad001.paulmaodi.assessment.entity.AccountProfile;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

@RestController
@RequestMapping("/v1/api/image")
public class ImageController {
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    
    @GetMapping(value = "/{name}/{surname}/{imageFormat}")
    public ResponseEntity<FileSystemResource> gethttpAddedImageLink(@PathVariable String name, @PathVariable String surname, @PathVariable String imageFormat) throws IOException{
        //Create new Application-managed persistence context
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //persistance
        TypedQuery<AccountProfile> query = entityManager.createQuery("SELECT a FROM AccountProfile a WHERE a.name = :name AND a.surname = :surname", AccountProfile.class);
        query.setParameter("name", name);
        query.setParameter("surname", surname);
        //get the result
        List<AccountProfile> results = query.getResultList();
        //check if the result is empty
        if(results.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        //get the first result
        AccountProfile accountProfile = results.get(0);
        //get the image path
        Path imgPath = Paths.get(accountProfile.getHttpImageLink());
        //create a new FileSystemResource
        FileSystemResource fileSystemResource = new FileSystemResource(imgPath);
        //return the result
        return ResponseEntity.ok(fileSystemResource);
    }
}
