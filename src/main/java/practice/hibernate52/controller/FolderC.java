package practice.hibernate52.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import practice.hibernate52.domain.Folder;
import practice.hibernate52.service.FolderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/folder")
public class FolderC {
    @Autowired
    @Qualifier("folderServiceImpl2")
    FolderService folderserviceimpl21;

    Gson gson = new Gson();

    public static final String UTF_8 = "UTF-8";

    @RequestMapping(value = "/get")
    public void get(HttpServletRequest request, HttpServletResponse response) {
        List<Folder> url2s = folderserviceimpl21.get(Folder.class);
        returnResult(url2s, response);
    }

    @RequestMapping(value = "/get3")
    public void get3(HttpServletRequest request, HttpServletResponse response) {
        List<Folder> folders = folderserviceimpl21.get(Folder.class);
        returnResult(folders, response);
    }

    public <T> void returnResult(List<T> datas, HttpServletResponse response){
        if(datas != null || datas.size() != 0){
            JsonObject result = new JsonObject();
            result.addProperty("suc", true);
            result.addProperty("data", gson.toJson(datas));
            result.addProperty("msg", "成功");
            writeResponse(result.toString(), response);
        }else{
            JsonObject result = new JsonObject();
            result.addProperty("suc", false);
            result.addProperty("msg", "失败");
            writeResponse(result.toString(), response);
        }
    }

    protected final void writeResponse(String s, HttpServletResponse response){
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding(UTF_8);
            response.getWriter().print(s);
            response.getWriter().flush();
            response.getWriter().close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}