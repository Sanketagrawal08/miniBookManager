package com.example.abhi0.helloa.Helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileuPLOADhELPER {
    public final String UPLOAD_DIR="C:\\Users\\sanke\\OneDrive\\Desktop\\helloa\\src\\main\\resources\\static\\image\\";
    public boolean uploadFile(MultipartFile f){
        boolean t = false;
      try {
        // InputStream is = f.getInputStream();
        // byte[] data = new byte[is.available()];
        // is.read(data);

        // //write daat
        // FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+f.getOriginalFilename());
        // fos.write(data);
        // fos.flush();
        // fos.close();


       //2nd option
       Files.copy(f.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+f.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);

        t=true;
       } catch (Exception e) {
        e.printStackTrace();
        System.err.println("Error uploading file: " + e.getMessage());
      }
        return t;
    }
}
