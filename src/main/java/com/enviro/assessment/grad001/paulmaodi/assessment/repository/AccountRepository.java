package com.enviro.assessment.grad001.paulmaodi.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enviro.assessment.grad001.paulmaodi.assessment.entity.AccountProfile;

/**
 * Repository class for AccountProfile table in the database to store the
 * account
 * holder's name, surname and the httpImageLink.
 */
@Repository
public interface AccountRepository extends JpaRepository<AccountProfile, Long> {
    /**
     * This method is used to find the account holder by name and surname.
     * 
     * @param name    The name of the account holder.
     * @param surname The surname of the account holder.
     * @return The account holder.
     */
    AccountProfile findBySurnameAndName(String name, String surname);
}
