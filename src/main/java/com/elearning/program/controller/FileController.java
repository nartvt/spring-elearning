package com.elearning.program.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("file")
public class FileController {
    private final String UPLOAD_FOLDER = "resources/upload/";
    private final String UPLOAD_FOLDER_RESULT = "statics/upload/";

    @PostMapping("upload")
    @ResponseBody
    public Object upload(@RequestParam MultipartFile file, HttpServletRequest request) {
        String path = request.getServletContext().getRealPath("/" + UPLOAD_FOLDER);

        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            File pathToFile = new File(path + file.getOriginalFilename());
            file.transferTo(pathToFile);
            return UPLOAD_FOLDER_RESULT+file.getOriginalFilename();
        } catch (IllegalStateException  e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}