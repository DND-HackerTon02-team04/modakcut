package io.dnd.modakcut.global.utils;

import java.io.IOException;
import java.util.UUID;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.util.IOUtils;
import io.dnd.modakcut.global.utils.exception.FileIsEmptyException;
import io.dnd.modakcut.global.utils.exception.FileUploadFailException;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
public class S3Util {

	private final AmazonS3 amazonS3;

	@Value("${aws.s3.bucket}")
	private String bucketName;

	@Value("${aws.s3.base-image-url}")
	private String baseUrl;

	public String upload(MultipartFile file) {
		if(file.isEmpty() && file.getOriginalFilename() == null) throw FileIsEmptyException.EXCEPTION;
		String originFileName = file.getOriginalFilename();
		String ext = originFileName.substring(originFileName.lastIndexOf("."));
		String randomValue = UUID.randomUUID().toString();
		String fileName = randomValue + ext;

		try {
			ObjectMetadata objMeta = new ObjectMetadata();
			byte[] bytes = IOUtils.toByteArray(file.getInputStream());
			objMeta.setContentLength(bytes.length);
			amazonS3.putObject(new PutObjectRequest(bucketName, fileName, file.getInputStream(), objMeta)
			.withCannedAcl(CannedAccessControlList.PublicRead));
		} catch (IOException e) {
			throw FileUploadFailException.EXCEPTION;
		}

		return baseUrl + "/" + fileName;
	}

	public String getObjectUrl(String objectName) {
		return amazonS3.getUrl(bucketName, objectName).toString();
	}

}
