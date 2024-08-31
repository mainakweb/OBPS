package com.example.jwt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Sdbg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String purchasingDocNo;
    private String referenceNo;
    private String actionType;
    private String fileName;
    private String filePath;
    private String remarks;
    private String status;
    private String vendorCode;
    private String assignedFrom;
    private String assignedTo;
    private int lastAssigned;
    private String createdByName;
    private String updatedBy;
    private Long createdAt;
    private String createdById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPurchasingDocNo() {
        return purchasingDocNo;
    }

    public void setPurchasingDocNo(String purchasingDocNo) {
        this.purchasingDocNo = purchasingDocNo;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getAssignedFrom() {
        return assignedFrom;
    }

    public void setAssignedFrom(String assignedFrom) {
        this.assignedFrom = assignedFrom;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public int getLastAssigned() {
        return lastAssigned;
    }

    public void setLastAssigned(int lastAssigned) {
        this.lastAssigned = lastAssigned;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }
}
