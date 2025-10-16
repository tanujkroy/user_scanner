package com.wbsamb.userscanner.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@Service
public class QrCodeGenerateService {

    @Value("${file.upload-dir}")
    private String UPLOAD_DIR;

    private final ObjectMapper mapper = new ObjectMapper();

    public String generateQRCode(Object content, int width, int height) {
        try {
            // Serialize user object as JSON string
            String jsonContent = mapper.writeValueAsString(content);

            // Create QR code image
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(jsonContent, BarcodeFormat.QR_CODE, width, height);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", stream);
            byte[] imageBytes = stream.toByteArray();

            UUID uuid = UUID.randomUUID();
            String scannerDir = UPLOAD_DIR + "/userscanner";
            File uploadDir = new File(scannerDir);
            if (!uploadDir.exists()) uploadDir.mkdirs();

            String fileName = uuid + ".png";
            String uploadPath = scannerDir + "/" + fileName;

            Path path = Paths.get(uploadPath);
            Files.write(path, imageBytes);

            return "/uploadfile/"+fileName;
        } catch (WriterException | IOException e) {
            throw new RuntimeException("QR Code generation failed", e);
        }
    }
}
