package com.example.swe307_project2.controller;

import com.example.swe307_project2.services.S3ImageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class ImageController {

    private final S3ImageService s3ImageService;

    public ImageController(S3ImageService s3ImageService) {
        this.s3ImageService = s3ImageService;
    }

    @GetMapping("/images")
    public List<String> listImages() {
        return s3ImageService.listImageUrls();
    }

    @PostMapping("/upload")
    public String uploadUserImage(@RequestParam("file") MultipartFile file, @RequestParam("userId") String userId) throws IOException {
        return s3ImageService.uploadUserImage(file, userId);
    }

    // New endpoint to delete an image by key
    @DeleteMapping("/delete")
    public String deleteImage(@RequestParam("key") String key) {
        s3ImageService.deleteImage(key);
        return "Image deleted successfully.";
    }
}
