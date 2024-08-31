package com.example.jwt.service.po;


import com.example.jwt.model.VendorActivities;
import com.example.jwt.repository.VendorActivitiesRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.io.IOException;

import java.util.List;

@Service
public class VendorActivitiesService {


    @Autowired
    VendorActivitiesRepository vendorActivitiesRepository;


    public List<VendorActivities> list(String purchasing_doc_no) {

        return vendorActivitiesRepository.findByPurchasingDocNoOrderByCreatedAtDesc(purchasing_doc_no);

    }

    public VendorActivities save(String getFilePath, String originalFilename, String purchasingDocNo, String actionType, String remarks, String status, String vendor_code) throws IOException {

        VendorActivities vendorActivities = new VendorActivities();
        vendorActivities.setFileName(originalFilename);
        vendorActivities.setFilePath(getFilePath);
        vendorActivities.setPurchasingDocNo(purchasingDocNo);
        vendorActivities.setActionType(actionType);
        vendorActivities.setRemarks(remarks);
        vendorActivities.setStatus(status);
        vendorActivities.setUpdatedBy("VENDOR");
        vendorActivities.setCreatedById(vendor_code);
        vendorActivities.setCreatedAt(System.currentTimeMillis());
        return vendorActivitiesRepository.save(vendorActivities);
    }




}
