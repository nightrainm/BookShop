package com.fc.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class FileUploadUtil {
    static public String fileUpload(MultipartFile file, String path) {
        //获取原文件名
        String filename = file.getOriginalFilename();
        //拿到后缀
        assert filename != null;
        String suffix = filename.substring(filename.lastIndexOf("."));
        //格式化
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        filename = format.format(System.currentTimeMillis()) + suffix;
        //获取上传路径
        path += "/" + filename;

        File relPath = new File(path);
        if (!relPath.exists()) {
            relPath.mkdirs();
        }
        //上传
        try {
            file.transferTo(relPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //虚拟(访问)路径
        path = "images/" + filename;
        return path;
    }
}
