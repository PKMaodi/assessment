package com.enviro.assessment.grad001.paulmaodi.assessment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enviro.assessment.grad001.paulmaodi.assessment.entity.AccountProfile;

@Repository
public interface AccountProfileRepository extends CrudRepository<AccountProfile, Long>{
    
}
