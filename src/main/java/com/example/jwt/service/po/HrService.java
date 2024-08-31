package com.example.jwt.service.po;

import com.example.jwt.model.hr.Hr;
import com.example.jwt.repository.HrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import java.nio.file.Path;
import java.nio.file.Paths;
@Service
public class HrService {
    private final Path rootLocation = Paths.get("uploads/hrComplianceUpload");
    @Autowired
    HrRepository hrRepository;


    public List<Hr> list(String purchasing_doc_no) {

        return hrRepository.findByPurchasingDocNoOrderByCreatedAtDesc(purchasing_doc_no);

    }
    public Hr save(MultipartFile file, String purchasingDocNo, String actionType, String remarks, String status, String vendor_code) throws IOException {


        if (file.isEmpty()) {
            throw new IOException("Failed to store empty file.");
        }
        // Ensure the directory exists
        Files.createDirectories(rootLocation);

        // Resolve the file path
        Path filePath = this.rootLocation.resolve(file.getOriginalFilename());

        // Save file to specified path
        Files.copy(file.getInputStream(), filePath);

        Hr hr = new Hr();
        hr.setFileName(file.getOriginalFilename());
        hr.setFilePath(filePath.toString());
        hr.setPurchasingDocNo(purchasingDocNo);
        hr.setActionType(actionType);
        hr.setRemarks(remarks);
        hr.setStatus(status);
        hr.setUpdatedby("GRSE HR");
        hr.setCreatedById(vendor_code);
        hr.setCreatedAt(System.currentTimeMillis());
        return hrRepository.save(hr);
    }

}
