package org.remix.ssh.controller.project.urlplugin;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/plugin")
public class UrlNotePlugin {
    @RequestMapping("/url")
    public void test(HttpServletRequest request, HttpServletResponse response){
        String json = "{\"code\": \"成功\"}";
        returnJson(request, response, json);
    }

    public void returnJson(HttpServletRequest request, HttpServletResponse response, String json){
        try{
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(json);
            out.flush();
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
