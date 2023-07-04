package com.enviro.assessment.grad001.paulmaodi.assessment.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/image")
public class ImageController {
    
    @GetMapping(value = "/{name}/{surname}/{\\w\\. \\w}")
    public FileSystemResource gethttpAddedImageLink(@PathVariable String name, @PathVariable String surname){
        return null;
        //return the result

    }
}
