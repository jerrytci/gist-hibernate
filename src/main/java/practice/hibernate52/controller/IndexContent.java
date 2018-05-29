package practice.hibernate52.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import practice.hibernate52.service.IndexContentService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/indexContent")
public class IndexContent {
    @Resource
    private IndexContentService indexContentServiceImpl;

    @RequestMapping(value = "/folder/{parentId}")
    public void indexFolder(HttpServletRequest request, HttpServletResponse response, @PathVariable("parentId")int parentId) {
        try {
//            JsonArray jsonArray2 = (JsonArray) indexContentServiceImpl.getIndexFolder(parentId);

            System.out.println("parentId: " + parentId);
            //test data
            String s = "[{\"id\":\"7\",\"text\":\"Private\",\"state\":\"closed\",\"iconCls\":\"icon-folder\",\"attributes\":{\"url\":\"listfile.htm?folderId=7\",\"version\":3,\"filling\":0,\"download\":0,\"write\":0,\"delete1\":0,\"browse\":1,\"owner\":0,\"actorids\":[{\"actorid\":11}]}},{\"id\":\"8\",\"text\":\"Public\",\"state\":\"closed\",\"iconCls\":\"icon-folder\",\"attributes\":{\"url\":\"listfile.htm?folderId=8\",\"version\":7,\"filling\":1,\"download\":1,\"write\":1,\"delete1\":1,\"browse\":1,\"owner\":1,\"actorids\":[{\"actorid\":9},{\"actorid\":11}]}}]";
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(s).getAsJsonArray();

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(jsonArray.toString());
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ModelAndView build(HttpServletRequest request, HttpServletResponse response){
        return null;
    }
    @RequestMapping("/test")
    public ModelAndView test(HttpServletRequest request, HttpServletResponse response){
        String inhere = "in here";
        System.out.println(inhere);
        return null;
    }
}
