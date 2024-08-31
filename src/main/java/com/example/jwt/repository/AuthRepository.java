package com.example.jwt.repository;

import com.example.jwt.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth, Integer> {
    List<Auth> findByVendorCode(String vendorCode);
}
