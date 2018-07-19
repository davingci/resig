
package org.davingci.resig.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UploadDTO {

    private Integer uploaded;

    private String fileName;

    private String url;
}
