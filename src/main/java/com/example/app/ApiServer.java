package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

@Controller
@EnableAutoConfiguration
public class ApiServer
{
    private final String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.\n";

    @RequestMapping(value = "/zip/bad", method = RequestMethod.GET)
    public void badZip(HttpServletResponse response) throws IOException
    {
        GZIPOutputStream out;

        response.setHeader(HttpHeaders.CONTENT_ENCODING, "gzip");
        out = writeZipStream(response.getOutputStream());
        out.flush();
    }

    @RequestMapping(value = "/zip/good", method = RequestMethod.GET)
    public void goodZip(HttpServletResponse response) throws IOException
    {
        GZIPOutputStream out;

        response.setHeader(HttpHeaders.CONTENT_ENCODING, "gzip");
        out = writeZipStream(response.getOutputStream());
        out.close();
    }

    private GZIPOutputStream writeZipStream(OutputStream outputStream) throws IOException
    {
        GZIPOutputStream out = new GZIPOutputStream(outputStream);

        for (int i = 0; i < 50; i++) {
            out.write(text.getBytes("UTF-8"));
        }

        return out;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApiServer.class, args);
    }
}
