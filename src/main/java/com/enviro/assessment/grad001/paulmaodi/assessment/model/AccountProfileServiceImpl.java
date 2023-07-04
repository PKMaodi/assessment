package com.enviro.assessment.grad001.paulmaodi.assessment.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.paulmaodi.assessment.entity.AccountProfile;
import com.enviro.assessment.grad001.paulmaodi.assessment.repository.AccountProfileRepository;

@Service
public class AccountProfileServiceImpl implements AccountProfileService{
    @Autowired
    private AccountProfileRepository accountProfileRepository;

    @Override
    public AccountProfile createProfile(AccountProfile accountProfile) {
        return accountProfileRepository.save(accountProfile);
        
    }

    @Override
    public List<AccountProfile> readProfile() {
        return (List<AccountProfile>) accountProfileRepository.findAll();
    }
    
}
