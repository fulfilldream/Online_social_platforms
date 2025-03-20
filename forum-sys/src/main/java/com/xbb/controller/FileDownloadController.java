package com.xbb.controller;

import com.xbb.util.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@CrossOrigin
public class FileDownloadController {

    // 文件下载
    @RequestMapping("/download")
    public void download(@RequestParam("filePath") String filePath,
                            HttpServletResponse response) throws Exception {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        File file = new File(filePath);
        try {
            // 下载文件
            response.setHeader(
                    "Content-Disposition",
                    "attachment;fileName=downloadFile." + FileUtils.fileSuffix(file.getPath())
            );
            response.setHeader("Content-length", String.valueOf(file.length()));
            response.setCharacterEncoding("UTF-8");
            response.setContentType("multipart/form-data");

            inputStream = new FileInputStream(file);
            outputStream = response.getOutputStream();
            streamCopy(inputStream, outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (Exception e) {
            }
        }
    }

    private long streamCopy(InputStream in, OutputStream out) throws IOException {
        long count = 0;
        byte[] buf = new byte[1024];
        while (true) {
            int n = in.read(buf);
            if (n < 0) break;
            if (n == 0) continue;
            out.write(buf, 0, n);
            count += n;
        }
        return count;
    }

}

