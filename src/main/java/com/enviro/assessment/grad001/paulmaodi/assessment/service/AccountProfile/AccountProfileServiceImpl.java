package com.enviro.assessment.grad001.paulmaodi.assessment.service.AccountProfile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.paulmaodi.assessment.entity.AccountProfile;
import com.enviro.assessment.grad001.paulmaodi.assessment.repository.AccountRepository;

@Service
public class AccountProfileServiceImpl implements AccountProfileService {

    @Autowired
    AccountRepository accRepo;

    @Override
    public AccountProfile saveAccountProfile(AccountProfile accountProfile) {
        return accRepo.save(accountProfile);
    }
}
