package practice.hibernate52.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import practice.hibernate52.domain.Folder;
import practice.hibernate52.service.BasicService;
import practice.hibernate52.service.impl.FolderServiceImpl2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/folder")
public class FolderC {
    @Autowired
    @Qualifier("folderServiceImpl2")
//    FolderService folderserviceimpl21;
    FolderServiceImpl2 folderserviceimpl21;

    @Autowired
    BasicService basicService;

    Gson gson = new Gson();

    public static final String UTF_8 = "UTF-8";

    @RequestMapping(value = "/init")
    public void get(HttpServletRequest request, HttpServletResponse response) {
        List rootFolder = new ArrayList();
        rootFolder.add(1L);
        rootFolder.add(2L);

//        List<Folder> folders = folderserviceimpl21.get(rootFolder);
        List<Folder> folders = basicService.get(Folder.class, rootFolder);

        JsonArray folderTree = new JsonArray();
        JsonObject fPublic = new JsonObject();
        fPublic.addProperty("id", 1);
        fPublic.addProperty("text", "public");
        fPublic.addProperty("state", "closed");

        JsonObject fPrivate = new JsonObject();
        fPrivate.addProperty("id", 2);
        fPrivate.addProperty("text", "private");
        fPrivate.addProperty("state", "closed");

        folderTree.add(fPublic);
        folderTree.add(fPrivate);

        writeResponse(folderTree.toString(), response);
    }

    @RequestMapping(value = "/get")
    public void get2(HttpServletRequest request, HttpServletResponse response, Long folderID) {
        if(folderID == null){
            return;
        }

        String hql = "from Folder where parentid = "+ folderID;
        List<Folder> folders = basicService.get(hql);

        JsonArray folderTree = new JsonArray();
        JsonObject fPublic = new JsonObject();
        fPublic.addProperty("id", 1);
        fPublic.addProperty("text", "public");
        fPublic.addProperty("state", "closed");

        JsonObject fPrivate = new JsonObject();
        fPrivate.addProperty("id", 2);
        fPrivate.addProperty("text", "private");
        fPrivate.addProperty("state", "closed");

        folderTree.add(fPublic);
        folderTree.add(fPrivate);

        writeResponse(folderTree.toString(), response);
    }

    @RequestMapping(value = "/get/{folderID}")
    public void get3(HttpServletRequest request, HttpServletResponse response, @PathVariable Long folderID) {
        return;
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