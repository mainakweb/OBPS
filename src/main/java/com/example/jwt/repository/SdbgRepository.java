package com.example.jwt.repository;

import com.example.jwt.model.Sdbg;
import com.example.jwt.model.SdbgEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SdbgRepository  extends JpaRepository<Sdbg, Integer> {
    List<Sdbg> findByPurchasingDocNoOrderByCreatedAtDesc(String purchasingDocNo);
    //checkIsApprovedRejected
    String isApprovedRejectedQuery = "SELECT COUNT(status) AS count_val FROM sdbg " +
            "WHERE purchasing_doc_no = ?1 AND reference_no = ?2 AND (status = ?3 OR status = ?4)";

    @Query(value = isApprovedRejectedQuery, nativeQuery = true)
    int isApprovedRejected(String purchasingDocNo, String referenceNo, String status1, String status2);

    List<Sdbg> findByPurchasingDocNoAndReferenceNo(String purchasingDocNo, String referenceNo);

}
