
package org.davingci.resig.web;

import org.davingci.resig.dto.UploadDTO;
import org.davingci.resig.response.Response;
import org.davingci.resig.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/upload")
    public Response upload(@RequestParam("file") MultipartFile file) {
        return uploadService.upload(file);
    }

    @PostMapping("/upload-ckeditor")
    public UploadDTO ckUpload(@RequestParam("upload") MultipartFile file) {
        return uploadService.ckUpload(file);
    }


}
