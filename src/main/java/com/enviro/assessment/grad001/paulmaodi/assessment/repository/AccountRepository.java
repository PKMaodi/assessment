package com.enviro.assessment.grad001.paulmaodi.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enviro.assessment.grad001.paulmaodi.assessment.entity.AccountProfile;

@Repository
public interface AccountRepository extends JpaRepository<AccountProfile, Long> {
    AccountProfile findBySurnameAndName(String name, String surname);
}
