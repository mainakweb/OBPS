package com.example.jwt.controller.po;

import com.example.jwt.lib.Constant;
import com.example.jwt.lib.ResSend;
import com.example.jwt.model.hr.Hr;
import com.example.jwt.service.po.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("api/v1/po/hr")
public class HrController {
    @Autowired
    HrService hrService;
    @Autowired
    Constant constant;


    @GetMapping("complianceUploadedList")
    public ResponseEntity<ResSend> list(@RequestParam("poNo") String poNo) {
        try {
            if (poNo.isEmpty() || poNo.isBlank()) {
                ResSend data = new ResSend(false, 400, "Please send poNo", null, null);
                return new ResponseEntity<ResSend>(data, HttpStatus.OK);
            }
            Object dataObj = hrService.list(poNo);
            ResSend data = new ResSend(true, 200, "HR Compliance Uploaded List fetched", dataObj, null);
            return new ResponseEntity<ResSend>(data, HttpStatus.OK);
        } catch (Exception e) {
            ResSend data = new ResSend(false, 500, "Internal server error", e.getMessage(), null);
            return new ResponseEntity<ResSend>(data, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("hrComplianceUpload")
    public ResponseEntity<ResSend> hrComplianceUpload(
            @RequestAttribute("customUserDetails") Map<String, Object> customUserDetails,
            @RequestParam("file") MultipartFile file,
            @RequestParam("purchasingDocNo") String purchasingDocNo,
            @RequestParam("actionType") String actionType,
            @RequestParam("remarks") String remarks,
            @RequestParam("status") String status

    ) {
        try {

            if(!customUserDetails.get("department_id").toString().equals(constant.USER_TYPE_GRSE_HR)) {
                ResSend data = new ResSend(false, 200, "Only HR can upload!", null, null);
                return new ResponseEntity<ResSend>(data, HttpStatus.NOT_ACCEPTABLE);
            }
            if (purchasingDocNo.isBlank() || purchasingDocNo.isEmpty() || remarks.isBlank() || remarks.isEmpty() || status.isEmpty() || status.isBlank()) {
                ResSend data = new ResSend(false, 200, "Please send valid payload!", null, null);
                return new ResponseEntity<ResSend>(data, HttpStatus.NOT_ACCEPTABLE);
            }

            Hr savedHr = hrService.save(file, purchasingDocNo, actionType, remarks, status, customUserDetails.get("vendor_code").toString());
            ResSend data = new ResSend(true, 200, "HR Compliance Uploaded successfully !", savedHr, null);
            return new ResponseEntity<ResSend>(data, HttpStatus.OK);
        } catch (IOException e) {
            ResSend data = new ResSend(false, 500, "Internal server error2", e.getMessage(), null);
            return new ResponseEntity<ResSend>(data, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
