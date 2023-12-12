package pe.edu.utp.olimpiadas_aqp.services;

import org.springframework.web.multipart.MultipartFile;
import pe.edu.utp.olimpiadas_aqp.models.responses.upload.UploadRes;

import java.io.IOException;

public interface FileUploadServiceInterface {
    UploadRes uploadFile(MultipartFile multipartFile) throws IOException;
}
