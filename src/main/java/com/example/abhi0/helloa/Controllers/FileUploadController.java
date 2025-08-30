package com.example.abhi0.helloa.Controllers;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.multipart.MultipartFile;

import com.example.abhi0.helloa.Helper.FileuPLOADhELPER;

@RestController
public class FileUploadController {

    @Autowired
    private FileuPLOADhELPER fileuPLOADhELPER;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile( @RequestParam("file") MultipartFile file){
        //System.out.println(file.getOriginalFilename());
        //UPLOAD_DIR -- FILE KAHA UPLOAD HONGI WO BATA RAHA HE 
        //"C:\Users\sanke\OneDrive\Desktop\helloa\src\main\resources\static\image"


        boolean isSuccess = fileuPLOADhELPER.uploadFile(file);
        if(!isSuccess) return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ni hua sory darling sory darling");
        return ResponseEntity.ok("hogaya");
    }

}
