package com.example.jwt.service.po;

import com.example.jwt.lib.Status;
import com.example.jwt.lib.TableName;
import com.example.jwt.model.Sdbg;
import com.example.jwt.model.SdbgEntry;

import com.example.jwt.model.dto.SdbgEntryPayload;
import com.example.jwt.repository.EkkoRepository;
import com.example.jwt.repository.SdbgEntryRepository;
import com.example.jwt.repository.SdbgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SdbgService {
    @Autowired
    SdbgRepository sdbgRepository;
    @Autowired
    EkkoRepository ekkoRepository;
    @Autowired
    TableName tableName;
    @Autowired
    SdbgEntryRepository sdbgEntryRepository;
    @Autowired
    Status status;


    public List<Sdbg> list(String purchasing_doc_no) {

        return sdbgRepository.findByPurchasingDocNoOrderByCreatedAtDesc(purchasing_doc_no);

    }

    public Sdbg save(String referenceNo, String purchasingDocNo, String getFilePath, String originalFilename, String remarks, String status, String actionType, String vendorCode) throws IOException {

        Sdbg sdbg = new Sdbg();
        sdbg.setReferenceNo(referenceNo);
        sdbg.setFileName(originalFilename);
        sdbg.setFilePath(getFilePath);
        sdbg.setPurchasingDocNo(purchasingDocNo);
        sdbg.setActionType(actionType);
        sdbg.setRemarks(remarks);
        sdbg.setStatus(status);
        sdbg.setUpdatedBy("VENDOR");
        sdbg.setCreatedById(vendorCode);
        sdbg.setCreatedAt(System.currentTimeMillis());

        return sdbgRepository.save(sdbg);
    }

    public int checkIsDealingOfficer(String purchasingDocNo, String vendorCode) {
        // return 0;
        return ekkoRepository.isDealingOfficer(purchasingDocNo, vendorCode);
        // return 0;
    }

    public int isApprovedRejected(String purchasingDocNo, String referenceNo, String status1, String status2) {
        // return 0;
        return sdbgRepository.isApprovedRejected(purchasingDocNo, referenceNo, status1, status2);
        // return 0;
    }

    public Sdbg sdbgQueryInsert(String getTableName, SdbgEntryPayload sdbgEntryPayload, Map<String, Object> customUserDetails) throws IOException {
        Map<String, Object> getVendorInfo = ekkoRepository.getVendorInfo(sdbgEntryPayload.getPurchasingDocNo());

        try {
            SdbgEntry sdbgEntry = new SdbgEntry();
//            sdbgEntryInsertUpdate.setReferenceNo(sdbgEntry.getReferenceNo());
            sdbgEntry.setVendorName(getVendorInfo.get("name1").toString());
            sdbgEntry.setVendorCity(getVendorInfo.get("ort01").toString());
            sdbgEntry.setVendorPinCode("");
            sdbgEntry.setVendorAddress1("");
            sdbgEntry.setCreatedBy(customUserDetails.get("vendor_code").toString());
            sdbgEntry.setCreatedAt(System.currentTimeMillis());
            if (Long.valueOf(sdbgEntryPayload.getExtensionDate1()) == null) {
                sdbgEntry.setExtensionDate1(0);
            }
            if (Long.valueOf(sdbgEntryPayload.getExtensionDate2()) == null) {
                sdbgEntry.setExtensionDate2(0);
            }
            if (Long.valueOf(sdbgEntryPayload.getExtensionDate3()) == null) {
                sdbgEntry.setExtensionDate3(0);
            }
            if (Long.valueOf(sdbgEntryPayload.getExtensionDate4()) == null) {
                sdbgEntry.setExtensionDate4(0);
            }
            if (Long.valueOf(sdbgEntryPayload.getExtensionDate5()) == null) {
                sdbgEntry.setExtensionDate5(0);
            }
            if (Long.valueOf(sdbgEntryPayload.getExtensionDate6()) == null) {
                sdbgEntry.setExtensionDate5(0);
            }

            if (Long.valueOf(sdbgEntryPayload.getReleaseDate()) == null) {
                sdbgEntry.setReleaseDate(0);
            }
            if (Long.valueOf(sdbgEntryPayload.getDemandNoticeDate()) == null) {
                sdbgEntry.setDemandNoticeDate(0);
            }
            if (Long.valueOf(sdbgEntryPayload.getExtensionLetterDate()) == null) {
                sdbgEntry.setExtensionLetterDate(0);
            }

//        if (getTableName == tableName.SDBG_SAVE) {
//            sdbgEntry.
//        }
            Optional<SdbgEntry> check = sdbgEntryRepository.findByPurchasingDocNoAndReferenceNo(sdbgEntryPayload.getPurchasingDocNo(), sdbgEntryPayload.getReferenceNo());

            if (check.isPresent()) {
                // System.out.println(true);
                SdbgEntry update = check.get();
                update.setIfscCode(sdbgEntryPayload.getIfscCode());
                update.setBankCity(sdbgEntryPayload.getBankCity());
                update.setBankPinCode(sdbgEntryPayload.getBankPinCode());
                update.setCheckListReference(sdbgEntryPayload.getCheckListReference());
                update.setCheckListDate(sdbgEntryPayload.getCheckListDate());
                update.setBankName(sdbgEntryPayload.getBankName());
                update.setBranchName(sdbgEntryPayload.getBranchName());
                update.setBankAddr1(sdbgEntryPayload.getBankAddr1());
                update.setBankAddr2(sdbgEntryPayload.getBankAddr2());
                update.setBankAddr3(sdbgEntryPayload.getBankAddr3());
                update.setBankPinCode(sdbgEntryPayload.getBankPinCode());
                update.setBgNo(sdbgEntryPayload.getBgNo());
                update.setBgDate(sdbgEntryPayload.getBgDate());
                update.setBgAmmount(sdbgEntryPayload.getBgAmmount());
                update.setYardNo(sdbgEntryPayload.getYardNo());
                update.setValidityDate(sdbgEntryPayload.getValidityDate());
                update.setClaimPriod(sdbgEntryPayload.getClaimPriod());
                update.setBgType(sdbgEntryPayload.getBgType());
                update.setStatus(sdbgEntryPayload.getStatus());
                update.setPoDate(sdbgEntryPayload.getPoDate());
                update.setBgFileNo(sdbgEntryPayload.getBgFileNo());
                update.setBgRecivedDate(sdbgEntryPayload.getBgRecivedDate());
                update.setDepartment(sdbgEntryPayload.getDepartment());

                sdbgEntryRepository.save(update);
            } else {
//            System.out.println(false);
                SdbgEntry insert = new SdbgEntry();
                insert.setPurchasingDocNo(sdbgEntryPayload.getPurchasingDocNo());
                insert.setReferenceNo(sdbgEntryPayload.getReferenceNo());

                insert.setIfscCode(sdbgEntryPayload.getIfscCode());
                insert.setBankCity(sdbgEntryPayload.getBankCity());
                insert.setBankPinCode(sdbgEntryPayload.getBankPinCode());
                insert.setCheckListReference(sdbgEntryPayload.getCheckListReference());
                insert.setCheckListDate(sdbgEntryPayload.getCheckListDate());
                insert.setBankName(sdbgEntryPayload.getBankName());
                insert.setBranchName(sdbgEntryPayload.getBranchName());
                insert.setBankAddr1(sdbgEntryPayload.getBankAddr1());
                insert.setBankAddr2(sdbgEntryPayload.getBankAddr2());
                insert.setBankAddr3(sdbgEntryPayload.getBankAddr3());
                insert.setBankPinCode(sdbgEntryPayload.getBankPinCode());
                insert.setBgNo(sdbgEntryPayload.getBgNo());
                insert.setBgDate(sdbgEntryPayload.getBgDate());
                insert.setBgAmmount(sdbgEntryPayload.getBgAmmount());
                insert.setYardNo(sdbgEntryPayload.getYardNo());
                insert.setValidityDate(sdbgEntryPayload.getValidityDate());
                insert.setClaimPriod(sdbgEntryPayload.getClaimPriod());
                insert.setBgType(sdbgEntryPayload.getBgType());
                insert.setStatus(sdbgEntryPayload.getStatus());
                insert.setPoDate(sdbgEntryPayload.getPoDate());
                insert.setBgFileNo(sdbgEntryPayload.getBgFileNo());
                insert.setBgRecivedDate(sdbgEntryPayload.getBgRecivedDate());
                insert.setDepartment(sdbgEntryPayload.getDepartment());
                insert.setCreatedBy("GRSE");
                sdbgEntryRepository.save(insert);

            }
            List<Sdbg> getData = sdbgRepository.findByPurchasingDocNoAndReferenceNo(sdbgEntryPayload.getPurchasingDocNo(), sdbgEntryPayload.getReferenceNo());

            if (sdbgEntryPayload.getStatus().equals(status.FORWARD_TO_FINANCE)) {
            }

            if (getData.isEmpty()) {
                throw new IOException("No record found by this reference no/po no.");
            }
            String remarks = (sdbgEntryPayload.getStatus().equals(status.REJECTED)) ? "This BG is " + status.REJECTED : "BG entry forwarded to Finance.";
            String assignedFrom = (sdbgEntryPayload.getStatus().equals(status.REJECTED)) ? null : customUserDetails.get("vendor_code").toString();
            Sdbg sdbgInsert = new Sdbg();
            sdbgInsert.setReferenceNo(sdbgEntryPayload.getReferenceNo());
            sdbgInsert.setPurchasingDocNo(sdbgEntryPayload.getPurchasingDocNo());
            sdbgInsert.setStatus(sdbgEntryPayload.getStatus());
            sdbgInsert.setAssignedTo(sdbgEntryPayload.getAssignTo());
            sdbgInsert.setCreatedAt(System.currentTimeMillis());
            sdbgInsert.setCreatedByName("Dealing officer");
            sdbgInsert.setCreatedById(customUserDetails.get("vendor_code").toString());
            sdbgInsert.setUpdatedBy("GRSE");
            sdbgInsert.setRemarks(remarks);
            sdbgInsert.setAssignedFrom(assignedFrom);
            sdbgInsert.setFileName(getData.get(0).getFileName());
            sdbgInsert.setFilePath(getData.get(0).getFilePath());
            sdbgInsert.setVendorCode(getData.get(0).getVendorCode());
            sdbgInsert.setActionType(getData.get(0).getActionType());
            return sdbgRepository.save(sdbgInsert);

        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }

}


