package com.enviro.assessment.grad001.paulmaodi.assessment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessment.grad001.paulmaodi.assessment.entity.AccountProfile;
import com.enviro.assessment.grad001.paulmaodi.assessment.model.AccountProfileService;



@RestController
public class AccountProfileController {

    @Autowired private AccountProfileService accountProfilesService;

    //Save to database
    @PostMapping("/{name}/{surname}/{\\w\\. \\w}")
    public AccountProfile saveAccountProfile(@Valid @RequestBody AccountProfile accountProfile){
        return accountProfilesService.createProfile(accountProfile);
    }

    //Read from Database
    @GetMapping("/{name}/{surname}/{\\w\\. \\w}")
    public List<AccountProfile> getAccountProfile(){
        return accountProfilesService.readProfile();
    }
}
