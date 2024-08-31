package com.example.jwt.model;

import jakarta.persistence.*;
//import java.math.long;

@Entity
@Table(name = "sdbg_entry")
public class SdbgEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sdbg_entry_id", nullable = false, updatable = false)
    private Integer sdbgEntryId;

    @Column(name = "purchasing_doc_no", length = 18, nullable = false)
    private String purchasingDocNo;

    @Column(name = "reference_no", length = 30, nullable = false)
    private String referenceNo;

    @Column(name = "department", length = 100)
    private String department;

    @Column(name = "bank_name", length = 100, nullable = false)
    private String bankName;

    @Column(name = "branch_name", length = 255, nullable = false)
    private String branchName;

    @Column(name = "ifsc_code", length = 20)
    private String ifscCode;

    @Column(name = "bank_addr1", length = 255, nullable = false)
    private String bankAddr1;

    @Column(name = "bank_addr2", length = 255)
    private String bankAddr2;

    @Column(name = "bank_addr3", length = 255)
    private String bankAddr3;

    @Column(name = "bank_city", length = 255)
    private String bankCity;

    @Column(name = "bank_pin_code", length = 7)
    private String bankPinCode;

    @Column(name = "bg_no", length = 55, nullable = false)
    private String bgNo;

    @Column(name = "bg_date", nullable = false)
    private long bgDate;

    @Column(name = "bg_ammount", nullable = false)
    private long bgAmmount;

    @Column(name = "po_date")
    private long poDate;

    @Column(name = "yard_no", length = 255, nullable = false)
    private String yardNo;

    @Column(name = "validity_date", nullable = false)
    private long validityDate;

    @Column(name = "check_list_reference", length = 200)
    private String checkListReference;

    @Column(name = "check_list_date", nullable = false)
    private long checkListDate;

    @Column(name = "bg_type", length = 60)
    private String bgType;

    @Column(name = "vendor_name", length = 100)
    private String vendorName;

    @Column(name = "vendor_address1", columnDefinition = "text")
    private String vendorAddress1;

    @Column(name = "vendor_address2", columnDefinition = "text")
    private String vendorAddress2;

    @Column(name = "vendor_address3", columnDefinition = "text")
    private String vendorAddress3;

    @Column(name = "vendor_city", length = 60)
    private String vendorCity;

    @Column(name = "vendor_pin_code", length = 255)
    private String vendorPinCode;

    @Column(name = "extension_date1", nullable = false)
    private long extensionDate1;

    @Column(name = "extension_date2")
    private long extensionDate2;

    @Column(name = "extension_date3")
    private long extensionDate3;

    @Column(name = "extension_date4")
    private long extensionDate4;

    @Column(name = "extension_date5")
    private long extensionDate5;

    @Column(name = "extension_date6")
    private long extensionDate6;

    @Column(name = "release_date", nullable = false)
    private long releaseDate;

    @Column(name = "demand_notice_date", nullable = false)
    private long demandNoticeDate;

    @Column(name = "extension_letter_date")
    private long extensionLetterDate;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    @Column(name = "created_at", nullable = false)
    private long createdAt;

    @Column(name = "created_by", length = 12, nullable = false)
    private String createdBy;

    @Column(name = "claim_priod")
    private long claimPriod;

    @Column(name = "bg_file_no", length = 60)
    private String bgFileNo;

    @Column(name = "bg_recived_date")
    private long bgRecivedDate;

    // Default constructor
    public SdbgEntry() {
    }

    // Constructor with all fields
    public SdbgEntry(Integer sdbgEntryId, String purchasingDocNo, String referenceNo, String department,
                     String bankName, String branchName, String ifscCode, String bankAddr1, String bankAddr2,
                     String bankAddr3, String bankCity, String bankPinCode, String bgNo, Long bgDate, Long bgAmmount,
                     Long poDate, String yardNo, Long validityDate, String checkListReference, Long checkListDate,
                     String bgType, String vendorName, String vendorAddress1, String vendorAddress2, String vendorAddress3,
                     String vendorCity, String vendorPinCode, Long extensionDate1, Long extensionDate2, Long extensionDate3,
                     Long extensionDate4, Long extensionDate5, Long extensionDate6, Long releaseDate, Long demandNoticeDate,
                     Long extensionLetterDate, String status, Long createdAt, String createdBy, Long claimPriod,
                     String bgFileNo, Long bgRecivedDate) {
        this.sdbgEntryId = sdbgEntryId;
        this.purchasingDocNo = purchasingDocNo;
        this.referenceNo = referenceNo;
        this.department = department;
        this.bankName = bankName;
        this.branchName = branchName;
        this.ifscCode = ifscCode;
        this.bankAddr1 = bankAddr1;
        this.bankAddr2 = bankAddr2;
        this.bankAddr3 = bankAddr3;
        this.bankCity = bankCity;
        this.bankPinCode = bankPinCode;
        this.bgNo = bgNo;
        this.bgDate = bgDate;
        this.bgAmmount = bgAmmount;
        this.poDate = poDate;
        this.yardNo = yardNo;
        this.validityDate = validityDate;
        this.checkListReference = checkListReference;
        this.checkListDate = checkListDate;
        this.bgType = bgType;
        this.vendorName = vendorName;
        this.vendorAddress1 = vendorAddress1;
        this.vendorAddress2 = vendorAddress2;
        this.vendorAddress3 = vendorAddress3;
        this.vendorCity = vendorCity;
        this.vendorPinCode = vendorPinCode;
        this.extensionDate1 = extensionDate1;
        this.extensionDate2 = extensionDate2;
        this.extensionDate3 = extensionDate3;
        this.extensionDate4 = extensionDate4;
        this.extensionDate5 = extensionDate5;
        this.extensionDate6 = extensionDate6;
        this.releaseDate = releaseDate;
        this.demandNoticeDate = demandNoticeDate;
        this.extensionLetterDate = extensionLetterDate;
        this.status = status;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.claimPriod = claimPriod;
        this.bgFileNo = bgFileNo;
        this.bgRecivedDate = bgRecivedDate;
    }

    // Getters and Setters

    public Integer getSdbgEntryId() {
        return sdbgEntryId;
    }

    public void setSdbgEntryId(Integer sdbgEntryId) {
        this.sdbgEntryId = sdbgEntryId;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBankAddr1() {
        return bankAddr1;
    }

    public void setBankAddr1(String bankAddr1) {
        this.bankAddr1 = bankAddr1;
    }

    public String getBankAddr2() {
        return bankAddr2;
    }

    public void setBankAddr2(String bankAddr2) {
        this.bankAddr2 = bankAddr2;
    }

    public String getBankAddr3() {
        return bankAddr3;
    }

    public void setBankAddr3(String bankAddr3) {
        this.bankAddr3 = bankAddr3;
    }

    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
    }

    public String getBankPinCode() {
        return bankPinCode;
    }

    public void setBankPinCode(String bankPinCode) {
        this.bankPinCode = bankPinCode;
    }

    public String getBgNo() {
        return bgNo;
    }

    public void setBgNo(String bgNo) {
        this.bgNo = bgNo;
    }

    public long getBgDate() {
        return bgDate;
    }

    public void setBgDate(long bgDate) {
        this.bgDate = bgDate;
    }

    public long getBgAmmount() {
        return bgAmmount;
    }

    public void setBgAmmount(long bgAmmount) {
        this.bgAmmount = bgAmmount;
    }

    public long getPoDate() {
        return poDate;
    }

    public void setPoDate(long poDate) {
        this.poDate = poDate;
    }

    public String getYardNo() {
        return yardNo;
    }

    public void setYardNo(String yardNo) {
        this.yardNo = yardNo;
    }

    public long getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(long validityDate) {
        this.validityDate = validityDate;
    }

    public String getCheckListReference() {
        return checkListReference;
    }

    public void setCheckListReference(String checkListReference) {
        this.checkListReference = checkListReference;
    }

    public long getCheckListDate() {
        return checkListDate;
    }

    public void setCheckListDate(long checkListDate) {
        this.checkListDate = checkListDate;
    }

    public String getBgType() {
        return bgType;
    }

    public void setBgType(String bgType) {
        this.bgType = bgType;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorAddress1() {
        return vendorAddress1;
    }

    public void setVendorAddress1(String vendorAddress1) {
        this.vendorAddress1 = vendorAddress1;
    }

    public String getVendorAddress2() {
        return vendorAddress2;
    }

    public void setVendorAddress2(String vendorAddress2) {
        this.vendorAddress2 = vendorAddress2;
    }

    public String getVendorAddress3() {
        return vendorAddress3;
    }

    public void setVendorAddress3(String vendorAddress3) {
        this.vendorAddress3 = vendorAddress3;
    }

    public String getVendorCity() {
        return vendorCity;
    }

    public void setVendorCity(String vendorCity) {
        this.vendorCity = vendorCity;
    }

    public String getVendorPinCode() {
        return vendorPinCode;
    }

    public void setVendorPinCode(String vendorPinCode) {
        this.vendorPinCode = vendorPinCode;
    }

    public long getExtensionDate1() {
        return extensionDate1;
    }

    public void setExtensionDate1(long extensionDate1) {
        this.extensionDate1 = extensionDate1;
    }

    public long getExtensionDate2() {
        return extensionDate2;
    }

    public void setExtensionDate2(long extensionDate2) {
        this.extensionDate2 = extensionDate2;
    }

    public long getExtensionDate3() {
        return extensionDate3;
    }

    public void setExtensionDate3(long extensionDate3) {
        this.extensionDate3 = extensionDate3;
    }

    public long getExtensionDate4() {
        return extensionDate4;
    }

    public void setExtensionDate4(long extensionDate4) {
        this.extensionDate4 = extensionDate4;
    }

    public long getExtensionDate5() {
        return extensionDate5;
    }

    public void setExtensionDate5(long extensionDate5) {
        this.extensionDate5 = extensionDate5;
    }

    public long getExtensionDate6() {
        return extensionDate6;
    }

    public void setExtensionDate6(long extensionDate6) {
        this.extensionDate6 = extensionDate6;
    }

    public long getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(long releaseDate) {
        this.releaseDate = releaseDate;
    }

    public long getDemandNoticeDate() {
        return demandNoticeDate;
    }

    public void setDemandNoticeDate(long demandNoticeDate) {
        this.demandNoticeDate = demandNoticeDate;
    }

    public long getExtensionLetterDate() {
        return extensionLetterDate;
    }

    public void setExtensionLetterDate(long extensionLetterDate) {
        this.extensionLetterDate = extensionLetterDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public long getClaimPriod() {
        return claimPriod;
    }

    public void setClaimPriod(long claimPriod) {
        this.claimPriod = claimPriod;
    }

    public String getBgFileNo() {
        return bgFileNo;
    }

    public void setBgFileNo(String bgFileNo) {
        this.bgFileNo = bgFileNo;
    }

    public long getBgRecivedDate() {
        return bgRecivedDate;
    }

    public void setBgRecivedDate(long bgRecivedDate) {
        this.bgRecivedDate = bgRecivedDate;
    }
}

