package com.example.swe307_project2.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class S3ImageService {

    private final S3Client s3Client;

    @Value("${aws.bucketName}")
    private String bucketName;

    @Value("${aws.region}")
    private String region;

    public S3ImageService(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    public List<String> listImageUrls() {
        ListObjectsV2Request request = ListObjectsV2Request.builder()
                .bucket(bucketName)
                .build();

        ListObjectsV2Response response = s3Client.listObjectsV2(request);

        return response.contents().stream()
                .map(s3Object -> generateImageUrl(s3Object))
                .collect(Collectors.toList());
    }

    private String generateImageUrl(S3Object s3Object) {
        return String.format("https://%s.s3.%s.amazonaws.com/%s", bucketName, region, s3Object.key());
    }

    public String uploadUserImage(MultipartFile file, String userId) throws IOException {
        String key = file.getOriginalFilename();

        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .contentType(file.getContentType())
                .build();

        try (var inputStream = file.getInputStream()) {
            PutObjectResponse response = s3Client.putObject(putObjectRequest,
                    software.amazon.awssdk.core.sync.RequestBody.fromInputStream(inputStream, file.getSize()));

            if (response.sdkHttpResponse().isSuccessful()) {
                return String.format("https://%s.s3.%s.amazonaws.com/%s", bucketName, region, key);
            } else {
                throw new IOException("Failed to upload image to S3");
            }
        }
    }

    // New method to delete an image by key
    public void deleteImage(String key) {
        DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        s3Client.deleteObject(deleteObjectRequest);
    }
}
