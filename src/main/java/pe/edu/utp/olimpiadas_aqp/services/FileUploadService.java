package pe.edu.utp.olimpiadas_aqp.services;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.utp.olimpiadas_aqp.models.responses.upload.UploadRes;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Service
public class FileUploadService implements FileUploadServiceInterface {

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public UploadRes uploadFile(MultipartFile multipartFile) throws IOException {
        UploadRes response = new UploadRes();
        String url = cloudinary.uploader()
                .upload(multipartFile.getBytes(),
                        Map.of("public_id", UUID.randomUUID().toString()))
                .get("url")
                .toString();
        response.setUrl(url);
        return response;
    }
}
