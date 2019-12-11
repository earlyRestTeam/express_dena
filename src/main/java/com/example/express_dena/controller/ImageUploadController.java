package com.example.express_dena.controller;


import com.example.express_dena.util.APIResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 王志坚
 * @createTime 2019.11.27.19:57
 */
@Controller
public class ImageUploadController {

    @PostMapping("upload")
    @ResponseBody
    public APIResult upload(HttpServletRequest request, MultipartFile file){
        String realPath = this.getClass().getClassLoader().getResource("static").getFile().toString()+File.separator+"upload"+File.separator;
        System.out.println("realPath = " + realPath);
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        String originalFilename = file.getOriginalFilename();
        //originalFilename = originalFilename.substring(originalFilename.lastIndexOf("."));
        name += originalFilename;
        System.out.println("originalFilename = " + originalFilename);
        File f = new File(realPath+name);
        File parentFile = f.getParentFile();
        if( !parentFile.exists())
            parentFile.mkdirs();
        try {
            file.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return APIResult.genSuccessApiResponse("/upload/"+name);
    }

}
