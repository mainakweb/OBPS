package com.example.jwt.controller.po;

import com.example.jwt.lib.*;
import com.example.jwt.model.Sdbg;
import com.example.jwt.model.dto.SdbgEntryPayload;
import com.example.jwt.service.helper.LastassigneeHelperServces;
import com.example.jwt.service.helper.PoHelperService;
import com.example.jwt.service.po.SdbgService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/po/sdbg")
public class SdbgController {
    @Autowired
    SdbgService sdbgService;
    @Autowired
    FileUpload fileUpload;
    @Autowired
    Constant constant;
    @Autowired
    PoHelperService poHelperService;
    @Autowired
    Status status;
    @Autowired
    DepertmentMaster depertmentMaster;
    @Autowired
    LastassigneeHelperServces lastassigneeHelperServces;

    @Autowired
    TableName tableName;


    //
    @GetMapping("getSDBGData")
    public ResponseEntity<ResSend> list(@RequestParam("poNo") String poNo) {
        try {

            if (poNo.isEmpty() || poNo.isBlank()) {
                ResSend data = new ResSend(false, 400, "Please send poNo", null, null);
                return new ResponseEntity<ResSend>(data, HttpStatus.OK);
            }

            Object dataObj = sdbgService.list(poNo);
            ResSend data = new ResSend(true, 200, "sdbg List fetched", dataObj, null);
            return new ResponseEntity<ResSend>(data, HttpStatus.OK);
        } catch (Exception e) {
            ResSend data = new ResSend(false, 500, "Internal server error", e.getMessage(), null);
            return new ResponseEntity<ResSend>(data, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("submitSDBG")
    public ResponseEntity<ResSend> submitSDBG(
            HttpServletRequest request,
            @RequestAttribute("customUserDetails") Map<String, Object> customUserDetails,
            @RequestParam("file") MultipartFile file,
            @RequestParam("purchasingDocNo") String purchasingDocNo,
            @RequestParam("actionType") String actionType,
            @RequestParam("remarks") String remarks,
            @RequestParam("status") String Status

    ) {
        try {

            if (!customUserDetails.get("department_id").toString().equals(constant.USER_TYPE_VENDOR)) {
                ResSend data = new ResSend(false, 200, "Please please login as vendor for SDBG subminission.", null, null);
                return new ResponseEntity<ResSend>(data, HttpStatus.NOT_ACCEPTABLE);
            }


            if (purchasingDocNo.isBlank() || purchasingDocNo.isEmpty() || remarks.isBlank() || remarks.isEmpty() || Status.isEmpty() || Status.isBlank()) {
                ResSend data = new ResSend(false, 200, "Please send valid payload!", null, null);
                return new ResponseEntity<ResSend>(data, HttpStatus.NOT_ACCEPTABLE);
            }

            if (!Status.equals(status.SUBMITTED)) {
                ResSend data = new ResSend(false, 400, "Please send valid payload!", null, null);
                return new ResponseEntity<ResSend>(data, HttpStatus.NOT_ACCEPTABLE);
            }

            String preFix = actionType.substring(0, 2);
            preFix.toUpperCase();
            String referenceNo = poHelperService.createReferenceNo(preFix, customUserDetails.get("vendor_code").toString());

            String getFilePath = fileUpload.dynamicFileUpload(request, file);
            String originalFilename = file.getOriginalFilename();

            Sdbg savedData = sdbgService.save(referenceNo, purchasingDocNo, getFilePath, originalFilename, remarks, Status, actionType, customUserDetails.get("vendor_code").toString());
            ResSend data = new ResSend(true, 200, "file uploaded!!", savedData, null);
            return new ResponseEntity<ResSend>(data, HttpStatus.OK);
        } catch (IOException e) {
            ResSend data = new ResSend(false, 500, "Internal server error2", e.getMessage(), null);
            return new ResponseEntity<ResSend>(data, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("assigneeList")
    public ResponseEntity<ResSend> assigneeList(
            @RequestAttribute("customUserDetails") Map<String, Object> customUserDetails
    ) {
        try {
            int departmentId = Integer.parseInt(customUserDetails.get("department_id").toString());
            int internalRoleId = Integer.parseInt(customUserDetails.get("internal_role_id").toString());

            if (departmentId != depertmentMaster.FINANCE || internalRoleId != constant.ASSIGNER) {
                ResSend data = new ResSend(false, 200, "Please Login as Finance Assigner!", null, null);
                return new ResponseEntity<ResSend>(data, HttpStatus.NOT_ACCEPTABLE);
            }

            List<Map<String, Object>> getAssigneeList = lastassigneeHelperServces.getAssigneeList(departmentId, constant.STAFF);

            ResSend data = new ResSend(true, 200, "file uploaded!!", getAssigneeList, null);
            return new ResponseEntity<ResSend>(data, HttpStatus.OK);
        } catch (IOException e) {
            ResSend data = new ResSend(false, 500, "Internal server error2", e.getMessage(), null);
            return new ResponseEntity<ResSend>(data, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //
    @PostMapping("sdbgSubmitByDealingOfficer")
    public ResponseEntity<ResSend> sdbgSubmitByDealingOfficer(
            @RequestAttribute("customUserDetails") Map<String, Object> customUserDetails,
            @RequestBody SdbgEntryPayload sdbgEntryPayload
    ) {
        try {
            if (
                    sdbgEntryPayload.getPurchasingDocNo().isEmpty() ||
                            sdbgEntryPayload.getPurchasingDocNo().isBlank() ||
                            sdbgEntryPayload.getReferenceNo().isEmpty() ||
                            sdbgEntryPayload.getReferenceNo().isBlank() ||
                            sdbgEntryPayload.getStatus().isEmpty() ||
                            sdbgEntryPayload.getStatus().isBlank()
            ) {
                ResSend data = new ResSend(true, 200, "INVALID PAYLOAD!!", null, null);
                return new ResponseEntity<ResSend>(data, HttpStatus.OK);
            }
            if (!sdbgEntryPayload.getStatus().equals(status.FORWARD_TO_FINANCE) && !sdbgEntryPayload.getStatus().equals(status.REJECTED)) {
                ResSend data = new ResSend(true, 200, "PLEASE SEND A VALID STATUS!!", null, null);
                return new ResponseEntity<ResSend>(data, HttpStatus.OK);
            }

            int isDo = sdbgService.checkIsDealingOfficer(sdbgEntryPayload.getPurchasingDocNo(), customUserDetails.get("vendor_code").toString());
            if (isDo == 0) {
                ResSend data = new ResSend(false, 200, "Please Login as dealing officer!!", null, null);
                return new ResponseEntity<ResSend>(data, HttpStatus.OK);
            }

            int check = sdbgService.isApprovedRejected(sdbgEntryPayload.getPurchasingDocNo(), sdbgEntryPayload.getReferenceNo(), status.APPROVED, status.REJECTED);
            if (check > 0) {
                ResSend data = new ResSend(false, 200, "You can't take any action against this reference no.", null, null);
                return new ResponseEntity<ResSend>(data, HttpStatus.OK);
            }

            Sdbg sdbgQueryInsert = sdbgService.sdbgQueryInsert(
                    tableName.SDBG_ENTRY,
                    sdbgEntryPayload,
                    customUserDetails
            );


            String msg =
                    (sdbgEntryPayload.getStatus().equals(status.REJECTED))
                            ? "This BG is Rejected."
                            : "Forworded to finance successfully!";


            ResSend data = new ResSend(true, 200, msg, sdbgQueryInsert, null);
            return new ResponseEntity<ResSend>(data, HttpStatus.OK);
        } catch (IOException e) {
            ResSend data = new ResSend(false, 500,  e.getMessage(), null,null);
            return new ResponseEntity<ResSend>(data, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //return null;
    }

}
