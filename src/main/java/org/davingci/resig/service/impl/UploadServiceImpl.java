
package org.davingci.resig.service.impl;

import lombok.extern.log4j.Log4j;
import org.davingci.resig.dto.UploadDTO;
import org.davingci.resig.response.Response;
import org.davingci.resig.service.UploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@Transactional
@Log4j
public class UploadServiceImpl implements UploadService {

    @Value("${uploadPath}")
    private String uploadPath;

    @Value("${uploadServer}")
    private String uploadServer;

    @Override
    public Response upload(MultipartFile file) {
        String filename = UUID.randomUUID().toString();

        String originalFilename = file.getOriginalFilename();
        int dotIndex = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(dotIndex+1,originalFilename.length());

        String storeFilename = filename + "." + suffix;

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadPath + storeFilename);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        log.info("upload success.");
        String url = uploadServer + storeFilename;
        UploadDTO uploadDTO = UploadDTO.builder().fileName(storeFilename).uploaded(1).url(url).build();
        return Response.builder().code(200).data(uploadDTO).build();
    }

    @Override
    public UploadDTO ckUpload(MultipartFile file) {
        String filename = UUID.randomUUID().toString();

        String originalFilename = file.getOriginalFilename();
        int dotIndex = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(dotIndex+1,originalFilename.length());

        String storeFilename = filename + "." + suffix;

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadPath + storeFilename);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        log.info("upload success.");
        String url = uploadServer + storeFilename;
        UploadDTO uploadDTO = UploadDTO.builder().fileName(storeFilename).uploaded(1).url(url).build();
        return uploadDTO;
    }
}
