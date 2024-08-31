package com.example.jwt.repository;

import com.example.jwt.model.SdbgEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SdbgEntryRepository   extends JpaRepository<SdbgEntry, Integer> {
    String isPresent = "SELECT COUNT(*) AS count FROM sdbg " +
            "WHERE purchasing_doc_no = ?1 AND reference_no = ?2";

    @Query(value = isPresent, nativeQuery = true)
    int isApprovedRejected(String purchasingDocNo, String referenceNo);


    Optional<SdbgEntry> findByPurchasingDocNoAndReferenceNo(String purchasingDocNo, String referenceNo);

}
