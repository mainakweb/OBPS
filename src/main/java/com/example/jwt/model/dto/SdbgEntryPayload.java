package com.example.jwt.model.dto;

import com.example.jwt.model.SdbgEntry;

public class SdbgEntryPayload extends SdbgEntry {

    private String remarks;
    private String assignTo;

    // Default constructor
    public SdbgEntryPayload() {
        super(); // Call to the superclass (SdbgEntry) default constructor
    }

    // Constructor with all fields from SdbgEntry and new fields from SdbgEntryPayload2
    public SdbgEntryPayload(Integer sdbgEntryId, String purchasingDocNo, String referenceNo, String department,
                            String bankName, String branchName, String ifscCode, String bankAddr1, String bankAddr2,
                            String bankAddr3, String bankCity, String bankPinCode, String bgNo, Long bgDate,
                            Long bgAmmount, Long poDate, String yardNo, Long validityDate, String checkListReference,
                            Long checkListDate, String bgType, String vendorName, String vendorAddress1,
                            String vendorAddress2, String vendorAddress3, String vendorCity, String vendorPinCode,
                            Long extensionDate1, Long extensionDate2, Long extensionDate3, Long extensionDate4,
                            Long extensionDate5, Long extensionDate6, Long releaseDate, Long demandNoticeDate,
                            Long extensionLetterDate, String status, Long createdAt, String createdBy, Long claimPriod,
                            String bgFileNo, Long bgRecivedDate, String remarks, String assignTo) {
        super(sdbgEntryId, purchasingDocNo, referenceNo, department, bankName, branchName, ifscCode, bankAddr1, bankAddr2,
                bankAddr3, bankCity, bankPinCode, bgNo, bgDate, bgAmmount, poDate, yardNo, validityDate, checkListReference,
                checkListDate, bgType, vendorName, vendorAddress1, vendorAddress2, vendorAddress3, vendorCity, vendorPinCode,
                extensionDate1, extensionDate2, extensionDate3, extensionDate4, extensionDate5, extensionDate6, releaseDate,
                demandNoticeDate, extensionLetterDate, status, createdAt, createdBy, claimPriod, bgFileNo, bgRecivedDate);
        this.remarks = remarks;
        this.assignTo = assignTo;
    }

    // Getters and setters for the new fields

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }
}

