package com.enviro.assessment.grad001.paulmaodi.assessment.model;

import java.util.List;

import com.enviro.assessment.grad001.paulmaodi.assessment.entity.AccountProfile;

public interface AccountProfileService {
    //Persist into the Database
    AccountProfile createProfile(AccountProfile accountProfile);

    //Read From the Database
    List<AccountProfile> readProfile();
}
