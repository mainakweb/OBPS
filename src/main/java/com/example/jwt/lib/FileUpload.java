package com.example.jwt.lib;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUpload {
    @Value("${file.upload}")
    private String fileUploade;

    public static String staticfileUploadePath;
    private String lastPathSegment; // Variable to store the last path segment
    private Path rootLocation;

    // Method to set the last path segment
    public void setLastPathSegment(String lastPathSegment) {
        //System.out.println(lastPathSegment);
        this.lastPathSegment = lastPathSegment;
        init(); // Call init to set up rootLocation after lastPathSegment is set
    }

    //  @PostConstruct
    public void init() {
        // Initialize the static global variable
        staticfileUploadePath = fileUploade;
        // Initialize the rootLocation using the staticGlobalVariable and lastPathSegment
        if (lastPathSegment != null) {
            rootLocation = Paths.get(staticfileUploadePath + "/" + lastPathSegment);
           System.out.println("Root Location: " + rootLocation.toString());
        } else {
            throw new IllegalStateException("Last path segment is not set!");
        }
    }

    public String dynamicFileUpload(HttpServletRequest request, MultipartFile file) throws IOException {
        // try {
        // Validate file type (must be a PDF)
        if (!file.getContentType().equals("application/pdf")) {
            throw new IOException("File type is not supported. Only PDF files are allowed.");
        }

        // Validate file size (max 2MB)
        long maxSizeInBytes = 2 * 1024 * 1024; // 2MB in bytes
        if (file.getSize() > maxSizeInBytes) {
            throw new IOException("File size exceeds the maximum allowed size of 2MB.");
        }

        if (file.isEmpty()) {
            throw new IOException("Failed to store empty file.");
        }

        if(request.getRequestURL().toString().isEmpty()) {
            throw new IOException("Could not get request path.");
        }
        // Get the current request URL
        String fullURL = request.getRequestURL().toString();
        String lastPathSegment = fullURL.substring(fullURL.lastIndexOf('/') + 1);
        setLastPathSegment(lastPathSegment);
        System.out.println(lastPathSegment);
        // Ensure the directory exists
        Files.createDirectories(rootLocation);

        // Resolve the file path
        Path filePath = this.rootLocation.resolve(file.getOriginalFilename());

        // Save file to specified path
        Files.copy(file.getInputStream(), filePath);

        return filePath.toString();
//        } catch (IOException e) {
//            throw new IOException("Failed to store empty filew.");
//        }

    }

    // This method returns the path to the file based on the filename
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

}
