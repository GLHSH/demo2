package com.example.demo.controller;

import ch.qos.logback.core.util.FileUtil;
import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
@Controller
@RequestMapping("/upload")
public class UploadController {
    @RequestMapping(method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
//        val originalFilename = file.getOriginalFilename().substring( file.getOriginalFilename().indexOf(".")+1);
//        String fileName = "img."+originalFilename;
//        String savePath = "D:/upload/7";
//        String savePath2 = savePath+"/"+"7";
//        File file1 = new File(savePath);
//        File file2 = new File(savePath2);
//        System.out.println(file1.exists());
//        if (!file1.exists()) {
//            System.out.println("创建文件file1"+file1.mkdir());
//        }
//        if (!file2.exists()) {
//            System.out.println("创建文件file2"+file2.mkdir());
//        }
//        File dest = new File(savePath2 +"/"+ fileName);
//        try {
//            file.transferTo(dest);
//            System.out.println("上传成功");
//            return "上传成功";
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("上传失败");
//            return "上传失败";
//        }
        return null;
    }
}
//public class FileUpload {
//    public static void uploadFile(HttpServletRequest request, String saveFilePath) throws ServletException, IOException {
//        final String fileUploadPath = saveFilePath;
//
//        // Create a directory if it does not exist
//        File fileUploadDirectory = new File(fileUploadPath);
//        if (!fileUploadDirectory.exists()) {
//            fileUploadDirectory.mkdirs();
//        }
//
//        // Get the file part from the request
//        Part filePart = request.getPart("file");
//
//        // Get the file name
//        String fileName = extractFileName(filePart);
//
//        // Write the file to the specified path
//        Path filePath = Paths.get(fileUploadPath + File.separator + fileName);
//        try (InputStream fileContent = filePart.getInputStream()) {
//            Files.copy(fileContent, filePath);
//        }
//    }
//
//    // Extracts file name from content-disposition header of part
//    private static String extractFileName(Part filePart) {
//        String contentDispositionHeader = filePart.getHeader("content-disposition");
//        for (String contentDisposition : contentDispositionHeader.split(";")) {
//            if (contentDisposition.trim().startsWith("filename")) {
//                return contentDisposition.substring(contentDisposition.indexOf("=") + 1).trim().replace("\"", "");
//            }
//        }
//        return null;
//    }
//
//    public String uploadFile(MultipartFile file) throws IOException {
//        //拿到文件的名称和类型 以及大小
//        String originalFilename = file.getOriginalFilename();
//        String type = FileUtil.extName(originalFilename);
//        long size = file.getSize();
//        //定义一个文件唯一的标识码
//        String uuid = IdUtil.fastSimpleUUID();
//        String fileUUID =  uuid + StrUtil.DOT + type;
//        File uploadFile = new File(fileUploadPath + fileUUID);
//        //判断配置的文件目录是否存在，若不存在则创建一个新的文件目录
//        File parentFile = uploadFile.getParentFile();
//        if (!parentFile.exists()){
//            parentFile.mkdirs();
//        }
//        String url;
//        //上传文件到磁盘
//        file.transferTo(uploadFile);
//        //获取文件的MD5
//        String md5 = SecureUtil.md5(uploadFile);
//        //从数据库查询是否存在相同的记录
//        Files dbFiles = getFileByMd5(md5);
//        if (dbFiles != null){
//            url = dbFiles.getUrl();
//            //由于文件已存在,所以删除刚才上传的重复文件
//            uploadFile.delete();
//            System.out.println("文件已存在!!"+url);
//            return "文件已存在";
//        } else {
//            //数据库若不存在重复文件，则不删除刚才上传的文件
//            url = "http://localhost:9090/file/"+fileUUID;
//            //存储数据库
//            Files savaFile = new Files();
//            savaFile.setName(originalFilename);
//            savaFile.setType(type);
//            savaFile.setSize(size/1024);
//            savaFile.setUrl(url);
//            savaFile.setMd5(md5);
//            fileMapper.insert(savaFile);
//        }
//        System.out.println("路径是："+url);
//        return url;
//    }
//
//
//    private void singleDownload(String fileUUID, HttpServletResponse response) throws IOException {
//        File uploadFile = new File(fileUploadPath + fileUUID);
//        System.out.println("文件地址:"+fileUploadPath);
//        System.out.println("文件唯一标识名:"+fileUUID);
//        //设置输出流的格式
//        ServletOutputStream os = response.getOutputStream();
//        response.addHeader("content-Disposition","attachment;filename="+ URLEncoder.encode(fileUUID,"UTF-8"));
//        response.setContentType("application/octet-stream");
//        //读取文件的字节流
//        os.write(FileUtil.readBytes(uploadFile));
//        os.flush();
//        os.close();
//        System.out.println("文件下载完成: "+uploadFile);
//    }
//
//
//
//}
///**
//        这个代码会将上传的文件写入到指定的文件路径下。你只需要将文件上传的请求发送到该方法即可。
//        例如，下面是一个使用该代码上传文件的代码段：
//        FileUpload.uploadFile(request, "/path/to/my/files");
//        这将上传名为“file”的文件，并将其保存在`/path/to/my/files`文件夹中。
//**/