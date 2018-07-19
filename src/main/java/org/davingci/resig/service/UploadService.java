
package org.davingci.resig.service;

import org.davingci.resig.dto.UploadDTO;
import org.davingci.resig.response.Response;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    public Response upload(MultipartFile file);

    public UploadDTO ckUpload(MultipartFile file);
}
