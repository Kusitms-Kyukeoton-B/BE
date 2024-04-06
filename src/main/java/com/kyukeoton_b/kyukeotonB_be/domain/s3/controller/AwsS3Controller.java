package com.kyukeoton_b.kyukeotonB_be.domain.s3.controller;

import com.kyukeoton_b.kyukeotonB_be.domain.s3.service.AwsS3Service;
import com.kyukeoton_b.kyukeotonB_be.global.ApiResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/s3")
public class AwsS3Controller {
    private final AwsS3Service awsS3Service;
    public AwsS3Controller(AwsS3Service awsS3Service) {
        this.awsS3Service = awsS3Service;
    }

    @PostMapping("/file")
    public ApiResponse<String> uploadFile(@RequestPart(name = "file") MultipartFile image) {
        String fileUrl = awsS3Service.uploadFile(image);
        return ApiResponse.onSuccess("이미지를 성공적으로 업로드 하였습니다.", fileUrl);
    }

    @DeleteMapping("")
    public ApiResponse<String> deleteFile(@RequestPart(name = "file") String fileName) {
        awsS3Service.deleteFile(fileName);
        return ApiResponse.onSuccess("이미지를 성공적으로 삭제 하였습니다.");
    }

}
