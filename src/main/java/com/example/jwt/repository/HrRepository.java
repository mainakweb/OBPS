package com.example.jwt.repository;



import com.example.jwt.model.hr.Hr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HrRepository  extends JpaRepository<Hr, Integer> {
    List<Hr> findByPurchasingDocNoOrderByCreatedAtDesc(String purchasingDocNo);
}
