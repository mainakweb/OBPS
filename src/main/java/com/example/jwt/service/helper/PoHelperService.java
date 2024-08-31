package com.example.jwt.service.helper;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PoHelperService {
    public String createReferenceNo(String preFix, String vendorCode)  throws IOException {
        vendorCode = vendorCode.substring(vendorCode.length() - 4);
        String referenceNo = preFix.toUpperCase() + "-" + System.currentTimeMillis() + "-" + vendorCode;
        return referenceNo;
    }
}
