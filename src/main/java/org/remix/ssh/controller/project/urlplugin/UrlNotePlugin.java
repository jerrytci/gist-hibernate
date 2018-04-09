package org.remix.ssh.controller.project.urlplugin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.remix.ssh.domain.urlplugin.Folder;
import org.remix.ssh.domain.urlplugin.Url;
import org.remix.ssh.service.urlplugin.UrlService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/plugin")
public class UrlNotePlugin {
    @Resource
    private UrlService urlServiceImpl;

    private static Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();


    @RequestMapping("/url")
    public void test(HttpServletRequest request, HttpServletResponse response){
        String json = "{\"code\": \"成功\"}";
        returnJson(request, response, json);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntity save(HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameter("title");
        String url = request.getParameter("url");
        String folder = request.getParameter("folder");

        Url url1 = new Url();
        url1.setTitle(title);
        url1.setUrl(url);

        urlServiceImpl.saveUrl(url1, folder);
        String json = "{\"result\": \"suc\"}";
        return ResponseEntity.ok(json);
    }

    @RequestMapping(value = "/folder/all", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntity getFolderHierarchy(HttpServletRequest request, HttpServletResponse response) {
        List<Folder> folders = urlServiceImpl.getAllFolder();

        String json = "{}";
        if(folders == null){
            json = "{\"result\": \"suc\"}";
        }else{

        }

        return ResponseEntity.ok(json);
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
