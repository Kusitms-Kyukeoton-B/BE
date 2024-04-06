package com.kyukeoton_b.kyukeotonB_be.domain.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.exception.PostException;
import com.kyukeoton_b.kyukeotonB_be.global.config.AmazonConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

import static com.kyukeoton_b.kyukeotonB_be.global.status.ErrorStatus.S3_NOT_FOUND;

@Slf4j
@Component
@RequiredArgsConstructor
public class AmazonS3Manager {

    private final AmazonS3 amazonS3;

    private final AmazonConfig amazonConfig;


    public String uploadFile(String keyName, MultipartFile file) {
        System.out.println("keyName = " + keyName);

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        try {
            amazonS3.putObject(new PutObjectRequest(amazonConfig.getBucket(), keyName, file.getInputStream(), metadata));
        } catch (IOException e) {
            throw new PostException(S3_NOT_FOUND);
        }
        return amazonS3.getUrl(amazonConfig.getBucket(), keyName).toString();
    }
}


