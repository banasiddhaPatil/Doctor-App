package com.geekster.DoctorAPP.repository;

import com.geekster.DoctorAPP.model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPTokenRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findFirstByTokenValue(String tokenValue);
}
