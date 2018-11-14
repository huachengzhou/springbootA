package com.blue.spring.controller.other;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/11/14
 **/
@Controller
public class FileUploadController {
    private final Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping(value = "/file/ForWard.action")
    public String forwardFile(){
        logger.info("forwardFile()");
        return "fileTest/forwardUpload";
    }



    @RequestMapping(value = "/file/upload.action",method = RequestMethod.POST)
    public String fileupload(@RequestParam(value = "file")MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        String path = request.getSession().getServletContext().getRealPath("/") + "files/"+file.getOriginalFilename();
        logger.info(path);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
            if (file.getSize()>0){
                uploadFile(path,file.getInputStream());
                out = response.getWriter();
            }
            logger.info("success!");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/sys/home";
    }

    private static void uploadFile(String path, InputStream in) {
        try {
            FileOutputStream bu = new FileOutputStream(path);
            BufferedOutputStream out = new BufferedOutputStream(bu);
            int i;
            while ((i = in.read()) != -1) {
                out.write(i);
            }
            out.flush();
            out.flush();
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
