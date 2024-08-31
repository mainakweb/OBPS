package com.example.jwt.repository;

import com.example.jwt.model.VendorActivities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorActivitiesRepository  extends JpaRepository<VendorActivities, Integer> {
    List<VendorActivities> findByPurchasingDocNoOrderByCreatedAtDesc(String purchasingDocNo);
}
