package pe.edu.utp.olimpiadas_aqp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.utp.olimpiadas_aqp.models.responses.upload.UploadRes;
import pe.edu.utp.olimpiadas_aqp.services.FileUploadServiceInterface;

import java.io.IOException;

@RestController
@RequestMapping("/api/upload")
public class FileUploadController {

    @Autowired
    FileUploadServiceInterface fileUploadService;

    @RequestMapping(value = "image", method = RequestMethod.POST)
    public UploadRes uploadFile(@RequestParam MultipartFile multipartFile) throws IOException {
        return fileUploadService.uploadFile(multipartFile);
    }
}
