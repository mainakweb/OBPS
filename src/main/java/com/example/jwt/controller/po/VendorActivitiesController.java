package com.example.jwt.controller.po;

import com.example.jwt.lib.Constant;
import com.example.jwt.lib.FileUpload;
import com.example.jwt.lib.ResSend;
import com.example.jwt.model.VendorActivities;
import com.example.jwt.service.helper.PoHelperService;
import com.example.jwt.service.po.VendorActivitiesService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


import java.util.Map;

@RestController
@RequestMapping("api/v1/po/vendor")
public class VendorActivitiesController {
    @Autowired
    VendorActivitiesService vendorActivitiesService;
    @Autowired
    FileUpload fileUpload;
    @Autowired
    Constant constant;
    @Autowired
    PoHelperService poHelperService;

    @GetMapping("list")
    public ResponseEntity<ResSend> list(@RequestParam("poNo") String poNo) {
        try {
            if (poNo.isEmpty() || poNo.isBlank()) {
                ResSend data = new ResSend(false, 400, "Please send poNo", null, null);
                return new ResponseEntity<ResSend>(data, HttpStatus.OK);
            }
            System.out.println(poHelperService.createReferenceNo("sedw", poNo));
            Object dataObj = vendorActivitiesService.list(poNo);
            ResSend data = new ResSend(true, 200, "VENDOR ACTIVITIES List fetched", dataObj, null);
            return new ResponseEntity<ResSend>(data, HttpStatus.OK);
        } catch (Exception e) {
            ResSend data = new ResSend(false, 500, "Internal server error", e.getMessage(), null);
            return new ResponseEntity<ResSend>(data, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("vendorActivities")
    public ResponseEntity<ResSend> vendorActivitiesUpload(
            HttpServletRequest request,
            @RequestAttribute("customUserDetails") Map<String, Object> customUserDetails,
            @RequestParam("file") MultipartFile file,
            @RequestParam("purchasingDocNo") String purchasingDocNo,
            @RequestParam("actionType") String actionType,
            @RequestParam("remarks") String remarks,
            @RequestParam("status") String status

    ) {
        try {

            if(!customUserDetails.get("department_id").toString().equals(constant.USER_TYPE_VENDOR)) {
                ResSend data = new ResSend(false, 200, "Only VENDOR can upload!", null, null);
                return new ResponseEntity<ResSend>(data, HttpStatus.NOT_ACCEPTABLE);
            }
            if (purchasingDocNo.isBlank() || purchasingDocNo.isEmpty() || remarks.isBlank() || remarks.isEmpty() || status.isEmpty() || status.isBlank()) {
                ResSend data = new ResSend(false, 200, "Please send valid payload!", null, null);
                return new ResponseEntity<ResSend>(data, HttpStatus.NOT_ACCEPTABLE);
            }
            String getFilePath = fileUpload.dynamicFileUpload(request, file);
            String originalFilename = file.getOriginalFilename();

            VendorActivities savedData = vendorActivitiesService.save(getFilePath, originalFilename, purchasingDocNo, actionType, remarks, status, customUserDetails.get("vendor_code").toString());
            ResSend data = new ResSend(true, 200, "vendor Activities Uploaded successfully !", savedData, null);
            return new ResponseEntity<ResSend>(data, HttpStatus.OK);
        } catch (IOException e) {
            ResSend data = new ResSend(false, 500, "Internal server error2", e.getMessage(), null);
            return new ResponseEntity<ResSend>(data, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/downloadFiles/{filename:.+}")
//    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
//        try {
//            Path file = fileUpload.load(filename);
//            Resource resource = new UrlResource(file.toUri());
//
//            if (resource.exists() || resource.isReadable()) {
//                return ResponseEntity.ok()
//                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                        .body(resource);
//            } else {
//                throw new RuntimeException("Could not read the file: " + filename);
//            }
//        } catch (MalformedURLException e) {
//            throw new RuntimeException("Error: " + e.getMessage());
//        }
//    }

}
