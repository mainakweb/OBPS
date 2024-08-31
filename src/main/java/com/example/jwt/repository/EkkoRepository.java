package com.example.jwt.repository;

import com.example.jwt.model.Ekko;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface EkkoRepository extends JpaRepository<Ekko, Integer> {
    String isDealingOfficerQuery = "SELECT COUNT(EBELN) AS man_no FROM ekko WHERE EBELN = ?1 AND ERNAM = ?2";

    @Query(value = isDealingOfficerQuery, nativeQuery = true)
    int isDealingOfficer(String purchasingDocNo, String vendorCode);

    String getVendorInfoQ = "SELECT t1.lifnr AS vendorCode, t2.name1, t2.ort01 FROM ekko AS t1\n" +
            "        LEFT JOIN \n" +
            "            lfa1 AS t2 \n" +
            "        ON \n" +
            "            t1.lifnr = t2.lifnr WHERE\n" +
            "         t1.ebeln = ?1";

    @Query(value = getVendorInfoQ, nativeQuery = true)
    Map<String, Object> getVendorInfo(String purchasingDocNo);




}
