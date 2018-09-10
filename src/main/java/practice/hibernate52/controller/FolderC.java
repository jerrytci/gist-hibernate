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
import practice.hibernate52.service.FolderService;
import practice.hibernate52.service.impl.FolderServiceImpl2;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


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
    public static final String CLOSED = "closed";


    @Resource
    FolderService folderService;


    @RequestMapping(value = "/save")
    public void saveURl(HttpServletRequest request, HttpServletResponse response) {
//    public void saveURl(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false, value = "list[]") List<String> list) {
        String a = request.getParameter("a");
        Gson gson = new Gson();
        List<Object> b = gson.fromJson(a, new ArrayList<Object>().getClass());
        Gson gson2 = new Gson();

        List<List<List<String>>> b2 = new ArrayList<>();
        String c = data();
//        List<List<List<String>>> data = gson.fromJson(c, b2.getClass());

        List<Map<String, Object>> data2 = gson.fromJson(c, b2.getClass());

        List<Folder> folders = new ArrayList<>();
        for(int i=0; i<24; i++){
            Folder folder1 = new Folder();
            folder1.setParent(-1);

            folder1.setName(data2.get(i).get("name").toString());
            folder1.setDate_added(new Date(
                    Long.parseLong(
                            data2.get(i).get("date_added").toString()
                    )
            ));
            folder1.setDate_modified(new Date(
                    Long.parseLong(
                            data2.get(i).get("date_modified").toString()
                    )
            ));
            folder1.setName(data2.get(i).get("name").toString());

            folders.add(folder1);
        }

        folderService.saveFolder(folders);

         /*
          date_added: "13180181809147045"
          date_modified: "13180616954311007"
          id: "1255"
          name: "better.onetab"
          sync_transaction_version: "367"
          type: "folder"

          date_added: "13180616900257711"
          id: "1268"
          meta_info: {last_visited_desktop: "13180616949223838"}
          name: "cnwangjie/better-onetab: A better onetab for chrome"
          sync_transaction_version: "457"
          type: "url"
          url: "https://github.com/cnwangjie/better-onetab"
          */

    }

    public String data(){
        return new String("[ {\n" +
                "    \"children\": [ {\n" +
                "        \"date_added\": \"13180616900257711\",\n" +
                "        \"id\": \"1268\",\n" +
                "        \"meta_info\": {\n" +
                "            \"last_visited_desktop\": \"13180616949223838\"\n" +
                "        },\n" +
                "        \"name\": \"cnwangjie/better-onetab: A better onetab for chrome\",\n" +
                "        \"sync_transaction_version\": \"457\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://github.com/cnwangjie/better-onetab\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13180181799965673\",\n" +
                "        \"id\": \"1256\",\n" +
                "        \"name\": \"Lodash 中文文档(v4.16.1)\",\n" +
                "        \"sync_transaction_version\": \"449\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.css88.com/doc/lodash/#_getobject-path-defaultvalue\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13180182405872986\",\n" +
                "        \"id\": \"1257\",\n" +
                "        \"name\": \"mozilla/webextension-polyfill: A lightweight polyfill library for Promise-based WebExtension APIs in Chrome\",\n" +
                "        \"sync_transaction_version\": \"449\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://github.com/mozilla/webextension-polyfill\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13180182426299030\",\n" +
                "        \"id\": \"1258\",\n" +
                "        \"name\": \"JavaScript API - Google Chrome 扩展程序开发文档（非官方中文版）\",\n" +
                "        \"sync_transaction_version\": \"449\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://crxdoc-zh.appspot.com/extensions/api_index\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13180603944818203\",\n" +
                "        \"id\": \"1265\",\n" +
                "        \"meta_info\": {\n" +
                "            \"last_visited_desktop\": \"13180603944826877\"\n" +
                "        },\n" +
                "        \"name\": \"Browser Actions --扩展开发文档\",\n" +
                "        \"sync_transaction_version\": \"450\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://open.chrome.360.cn/extension_dev/browserAction.html#event-onClicked\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13180182974842218\",\n" +
                "        \"id\": \"1259\",\n" +
                "        \"name\": \"developer.chrome.com\",\n" +
                "        \"sync_transaction_version\": \"449\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://developer.chrome.com/extensions\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13180183219645777\",\n" +
                "        \"id\": \"1260\",\n" +
                "        \"name\": \"mashpie/i18n-node: Lightweight simple translation module for node.js / express.js with dynamic json storage. Uses common __('...') syntax in app and templates.\",\n" +
                "        \"sync_transaction_version\": \"449\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://github.com/mashpie/i18n-node\"\n" +
                "    } ],\n" +
                "    \"date_added\": \"13180181809147045\",\n" +
                "    \"date_modified\": \"13180616954311007\",\n" +
                "    \"id\": \"1255\",\n" +
                "    \"name\": \"better.onetab\",\n" +
                "    \"sync_transaction_version\": \"367\",\n" +
                "    \"type\": \"folder\"\n" +
                "}, {\n" +
                "    \"children\": [ {\n" +
                "        \"date_added\": \"13180695789677631\",\n" +
                "        \"id\": \"1270\",\n" +
                "        \"meta_info\": {\n" +
                "            \"last_visited_desktop\": \"13180695789694284\"\n" +
                "        },\n" +
                "        \"name\": \"API — Vue.js\",\n" +
                "        \"sync_transaction_version\": \"461\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://cn.vuejs.org/v2/api/#%E5%AE%9E%E4%BE%8B%E5%B1%9E%E6%80%A7\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13180696278991823\",\n" +
                "        \"id\": \"1271\",\n" +
                "        \"meta_info\": {\n" +
                "            \"last_visited_desktop\": \"13180696278992132\"\n" +
                "        },\n" +
                "        \"name\": \"Vue 实例 — Vue.js-生命周期图示\",\n" +
                "        \"sync_transaction_version\": \"464\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://cn.vuejs.org/v2/guide/instance.html#%E5%AE%9E%E4%BE%8B%E7%94%9F%E5%91%BD%E5%91%A8%E6%9C%9F%E9%92%A9%E5%AD%90\"\n" +
                "    } ],\n" +
                "    \"date_added\": \"13180695781520773\",\n" +
                "    \"date_modified\": \"13180696278991823\",\n" +
                "    \"id\": \"1269\",\n" +
                "    \"name\": \"vue\",\n" +
                "    \"sync_transaction_version\": \"460\",\n" +
                "    \"type\": \"folder\"\n" +
                "}, {\n" +
                "    \"children\": [ {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1159\",\n" +
                "        \"name\": \"dms常用\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://separatethis.com/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13180613169108029\",\n" +
                "        \"id\": \"1266\",\n" +
                "        \"meta_info\": {\n" +
                "            \"last_visited_desktop\": \"13180613169108866\"\n" +
                "        },\n" +
                "        \"name\": \"[DT-130] recently accessed,recently added,recently modified show nothing - JIRA\",\n" +
                "        \"sync_transaction_version\": \"451\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://astasys.atlassian.net/browse/DT-130?oldIssueView=true\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1160\",\n" +
                "        \"name\": \"astadmsdev — Bitbucket\",\n" +
                "        \"sync_transaction_version\": \"449\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://bitbucket.org/astadmsdev/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13179982385181388\",\n" +
                "        \"id\": \"1242\",\n" +
                "        \"name\": \"https://astasys.atlassian.net/projects/DT/issues\",\n" +
                "        \"sync_transaction_version\": \"449\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://astasys.atlassian.net/projects/DT/issues\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1161\",\n" +
                "        \"name\": \"[DT-67] watermark - JIRA\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://astasys.atlassian.net/projects/DT/issues/DT-67?filter=allopenissues\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1162\",\n" +
                "        \"name\": \"欢迎看板 | Trello\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://trello.com/b/aRbQUuCM/%E6%AC%A2%E8%BF%8E%E7%9C%8B%E6%9D%BF\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1163\",\n" +
                "        \"name\": \"Work | Trello\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://trello.com/b/Nn18JWiE/work\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1164\",\n" +
                "        \"name\": \"Live Demo - jQuery EasyUI\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.jeasyui.com/demo/main/index.php?plugin=DataList&theme=material&dir=ltr&pitem=&sort=\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1165\",\n" +
                "        \"name\": \"trial.astasys.com/login.htm\",\n" +
                "        \"sync_transaction_version\": \"449\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://trial.astasys.com/login.htm\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1166\",\n" +
                "        \"name\": \"???choose.user.type???\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://localhost:8443/choose-user-type\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1167\",\n" +
                "        \"name\": \"8080\",\n" +
                "        \"sync_transaction_version\": \"449\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://localhost:8080/login.htm\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1168\",\n" +
                "        \"name\": \"hke\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://separatethis.com/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1169\",\n" +
                "        \"name\": \"SSOCircle\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.ssocircle.com/en/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1170\",\n" +
                "        \"name\": \"SSOCheck Tool Overview\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.ssocircle.com/en/portfolio/ssocheck/tool-overview/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1171\",\n" +
                "        \"name\": \"SSOCheck Configuration\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://idp.ssocircle.com/sso/hos/PlanConfig.jsp?ConfigSet=true\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1172\",\n" +
                "        \"name\": \"SSOCircle\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.ssocircle.com/en/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1173\",\n" +
                "        \"name\": \"SSOCircle How-To\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.ssocircle.com/en/idp-tips-tricks/ssocircle-how-to/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1174\",\n" +
                "        \"name\": \"dms cloud\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://separatethis.com/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1175\",\n" +
                "        \"name\": \"Rabbit MQ安装配置及常见问题 - GrayGuo - 博客园\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.cnblogs.com/grayguo/p/5300776.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1176\",\n" +
                "        \"name\": \"创建rabbitmq：virtual host、exchange、queue - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/zheng911209/article/details/49949303\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1177\",\n" +
                "        \"name\": \"RabbitMQ Management\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://localhost:15672/#/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1178\",\n" +
                "        \"name\": \"neo4j@bolt://127.0.0.1:7687 - Neo4j Browser\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://127.0.0.1:7474/browser/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1179\",\n" +
                "        \"name\": \"Windows 平台安装 MongoDB | 菜鸟教程\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.runoob.com/mongodb/mongodb-window-install.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1180\",\n" +
                "        \"name\": \"Neo4j - CQL简介_w3cschool\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.w3cschool.cn/neo4j/neo4j_cql_introduction.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1181\",\n" +
                "        \"name\": \"win7平台安装mongodb时，如何删除已存在的MongoDB服务 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/assokoo123/article/details/38733777\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1182\",\n" +
                "        \"name\": \"ts\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://separatethis.com/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1183\",\n" +
                "        \"name\": \"TypeScript 入门教程 | 菜鸟教程\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.runoob.com/w3cnote/getting-started-with-typescript.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1184\",\n" +
                "        \"name\": \"Neo4j CQL - DELETE删除_w3cschool\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.w3cschool.cn/neo4j/delete.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1185\",\n" +
                "        \"name\": \"Neo4j的查询语法笔记(二)\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.mamicode.com/info-detail-1604946.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1186\",\n" +
                "        \"name\": \"NPM 使用介绍 | 菜鸟教程\",\n" +
                "        \"sync_transaction_version\": \"220\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.runoob.com/nodejs/nodejs-npm.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1187\",\n" +
                "        \"name\": \"React调试方法 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/u014695532/article/details/52843440\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1188\",\n" +
                "        \"name\": \"react\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://separatethis.com/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1189\",\n" +
                "        \"name\": \"List | UI React\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://react.semantic-ui.com/elements/list\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1190\",\n" +
                "        \"name\": \"List | Semantic UI\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://semantic-ui.com/elements/list\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1191\",\n" +
                "        \"name\": \"基础类型 · TypeScript中文网 · TypeScript——JavaScript的超集\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.tslang.cn/docs/handbook/basic-types.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1192\",\n" +
                "        \"name\": \"npm Documentation\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://docs.npmjs.com/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1193\",\n" +
                "        \"name\": \"nginx 301跳转到带www域名方法(不带www访问时重定向到带www域名) - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/qingjiaoforever/article/details/51393528\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1194\",\n" +
                "        \"name\": \"让事件流起来——RxJS 一小时入门 - KingMario - SegmentFault 讲堂\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://segmentfault.com/l/1500000010227865/freeplay\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1195\",\n" +
                "        \"name\": \"datagrid 有特殊字符行宽度 - Google 搜索\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.google.com.hk/search?q=datagrid+%E6%9C%89%E7%89%B9%E6%AE%8A%E5%AD%97%E7%AC%A6%E8%A1%8C%E5%AE%BD%E5%BA%A6&oq=datagrid+%E6%9C%89%E7%89%B9%E6%AE%8A%E5%AD%97%E7%AC%A6%E8%A1%8C%E5%AE%BD%E5%BA%A6&aqs=chrome..69i57.24960j0j1&sourceid=chrome&ie=UTF-8\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1196\",\n" +
                "        \"name\": \"jQuery EasyUI datagrid列名包含特殊字符会导致表格错位 不对齐 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://blog.csdn.net/qq_27039233/article/details/79030830\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1197\",\n" +
                "        \"name\": \"在AI中怎么看文件的大小_百度知道\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://zhidao.baidu.com/question/347833613.html?autoask=zhidao\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1198\",\n" +
                "        \"name\": \"ai打开出现配置错误请卸载并重新安装该产品_百度经验\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://jingyan.baidu.com/article/9113f81b06c5e42b3214c7d2.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1199\",\n" +
                "        \"name\": \"javascript Web上传文件夹的两种解决方案 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://blog.csdn.net/binyao02123202/article/details/6990756\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1200\",\n" +
                "        \"name\": \"“automation服务器不能创建对象”错误之解决 - 云+社区 - 腾讯云\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://cloud.tencent.com/developer/article/1027444\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1201\",\n" +
                "        \"name\": \"模块\\\"scrrun.dll\\\"已加载，但对DllRegisterServer的调用失败，错误代码为0x80004005_百度知道\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://zhidao.baidu.com/question/537433274.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1202\",\n" +
                "        \"name\": \"下载 Adobe Illustrator CS6 16.0.0.682（64位版） 绿色版 - 精品绿色便携软件\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.portablesoft.org/down/2559/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1203\",\n" +
                "        \"name\": \"Springmvc 上传文件MultipartFile 转File 笔记 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://blog.csdn.net/boneix/article/details/51303207\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1204\",\n" +
                "        \"name\": \"(5 条消息)在imageMagick中怎么没有convert.exe文件了？ - 知乎\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.zhihu.com/question/51651927\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1205\",\n" +
                "        \"name\": \"解決在windows 安裝 imagemagick 後 convert.exe 消失的問題\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.ddman.cc/2016/10/windows-imagemagick-convertexe.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1206\",\n" +
                "        \"name\": \"                         利用chrome浏览本地html页面，选择文件用js或jquery时怎么样才能获取到绝对路径-CSDN论坛\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://bbs.csdn.net/topics/390559129\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1207\",\n" +
                "        \"name\": \"JS选择文件夹对话框（实现文件夹上传） . - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://blog.csdn.net/zhengbo0/article/details/7677439\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1208\",\n" +
                "        \"name\": \"webkitdirectory 实现文件夹上传（包含文件夹大小和文件个数的校验） - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://blog.csdn.net/qq_35893120/article/details/79282554\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1209\",\n" +
                "        \"name\": \"chrome上传文件夹 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://blog.csdn.net/bedisdover/article/details/52579713\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1210\",\n" +
                "        \"name\": \"Failed to load resource: net::ERR_CONNECTION_ABORTED - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://blog.csdn.net/panshoujia/article/details/79650507\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1211\",\n" +
                "        \"name\": \"HTML5允许拖放上传文件夹或文件夹树吗？ - 代码日志\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://codeday.me/bug/20170908/70191.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068541000000\",\n" +
                "        \"id\": \"1212\",\n" +
                "        \"name\": \"纯 js 来实现大文件的分片上传\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://mengkang.net/1172.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177671094428101\",\n" +
                "        \"id\": \"1213\",\n" +
                "        \"name\": \"历史会话中右键移除该会话，是否能立即将该ui项移除？ - Fly社区\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://fly.layui.com/jie/13591/\"\n" +
                "    } ],\n" +
                "    \"date_added\": \"13177070552519206\",\n" +
                "    \"date_modified\": \"13180613335075442\",\n" +
                "    \"id\": \"5\",\n" +
                "    \"name\": \"asta\",\n" +
                "    \"sync_transaction_version\": \"76\",\n" +
                "    \"type\": \"folder\"\n" +
                "}, {\n" +
                "    \"children\": [ {\n" +
                "        \"date_added\": \"13179205369178862\",\n" +
                "        \"id\": \"1217\",\n" +
                "        \"name\": \"Temp Mail - 临时性 - 匿名电子邮件\",\n" +
                "        \"sync_transaction_version\": \"449\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://temp-mail.org/zh/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13179482817763273\",\n" +
                "        \"id\": \"1224\",\n" +
                "        \"name\": \"主页 - 在线短信接收\",\n" +
                "        \"sync_transaction_version\": \"449\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.pdflibr.com/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13176961086000000\",\n" +
                "        \"id\": \"1129\",\n" +
                "        \"name\": \"Google 翻译\",\n" +
                "        \"sync_transaction_version\": \"449\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://translate.google.com/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13179570602030636\",\n" +
                "        \"id\": \"1230\",\n" +
                "        \"name\": \"在线代码格式化\",\n" +
                "        \"sync_transaction_version\": \"348\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://tool.oschina.net/codeformat/js\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13176961079000000\",\n" +
                "        \"id\": \"1127\",\n" +
                "        \"meta_info\": {\n" +
                "            \"last_visited_desktop\": \"13180616892941364\"\n" +
                "        },\n" +
                "        \"name\": \"历史记录\",\n" +
                "        \"sync_transaction_version\": \"456\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"chrome://history/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13176961077000000\",\n" +
                "        \"id\": \"1128\",\n" +
                "        \"name\": \"书签\",\n" +
                "        \"sync_transaction_version\": \"32\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"chrome://bookmarks/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068834000000\",\n" +
                "        \"id\": \"1130\",\n" +
                "        \"name\": \"Google 趋势\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://trends.google.com/trends/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068834000000\",\n" +
                "        \"id\": \"1131\",\n" +
                "        \"name\": \"百度指数\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://index.baidu.com/?tpl=trend&type=0&area=0&time=13&word=gitlab%2Cgithub%2C%C2%EB%D4%C6\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068834000000\",\n" +
                "        \"id\": \"1132\",\n" +
                "        \"name\": \"在线工具 —— 开源中国社区\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://tool.oschina.net/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068834000000\",\n" +
                "        \"id\": \"1133\",\n" +
                "        \"name\": \"前端文档工具收藏夹 - 前端开发资源导航，前端工程师专用的导航站\",\n" +
                "        \"sync_transaction_version\": \"200\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.css88.com/nav/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068834000000\",\n" +
                "        \"id\": \"1134\",\n" +
                "        \"name\": \"在线工具 - 程序员的工具箱\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://tool.lu/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068834000000\",\n" +
                "        \"id\": \"1135\",\n" +
                "        \"name\": \"gitignore.io - Create Useful .gitignore Files For Your Project\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.gitignore.io/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068834000000\",\n" +
                "        \"id\": \"1136\",\n" +
                "        \"name\": \"Maven Repository:\",\n" +
                "        \"sync_transaction_version\": \"200\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://mvnrepository.com/search?q=\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068834000000\",\n" +
                "        \"id\": \"1137\",\n" +
                "        \"name\": \"历史快照\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://archive.org/web/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068834000000\",\n" +
                "        \"id\": \"1138\",\n" +
                "        \"name\": \"飞客BT搜索引擎 - FeikeBT 最好用的BT种子磁力链接搜索引擎\",\n" +
                "        \"sync_transaction_version\": \"251\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://feikebt.com/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177065191000000\",\n" +
                "        \"id\": \"1139\",\n" +
                "        \"name\": \"效率集-自定义网址导航,多重搜索\",\n" +
                "        \"sync_transaction_version\": \"111\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.xiaolvji.com/\"\n" +
                "    } ],\n" +
                "    \"date_added\": \"13177070552527917\",\n" +
                "    \"date_modified\": \"13180616906567512\",\n" +
                "    \"id\": \"10\",\n" +
                "    \"name\": \"tool\",\n" +
                "    \"sync_transaction_version\": \"79\",\n" +
                "    \"type\": \"folder\"\n" +
                "}, {\n" +
                "    \"children\": [ {\n" +
                "        \"date_added\": \"13177070134000000\",\n" +
                "        \"id\": \"1068\",\n" +
                "        \"name\": \"Java面试2018常考题目汇总（一） - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"111\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://blog.csdn.net/hope900/article/details/78647466\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070134000000\",\n" +
                "        \"id\": \"1069\",\n" +
                "        \"name\": \"115个Java面试题和答案——终极列表（上） - ImportNew\",\n" +
                "        \"sync_transaction_version\": \"84\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.importnew.com/10980.html#general\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070134000000\",\n" +
                "        \"id\": \"1070\",\n" +
                "        \"name\": \"115个Java面试题和答案——终极列表（下） - ImportNew\",\n" +
                "        \"sync_transaction_version\": \"84\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.importnew.com/11028.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070134000000\",\n" +
                "        \"id\": \"1072\",\n" +
                "        \"name\": \"Java面试题全集（上） - ImportNew\",\n" +
                "        \"sync_transaction_version\": \"111\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.importnew.com/22083.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070134000000\",\n" +
                "        \"id\": \"1073\",\n" +
                "        \"name\": \"Java面试题全集（下） - ImportNew\",\n" +
                "        \"sync_transaction_version\": \"84\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.importnew.com/22087.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070134000000\",\n" +
                "        \"id\": \"1074\",\n" +
                "        \"name\": \"Java 面试题：百度前200页都在这里了 - ImportNew\",\n" +
                "        \"sync_transaction_version\": \"84\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.importnew.com/27326.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070134000000\",\n" +
                "        \"id\": \"1075\",\n" +
                "        \"name\": \"Java工程师面试题整理[社招篇]\",\n" +
                "        \"sync_transaction_version\": \"84\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://zhuanlan.zhihu.com/p/21551758\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070134000000\",\n" +
                "        \"id\": \"1076\",\n" +
                "        \"name\": \"关于Spring的69个面试问答——终极列表 - ImportNew\",\n" +
                "        \"sync_transaction_version\": \"84\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.importnew.com/11657.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070134000000\",\n" +
                "        \"id\": \"1077\",\n" +
                "        \"name\": \"最近5年133个Java面试问题列表 - ImportNew\",\n" +
                "        \"sync_transaction_version\": \"84\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.importnew.com/17232.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070134000000\",\n" +
                "        \"id\": \"1078\",\n" +
                "        \"name\": \"企业级JAVA开发面试题库_华清远见教育集团\",\n" +
                "        \"sync_transaction_version\": \"84\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://javaee.hqyj.com/mianshi/?lbj-INew\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070134000000\",\n" +
                "        \"id\": \"1079\",\n" +
                "        \"name\": \"2017年前端面试题整理汇总100题 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://blog.csdn.net/kebi007/article/details/54882425#t90\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070134000000\",\n" +
                "        \"id\": \"1080\",\n" +
                "        \"name\": \"常见前端面试题及答案 - 默语 - 博客园\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.cnblogs.com/syfwhu/p/4434132.html#\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070134000000\",\n" +
                "        \"id\": \"1081\",\n" +
                "        \"name\": \"五百丁 - 中国领先的简历制作平台，提供海量个人简历模板，免费在线制作，简历定制，ppt定制\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.500d.me/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070134000000\",\n" +
                "        \"id\": \"1082\",\n" +
                "        \"name\": \"geekcompany/ResumeSample: Resume template for Chinese programmers . 程序员简历模板系列。包括PHP程序员简历模板、iOS程序员简历模板、Android程序员简历模板、Web前端程序员简历模板、Java程序员简历模板、C/C++\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://github.com/geekcompany/ResumeSample\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070134000000\",\n" +
                "        \"id\": \"1083\",\n" +
                "        \"name\": \"如何写好技术简历 —— 实例、模板及工具 | @Get社区\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://get.ftqq.com/744.get\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070134000000\",\n" +
                "        \"id\": \"1084\",\n" +
                "        \"name\": \"ResumeSample/java.md at master · geekcompany/ResumeSample\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://github.com/geekcompany/ResumeSample/blob/master/java.md\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070134000000\",\n" +
                "        \"id\": \"1085\",\n" +
                "        \"name\": \"职友集：一家做公司点评的网站\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.jobui.com/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070134000000\",\n" +
                "        \"id\": \"1086\",\n" +
                "        \"name\": \"悉知 - 专注企业信息查询 | 查企业 用悉知\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.xizhi.com/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070162000000\",\n" +
                "        \"id\": \"1087\",\n" +
                "        \"name\": \"拉勾网-专业的互联网招聘平台_找工作_招聘_人才网_求职\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.lagou.com/\"\n" +
                "    } ],\n" +
                "    \"date_added\": \"13177070552534807\",\n" +
                "    \"date_modified\": \"13179394008479889\",\n" +
                "    \"id\": \"19\",\n" +
                "    \"name\": \"job\",\n" +
                "    \"sync_transaction_version\": \"76\",\n" +
                "    \"type\": \"folder\"\n" +
                "}, {\n" +
                "    \"children\": [ {\n" +
                "        \"date_added\": \"13179482109834403\",\n" +
                "        \"id\": \"1220\",\n" +
                "        \"name\": \"25个经典的Spring面试问答 - Java开发社区 | CTOLib码库\",\n" +
                "        \"sync_transaction_version\": \"166\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.ctolib.com/topics-35589.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13179482269576187\",\n" +
                "        \"id\": \"1222\",\n" +
                "        \"name\": \"最全的BAT大厂面试题整理 - 简书\",\n" +
                "        \"sync_transaction_version\": \"167\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.jianshu.com/p/c70989bd5f29\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13179481884304616\",\n" +
                "        \"id\": \"1219\",\n" +
                "        \"name\": \"译：排名前20的REST和Spring MVC面试题 | Spring For All\",\n" +
                "        \"sync_transaction_version\": \"160\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.spring4all.com/article/1445\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13179483043304772\",\n" +
                "        \"id\": \"1226\",\n" +
                "        \"name\": \"给初中级JAVA准备的面试题 | 徐靖峰|个人博客\",\n" +
                "        \"sync_transaction_version\": \"165\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.cnkirito.moe/view-1/\"\n" +
                "    } ],\n" +
                "    \"date_added\": \"13179482277147784\",\n" +
                "    \"date_modified\": \"13179483043304772\",\n" +
                "    \"id\": \"1221\",\n" +
                "    \"name\": \"job2\",\n" +
                "    \"sync_transaction_version\": \"126\",\n" +
                "    \"type\": \"folder\"\n" +
                "}, {\n" +
                "    \"children\": [ {\n" +
                "        \"date_added\": \"13176961064000000\",\n" +
                "        \"id\": \"1141\",\n" +
                "        \"meta_info\": {\n" +
                "            \"last_visited_desktop\": \"13180672296076826\"\n" +
                "        },\n" +
                "        \"name\": \"rejerry (keeppatient)\",\n" +
                "        \"sync_transaction_version\": \"458\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://github.com/rejerry\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13176961062000000\",\n" +
                "        \"id\": \"1142\",\n" +
                "        \"name\": \"rejerry’s gists\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://gist.github.com/rejerry\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13176981283000000\",\n" +
                "        \"id\": \"1143\",\n" +
                "        \"name\": \"腾讯云-控制台\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://console.cloud.tencent.com/developer/security\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13176988539000000\",\n" +
                "        \"id\": \"1144\",\n" +
                "        \"name\": \"project\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://separatethis.com/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13176975670000000\",\n" +
                "        \"id\": \"1145\",\n" +
                "        \"name\": \"Enhancer - 首页\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://enhancer.io/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177065873000000\",\n" +
                "        \"id\": \"1146\",\n" +
                "        \"name\": \"掘金酱\",\n" +
                "        \"sync_transaction_version\": \"449\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://e.xitu.io/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177066042000000\",\n" +
                "        \"id\": \"1147\",\n" +
                "        \"name\": \"SegmentFault 思否\",\n" +
                "        \"sync_transaction_version\": \"163\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://segmentfault.com/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177067248000000\",\n" +
                "        \"id\": \"1148\",\n" +
                "        \"name\": \"前端库\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.awesomes.cn/repos/Applications/frameworks\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13176961086872076\",\n" +
                "        \"id\": \"1149\",\n" +
                "        \"name\": \"Google 翻译\",\n" +
                "        \"sync_transaction_version\": \"449\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://translate.google.com/\"\n" +
                "    } ],\n" +
                "    \"date_added\": \"13177070552525758\",\n" +
                "    \"date_modified\": \"13180672313992071\",\n" +
                "    \"id\": \"8\",\n" +
                "    \"name\": \"code\",\n" +
                "    \"sync_transaction_version\": \"78\",\n" +
                "    \"type\": \"folder\"\n" +
                "}, {\n" +
                "    \"children\": [ {\n" +
                "        \"date_added\": \"13177070338000000\",\n" +
                "        \"id\": \"681\",\n" +
                "        \"name\": \"自动装箱拆箱详解 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://blog.csdn.net/woshiluoye9/article/details/55805823\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070338000000\",\n" +
                "        \"id\": \"682\",\n" +
                "        \"name\": \"深入剖析Java中的装箱和拆箱 - 海 子 - 博客园\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.cnblogs.com/dolphin0520/p/3780005.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070338000000\",\n" +
                "        \"id\": \"683\",\n" +
                "        \"name\": \"Java 自动装箱与拆箱(Autoboxing and unboxing) - 蛋呢 - 博客园\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.cnblogs.com/danne823/archive/2011/04/22/2025332.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070338000000\",\n" +
                "        \"id\": \"684\",\n" +
                "        \"name\": \"Java基本数据类型总结 - 时间朋友 - 博客园\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.cnblogs.com/doit8791/archive/2012/05/25/2517448.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070338000000\",\n" +
                "        \"id\": \"685\",\n" +
                "        \"name\": \"StringBuffer的append拼接和String的+连接效率对比 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://blog.csdn.net/zqg4919/article/details/78543330\"\n" +
                "    } ],\n" +
                "    \"date_added\": \"13177070552566199\",\n" +
                "    \"date_modified\": \"13178619433912387\",\n" +
                "    \"id\": \"22\",\n" +
                "    \"name\": \"java\",\n" +
                "    \"sync_transaction_version\": \"76\",\n" +
                "    \"type\": \"folder\"\n" +
                "}, {\n" +
                "    \"children\": [ {\n" +
                "        \"date_added\": \"13177070394000000\",\n" +
                "        \"id\": \"465\",\n" +
                "        \"name\": \"集合继承关系图解 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://blog.csdn.net/biexiaofei/article/details/77031003\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070394000000\",\n" +
                "        \"id\": \"466\",\n" +
                "        \"name\": \"Java 集合和继承关系图 · jusonqiu/note Wiki\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://github.com/jusonqiu/note/wiki/Java-%E9%9B%86%E5%90%88%E5%92%8C%E7%BB%A7%E6%89%BF%E5%85%B3%E7%B3%BB%E5%9B%BE\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070394000000\",\n" +
                "        \"id\": \"467\",\n" +
                "        \"name\": \"[译]Java集合接口和类的继承关系图 - 简书\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.jianshu.com/p/31ed50ab01e3\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070394000000\",\n" +
                "        \"id\": \"468\",\n" +
                "        \"name\": \"主要介绍HashMap的四种循环遍历方式，各种方式的性能测试对比，根据HashMap的源码实现分析性能结果，总结结论\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.trinea.cn/android/hashmap-loop-performance/\"\n" +
                "    } ],\n" +
                "    \"date_added\": \"13177070552587869\",\n" +
                "    \"date_modified\": \"13178209037587493\",\n" +
                "    \"id\": \"32\",\n" +
                "    \"name\": \"集合类\",\n" +
                "    \"sync_transaction_version\": \"466\",\n" +
                "    \"type\": \"folder\"\n" +
                "}, {\n" +
                "    \"children\": [ {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"664\",\n" +
                "        \"name\": \"spring官方文档中文版 - 王代军 - 博客园\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.cnblogs.com/wangdaijun/p/6142168.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"665\",\n" +
                "        \"name\": \"Index of /spring-framework/docs/current/spring-framework-reference\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://docs.spring.io/spring-framework/docs/current/spring-framework-reference/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"666\",\n" +
                "        \"name\": \"Overview (Spring Framework 4.3.5.RELEASE API)\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://docs.spring.io/spring/docs/current/javadoc-api/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"667\",\n" +
                "        \"name\": \"在线文档-Spring-3.1.1\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://tool.oschina.net/apidocs/apidoc?api=Spring-3.1.1\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"668\",\n" +
                "        \"name\": \"Spring Framework Reference Documentation\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://spring.cndocs.tk/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"669\",\n" +
                "        \"name\": \"Spring Framework Reference Documentation\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://docs.spring.io/spring/docs/4.3.0.RC2/spring-framework-reference/htmlsingle/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"670\",\n" +
                "        \"name\": \"Spring官方文档翻译（1~6章） - 唐彤的博客 - 博客频道 - CSDN.NET\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/tangtong1/article/details/51326887\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"671\",\n" +
                "        \"name\": \"国内第1套_Spring4 视频教程 - CSDN学院 - CSDN.NET\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://edu.csdn.net/course/detail/852\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"672\",\n" +
                "        \"name\": \"MVC 框架教程 - Spring 教程 - 极客学院Wiki\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://wiki.jikexueyuan.com/project/spring/web-mvc-framework.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"673\",\n" +
                "        \"name\": \"spring.jar   Index of release/org/springframework/spring\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://repo.spring.io/release/org/springframework/spring/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"674\",\n" +
                "        \"name\": \"\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://separatethis.com/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"675\",\n" +
                "        \"name\": \"了解http协议和restful规范 - 推酷\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.tuicool.com/articles/3uyqQvn\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"676\",\n" +
                "        \"name\": \"Andyの笔记 - 博客频道 - CSDN.NET\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/fengshizty?viewmode=list\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"677\",\n" +
                "        \"name\": \"shuzheng/zheng: 基于Spring+SpringMVC+Mybatis分布式敏捷开发系统架构：内容管理系统（门户、博客、论坛、问答等）、统一支付中心（微信、支付宝、在线网银等）、用户权限管理系统（RBAC细粒度用户\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://github.com/shuzheng/zheng\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"678\",\n" +
                "        \"name\": \"Spring Security优劣之我见 - caomiao2006的专栏 - 博客频道 - CSDN.NET\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/caomiao2006/article/details/51812401\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"679\",\n" +
                "        \"name\": \"Spring Security 简介 - 销魂独闯天涯路的专栏 - 博客频道 - CSDN.NET\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/u012517198/article/details/51648074\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"680\",\n" +
                "        \"name\": \"security.xml_百度搜索\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=baidu&wd=security.xml&oq=security&rsv_pq=af67fbf20000263b&rsv_t=8625Mb%2FIpFw2vjACqRPqobLMBk0Lr%2FwLBaeRs31R9gR%2F17gZb8Cx4cv%2Frx4&rqlang=cn&rsv_enter=1&rsv_sug3=4&rsv_sug1=1&rsv_sug7=100&rsv_sug2=0&inputT=891&rsv_sug4=891\"\n" +
                "    } ],\n" +
                "    \"date_added\": \"13177070552566964\",\n" +
                "    \"date_modified\": \"13178209037586081\",\n" +
                "    \"id\": \"23\",\n" +
                "    \"name\": \"spring\",\n" +
                "    \"sync_transaction_version\": \"77\",\n" +
                "    \"type\": \"folder\"\n" +
                "}, {\n" +
                "    \"children\": [ {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"561\",\n" +
                "        \"name\": \"21. Web MVC framework\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://docs.spring.io/spring-framework/docs/4.2.4.RELEASE/spring-framework-reference/html/mvc.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"562\",\n" +
                "        \"name\": \"Spring MVC 教程,快速入门,深入分析 - 赵磊的技术博客 - ITeye技术网站\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://elf8848.iteye.com/blog/875830\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"563\",\n" +
                "        \"name\": \"Spring MVC中文文档翻译发布 - - ITeye技术网站\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://sodagreen-simplicity.iteye.com/blog/2307252\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"564\",\n" +
                "        \"name\": \"\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://separatethis.com/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"565\",\n" +
                "        \"name\": \"springMVC和视图技术的整合_百度搜索\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=SE_hldp00800_iw44c7tx&wd=springMVC%E5%92%8C%E8%A7%86%E5%9B%BE%E6%8A%80%E6%9C%AF%E7%9A%84%E6%95%B4%E5%90%88&oq=springMV%26lt%3B&rsv_pq=e452922b00000a77&rsv_t=528613inliygTLWf9xPdF7h2FukaH4SY%2FgB3nHKDWJLDBwNN9nulH%2BZeLvoalqVaHxmUz%2FIoqZ5yGv0i&rsv_enter=1&rsv_sug3=33&rsv_sug1=7&rsv_sug7=100&rsv_sug2=0&inputT=8121&rsv_sug4=12241\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"566\",\n" +
                "        \"name\": \"【SpringMVC系列四】 springMVC 视图整合（1） - 刘腾腾 廊坊师范学院信息技术提高班 第九期 - 博客频道 - CSDN.NET\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/liutengteng130/article/details/42296501\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"567\",\n" +
                "        \"name\": \"Spring MVC中Session的正确用法之我见 - waytofall - 博客园\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.cnblogs.com/waytofall/p/3460533.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"568\",\n" +
                "        \"name\": \"Spring MVC 教程,快速入门,深入分析 - 技术博客 - ITeye技术网站\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://elf8848.iteye.com/blog/875830/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"569\",\n" +
                "        \"name\": \"Spring MVC 中的基于注解的 Controller - 虢兆坤 - ITeye技术网站\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://zachary-guo.iteye.com/blog/1318597#comments\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"570\",\n" +
                "        \"name\": \"Spring-Demo/spring-mvc-action-tutorial: 史上最全最强SpringMVC详细示例实战教程\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://github.com/Spring-Demo/spring-mvc-action-tutorial\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"571\",\n" +
                "        \"name\": \"史上最全最强SpringMVC详细示例实战教程 - Sunnier - 博客园\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.cnblogs.com/sunniest/p/4555801.html#commentform\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"572\",\n" +
                "        \"name\": \"0061 Spring MVC的数据格式化--Formatter--FormatterRegistrar--@DateTimeFormat--@NumberFormat - sonng - 博客园\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.cnblogs.com/sonng/p/6661273.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"573\",\n" +
                "        \"name\": \"springmvc前台向后台传值几种方式从简单到复杂 - revent的专栏 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/revent/article/details/64125965\"\n" +
                "    } ],\n" +
                "    \"date_added\": \"13177070552576996\",\n" +
                "    \"date_modified\": \"13178209037586531\",\n" +
                "    \"id\": \"26\",\n" +
                "    \"name\": \"springmvc\",\n" +
                "    \"sync_transaction_version\": \"78\",\n" +
                "    \"type\": \"folder\"\n" +
                "}, {\n" +
                "    \"children\": [ {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"613\",\n" +
                "        \"name\": \"hibernate学习方法\",\n" +
                "        \"sync_transaction_version\": \"84\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://note.youdao.com/share/?id=8e0fa054db1b9d4d2db62fe747fb603b&type=note#/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"614\",\n" +
                "        \"name\": \"Nexus Repository Manager\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://repository.jboss.org/nexus/index.html#nexus-search;gav~org.hibernate~hibernate-core~5.1.1.Final~~\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"615\",\n" +
                "        \"name\": \"Overview (Hibernate JavaDocs)\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://docs.jboss.org/hibernate/orm/5.1/javadocs/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"616\",\n" +
                "        \"name\": \"javax.persistence Class Hierarchy (hibernate-jpa-2.1-api 1.0.0.Final API)\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://docs.jboss.org/hibernate/jpa/2.1/api/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"617\",\n" +
                "        \"name\": \"Hibernate JavaDoc-4.1.4\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://tool.oschina.net/apidocs/apidoc?api=hibernate-4.1.4\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"618\",\n" +
                "        \"name\": \"Hibernate ORM 5.2 User Guide\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"619\",\n" +
                "        \"name\": \"Hibernate3.4马士兵 70page\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/tanyit/article/details/6987279#_Toc251597124\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"620\",\n" +
                "        \"name\": \"Hibernate Annotations\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://docs.jboss.org/hibernate/annotations/3.4/reference/zh_cn/html_single/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"621\",\n" +
                "        \"name\": \"Hibernate实战(第2版)(Hibernate之父亲自执笔)[按需印刷] - china-pub网上书店\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://product.china-pub.com/39339#ml\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"622\",\n" +
                "        \"name\": \"Hibernate学习要点总结_人生起航_新浪博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.sina.com.cn/s/blog_c12f8bdf0101c6jh.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"623\",\n" +
                "        \"name\": \"【SSH进阶之路】Hibernate基本原理（一） - 努力+坚持，而且还很年轻 - 博客频道 - CSDN.NET\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/jiuqiyuliang/article/details/39078749/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"624\",\n" +
                "        \"name\": \"23.二级缓存(1)-Hibernate视频教程在线学习与下载- 尚硅谷_佟刚\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.jczhijia.com/CoursePay/15818.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"625\",\n" +
                "        \"name\": \"佟刚hibernate_百度搜索\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.baidu.com/s?ie=UTF-8&wd=%E4%BD%9F%E5%88%9Ahibernate\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"626\",\n" +
                "        \"name\": \"Hibernate 4.2 入门视频教程_在线Java视频教程_课课家\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.kokojia.com/course-867.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"627\",\n" +
                "        \"name\": \"Hibernate4.0精讲视频课程（共50课时）_在线培训教程_51CTO学院\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://edu.51cto.com/course/course_id-4213.html?edu_recommend_adid=85\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"628\",\n" +
                "        \"name\": \"\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://separatethis.com/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"629\",\n" +
                "        \"name\": \"HIBERNATE - 开源搜索 - 开源中国社区\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.oschina.net/search?scope=code&q=HIBERNATE\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"630\",\n" +
                "        \"name\": \"Spring Hibernate 实现BaseDao - 开源中国社区\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.oschina.net/code/snippet_2395251_51563\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"631\",\n" +
                "        \"name\": \"hibernate 3 工具类 - 开源中国社区\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.oschina.net/code/snippet_176115_11688\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"632\",\n" +
                "        \"name\": \"Hibernate查询的各种方式效率比较 - 我的Java之路,关注Java技术的发展 - 博客频道 - CSDN.NET\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/zhouxianli/article/details/5253063\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"633\",\n" +
                "        \"name\": \"Hibernate查询数据的几种方式： - Mr.Sun - 博客频道 - CSDN.NET\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/sun_song520/article/details/50407971\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"634\",\n" +
                "        \"name\": \"HikariPool_百度搜索\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.baidu.com/s?ie=UTF-8&wd=HikariPool\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"635\",\n" +
                "        \"name\": \"hibernate 延迟加载深入分析（persistentSet的延迟加载） - 南开小巷 - 博客园\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.cnblogs.com/zhangshitong/p/5306442.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"636\",\n" +
                "        \"name\": \"Ehcache详细解读 - 四火的BLOG - ITeye技术网站\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://raychase.iteye.com/blog/1545906\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"637\",\n" +
                "        \"name\": \"getHibernateTemplate().executeWithNativeSession_百度搜索\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.baidu.com/s?wd=getHibernateTemplate().executeWithNativeSession\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"638\",\n" +
                "        \"name\": \"hibernate的executeWithNativeSession(HibernateCallbk())、execute(new HibernateCallback())无法对spring事务回滚 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/petershusheng/article/details/52432507\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"639\",\n" +
                "        \"name\": \"session.merge_百度搜索\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=baidu&wd=session.merge&oq=merge&rsv_pq=8939af420000a8d9&rsv_t=532cgT6sLRix7OEgpwfhIKCwYZ0vPIAlAqspltVugOOrBM%2BwYKtg3sy2Wdo&rqlang=cn&rsv_enter=1&rsv_sug3=9&rsv_sug1=2&rsv_sug7=100&rsv_sug2=0&inputT=2827&rsv_sug4=3516\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"640\",\n" +
                "        \"name\": \"session.merge ()方法 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/u012367513/article/details/38317765\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"641\",\n" +
                "        \"name\": \"Hibernate中的merge使用详情解说 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/lang_man_xing/article/details/7572964\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"642\",\n" +
                "        \"name\": \"hibernate游离状态_百度搜索\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.baidu.com/s?wd=hibernate%E6%B8%B8%E7%A6%BB%E7%8A%B6%E6%80%81\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"643\",\n" +
                "        \"name\": \"Hibernate持久化对象的生命周期（三种状态：临时、持久、游离 ） - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/u012881584/article/details/40434279\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"644\",\n" +
                "        \"name\": \"hibernate深度学习 游离状态 HQL - 燕云十八 - 博客园\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.cnblogs.com/hwcs/p/7462981.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"645\",\n" +
                "        \"name\": \"hibernate实体对象的三种状态:自由状态,持久状态,游离状态. - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/my773962804/article/details/51479712\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"646\",\n" +
                "        \"name\": \"Hibernate 对象的三种状态 持久状态 临时状态 游离状态 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/yulinlin_fei/article/details/52026510\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"647\",\n" +
                "        \"name\": \"hibernate中session的三种状态 - Hibernate - Java - ITeye论坛\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.iteye.com/topic/859826\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"648\",\n" +
                "        \"name\": \"对持久化对象的修改什么时候会保存到数据库_百度搜索\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.baidu.com/s?wd=%E5%AF%B9%E6%8C%81%E4%B9%85%E5%8C%96%E5%AF%B9%E8%B1%A1%E7%9A%84%E4%BF%AE%E6%94%B9%E4%BB%80%E4%B9%88%E6%97%B6%E5%80%99%E4%BC%9A%E4%BF%9D%E5%AD%98%E5%88%B0%E6%95%B0%E6%8D%AE%E5%BA%93\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"649\",\n" +
                "        \"name\": \"托管状态与游离状态 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/hongtaq/article/details/7906843\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"650\",\n" +
                "        \"name\": \"hibernate session 3种状态_百度搜索\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=baidu&wd=hibernate%20session%203%E7%A7%8D%E7%8A%B6%E6%80%81&oq=hibernate%2520session4%25E7%25A7%258D%25E7%258A%25B6%25E6%2580%2581&rsv_pq=d0e1828d00000559&rsv_t=9f37BOXQs3DebhUzHhKRYF%2F6phUBdXFzxTd7bT35jKxKqaVaFFSPqpoMV8Q&rqlang=cn&rsv_enter=1&inputT=3387&rsv_sug3=12&rsv_sug1=2&rsv_sug7=000&rsv_sug2=0&rsv_sug4=4518&rsv_sug=1\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"651\",\n" +
                "        \"name\": \"hibernate中的session几种状态 - codeZhu - 博客园\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.cnblogs.com/Jc-zhu/p/4527155.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"652\",\n" +
                "        \"name\": \"Hibernate Session 4种对象状态 - 陆伟 - 博客园\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.cnblogs.com/bulrush/p/7786973.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"653\",\n" +
                "        \"name\": \"执行session merge方法后数据没有保存到数据库_百度搜索\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=baidu&wd=%E6%89%A7%E8%A1%8Csession%20merge%E6%96%B9%E6%B3%95%E5%90%8E%E6%95%B0%E6%8D%AE%E6%B2%A1%E6%9C%89%E4%BF%9D%E5%AD%98%E5%88%B0%E6%95%B0%E6%8D%AE%E5%BA%93&oq=session%2520merge%25E5%2590%258E%25E6%2595%25B0%25E6%258D%25AE%25E6%25B2%25A1%25E6%259C%2589%25E4%25BF%259D%25E5%25AD%2598%25E5%2588%25B0%25E6%2595%25B0%25E6%258D%25AE%25E5%25BA%2593&rsv_pq=b49819e60000ff4f&rsv_t=ed9a6MWHki9M971gGK8wMtY4YB%2BGnGDCGKYDeYvIgJVfhmTiyQGMJXcuabU&rqlang=cn&rsv_enter=1&inputT=10853&rsv_sug3=15&rsv_sug1=3&rsv_sug7=000&rsv_sug2=0&rsv_sug4=12819&rsv_sug=1\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"654\",\n" +
                "        \"name\": \"初学hibernate遇到了一个很费解的问题，hibernate使用merge()保存对象_百度知道\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://zhidao.baidu.com/question/425757460.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"655\",\n" +
                "        \"name\": \"hibernate generator_百度搜索\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=baidu&wd=hibernate%20generator&oq=generator&rsv_pq=869b35990000f119&rsv_t=21f6eePb3fnIEdBq9ZrcPw2H5nyj15WzEla3JYYogsFxMkWwBckzr1mGQuI&rqlang=cn&rsv_enter=1&rsv_sug3=2&rsv_sug1=1&rsv_sug7=100&bs=generator\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"656\",\n" +
                "        \"name\": \"Hibernate generator小结 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/ye1992/article/details/19632001\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"657\",\n" +
                "        \"name\": \"subline text格式化_百度搜索\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.baidu.com/s?wd=subline+text%E6%A0%BC%E5%BC%8F%E5%8C%96\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"658\",\n" +
                "        \"name\": \"Sublime中增加格式化代码的快捷键 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/abbuggy/article/details/9106619\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"659\",\n" +
                "        \"name\": \"js如何将字符串转换成数字_百度搜索\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.baidu.com/s?wd=js%E5%A6%82%E4%BD%95%E5%B0%86%E5%AD%97%E7%AC%A6%E4%B8%B2%E8%BD%AC%E6%8D%A2%E6%88%90%E6%95%B0%E5%AD%97\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"660\",\n" +
                "        \"name\": \"js 字符串转换成数字的三种方法 - Day by day的博客 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/w1019945543/article/details/62217974\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"661\",\n" +
                "        \"name\": \"js怎么把字符串转换成数字_百度知道\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://zhidao.baidu.com/question/372293549.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"662\",\n" +
                "        \"name\": \"ApplicationContextAware_百度搜索\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.baidu.com/s?wd=ApplicationContextAware\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"663\",\n" +
                "        \"name\": \"如何手动获取Spring容器中的bean（ApplicationContextAware 接口） - Dulk - 博客园\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.cnblogs.com/deng-cc/p/6373670.html\"\n" +
                "    } ],\n" +
                "    \"date_added\": \"13177070552568540\",\n" +
                "    \"date_modified\": \"13178686971567015\",\n" +
                "    \"id\": \"24\",\n" +
                "    \"name\": \"hibernate\",\n" +
                "    \"sync_transaction_version\": \"77\",\n" +
                "    \"type\": \"folder\"\n" +
                "}, {\n" +
                "    \"children\": [ {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"574\",\n" +
                "        \"name\": \"mybatis – MyBatis 3 | 入门\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.mybatis.org/mybatis-3/zh/getting-started.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"575\",\n" +
                "        \"name\": \"Overview (mybatis 3.4.1-SNAPSHOT API)\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.mybatis.org/mybatis-3/zh/apidocs/index.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"576\",\n" +
                "        \"name\": \"mybatis-spring – MyBatis-Spring | 第四章 事务\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.mybatis.org/spring/zh/transactions.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"577\",\n" +
                "        \"name\": \"MyBatis Generator – MyBatis Generator新增功能\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://mbg.cndocs.tk/whatsNew.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"578\",\n" +
                "        \"name\": \"mybatis实战教程(mybatis in action),mybatis入门到精通 - TechBirds在路上 - 博客频道 - CSDN.NET\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/techbirds_bao/article/details/9233599/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"579\",\n" +
                "        \"name\": \"Mybatis培训视频教程（共10课时）_在线培训教程_51CTO学院\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://edu.51cto.com/course/course_id-1354-page-1.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"580\",\n" +
                "        \"name\": \"Mybatis - 随笔分类 - 孤傲苍狼 - 博客园\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.cnblogs.com/xdp-gacl/category/655890.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"581\",\n" +
                "        \"name\": \"MyBatis环境配置及入门 - MyBatis教程\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.yiibai.com/mybatis/install_configure.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"582\",\n" +
                "        \"name\": \"使用maven构建spring mvc+mybatis应用 - CSDN学院 - CSDN.NET\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://edu.csdn.net/course/detail/1516\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"583\",\n" +
                "        \"name\": \"SSM框架——详细整合教程（Spring+SpringMVC+MyBatis） - AndyLizh的专栏 - 博客频道 - CSDN.NET\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/gebitan505/article/details/44455235/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"584\",\n" +
                "        \"name\": \"SSM框架——详细整合教程（Spring+SpringMVC+MyBatis） - 在路上 - 博客频道 - CSDN.NET\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/zhshulin/article/details/37956105\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"585\",\n" +
                "        \"name\": \"\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://separatethis.com/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"586\",\n" +
                "        \"name\": \"mybatis resultMap 用在什么情况下？_百度知道\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://zhidao.baidu.com/link?url=XGs5q9lXc7I0y1wp9FpDXZpwCOSZB2sZEBze9uau-ixQ3Vk6ePQ7GRspyfzVXY_YNJdwisjW5u7WMjdHvEftjq\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"587\",\n" +
                "        \"name\": \"MyBatis和Hibernate相比，优势在哪里？ - Hibernate - 知乎\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.zhihu.com/question/21104468\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"588\",\n" +
                "        \"name\": \"mybatis 多对多 处理 - - ITeye技术网站\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://feiyeguohai.iteye.com/blog/1180898/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"589\",\n" +
                "        \"name\": \"关于mybaits多对多的映射的一个问题-CSDN问答\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://ask.csdn.net/questions/332991\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"590\",\n" +
                "        \"name\": \"解决字段名与实体类属性名不相同的冲突 - 渣渣 - 博客频道 - CSDN.NET\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/sun_wangdong/article/details/48518687\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"591\",\n" +
                "        \"name\": \"06_一对多联表查询_Mybatis培训视频教程（共10课时）_在线培训教程_51CTO学院\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://edu.51cto.com/lesson/id-25784.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"592\",\n" +
                "        \"name\": \"MyBatis魔法堂：ResultMap详解 - ^_^肥仔John - 博客园\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.cnblogs.com/fsjohnhuang/p/4076592.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"593\",\n" +
                "        \"name\": \"Mybatis表关联一对多 - MyBatis教程\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.yiibai.com/mybatis/mybatis-one2many.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"594\",\n" +
                "        \"name\": \"Mybatis 示例之 Association - 偶尔记一下 - 博客频道 - CSDN.NET\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/isea533/article/details/20868189\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"595\",\n" +
                "        \"name\": \"一步步学Mybatis-告别繁琐的配置之Mybatis配置文件生成工具 （7） - 红烧狮子头 - 博客园\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.cnblogs.com/daviddai/p/3485595.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"596\",\n" +
                "        \"name\": \"mybatis如何创建别名在单独的配置文件_百度搜索\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.baidu.com/s?ie=utf-8&f=3&rsv_bp=1&tn=baidu&wd=mybatis%E5%A6%82%E4%BD%95%E5%88%9B%E5%BB%BA%E5%88%AB%E5%90%8D%E5%9C%A8%E5%8D%95%E7%8B%AC%E7%9A%84%E9%85%8D%E7%BD%AE%E6%96%87%E4%BB%B6&rsv_pq=b521181c000635f7&rsv_t=203d%2F%2Fd3fBE21hUrgTx3G5QL5%2BQetHAIm8Fsnlfn%2Fnd3qJ8m02luIm0N2sc&rqlang=cn&rsv_enter=1&rsv_sug3=11&rsv_sug1=1&rsv_sug7=000&rsv_sug2=0&prefixsug=mybatis%E5%A6%82%E4%BD%95%E5%88%9B%E5%BB%BA%E5%88%AB%E5%90%8D%E5%9C%A8%E5%8D%95%E7%8B%AC%E7%9A%84%E9%85%8D%E7%BD%AE%E6%96%87%E4%BB%B6&rsp=0&inputT=8269&rsv_sug4=12368&rsv_sug=1\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"597\",\n" +
                "        \"name\": \"mybatis完整demo_百度搜索\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.baidu.com/s?wd=mybatis%E5%AE%8C%E6%95%B4demo&pn=10&oq=mybatis%E5%AE%8C%E6%95%B4demo&ie=utf-8&rsv_pq=82a056db00026ef9&rsv_t=dd84rKInVQBqAKu91OM4Vbb02PIN0znTenYqHOUsWNJcnU4kPVCu9IZbul0&rsv_page=1\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"598\",\n" +
                "        \"name\": \"Mybatis系列之-连接数据库的配置单独放在一个properties文件中 - - 博客频道 - CSDN.NET\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/xiaohan2826/article/details/49510257\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"599\",\n" +
                "        \"name\": \"mybatis使用版本控制并发 - Mybatis - Coin163\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.coin163.com/d/mybatis/mybatis-version.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"600\",\n" +
                "        \"name\": \"Mybatis乐观锁插件 - 若鱼的专栏 - 博客频道 - CSDN.NET\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/goldenfish1919/article/details/51750653\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"601\",\n" +
                "        \"name\": \"mybatis使用版本控制并发 - Mybatis - Coin163\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.coin163.com/d/mybatis/mybatis-version.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"602\",\n" +
                "        \"name\": \"如何自定义eclipse代码格式化（Ctrl+Shift+F） - 戎码一生\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://rongmayisheng.com/post/%E5%A6%82%E4%BD%95%E8%87%AA%E5%AE%9A%E4%B9%89eclipse%E4%BB%A3%E7%A0%81%E6%A0%BC%E5%BC%8F%E5%8C%96%EF%BC%88ctrlshiftf%EF%BC%89\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"603\",\n" +
                "        \"name\": \"Mybatis乐观锁插件 - 若鱼的专栏 - 博客频道 - CSDN.NET\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/goldenfish1919/article/details/51750653\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"604\",\n" +
                "        \"name\": \"一级缓存应用---通过项目逐步深入了解Mybatis(四) - 简书\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.jianshu.com/p/b2c5f7b6c58f\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"605\",\n" +
                "        \"name\": \"请求一下 mybatis 的spring的注解事务控制返回id主键的问题-CSDN论坛-CSDN.NET-中国最大的IT技术社区\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://bbs.csdn.net/topics/390848655\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"606\",\n" +
                "        \"name\": \"mybatis selectMap方法使用注意事项\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.denghuafeng.com/post-238.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"607\",\n" +
                "        \"name\": \"mybaits 类的属性是map该如何写映射文件。详情如图。发现自己没有财富值。。。只能说声感谢。_百度知道\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://zhidao.baidu.com/question/436777662991305284.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"608\",\n" +
                "        \"name\": \"深入浅出Mybatis系列（五）---TypeHandler简介及配置（mybatis源码篇） - 南轲梦 - 博客园\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.cnblogs.com/dongying/p/4040435.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"609\",\n" +
                "        \"name\": \"MyBatis之TypeHandler - 余林丰 - 博客园\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.cnblogs.com/yulinfeng/p/5991170.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"610\",\n" +
                "        \"name\": \"Mybatis字段映射Map - 有个博客 - ITeye技术网站\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://tigerlchen.iteye.com/blog/1576414\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"611\",\n" +
                "        \"name\": \"MyBatis 3中实现一对多的插入和查询 - jubincn的专栏 - 博客频道 - CSDN.NET\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.csdn.net/jubincn/article/details/7446316\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"612\",\n" +
                "        \"name\": \"MyBatis使用Collection查询多对多或一对多结果集bug - ZimZz - 博客园 排序\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.cnblogs.com/zemliu/archive/2013/08/16/3263053.html\"\n" +
                "    } ],\n" +
                "    \"date_added\": \"13177070552573188\",\n" +
                "    \"date_modified\": \"13178209037586383\",\n" +
                "    \"id\": \"25\",\n" +
                "    \"name\": \"mybatis\",\n" +
                "    \"sync_transaction_version\": \"78\",\n" +
                "    \"type\": \"folder\"\n" +
                "}, {\n" +
                "    \"children\": [ {\n" +
                "        \"date_added\": \"13177070243000000\",\n" +
                "        \"id\": \"1152\",\n" +
                "        \"name\": \"LayIM接入案例Java篇 - Fly社区\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://fly.layui.com/jie/3229/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070243000000\",\n" +
                "        \"id\": \"1153\",\n" +
                "        \"name\": \"微信登陆\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://php.77wx.cn/Yue/Index/index\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070243000000\",\n" +
                "        \"id\": \"1154\",\n" +
                "        \"name\": \"一些LayIM更新建议，都是本人使用过程中遇到的问题和觉得还算需要的一些功能，不喜勿喷 - Fly社区\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://fly.layui.com/jie/15619/#item-1512633715203\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070243000000\",\n" +
                "        \"id\": \"1155\",\n" +
                "        \"name\": \"离线消息的处理 - Fly社区\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://fly.layui.com/jie/4110/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070243000000\",\n" +
                "        \"id\": \"1156\",\n" +
                "        \"name\": \"如何接受离线消息，有大牛提供一下思路吗 - Fly社区\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://fly.layui.com/jie/17113/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070243000000\",\n" +
                "        \"id\": \"1157\",\n" +
                "        \"name\": \"LayIM社交模式 在线演示 - Layui\",\n" +
                "        \"sync_transaction_version\": \"220\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://layim.pdosgk.com/Home/Swoole/layim.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070257000000\",\n" +
                "        \"id\": \"1158\",\n" +
                "        \"name\": \"websocket框架socket-io-java使用小结 - 简书\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.jianshu.com/p/7a076661e099\"\n" +
                "    } ],\n" +
                "    \"date_added\": \"13178209037583118\",\n" +
                "    \"date_modified\": \"13179921316450788\",\n" +
                "    \"id\": \"6\",\n" +
                "    \"name\": \"layim\",\n" +
                "    \"sync_transaction_version\": \"1\",\n" +
                "    \"type\": \"folder\"\n" +
                "}, {\n" +
                "    \"children\": [ {\n" +
                "        \"date_added\": \"13177067808000000\",\n" +
                "        \"id\": \"1119\",\n" +
                "        \"name\": \"jQuery 教程\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.w3school.com.cn/jquery/index.asp\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177067819000000\",\n" +
                "        \"id\": \"1120\",\n" +
                "        \"name\": \"jquery在线手册|jQuery API中文手册|jQuery速查表|jQuery参考手册|jQuery API|jQuery在线文档|jQuery最新手册\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.jq22.com/chm/jquery/index.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177067770000000\",\n" +
                "        \"id\": \"1121\",\n" +
                "        \"name\": \"jQuery插件库-收集最全最新最好的jQuery插件\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.jq22.com/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177067832000000\",\n" +
                "        \"id\": \"1122\",\n" +
                "        \"name\": \"HTML 教程 | 菜鸟教程\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.runoob.com/html/html-tutorial.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177067843000000\",\n" +
                "        \"id\": \"1123\",\n" +
                "        \"name\": \"HTML 参考手册\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.w3school.com.cn/tags/index.asp\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177067856000000\",\n" +
                "        \"id\": \"1124\",\n" +
                "        \"name\": \"CSS参考手册_web前端开发参考手册系列\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://css.doyoe.com/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177067868000000\",\n" +
                "        \"id\": \"1125\",\n" +
                "        \"name\": \"CSS 教程\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.w3school.com.cn/css/index.asp\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177067885000000\",\n" +
                "        \"id\": \"1126\",\n" +
                "        \"name\": \"CSS 教程 | 菜鸟教程\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.runoob.com/css/css-tutorial.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068097000000\",\n" +
                "        \"id\": \"1113\",\n" +
                "        \"name\": \"npm 与 yarn 命令对比 - 前端进阶之路 - SegmentFault 思否\",\n" +
                "        \"sync_transaction_version\": \"80\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://segmentfault.com/a/1190000008632323\"\n" +
                "    } ],\n" +
                "    \"date_added\": \"13178209037583736\",\n" +
                "    \"date_modified\": \"13178619433912375\",\n" +
                "    \"id\": \"11\",\n" +
                "    \"name\": \"frontend\",\n" +
                "    \"sync_transaction_version\": \"1\",\n" +
                "    \"type\": \"folder\"\n" +
                "}, {\n" +
                "    \"children\": [ {\n" +
                "        \"date_added\": \"13177067942000000\",\n" +
                "        \"id\": \"1116\",\n" +
                "        \"name\": \"CSS - box-sizing\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://zh.learnlayout.com/box-sizing.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177067957000000\",\n" +
                "        \"id\": \"1117\",\n" +
                "        \"name\": \"RGB颜色查询对照表\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.114la.com/other/rgb.htm\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070231000000\",\n" +
                "        \"id\": \"1118\",\n" +
                "        \"name\": \"CSS布局说——可能是最全的 - 前端随笔 - SegmentFault 思否\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://segmentfault.com/a/1190000011358507\"\n" +
                "    } ],\n" +
                "    \"date_added\": \"13178209037583875\",\n" +
                "    \"date_modified\": \"13178209037583875\",\n" +
                "    \"id\": \"12\",\n" +
                "    \"name\": \"css\",\n" +
                "    \"sync_transaction_version\": \"1\",\n" +
                "    \"type\": \"folder\"\n" +
                "}, {\n" +
                "    \"children\": [ {\n" +
                "        \"date_added\": \"13177067981000000\",\n" +
                "        \"id\": \"1114\",\n" +
                "        \"name\": \"ECMAScript 6入门\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://es6.ruanyifeng.com/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177067996000000\",\n" +
                "        \"id\": \"1115\",\n" +
                "        \"name\": \"ECMAScript 6 compatibility table\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://kangax.github.io/compat-table/es6/\"\n" +
                "    } ],\n" +
                "    \"date_added\": \"13178209037584029\",\n" +
                "    \"date_modified\": \"13178209037584029\",\n" +
                "    \"id\": \"13\",\n" +
                "    \"name\": \"es6\",\n" +
                "    \"sync_transaction_version\": \"1\",\n" +
                "    \"type\": \"folder\"\n" +
                "}, {\n" +
                "    \"children\": [ {\n" +
                "        \"date_added\": \"13177068482000000\",\n" +
                "        \"id\": \"1109\",\n" +
                "        \"name\": \"SQL 教程 | 菜鸟教程\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.runoob.com/sql/sql-tutorial.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068482000000\",\n" +
                "        \"id\": \"1110\",\n" +
                "        \"name\": \"21分钟 MySQL 入门教程 - wid - 博客园\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.cnblogs.com/mr-wid/archive/2013/05/09/3068229.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068482000000\",\n" +
                "        \"id\": \"1111\",\n" +
                "        \"name\": \"MongoDB 教程 | 菜鸟教程\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.runoob.com/mongodb/mongodb-tutorial.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068482000000\",\n" +
                "        \"id\": \"1112\",\n" +
                "        \"name\": \"DBCollection\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://api.mongodb.com/java/current/com/mongodb/DBCollection.html\"\n" +
                "    } ],\n" +
                "    \"date_added\": \"13178209037584308\",\n" +
                "    \"date_modified\": \"13178209037584308\",\n" +
                "    \"id\": \"15\",\n" +
                "    \"name\": \"db\",\n" +
                "    \"sync_transaction_version\": \"1\",\n" +
                "    \"type\": \"folder\"\n" +
                "}, {\n" +
                "    \"children\": [ {\n" +
                "        \"date_added\": \"13178011047760611\",\n" +
                "        \"id\": \"1106\",\n" +
                "        \"name\": \"Windows下NoSql图形数据库☞Neo4j的安装+环境变量配置+服务注册+访问 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://blog.csdn.net/appleyk/article/details/79091898\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13178012331917347\",\n" +
                "        \"id\": \"1107\",\n" +
                "        \"name\": \"solr7.4 安装与使用 - Tony_ding - 博客园\",\n" +
                "        \"sync_transaction_version\": \"35\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.cnblogs.com/tony-zt/p/9260017.html\"\n" +
                "    } ],\n" +
                "    \"date_added\": \"13178209037584760\",\n" +
                "    \"date_modified\": \"13178209037584760\",\n" +
                "    \"id\": \"16\",\n" +
                "    \"name\": \"neo4j\",\n" +
                "    \"sync_transaction_version\": \"1\",\n" +
                "    \"type\": \"folder\"\n" +
                "}, {\n" +
                "    \"children\": [ {\n" +
                "        \"date_added\": \"13177070198000000\",\n" +
                "        \"id\": \"1093\",\n" +
                "        \"name\": \"Gist-templates-plugin\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://geowarin.github.io/gist-templates-plugin/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070198000000\",\n" +
                "        \"id\": \"1094\",\n" +
                "        \"name\": \"IntelliJ IDEA之创建自己的注释模板Live Templates - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://blog.csdn.net/mhs624014469/article/details/76285258\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070198000000\",\n" +
                "        \"id\": \"1095\",\n" +
                "        \"name\": \"Java开发必装的IntelliJ IDEA插件-HollisChuang's Blog\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.hollischuang.com/archives/966\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070198000000\",\n" +
                "        \"id\": \"1096\",\n" +
                "        \"name\": \"IntelliJ IDEA 设置代码提示或自动补全的快捷键 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://blog.csdn.net/renfufei/article/details/45392907\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070198000000\",\n" +
                "        \"id\": \"1097\",\n" +
                "        \"name\": \"Android Studio项目应该提交哪些文件到GitHub上？ - 知乎\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.zhihu.com/question/37910193\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070198000000\",\n" +
                "        \"id\": \"1098\",\n" +
                "        \"name\": \"java - idea提交svn为什么都不提交iml文件，这东西如何手动创建 - SegmentFault 思否\",\n" +
                "        \"sync_transaction_version\": \"220\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://segmentfault.com/q/1010000006179584\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070198000000\",\n" +
                "        \"id\": \"1099\",\n" +
                "        \"name\": \"GitHub合并2个项目并保留commit记录 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://blog.csdn.net/u010887744/article/details/72853894\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070198000000\",\n" +
                "        \"id\": \"1100\",\n" +
                "        \"name\": \"java - \\\"from unexpected\\\" when createQuery - Stack Overflow\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://stackoverflow.com/questions/42871038/from-unexpected-when-createquery\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070198000000\",\n" +
                "        \"id\": \"1101\",\n" +
                "        \"name\": \"Intellij IDEA 自动清除无效 import 和 清除无效 import 的快捷键 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://blog.csdn.net/HeatDeath/article/details/79353990\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070198000000\",\n" +
                "        \"id\": \"1102\",\n" +
                "        \"name\": \"maven 下载 源码和javadoc命令 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://blog.csdn.net/topwqp/article/details/8902863\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070198000000\",\n" +
                "        \"id\": \"1103\",\n" +
                "        \"name\": \"IntelliJ IDEA 内存优化最佳实践 - OneAPM 博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://blog.oneapm.com/apm-tech/426.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070198000000\",\n" +
                "        \"id\": \"1104\",\n" +
                "        \"name\": \"在Intellij IDEA中使用Debug - bojiangzhou - 博客园\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.cnblogs.com/chiangchou/p/idea-debug.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070198000000\",\n" +
                "        \"id\": \"1105\",\n" +
                "        \"name\": \"Idea设置默认不折叠一行的函数 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"220\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://blog.csdn.net/bewilderment/article/details/48493447\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13179919278642513\",\n" +
                "        \"id\": \"1239\",\n" +
                "        \"name\": \"webstorm 格式化代码及常用快捷键 一介布衣\",\n" +
                "        \"sync_transaction_version\": \"220\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://yijiebuyi.com/blog/8c94ccab84a48c5702158aac974f7841.html\"\n" +
                "    } ],\n" +
                "    \"date_added\": \"13178209037584960\",\n" +
                "    \"date_modified\": \"13179921316450786\",\n" +
                "    \"id\": \"17\",\n" +
                "    \"name\": \"idea\",\n" +
                "    \"sync_transaction_version\": \"1\",\n" +
                "    \"type\": \"folder\"\n" +
                "}, {\n" +
                "    \"children\": [ {\n" +
                "        \"date_added\": \"13177070207000000\",\n" +
                "        \"id\": \"1088\",\n" +
                "        \"name\": \"使用VS Code快速编写HTML - 简书\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.jianshu.com/p/e1f5e0c01967\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070207000000\",\n" +
                "        \"id\": \"1089\",\n" +
                "        \"name\": \"Visual Studio Code之常备快捷键 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://blog.csdn.net/u010019717/article/details/50443970\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070207000000\",\n" +
                "        \"id\": \"1090\",\n" +
                "        \"name\": \"How do you format code in Visual Studio Code (VSCode) - Stack Overflow\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://stackoverflow.com/questions/29973357/how-do-you-format-code-in-visual-studio-code-vscode\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070207000000\",\n" +
                "        \"id\": \"1091\",\n" +
                "        \"name\": \"VS Code折腾记 - (2) 快捷键大全，没有更全 - CSDN博客\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://blog.csdn.net/crper/article/details/54099319\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070207000000\",\n" +
                "        \"id\": \"1092\",\n" +
                "        \"name\": \"在Visual Studio Code（VSCode）中如果做代码格式化？ - 纯净的天空\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://vimsky.com/article/3566.html\"\n" +
                "    } ],\n" +
                "    \"date_added\": \"13178209037585138\",\n" +
                "    \"date_modified\": \"13178209037585138\",\n" +
                "    \"id\": \"18\",\n" +
                "    \"name\": \"vscode\",\n" +
                "    \"sync_transaction_version\": \"1\",\n" +
                "    \"type\": \"folder\"\n" +
                "}, {\n" +
                "    \"children\": [ {\n" +
                "        \"date_added\": \"13179483031569784\",\n" +
                "        \"id\": \"1225\",\n" +
                "        \"name\": \"Spring Security(一)--Architecture Overview | 徐靖峰|个人博客\",\n" +
                "        \"sync_transaction_version\": \"206\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.cnkirito.moe/spring-security-1/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13179495824776985\",\n" +
                "        \"id\": \"1228\",\n" +
                "        \"name\": \"Spring Boot（上）\",\n" +
                "        \"sync_transaction_version\": \"206\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.chilangedu.com/course/1489582623.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13179548555434385\",\n" +
                "        \"id\": \"1229\",\n" +
                "        \"name\": \"程序猿DD/SpringBoot-Learning: Spring Boot教程与Spring Cloud教程，Spring Boot 2.0新特性讲解连载中！！！\",\n" +
                "        \"sync_transaction_version\": \"206\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://gitee.com/didispace/SpringBoot-Learning\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13179482418949382\",\n" +
                "        \"id\": \"1223\",\n" +
                "        \"name\": \"鸿洋\",\n" +
                "        \"sync_transaction_version\": \"206\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://mp.weixin.qq.com/s?__biz=MzAxMTI4MTkwNQ==&mid=2650825102&idx=1&sn=4cc793e81189c68f664327038f878944&chksm=80b7b510b7c03c06aa3fe1f0984d77990bbe757ef7cb85e3a111aaaedd1d7e7671edf929b451&mpshare=1&scene=1&srcid=0312K7bQvNvr1L9l2GplitcT#rd\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177671162392326\",\n" +
                "        \"id\": \"36\",\n" +
                "        \"name\": \"javascript - 如何正确判断js数据类型 - SegmentFault 思否\",\n" +
                "        \"sync_transaction_version\": \"206\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://segmentfault.com/q/1010000000464600\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177671379174814\",\n" +
                "        \"id\": \"35\",\n" +
                "        \"name\": \"jQuery中DOM节点的删除方法总结（超全面）_js_猪先飞\",\n" +
                "        \"sync_transaction_version\": \"207\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.zhuxianfei.com/jishu/js/24071.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13179895798878464\",\n" +
                "        \"id\": \"1234\",\n" +
                "        \"name\": \"polyfill为何物 - 掘金\",\n" +
                "        \"sync_transaction_version\": \"220\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://juejin.im/post/5a579bc7f265da3e38496ba1\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13179895809464441\",\n" +
                "        \"id\": \"1235\",\n" +
                "        \"name\": \"Web开发中的“黑话” - Livoras - SegmentFault 思否\",\n" +
                "        \"sync_transaction_version\": \"220\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://segmentfault.com/a/1190000002593432\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13179896945515002\",\n" +
                "        \"id\": \"1236\",\n" +
                "        \"name\": \"区别 dependencies、devDependencies\",\n" +
                "        \"sync_transaction_version\": \"220\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://blog.zfanw.com/difference-between-dependencies-and-devdependencies/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13179897127278014\",\n" +
                "        \"id\": \"1237\",\n" +
                "        \"name\": \"概念 | webpack 中文网\",\n" +
                "        \"sync_transaction_version\": \"220\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.webpackjs.com/concepts/\"\n" +
                "    } ],\n" +
                "    \"date_added\": \"13179895797160572\",\n" +
                "    \"date_modified\": \"13179921316450554\",\n" +
                "    \"id\": \"1233\",\n" +
                "    \"name\": \"0828\",\n" +
                "    \"sync_transaction_version\": \"206\",\n" +
                "    \"type\": \"folder\"\n" +
                "}, {\n" +
                "    \"children\": [ {\n" +
                "        \"date_added\": \"13180012116453422\",\n" +
                "        \"id\": \"1246\",\n" +
                "        \"name\": \"js 数组 map方法 - 神奇的旋风 - 博客园\",\n" +
                "        \"sync_transaction_version\": \"251\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.cnblogs.com/xuan52rock/p/4460949.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13180012123496552\",\n" +
                "        \"id\": \"1247\",\n" +
                "        \"name\": \"javascript中filter的用法 - cjx_work - 博客园\",\n" +
                "        \"sync_transaction_version\": \"251\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.cnblogs.com/cjx-work/p/8052865.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13180012134267928\",\n" +
                "        \"id\": \"1248\",\n" +
                "        \"name\": \"js(=>) 箭头函数 详细解说 案例大全 - 海纶 - 博客园\",\n" +
                "        \"sync_transaction_version\": \"350\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.cnblogs.com/hailun/p/6279029.html\"\n" +
                "    } ],\n" +
                "    \"date_added\": \"13180012113191919\",\n" +
                "    \"date_modified\": \"13180024702259663\",\n" +
                "    \"id\": \"1245\",\n" +
                "    \"name\": \"js\",\n" +
                "    \"sync_transaction_version\": \"253\",\n" +
                "    \"type\": \"folder\"\n" +
                "}, {\n" +
                "    \"children\": [ {\n" +
                "        \"date_added\": \"13180249252379762\",\n" +
                "        \"id\": \"1261\",\n" +
                "        \"name\": \"七周年战斗之夜- 英雄联盟官方网站 - 腾讯游戏\",\n" +
                "        \"sync_transaction_version\": \"465\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://lol.qq.com/act/a20180815fighting/?e_code=434654\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13180005736320269\",\n" +
                "        \"id\": \"1244\",\n" +
                "        \"name\": \"建立高质量“个人资料库”的五原则，知道越早，效果越好_36氪\",\n" +
                "        \"sync_transaction_version\": \"465\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://36kr.com/p/5150717.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13180422405865669\",\n" +
                "        \"id\": \"1262\",\n" +
                "        \"name\": \"\",\n" +
                "        \"sync_transaction_version\": \"466\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"file:///C:/Users/cyci/Desktop/images.jpg\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13179920260487300\",\n" +
                "        \"id\": \"1240\",\n" +
                "        \"name\": \"基于vue-cli快速构建 - 简书\",\n" +
                "        \"sync_transaction_version\": \"466\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.jianshu.com/p/2769efeaa10a\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13180591905784955\",\n" +
                "        \"id\": \"1264\",\n" +
                "        \"meta_info\": {\n" +
                "            \"last_visited_desktop\": \"13180784973597058\"\n" +
                "        },\n" +
                "        \"name\": \"[北京/RoW] FydeOS | 燧炻创新招聘全栈及前端开发 - V2EX\",\n" +
                "        \"sync_transaction_version\": \"466\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://lax.v2ex.com/t/473335\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177068482000000\",\n" +
                "        \"id\": \"1108\",\n" +
                "        \"name\": \"3\",\n" +
                "        \"sync_transaction_version\": \"466\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://www.runoob.com/mysql/mysql-tutorial.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070004000000\",\n" +
                "        \"id\": \"1140\",\n" +
                "        \"name\": \"2\",\n" +
                "        \"sync_transaction_version\": \"466\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://www.cnblogs.com/jikey/p/5201185.html\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070369000000\",\n" +
                "        \"id\": \"20\",\n" +
                "        \"meta_info\": {\n" +
                "            \"last_visited_desktop\": \"13180672296076826\"\n" +
                "        },\n" +
                "        \"name\": \"1\",\n" +
                "        \"sync_transaction_version\": \"466\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"https://github.com/rejerry\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13179463260268568\",\n" +
                "        \"id\": \"1218\",\n" +
                "        \"name\": \"\",\n" +
                "        \"sync_transaction_version\": \"466\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"chrome://bookmarks/\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13179895456704485\",\n" +
                "        \"id\": \"1232\",\n" +
                "        \"name\": \"\",\n" +
                "        \"sync_transaction_version\": \"466\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://dict.youdao.com/w/poly/#keyfrom=dict2.top\"\n" +
                "    } ],\n" +
                "    \"date_added\": \"13180784967046207\",\n" +
                "    \"date_modified\": \"13180785147184887\",\n" +
                "    \"id\": \"1272\",\n" +
                "    \"name\": \"temp\",\n" +
                "    \"sync_transaction_version\": \"465\",\n" +
                "    \"type\": \"folder\"\n" +
                "}, {\n" +
                "    \"children\": [ {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"686\",\n" +
                "        \"name\": \" backend\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://separatethis.com/\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1056\",\n" +
                "            \"name\": \"JSP 教程 | 菜鸟教程\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.runoob.com/jsp/jsp-tutorial.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1057\",\n" +
                "            \"name\": \"JSP 自定义标签 | 菜鸟教程\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.runoob.com/jsp/jsp-custom-tags.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1058\",\n" +
                "            \"name\": \"JSP 标准标签库（JSTL） | 菜鸟教程\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.runoob.com/jsp/jsp-jstl.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1059\",\n" +
                "            \"name\": \"JSP快速入门教程——全十讲 - 李绪成的一亩三分地 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/javaeeteacher/article/details/1932447\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1060\",\n" +
                "            \"name\": \"JSP 调试 | 菜鸟教程\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.runoob.com/jsp/jsp-debugging.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1061\",\n" +
                "            \"name\": \"JSP 调试 | 菜鸟教程\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.runoob.com/jsp/jsp-debugging.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1062\",\n" +
                "            \"name\": \"JSP的九大内置对象和四个作用域 - 王大叔爱编程的个人空间 - 开源中国社区\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://my.oschina.net/u/617909/blog/323527\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1063\",\n" +
                "            \"name\": \"JSTL 核心标签库 使用 - lihui_yy - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/lihuiyy/archive/2012/02/24/2366806.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1064\",\n" +
                "            \"name\": \"window.location.href的用法(动态输出跳转)_基础知识_脚本之家\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.jb51.net/article/53479.htm\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1065\",\n" +
                "            \"name\": \"eclipse编辑jsp文件和javascript代码很卡 - 古山龙的专栏 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/zyf_balance/article/details/45666277\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1066\",\n" +
                "            \"name\": \"在jsp中如何引入css的三种方法 - Yang_Tsai - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/yang_tsai/article/details/50600698\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1067\",\n" +
                "            \"name\": \"jsp、css中引入外部资源相对路径的问题 - 初学者心态 - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/jinianjun/p/4065022.html\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037617944\",\n" +
                "        \"date_modified\": \"13178209037617944\",\n" +
                "        \"id\": \"687\",\n" +
                "        \"name\": \"jsp\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1046\",\n" +
                "            \"name\": \"初学 Java Web 开发，请远离各种框架，从 Servlet 开发 - 开源中国社区\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.oschina.net/question/12_52027?sort=default&p=2#answers\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1047\",\n" +
                "            \"name\": \"Struts2视频教程（共45课时）_在线培训教程_51CTO学院\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://edu.51cto.com/course/course_id-960.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1048\",\n" +
                "            \"name\": \"Struts2教程\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.yiibai.com/struts_2/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1049\",\n" +
                "            \"name\": \"Overview (Struts 2 Core 2.5-BETA1 API)\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://struts.apache.org/maven/struts2-core/apidocs/index.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1050\",\n" +
                "            \"name\": \"servlet\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://separatethis.com/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1051\",\n" +
                "            \"name\": \"Servlet 教程 | 菜鸟教程\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.runoob.com/servlet/servlet-tutorial.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1052\",\n" +
                "            \"name\": \"HttpServletResponse和HttpServletRequest详解\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.mamicode.com/info-detail-394986.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1053\",\n" +
                "            \"name\": \"关于HTTP协议，一篇就够了 - ranyonsue - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/ranyonsue/p/5984001.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1054\",\n" +
                "            \"name\": \"servlet到底是什么？ - honghailiang的专栏 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/honghailiang888/article/details/50585475\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1055\",\n" +
                "            \"name\": \"HttpClient使用详解 - 鹏霄万里展雄飞 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/wangpeng047/article/details/19624529\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037617950\",\n" +
                "        \"date_modified\": \"13178209037617950\",\n" +
                "        \"id\": \"688\",\n" +
                "        \"name\": \"servlet\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1012\",\n" +
                "            \"name\": \"Java入门教程微学苑\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.weixueyuan.net/java/rumen/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1013\",\n" +
                "            \"name\": \"Overview (Java Platform SE 8 )\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://docs.oracle.com/javase/8/docs/api/index.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1014\",\n" +
                "            \"name\": \"在线文档-jdk_7u4\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://tool.oschina.net/apidocs/apidoc?api=jdk_7u4\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1015\",\n" +
                "            \"name\": \"Java设计培训课程|Java设计视频教程-腾讯课堂\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://ke.qq.com/course/list?mt=1001&st=2002&tt=3007\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1016\",\n" +
                "            \"name\": \"尚硅谷_全套Java\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.atguigu.com/download.shtml\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1017\",\n" +
                "            \"name\": \"\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://separatethis.com/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1018\",\n" +
                "            \"name\": \"HashMap,LinkedHashMap,TreeMap的有序性 - zhuhao717的专栏 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/zhuhao717/article/details/47444763\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1019\",\n" +
                "            \"name\": \"几种常用的设计模式介绍 - sengeiou的专栏 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/xsl1990/article/details/16359289\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1020\",\n" +
                "            \"name\": \"Java开发中的23种设计模式详解 - 退思园 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/doymm2008/article/details/13288067\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1021\",\n" +
                "            \"name\": \"在 Java 的注释上做文章(转) - 小猪快跑JAVA技术 - BlogJava\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.blogjava.net/fjq639/archive/2005/12/21/24928.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1022\",\n" +
                "            \"name\": \"Java编程风格与命名规范整理 - coolhwm - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/coolhwm/archive/2012/03/22/2411811.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1023\",\n" +
                "            \"name\": \"为什么做java的web开发我们会使用struts2，springMVC和spring这样的框架? · Issue #8 · RubyLouvre/agate · GitHub\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://github.com/RubyLouvre/agate/issues/8\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1024\",\n" +
                "            \"name\": \"java web开发规范 - - ITeye技术网站\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://kangxi4xjp.iteye.com/blog/1513832\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1025\",\n" +
                "            \"name\": \"Web开发技术(Java) - Java - IT610.com\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.it610.com/article/631123.htm\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1026\",\n" +
                "            \"name\": \"初学 Java Web 开发，请远离各种框架，从 Servlet 开发 - 开源中国社区\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.oschina.net/question/12_52027#tags_nav\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1027\",\n" +
                "            \"name\": \"JavaWeb开发学习——Tomcat的部署（一） - 程序园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.voidcn.com/blog/hc1025808587/article/p-2095278.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1028\",\n" +
                "            \"name\": \"java web开发规范 - - ITeye技术网站\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://kangxi4xjp.iteye.com/blog/1513832\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1029\",\n" +
                "            \"name\": \"Tomcat与Java Web开发技术详解_读书频道_51CTO.COM_领先的中文IT技术网站\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://book.51cto.com/art/200707/51416.htm\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1030\",\n" +
                "            \"name\": \"W3C的标准规范是怎样制定出来的？ - 51CTO.COM\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://developer.51cto.com/art/201608/515603.htm\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1031\",\n" +
                "            \"name\": \"java web开发规范是哪个公司制定的 - Google 搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.google.com/search?q=java+web%E5%BC%80%E5%8F%91%E8%A7%84%E8%8C%83%E6%98%AF%E5%93%AA%E4%B8%AA%E5%85%AC%E5%8F%B8%E5%88%B6%E5%AE%9A%E7%9A%84&ei=tM27V_71KoGv0ATPnrvIAQ&start=10&sa=N&biw=956&bih=933\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1032\",\n" +
                "            \"name\": \"JAVA EE规范_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?ie=UTF-8&wd=JAVA%20EE%E8%A7%84%E8%8C%83\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1033\",\n" +
                "            \"name\": \"JavaEE的13种核心技术规范_joker_新浪博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.sina.com.cn/s/blog_74f34c6101010zp4.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1034\",\n" +
                "            \"name\": \"JavaEE 7规范集 - chszs的专栏 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/chszs/article/details/9093273\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1035\",\n" +
                "            \"name\": \"Java EE 6规范中文版\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.chinaitlab.com/Java/Special/java_ee/Chapter6.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1036\",\n" +
                "            \"name\": \"对JAVAEE、规范的一点理解 - Tomcat,JBoss,JavaEE,规范,实现 - Java - ITeye论坛\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.iteye.com/topic/1125848\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1037\",\n" +
                "            \"name\": \"Java EE规范各个版本的比较V1.0_百度文库\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://wenku.baidu.com/link?url=Ba8UVu7NuGzAp4xAOt9ia6R8DlageIdKR9lm12zfRvgL5bwsg05Zj9alMjhKjahNB083LvKpRLWoK4e419dKPp5W7JjEjGquG0X94tmck2S\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1038\",\n" +
                "            \"name\": \"Java_EE架构的介绍_百度文库\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://wenku.baidu.com/link?url=cTq7pLyeRkXOg4ts6kgkpNM9uDAQtgwk4oCXtztyp6b40tYrhmHhRPt3N2tIhhzEZlZwYV4wAZ3chF0Ungw6LDH67Esr8ydPLJH5dgDImUO\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1039\",\n" +
                "            \"name\": \"Java EE体系有哪些标准?详细一点谢谢！_百度知道\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://zhidao.baidu.com/link?url=tBxoJYcyaoZAE5D6NACQUyI6C05oztL0gLPi7OqJOXdgWdlIHlXhhnQXwxz_LyDfctCYXdFgC1sCrB4pNNRSLK\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1040\",\n" +
                "            \"name\": \"企业级JAVA是一种基于什么的规范？_百度知道\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://zhidao.baidu.com/link?url=99YuqOhqZIxVBe_ZuxjI_ZSeMMRIuRRClumqzTAOlpqQ0reNUurz8BFEEmD30Li8PG8PW9cBcjTomNSMlIwPw57nBaTKZeFs4U1caR7ld8u\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1041\",\n" +
                "            \"name\": \"J2EE是一种技术还是一种平台，他提供了哪些技术 - 奋斗、 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/zheng0518/article/details/39104125\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1042\",\n" +
                "            \"name\": \"j2ee编程规范_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=baidu&wd=j2ee%E7%BC%96%E7%A8%8B%E8%A7%84%E8%8C%83&oq=j2ee%E7%BA%A6%E5%AE%9A%E7%BC%96%E7%A8%8B&rsv_pq=cfc7774c0000e002&rsv_t=4dfamodycoHhnOVMcF1ElZGVwQgskMbwFtYazfBC44Dtxi5rN2VtdjOI%2BqQ&rqlang=cn&rsv_enter=1&inputT=6321&rsv_sug3=38&rsv_sug1=17&rsv_sug7=100&rsv_sug2=0&rsv_sug4=6781\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1043\",\n" +
                "            \"name\": \"java 传参数时 类型后跟 3个点 “...” 的意义 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/gst6062825/article/details/7614433\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1044\",\n" +
                "            \"name\": \"java使用省略号代替多参数（参数类型... 参数名） - Boblim - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.cnblogs.com/fnlingnzb-learner/p/5952716.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1045\",\n" +
                "            \"name\": \"内部类_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?wd=%E5%86%85%E9%83%A8%E7%B1%BB\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037617953\",\n" +
                "        \"date_modified\": \"13178209037617953\",\n" +
                "        \"id\": \"689\",\n" +
                "        \"name\": \"java\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1003\",\n" +
                "            \"name\": \"json\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://separatethis.com/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1004\",\n" +
                "            \"name\": \"AJAX 实例 | 菜鸟教程\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.runoob.com/ajax/ajax-examples.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1005\",\n" +
                "            \"name\": \"jQuery ajax - ajax() 方法\",\n" +
                "            \"sync_transaction_version\": \"449\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.w3school.com.cn/jquery/ajax_ajax.asp\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1006\",\n" +
                "            \"name\": \"JSON 教程 | 菜鸟教程\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.runoob.com/json/json-tutorial.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1007\",\n" +
                "            \"name\": \"完全理解Gson（1）：简单入门 - ImportNew\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.importnew.com/16630.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1008\",\n" +
                "            \"name\": \"你真的会用Gson吗?Gson使用指南（一） - 简书\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.jianshu.com/p/e740196225a4\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1009\",\n" +
                "            \"name\": \"创建json文件_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?ie=utf-8&f=3&rsv_bp=1&tn=baidu&wd=%E5%88%9B%E5%BB%BAjson%E6%96%87%E4%BB%B6&oq=json%E6%96%87%E4%BB%B6%E4%B8%8B%E8%BD%BD&rsv_pq=89c523a800091b82&rsv_t=ae76W52PKh9Xvc4rDaHAf3V6eepc0cRoiuZk6dqo1LbtE3GncSv2gZVDidI&rqlang=cn&rsv_enter=1&rsv_sug3=14&rsv_sug1=12&rsv_sug7=100&rsv_sug2=0&prefixsug=%E5%88%9B%E5%BB%BAjson&rsp=3&inputT=46657&rsv_sug4=46656\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1010\",\n" +
                "            \"name\": \"怎么创建json文件-CSDN论坛-CSDN.NET-中国最大的IT技术社区\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://bbs.csdn.net/topics/390697422\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1011\",\n" +
                "            \"name\": \"关于Gson对日期的格式化 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/lilovfly/article/details/53504233\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037617957\",\n" +
                "        \"date_modified\": \"13180603750009645\",\n" +
                "        \"id\": \"690\",\n" +
                "        \"name\": \"json\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1000\",\n" +
                "            \"name\": \"windows下在一台电脑上配置多个git账号 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/mq2856992713/article/details/62090841\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1001\",\n" +
                "            \"name\": \"手把手叫你一台电脑配置两个Git账户 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/u012150370/article/details/52694629\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"1002\",\n" +
                "            \"name\": \"如何在一个电脑上同时使用两个Git的账号 - 简书\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.jianshu.com/p/rUPd9o\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037617961\",\n" +
                "        \"date_modified\": \"13178209037617961\",\n" +
                "        \"id\": \"691\",\n" +
                "        \"name\": \"git一台电脑设置两个git账户\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"996\",\n" +
                "            \"name\": \"一把DIY无线优联87机械键盘 - 电脑讨论 - Chiphell - 分享与交流用户体验\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.chiphell.com/forum.php?mod=viewthread&tid=1646164\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"997\",\n" +
                "            \"name\": \"心血来潮 机械键盘改无线 全矩阵飞线 - 电脑讨论 - Chiphell - 分享与交流用户体验\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.chiphell.com/thread-1695944-1-1.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"998\",\n" +
                "            \"name\": \"(7 条消息)为什么机械键盘没有无线的？ - 知乎\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.zhihu.com/question/21145944\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"999\",\n" +
                "            \"name\": \"怎么把有线机械键盘改为无线键盘？支持2.4G无线模块或者蓝牙都可以！_电脑知识_zblog模板\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.ylefu.com/post/410.html\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037617965\",\n" +
                "        \"date_modified\": \"13178209037617966\",\n" +
                "        \"id\": \"692\",\n" +
                "        \"name\": \"无线\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"693\",\n" +
                "        \"name\": \"frontend\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://separatethis.com/\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"982\",\n" +
                "            \"name\": \"Ant Design of React - Ant Design\",\n" +
                "            \"sync_transaction_version\": \"220\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://ant.design/docs/react/introduce-cn\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"983\",\n" +
                "            \"name\": \"项目实战 - Ant Design\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://ant.design/docs/react/practical-projects-cn\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"984\",\n" +
                "            \"name\": \"dva/README_zh-CN.md at master · dvajs/dva\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://github.com/dvajs/dva/blob/master/README_zh-CN.md\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"985\",\n" +
                "            \"name\": \"dva/Concepts_zh-CN.md at master · dvajs/dva\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://github.com/dvajs/dva/blob/master/docs/Concepts_zh-CN.md\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"986\",\n" +
                "            \"name\": \"自述 | Redux 中文文档 Join the chat at https://gitter.im/camsong/redux-in-chinese\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://cn.redux.js.org/index.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"987\",\n" +
                "            \"name\": \"dva/API_zh-CN.md at master · dvajs/dva\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://github.com/dvajs/dva/blob/master/docs/API_zh-CN.md\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"988\",\n" +
                "            \"name\": \"dvajs/dva-knowledgemap: Knowledge map for dva.\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://github.com/dvajs/dva-knowledgemap\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"989\",\n" +
                "            \"name\": \"sorrycc/roadhog: \uD83D\uDC37 Cli tool for creating react apps, configurable version of create-react-app.\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://github.com/sorrycc/roadhog#%E9%85%8D%E7%BD%AE\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"990\",\n" +
                "            \"name\": \"React + Ant Design 快速上手 - 知乎专栏\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://zhuanlan.zhihu.com/p/26743523\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"991\",\n" +
                "            \"name\": \"Redux 入门教程（一）：基本用法 - 阮一峰的网络日志\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.ruanyifeng.com/blog/2016/09/redux_tutorial_part_one_basic_usages.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"992\",\n" +
                "            \"name\": \"React全家桶之响应式编程：使用observable中间件实现redux异步数据流 - 知乎专栏\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://zhuanlan.zhihu.com/p/22437186\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"993\",\n" +
                "            \"name\": \"redux-observable笔记 - BestMe丶 - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/BestMePeng/p/redux_observable.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"994\",\n" +
                "            \"name\": \"动机 | Redux 中文文档\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.redux.org.cn/docs/introduction/Motivation.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"995\",\n" +
                "            \"name\": \"实例讲解react+react-router+redux - 前端小渣 - SegmentFault\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://segmentfault.com/a/1190000007862103\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037618002\",\n" +
                "        \"date_modified\": \"13179921316450776\",\n" +
                "        \"id\": \"694\",\n" +
                "        \"name\": \"antd\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"962\",\n" +
                "            \"name\": \"ES5, ES6, ES2016, ES.Next: JavaScript 的版本是怎么回事？「译」 - 黄玄的博客 | Hux Blog\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://huangxuan.me/2015/09/22/js-version/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"963\",\n" +
                "            \"name\": \"ECMAScript版本历史 - 简书\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.jianshu.com/p/11b58d1bfeed\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"964\",\n" +
                "            \"name\": \"js中严格模式与普通模式区别 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/sunshinegirl_7/article/details/49510371\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"965\",\n" +
                "            \"name\": \"Javascript 严格模式详解 - 阮一峰的网络日志\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.ruanyifeng.com/blog/2013/01/javascript_strict_mode.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"966\",\n" +
                "            \"name\": \"JavaScript中的Object，Function和自定义function之间的区别和联系 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/u013302153/article/details/53543882\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"967\",\n" +
                "            \"name\": \"jQuery.extend 函数使用详解 - zikai - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/zikai/p/5074686.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"968\",\n" +
                "            \"name\": \"在js 中 $ 的用处是什么，能具体解释下他怎么用吗_百度知道\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://zhidao.baidu.com/question/350777306.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"969\",\n" +
                "            \"name\": \"CSS、JS中的相对路径引用 - 徐下策 - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/xuxiace/archive/2012/03/06/2381874.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"970\",\n" +
                "            \"name\": \"onclick事件与href='javascript:function()'的比较 - - ITeye博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://niuxiaoxia870563296.iteye.com/blog/1735198\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"971\",\n" +
                "            \"name\": \"ajax上传文件提交时，enctype=multipart/form-data怎么带过去？_百度知道\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://zhidao.baidu.com/question/506442288.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"972\",\n" +
                "            \"name\": \"easyUI中PropertyGrid 设置不可编辑 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/erike_zhang/article/details/38401519\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"973\",\n" +
                "            \"name\": \"JS中对象的类型_前端-老李_新浪博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.sina.com.cn/s/blog_70a3539f0101eww3.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"974\",\n" +
                "            \"name\": \"也谈分离JavaScript和HTML - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/eengel/article/details/6193209\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"975\",\n" +
                "            \"name\": \"JavaScript代码放在HTML代码哪里比较好 | 编程开发-前端开发-专业编程开发技术网站\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.wufangbo.com/js-fang-na-li-hao/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"976\",\n" +
                "            \"name\": \"各种JS模板引擎对比数据(高性能JavaScript模板引擎) - itprobie-菜鸟程序员 - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/guohu/p/3870677.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"977\",\n" +
                "            \"name\": \"form.submit()与 window.location.href 区别_百度知道\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://zhidao.baidu.com/question/291848233.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"978\",\n" +
                "            \"name\": \"js中window.location提交传值与document.form.submit();提交传_百度知道\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://zhidao.baidu.com/question/2118773007496962467.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"979\",\n" +
                "            \"name\": \"用javascript:history.go(-1)返回上一页时,为什么出现网页已过期_百度知道\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://zhidao.baidu.com/question/155733326.html?qbl=relate_question_0&word=form%20submit%BB%E1%BD%AB%BC%C7%C2%BC%BC%D3%B5%BDwindow.history%C2%F0\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"980\",\n" +
                "            \"name\": \"form提交后，window.history.back(-1)显示网页已过期，get方法提交则没问题_百度知道\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://zhidao.baidu.com/question/348602317.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"981\",\n" +
                "            \"name\": \"javascript - window.location 和 window.location.href区别是什么 - SegmentFault 思否\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://segmentfault.com/q/1010000002729501\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037618006\",\n" +
                "        \"date_modified\": \"13178209037618006\",\n" +
                "        \"id\": \"695\",\n" +
                "        \"name\": \"js\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"956\",\n" +
                "            \"name\": \"HTML DOM setTimeout() 方法\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.w3school.com.cn/jsref/met_win_settimeout.asp\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"957\",\n" +
                "            \"name\": \"window.open_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=baidu&wd=window.open&oq=canvas%2520%25E6%2595%2599%25E7%25A8%258B&rsv_pq=896e08370000d7d1&rsv_t=99f07SGuz6uZvEf%2FSLfAVwx15oLSSnnwUSxpcVBSI3NjYbNDCo7twBu6hJ0&rqlang=cn&rsv_enter=1&inputT=2865&rsv_n=2&rsv_sug3=31&rsv_sug1=26&rsv_sug7=100&bs=canvas%20%E6%95%99%E7%A8%8B\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"958\",\n" +
                "            \"name\": \"JavaScript中判断对象类型的几种方法总结_基础知识_脚本之家\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.jb51.net/article/43032.htm\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"959\",\n" +
                "            \"name\": \"js中精确判断对象类型--关于typeof 和Object.prototype.toString方法的区别 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/Eva3288/article/details/52781128?locationNum=10\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"960\",\n" +
                "            \"name\": \"Javascript异步编程的4种方法 - 阮一峰的网络日志\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.ruanyifeng.com/blog/2012/12/asynchronous%EF%BC%BFjavascript.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"961\",\n" +
                "            \"name\": \"函数式编程入门教程 - 阮一峰的网络日志\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.ruanyifeng.com/blog/2017/02/fp-tutorial.html\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037618009\",\n" +
                "        \"date_modified\": \"13178209037618010\",\n" +
                "        \"id\": \"696\",\n" +
                "        \"name\": \"other\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"697\",\n" +
                "        \"name\": \"db\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://separatethis.com/\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"944\",\n" +
                "            \"name\": \"游标可以用来更新数据吗_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=baidu&wd=%E6%B8%B8%E6%A0%87%E5%8F%AF%E4%BB%A5%E7%94%A8%E6%9D%A5%E6%9B%B4%E6%96%B0%E6%95%B0%E6%8D%AE%E5%90%97&oq=sqlserver%25202014%25E6%25B8%25B8%25E6%25A0%2587&rsv_pq=99320e1a0002efe6&rsv_t=d0e3BUTgwn8inb5SkagsTCO1TElYX8MgqHWxbgsXnVb3gzkNwgwzSSjgIZ0&rqlang=cn&rsv_enter=1&inputT=5358&rsv_sug3=20&rsv_sug1=12&rsv_sug7=100&rsv_sug2=0&rsv_sug4=5358\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"945\",\n" +
                "            \"name\": \"使用游标更新和删除数据 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/helloboat/article/details/51927580\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"946\",\n" +
                "            \"name\": \"SQLServer游标详解 - 一切源于简单 - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.cnblogs.com/myboke/p/3738912.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"947\",\n" +
                "            \"name\": \"SQL Server游标的使用【转】 - moss_tan_jun - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.cnblogs.com/moss_tan_jun/archive/2011/11/26/2263988.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"948\",\n" +
                "            \"name\": \"SQLSERVER存储过程基本语法 - Chaoa - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.cnblogs.com/chaoa/articles/3894311.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"949\",\n" +
                "            \"name\": \"SQL中游标的使用(转) - quietwalk - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.cnblogs.com/quietwalk/archive/2011/10/17/2215428.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"950\",\n" +
                "            \"name\": \"SQL Server 存储过程 - hoojo - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.cnblogs.com/hoojo/archive/2011/07/19/2110862.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"951\",\n" +
                "            \"name\": \"在存储过程中怎样可以获得查询出来的行数?_百度知道\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://zhidao.baidu.com/question/466489609.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"952\",\n" +
                "            \"name\": \"sqlserver游标的数量不对_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=baidu&wd=sqlserver%E6%B8%B8%E6%A0%87%E7%9A%84%E6%95%B0%E9%87%8F%E4%B8%8D%E5%AF%B9&oq=%25E6%25B8%25B8%25E6%25A0%2587%25E7%259A%2584%25E6%2595%25B0%25E9%2587%258F%25E4%25B8%258D%25E5%25AF%25B9&rsv_pq=b25e650d000036ba&rsv_t=95de%2F0nrp1d3hpd2O%2FY1k%2BGZHs57tNDzODzMnsn2eNkVG1nQpisNY%2ByH%2Brc&rqlang=cn&rsv_enter=1&rsv_sug3=2&rsv_sug2=0&inputT=2574&rsv_sug4=3535\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"953\",\n" +
                "            \"name\": \"MS-SQL中，怎么获取游标的记录总数-CSDN论坛\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://bbs.csdn.net/topics/310102572\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"954\",\n" +
                "            \"name\": \"update select_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=baidu&wd=update%20select&oq=sqlserver%2520select%2520into&rsv_pq=d0f261700000b75f&rsv_t=b471xyVcz8LwV%2Fb5ba8PcEWbrYWIaclIC3RDSokkkGCDdwqUA3Nh2MjUtuw&rqlang=cn&rsv_enter=1&rsv_sug3=38&rsv_sug1=55&rsv_sug7=100&sug=update%2520select&rsv_n=1&bs=sqlserver%20select%20into\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"955\",\n" +
                "            \"name\": \"SQL update select结合语句详解及应用 – 明凯博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.aimks.com/sql-update-the-select-statement-application.html\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037618045\",\n" +
                "        \"date_modified\": \"13178209037618045\",\n" +
                "        \"id\": \"698\",\n" +
                "        \"name\": \"游标\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"921\",\n" +
                "            \"name\": \"【SQL Server 2016 R Services系列一】：介绍及安装_随遇而安_新浪博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.sina.com.cn/s/blog_5e2017250102wfwi.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"922\",\n" +
                "            \"name\": \"JDBC的MySQL配置properties文件 - fxtxz2的专栏 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/fxtxz2/article/details/8025523\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"923\",\n" +
                "            \"name\": \"jdbc.properties配置mysql_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?ie=utf-8&f=3&rsv_bp=1&tn=baidu&wd=jdbc.properties%E9%85%8D%E7%BD%AEmysql&oq=jdbc.properties%E9%85%8D%E7%BD%AE&rsv_pq=e2bb37d10002eb4f&rsv_t=508cVw%2BFwfcYojGUy0QjHyjjQqp%2FJRqWT431SPVOLr0ivHkJ5D6InWx8AoE&rqlang=cn&rsv_enter=1&rsv_sug3=3&rsv_sug1=2&rsv_sug7=100&rsv_sug2=1&prefixsug=jdbc.properties%E9%85%8D%E7%BD%AE&rsp=2&rsv_sug4=2041&rsv_sug=1\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"924\",\n" +
                "            \"name\": \"SQL子查询的一些例子 - 天亮说晚安 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/devercn/article/details/22986\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"925\",\n" +
                "            \"name\": \"常见非关系型数据库(NoSQL)推荐介绍 - MaLeo - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/qq_22101509/article/details/49794303\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"926\",\n" +
                "            \"name\": \"MySQL 社区-你身边最优秀的MySQL中文社区! MySQL咨询,MySQL培训,MySQL优化 - Powered by Discuz!\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.mysqlpub.com/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"927\",\n" +
                "            \"name\": \"mysql处理添加外键时提示error 150 问题的解决方法_Mysql_脚本之家\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.jb51.net/article/28903.htm\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"928\",\n" +
                "            \"name\": \"MySQL之外键约束 - 张林春 - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/yidianfeng/archive/2011/02/24/1964148.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"929\",\n" +
                "            \"name\": \"About MySQL development (Optimizer mainly): WITH RECURSIVE and MySQL\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://guilhembichot.blogspot.com/2013/11/with-recursive-and-mysql.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"930\",\n" +
                "            \"name\": \"Navicat for MySQL 破解版-注册机-序列号汇总-搜狐\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://mt.sohu.com/20160720/n460105286.shtml\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"931\",\n" +
                "            \"name\": \"数据库读写分离_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?ie=UTF-8&wd=%E6%95%B0%E6%8D%AE%E5%BA%93%E8%AF%BB%E5%86%99%E5%88%86%E7%A6%BB\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"932\",\n" +
                "            \"name\": \"mongoDB for Java 查询显示指定字段 - h70614959的专栏 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/h70614959/article/details/8864510\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"933\",\n" +
                "            \"name\": \"【MongoDB】MongoDB只返回指定的字段的值 和 设定超时项_MacroCheng_新浪博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.sina.com.cn/s/blog_62f987620100ymaz.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"934\",\n" +
                "            \"name\": \"MongoDB MapReduce学习笔记 - loogn - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/loogn/archive/2012/02/09/2344054.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"935\",\n" +
                "            \"name\": \"MongoDB Documentation\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://docs.mongodb.com/?_ga=1.54899368.2074235218.1464422551\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"936\",\n" +
                "            \"name\": \"Java操作MongoDB模糊查询和分页查询 | IT小奋斗\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.what21.com/database/mongodb/mongodb-basis/java-query.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"937\",\n" +
                "            \"name\": \"mongodb基础系列——数据库查询数据返回前台JSP（一） - 推酷\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.tuicool.com/articles/F3YNFb\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"938\",\n" +
                "            \"name\": \"动态从数据库中获取数据填充Select - Franciswmf的博客 - ITeye技术网站\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://franciswmf.iteye.com/blog/1893515\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"939\",\n" +
                "            \"name\": \"java查询mongodb返回部分字段_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?ie=utf-8&f=3&rsv_bp=1&rsv_idx=1&tn=baidu&wd=java%E6%9F%A5%E8%AF%A2mongodb%E8%BF%94%E5%9B%9E%E9%83%A8%E5%88%86%E5%AD%97%E6%AE%B5&oq=java%20mongodb%E6%9F%A5%E8%AF%A2%E5%A6%82%E4%BD%95%E8%BF%94%E5%9B%9E%E9%83%A8%E5%88%86%E4%BF%A1%E6%81%AF&rsv_pq=ca7e7b3c000e1752&rsv_t=53a6%2BrsN3AKSOFKG1Ofy7VuOp5H3qs9bhzdGaseU0csVKrkffDUhDAx5LJw&rqlang=cn&rsv_enter=1&inputT=14990&rsv_sug3=31&rsv_sug1=3&rsv_sug7=000&rsv_sug2=0&prefixsug=java%E6%9F%A5%E8%AF%A2mongodb%E8%BF%94%E5%9B%9E%E9%83%A8%E5%88%86%E5%AD%97%E6%AE%B5&rsp=0&rsv_sug4=18853&rsv_sug=1\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"940\",\n" +
                "            \"name\": \"java 操作mongodb查询条件的常用设置 - MCpang的博客 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/mcpang/article/details/8731065\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"941\",\n" +
                "            \"name\": \"一个表的同一个字段可以和另外一个表的两个字段建立外键吗_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?wd=%E4%B8%80%E4%B8%AA%E8%A1%A8%E7%9A%84%E5%90%8C%E4%B8%80%E4%B8%AA%E5%AD%97%E6%AE%B5%E5%8F%AF%E4%BB%A5%E5%92%8C%E5%8F%A6%E5%A4%96%E4%B8%80%E4%B8%AA%E8%A1%A8%E7%9A%84%E4%B8%A4%E4%B8%AA%E5%AD%97%E6%AE%B5%E5%BB%BA%E7%AB%8B%E5%A4%96%E9%94%AE%E5%90%97\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"942\",\n" +
                "            \"name\": \"MySql中的varchar类型 - 时间朋友 - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.cnblogs.com/doit8791/archive/2012/05/28/2522556.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"943\",\n" +
                "            \"name\": \"请问数据库表中可以在一个表里面有两个关联同一个表的外键吗 - MyPiu的回答 - SegmentFault\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://segmentfault.com/q/1010000002572183/a-1020000002578065\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037618049\",\n" +
                "        \"date_modified\": \"13178209037618049\",\n" +
                "        \"id\": \"699\",\n" +
                "        \"name\": \"db-other\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"910\",\n" +
                "            \"name\": \"CMD命令名详细大全 _windows_Windows系列_操作系统_脚本之家\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.jb51.net/os/windows/36986.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"911\",\n" +
                "            \"name\": \"unicode编码表\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.360doc.com/content/15/0614/16/13885976_478067663.shtml#\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"912\",\n" +
                "            \"name\": \"EL表达式的常用方式\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.360doc.com/content/12/1115/10/11018021_247956261.shtml\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"913\",\n" +
                "            \"name\": \"EL表达式 参考手册 - 技术博客 - ITeye技术网站\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://elf8848.iteye.com/blog/888997\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"914\",\n" +
                "            \"name\": \"linux桌面环境gnome,kde,xfce,lxde 使用比较_LINUX_操作系统_脚本之家\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.jb51.net/LINUXjishu/78428.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"915\",\n" +
                "            \"name\": \"《Linux就该这么学》_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?ie=UTF-8&wd=%E3%80%8ALinux%E5%B0%B1%E8%AF%A5%E8%BF%99%E4%B9%88%E5%AD%A6%E3%80%8B\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"916\",\n" +
                "            \"name\": \"搞明白这八个问题，Linux系统就好学多了_TechWeb\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.techweb.com.cn/news/2016-09-12/2391648.shtml\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"917\",\n" +
                "            \"name\": \"你是如何构建 Web 前端 Mock Server 的？ - 知乎\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.zhihu.com/question/35436669\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"918\",\n" +
                "            \"name\": \"Web 研发模式演变 · Issue #184 · lifesinger/blog\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://github.com/lifesinger/blog/issues/184\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"919\",\n" +
                "            \"name\": \"《浅谈架构之路：前后端分离模式》 - 山人行 - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/shanrengo/p/6397734.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"920\",\n" +
                "            \"name\": \"从MVC到前后端分离（REST-个人也认为是目前比较流行和比较好的方式） - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/shaobingj126/article/details/49420145\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037618053\",\n" +
                "        \"date_modified\": \"13178209037618053\",\n" +
                "        \"id\": \"700\",\n" +
                "        \"name\": \"others\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"701\",\n" +
                "        \"name\": \"tool\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://separatethis.com/\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177152086036978\",\n" +
                "            \"id\": \"888\",\n" +
                "            \"name\": \"云+校园 - 腾讯云\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://cloud.tencent.com/act/campus/group/detail?utm_source=qcloud&utm_medium=campus&utm_campaign=group&group=37991\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"889\",\n" +
                "            \"name\": \"云主机-控制台\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://console.cloud.tencent.com/cvm/index\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"890\",\n" +
                "            \"name\": \"腾讯云主机上车啦，三年四个月360块。【阿里云吧】_百度贴吧\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://tieba.baidu.com/p/5601758437\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"891\",\n" +
                "            \"name\": \"备案流程\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://console.qcloud.com/beian/process\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"892\",\n" +
                "            \"name\": \"Linux的发行版之间的联系和区别 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/suixin788/article/details/52555558\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"893\",\n" +
                "            \"name\": \"\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://separatethis.com/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"894\",\n" +
                "            \"name\": \"Linux常用命令大全 - Boblim - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.cnblogs.com/fnlingnzb-learner/p/5831284.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"895\",\n" +
                "            \"name\": \"CentOS7安装MySQL - 一张对二 - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.cnblogs.com/bigbrotherer/p/7241845.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"896\",\n" +
                "            \"name\": \"Linux下MySQL 数据库的基本操作 - Glory_D - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.cnblogs.com/Glory-D/p/7518541.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"897\",\n" +
                "            \"name\": \"如何设置mysql远程访问及防火墙设置 - meetweb - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.cnblogs.com/meetweb/p/3701443.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"898\",\n" +
                "            \"name\": \"解决Navicat 报错:1130-host ... is not allowed to connect to this MySql server,不允许从远程访问的方法\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://zhuanlan.zhihu.com/p/32621440\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"899\",\n" +
                "            \"name\": \"\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://separatethis.com/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"900\",\n" +
                "            \"name\": \"linux如何查看自己安装软件在哪_百度知道\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://zhidao.baidu.com/question/756048512899324564.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"901\",\n" +
                "            \"name\": \"linux怎么查看IP地址_百度经验\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://jingyan.baidu.com/article/f006222837aacbfbd2f0c86d.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"902\",\n" +
                "            \"name\": \"linux下大家一般把程序安装在哪个目录？_百度知道\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://zhidao.baidu.com/question/90885987.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"903\",\n" +
                "            \"name\": \"Linux删除文件的命令？_百度知道\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://zhidao.baidu.com/question/446617471.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"904\",\n" +
                "            \"name\": \"\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://separatethis.com/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"905\",\n" +
                "            \"name\": \"用FileZilla搭建FTP服务器及相关问题 - MongoDe - SegmentFault 思否\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://segmentfault.com/a/1190000009033181\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"906\",\n" +
                "            \"name\": \"filezilla server 教程_百度经验\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://jingyan.baidu.com/article/17bd8e521067fe85ab2bb8ee.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"907\",\n" +
                "            \"name\": \"史上最牛的Linux视频教程_腾讯课堂\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://ke.qq.com/course/261163?from=qqchat&ADUIN=302508713&ADSESSION=1521958604&ADTAG=CLIENT.QQ.5549_.0&ADPUBNO=26784\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"908\",\n" +
                "            \"name\": \"解决SQL SERVER 2014远程连接数据库手册_百度经验\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://jingyan.baidu.com/article/a3aad71aed59a3b1fb00962f.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"909\",\n" +
                "            \"name\": \"使用yum来安装或卸载CentOS图形界面包 - hurner - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.cnblogs.com/hurner/archive/2011/09/05/2168101.html\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037618078\",\n" +
                "        \"date_modified\": \"13178209037618078\",\n" +
                "        \"id\": \"702\",\n" +
                "        \"name\": \"linux\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"866\",\n" +
                "            \"name\": \"如何通俗地理解 Gradle？ - 知乎\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.zhihu.com/question/30432152\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"867\",\n" +
                "            \"name\": \"Gradle User Guide Version 2.14.1\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://docs.gradle.org/current/userguide/userguide.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"868\",\n" +
                "            \"name\": \"构建工具 - Gradle 实战中文版 - 极客学院Wiki\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://wiki.jikexueyuan.com/project/gradleIn-action/build-tools.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"869\",\n" +
                "            \"name\": \"介绍 - Gradle 用户指南官方文档中文版 - 极客学院Wiki\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://wiki.jikexueyuan.com/project/GradleUserGuide-Wiki/introduction.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"870\",\n" +
                "            \"name\": \"选择文件构建 - Gradle 用户指南官方文档中文版 - 极客学院Wiki\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://wiki.jikexueyuan.com/project/GradleUserGuide-Wiki/using_the_gradle_command-line/selecting_which_build_to_execute.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"871\",\n" +
                "            \"name\": \"Gradle入门系列（1）：简介 - 文章 - 伯乐在线\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.jobbole.com/71999/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"872\",\n" +
                "            \"name\": \"如何安装配置gradle及eclipse的结合_百度经验\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://jingyan.baidu.com/article/9225544684a97c851648f486.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"873\",\n" +
                "            \"name\": \"初始化 Gradle 工程目录 - 推酷\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.tuicool.com/articles/7ZN3Aj\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"874\",\n" +
                "            \"name\": \"gradle/maven/eclipse工程相互转化 - 云守护的专栏 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/earbao/article/details/41550387\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"875\",\n" +
                "            \"name\": \"Gradle构建编译速度太慢的解决方法 - 吾爱源码\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.52codes.net/article/658.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"876\",\n" +
                "            \"name\": \"如何在gradle里执行命令gradle_百度知道\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://zhidao.baidu.com/link?url=ISW3-vjln7t-hD1Vbz8lmbuG9eFm2Fp6IUvG6P25dzZyDAUeCJefZA9ddJM1dblVItl3LTvS159Kk7NSrImZpjOgQKR7f-niaYnyj2uXBki\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"877\",\n" +
                "            \"name\": \"Gradle系列之从init.gradle说起 - 区长的专栏 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/sbsujjbcy/article/details/52079413#t3\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"878\",\n" +
                "            \"name\": \"gradle学习(19)-log系统 - [ Gradle学习系列 ]\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.kancloud.cn/digest/itfootball-gradle/105811\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"879\",\n" +
                "            \"name\": \"bboss gradle工程导入eclipse介绍 - Bboss 每天进步一点点 - ITeye技术网站\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://yin-bp.iteye.com/blog/2313145\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"880\",\n" +
                "            \"name\": \"Eclipse 安装Gradle插件 - 走马观花 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/caolaosanahnu/article/details/17022321\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"881\",\n" +
                "            \"name\": \"【Android】如何将Gradle工程转换为eclipse工程 - realize - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/realizelizijun2013/article/details/50572529\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"882\",\n" +
                "            \"name\": \"如何在 Eclipse 下用 Gradle 构建 Web Application_百度知道\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://zhidao.baidu.com/link?url=GgiR9JYZ2HouIt0idIne87zrkXY6DFJCWl3rjdK9vaA5NroTdq7WUDJfGQK2lYO5Z_48nZ4ahDx1nNjOE-m6qwQ-E9IWU6G9O97Pv91ViKy\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"883\",\n" +
                "            \"name\": \"关于本书 · Gradle User Guide 中文版\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://dongchuan.gitbooks.io/gradle-user-guide-/content/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"884\",\n" +
                "            \"name\": \"项目自动化 | Gradle 实战\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://lippiouyang.gitbooks.io/gradle-in-action-cn/content/project-automation/project-automation.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"885\",\n" +
                "            \"name\": \"Java Gradle入门指南之gretty插件（安装、命令与核心特性） - 呆尐兔兔 - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/gzdaijie/p/5267166.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"886\",\n" +
                "            \"name\": \"Groovy入门教程 - kmyhy的专栏 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/kmyhy/article/details/4200563\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"887\",\n" +
                "            \"name\": \"Gradle DSL Version 3.0\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://docs.gradle.org/current/dsl/\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037618082\",\n" +
                "        \"date_modified\": \"13178209037618082\",\n" +
                "        \"id\": \"703\",\n" +
                "        \"name\": \"gradle\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"839\",\n" +
                "            \"name\": \"help\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://idea.lanyus.com/help/help.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"840\",\n" +
                "            \"name\": \"JetBrains授权服务器\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://idea.wlphp.com/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"841\",\n" +
                "            \"name\": \"Intellij idea 快捷键大全 - zl的博客 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/zl834205311/article/details/60868138\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"842\",\n" +
                "            \"name\": \"Intellij Idea/Webstorm/Phpstorm 的高效快捷键 - GarfieldEr007的专栏 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/garfielder007/article/details/52335341\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"843\",\n" +
                "            \"name\": \"如何打开Intellij IDEA的代码提示功能_百度经验\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://jingyan.baidu.com/article/36d6ed1f62e9821bcf4883af.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"844\",\n" +
                "            \"name\": \"IntelliJ IDEA 自动编译功能无法使用,On 'update' action:选项里面没有update classes and resources这项_百度知道\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://zhidao.baidu.com/question/1381265197230335740.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"845\",\n" +
                "            \"name\": \"intellij idea中出现class path resource [spring/applicationContext.xml] cannot be opened because it does not exist - 远远木有 - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/zmy123/p/5829923.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"846\",\n" +
                "            \"name\": \"intellij与eclipse默认快捷键对比 - Nacey - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/nacey5201/article/details/35570591\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"847\",\n" +
                "            \"name\": \"【原创】Eclipse vs. IDEA快捷键对比大全 - 西代零零发 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/dc_726/article/details/9531281\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"848\",\n" +
                "            \"name\": \"Intellij IDEA 快捷键大全 - OPEN 开发经验库\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.open-open.com/lib/view/open1396578860887.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"849\",\n" +
                "            \"name\": \"IntelliJ IDEA 环境常用设置整理 - 喵星人 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/aya19880214/article/details/46777629\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"850\",\n" +
                "            \"name\": \"idea如何跑eclipse j2ee工程_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=baidu&wd=idea%E5%A6%82%E4%BD%95%E8%B7%91eclipse%20j2ee%E5%B7%A5%E7%A8%8B&oq=idea%25E5%25A6%2582%25E4%25BD%2595%25E8%25AE%25BE%25E7%25BD%25AEbuild%2520path&rsv_pq=cd3c059c0000821e&rsv_t=a35cIu5sz5YnJZN8E%2BnW1GTCXotziPVjBYrwiJFfV%2FvB%2BJRTIOEDycsSgoo&rqlang=cn&rsv_enter=1&rsv_sug3=27&rsv_sug1=8&rsv_sug7=100&rsv_sug2=0&inputT=20289&rsv_sug4=23462\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"851\",\n" +
                "            \"name\": \"怎么把Intelij IDEA的工程变为Eclipse工程，希望有人解答 - Java / Java相关_Eclipse_ThinkSAAS\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.thinksaas.cn/topics/0/498/498885.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"852\",\n" +
                "            \"name\": \"idea14导入eclipse项目并部署运行完整步骤 - u011493599的专栏 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/u011493599/article/details/45666457\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"853\",\n" +
                "            \"name\": \"idea导入eclipse项目并部署运行完整步骤_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=baidu&wd=idea%E5%AF%BC%E5%85%A5eclipse%E9%A1%B9%E7%9B%AE%E5%B9%B6%E9%83%A8%E7%BD%B2%E8%BF%90%E8%A1%8C%E5%AE%8C%E6%95%B4%E6%AD%A5%E9%AA%A4&oq=idea14%25E5%25AF%25BC%25E5%2585%25A5eclipse%25E9%25A1%25B9%25E7%259B%25AE%25E5%25B9%25B6%25E9%2583%25A8%25E7%25BD%25B2%25E8%25BF%2590%25E8%25A1%258C%25E5%25AE%258C%25E6%2595%25B4%25E6%25AD%25A5%25E9%25AA%25A4&rsv_pq=e6f678f70000249e&rsv_t=96bfM8vPuNaGXgZOv6gjNxscEY1crRcA1TyLtvjUo9YmY5E1RkJcPSP2YUA&rqlang=cn&rsv_enter=1&rsv_sug3=3&rsv_sug2=0&inputT=890&rsv_sug4=1751\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"854\",\n" +
                "            \"name\": \"idea class path resource [applicationContext.xml] cannot be opened because i_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?ie=UTF-8&wd=idea%20class%20path%20resource%20%5BapplicationContext.xml%5D%20cannot%20be%20opened%20because%20it%20does%20not%20exist\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"855\",\n" +
                "            \"name\": \"找不到applicationContext.xml，请问大家，这是怎么回事啊。。_百度知道\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://zhidao.baidu.com/question/249034418.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"856\",\n" +
                "            \"name\": \"intellij idea中出现class path resource [spring/applicationContext.xml] cannot be opened because it does not exist - 远远木有 - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/zmy123/p/5829923.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"857\",\n" +
                "            \"name\": \"idea设置source_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=baidu&wd=idea%E8%AE%BE%E7%BD%AEsource&oq=idea%25E8%25AE%25BE%25E7%25BD%25AEsource%2520root&rsv_pq=d7e56ea000001104&rsv_t=6001jYU5RgsgvNzhqqCTtmn6tk%2BYr5810oIH4Wmsrz0HKIcs2NkRF2B8Wts&rqlang=cn&rsv_enter=0&rsv_sug3=29&rsv_sug1=24&rsv_sug7=100&rsv_sug2=0&inputT=753&rsv_sug4=5970\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"858\",\n" +
                "            \"name\": \"解决IntelliJ IDEA无法读取配置文件的问题 - Sinte-Beuve - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/Sinte-Beuve/p/5730572.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"859\",\n" +
                "            \"name\": \"三种方法教你一步一步导入一个eclipse项目到Intellij IDEA_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=baidu&wd=%E4%B8%89%E7%A7%8D%E6%96%B9%E6%B3%95%E6%95%99%E4%BD%A0%E4%B8%80%E6%AD%A5%E4%B8%80%E6%AD%A5%E5%AF%BC%E5%85%A5%E4%B8%80%E4%B8%AAeclipse%E9%A1%B9%E7%9B%AE%E5%88%B0Intellij%20IDEA&oq=idea%25E5%25AF%25BC%25E5%2585%25A5eclipse%25E9%25A1%25B9%25E7%259B%25AE%25E5%25B9%25B6%25E9%2583%25A8%25E7%25BD%25B2%25E8%25BF%2590%25E8%25A1%258C%25E5%25AE%258C%25E6%2595%25B4%25E6%25AD%25A5%25E9%25AA%25A4&rsv_pq=f045b71c00003b83&rsv_t=4071y0Qtgf7uo7YJmjymeyeyPH4ex4KRc5fry5NoyaS3xxfLzkdwbh6h8QQ&rqlang=cn&rsv_enter=1&rsv_n=2&rsv_sug3=1&bs=idea%E5%AF%BC%E5%85%A5eclipse%E9%A1%B9%E7%9B%AE%E5%B9%B6%E9%83%A8%E7%BD%B2%E8%BF%90%E8%A1%8C%E5%AE%8C%E6%95%B4%E6%AD%A5%E9%AA%A4\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"860\",\n" +
                "            \"name\": \"三中方法教你一步一步导入一个eclipse项目到Intellij IDEA - Zomnus的博客 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/zomnus/article/details/52231729\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"861\",\n" +
                "            \"name\": \"idea 配置tomcat_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?ie=UTF-8&wd=idea%20%E9%85%8D%E7%BD%AEtomcat\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"862\",\n" +
                "            \"name\": \"IntelliJ IDEA Tomcat配置 详解 - chenshun123的博客 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/chenshun123/article/details/51285890\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"863\",\n" +
                "            \"name\": \"IntelliJ IDEA使用教程_IntelliJ IDEA开发中文手册[PDF]下载-极客学院Wiki\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://wiki.jikexueyuan.com/project/intellij-idea-tutorial/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"864\",\n" +
                "            \"name\": \"Idea中找不到Java Application 的xml配置文件问题研究 - Golden_lion的博客 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/xyw591238/article/details/51724583\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"865\",\n" +
                "            \"name\": \"代码生成利器：IDEA 强大的 Live Templates-博客-云栖社区-阿里云\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://yq.aliyun.com/articles/73449\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037618086\",\n" +
                "        \"date_modified\": \"13178209037618086\",\n" +
                "        \"id\": \"704\",\n" +
                "        \"name\": \"idea\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"827\",\n" +
                "            \"name\": \"eclipse如何取消注释_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?ie=UTF-8&wd=eclipse%E5%A6%82%E4%BD%95%E5%8F%96%E6%B6%88%E6%B3%A8%E9%87%8A\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"828\",\n" +
                "            \"name\": \"Eclipse的调试功能的10个小窍门 - ImportNew\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.importnew.com/6164.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"829\",\n" +
                "            \"name\": \"Eclipse将控制台输出信息保存为文件 - JAVA技术 - ITeye技术网站\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://vipshichg.iteye.com/blog/1926891\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"830\",\n" +
                "            \"name\": \"给Eclipse提速的7个技巧 - ImportNew\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.importnew.com/13942.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"831\",\n" +
                "            \"name\": \"Eclipse中jsp、js文件编辑时，卡死现象解决汇总 - 如是缘 - ITeye技术网站\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://rsy.iteye.com/blog/2095668/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"832\",\n" +
                "            \"name\": \"★ Eclipse Debug 界面应用详解——Eclipse Debug不为人知的秘密 - jackpk的专栏 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/jackpk/article/details/7655777\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"833\",\n" +
                "            \"name\": \"Eclipse Debug不为人知的秘密 - mgoann - ITeye技术网站\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://mgoann.iteye.com/blog/1396637\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"834\",\n" +
                "            \"name\": \"eclipse调试的时候如何自动跳转到debug视图_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?ie=UTF-8&wd=eclipse%E8%B0%83%E8%AF%95%E7%9A%84%E6%97%B6%E5%80%99%E5%A6%82%E4%BD%95%E8%87%AA%E5%8A%A8%E8%B7%B3%E8%BD%AC%E5%88%B0debug%E8%A7%86%E5%9B%BE\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"835\",\n" +
                "            \"name\": \"eclipse编写的GBK项目转变成UTF-8编码 - GEM_yaorao的博客 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/gem_yaorao/article/details/49530619\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"836\",\n" +
                "            \"name\": \"eclipse里面的java类名重命名F2，Rename - 天地人和 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/u013014784/article/details/43560389\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"837\",\n" +
                "            \"name\": \"Eclipse中jsp,html代码自动排版太丑怎么办？！改改就好了！ - 好库文摘\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://doc.okbase.net/%E4%BA%BA%E7%94%9F%E9%9A%BE%E5%BE%97%E7%B3%8A%E6%B6%82/archive/123084.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"838\",\n" +
                "            \"name\": \"Eclipse上Maven环境配置使用 (全) - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/java_2017_csdn/article/details/77450598/\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037618089\",\n" +
                "        \"date_modified\": \"13178209037618090\",\n" +
                "        \"id\": \"705\",\n" +
                "        \"name\": \"eclipse\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"825\",\n" +
                "            \"name\": \"持续集成(CI)、自动化构建和自动化测试--初探 - Chaoa - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/chaoa/articles/4447354.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"826\",\n" +
                "            \"name\": \"什么是Docker? - Docker入门教程 - docker中文社区\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.docker.org.cn/book/docker/what-is-docker-16.html\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037618093\",\n" +
                "        \"date_modified\": \"13178209037618093\",\n" +
                "        \"id\": \"706\",\n" +
                "        \"name\": \"docker\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"791\",\n" +
                "            \"name\": \"gitignore.io - Create Useful .gitignore Files For Your Project\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.gitignore.io/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"792\",\n" +
                "            \"name\": \"初次使用git配置以及git如何使用ssh密钥（将ssh密钥添加到github） - superGG1990 - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.cnblogs.com/superGG1990/p/6844952.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"793\",\n" +
                "            \"name\": \"Git的使用--如何将本地项目上传到Github - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/zamamiro/article/details/70172900\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"794\",\n" +
                "            \"name\": \"Git 多账户配置 - 太SHY - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/Kyouhui/p/6878963.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"795\",\n" +
                "            \"name\": \"Windows下Git多账号配置，同一电脑多个ssh-key的管理 - popfisher - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.cnblogs.com/popfisher/p/5731232.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"796\",\n" +
                "            \"name\": \"GIT 查看/修改用户名和邮箱地址 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/autoliuweijie/article/details/52230165\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"797\",\n" +
                "            \"name\": \"7g\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://guibin.iteye.com/blog/1014369\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"798\",\n" +
                "            \"name\": \"1 起步 - Pro Git\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://git.oschina.net/progit/1-%E8%B5%B7%E6%AD%A5.html#1.4-%E5%AE%89%E8%A3%85-Git\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"799\",\n" +
                "            \"name\": \"忽略特殊文件 - 廖雪峰的官方网站\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.liaoxuefeng.com/wiki/0013739516305929606dd18361248578c67b8067c8c017b000/0013758404317281e54b6f5375640abbb11e67be4cd49e0000\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"800\",\n" +
                "            \"name\": \"Git 使用规范流程 - 阮一峰的网络日志\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.ruanyifeng.com/blog/2015/08/git-use-process.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"801\",\n" +
                "            \"name\": \"git 查看远程分支、本地分支、创建分支、把分支推到远程repository、删除本地分支 - arkblue的专栏 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/arkblue/article/details/9568249/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"802\",\n" +
                "            \"name\": \"git之临时忽略文件 - 推酷\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.tuicool.com/articles/r2YFzmQ\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"803\",\n" +
                "            \"name\": \"Git 的 .gitignore 配置 - haiq - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/haiq/archive/2012/12/26/2833746.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"804\",\n" +
                "            \"name\": \"git - 使用SourceTree怎么忽略文件？ - SegmentFault\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://segmentfault.com/q/1010000004115468\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"805\",\n" +
                "            \"name\": \"在bitbucket用git 用法 - xyqzki的专栏 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/xyqzki/article/details/23187863\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"806\",\n" +
                "            \"name\": \"\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://separatethis.com/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"807\",\n" +
                "            \"name\": \"Git工作流指南：集中式工作流 - 文章 - 伯乐在线\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.jobbole.com/76847/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"808\",\n" +
                "            \"name\": \"Git工作流指南：Gitflow工作流 - 文章 - 伯乐在线\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.jobbole.com/76867/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"809\",\n" +
                "            \"name\": \"Git - git-rebase Documentation\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://git-scm.com/docs/git-rebase\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"810\",\n" +
                "            \"name\": \"git 简明指南\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.runoob.com/manual/git-guide/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"811\",\n" +
                "            \"name\": \"创建版本库 - 廖雪峰的官方网站\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.liaoxuefeng.com/wiki/0013739516305929606dd18361248578c67b8067c8c017b000/0013743256916071d599b3aed534aaab22a0db6c4e07fd0000\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"812\",\n" +
                "            \"name\": \"git stash和git stash pop - 快乐&&平凡 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/wh_19910525/article/details/7784901\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"813\",\n" +
                "            \"name\": \"git init 与 git init --bare 的区别 - ljchlx的专栏 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/ljchlx/article/details/21805231\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"814\",\n" +
                "            \"name\": \"四种常见 Git 工作流比较 - iTech - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/itech/p/5188929.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"815\",\n" +
                "            \"name\": \"git提交本地master到远程branch（bitbucket） - happygogf的专栏 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/happygogf/article/details/22894327\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"816\",\n" +
                "            \"name\": \"Git详解之三：Git分支 - 文章 - 伯乐在线\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.jobbole.com/25877/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"817\",\n" +
                "            \"name\": \"团队开发里频繁使用 git rebase 来保持树的整洁好吗? - SegmentFault\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://segmentfault.com/q/1010000000430041\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"818\",\n" +
                "            \"name\": \"7. 用rebase合并【教程1 操作分支】| 猴子都能懂的GIT入门 | 贝格乐（Backlog）\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://backlogtool.com/git-guide/cn/stepup/stepup2_8.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"819\",\n" +
                "            \"name\": \"在git提交环节，存在三大部分：working tree, index file, commit - lksodit_yiyi的专栏 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/lksodit_yiyi/article/details/8767150\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"820\",\n" +
                "            \"name\": \"git reset简介 - Robin Hu的专栏 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/hudashi/article/details/7664464/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"821\",\n" +
                "            \"name\": \"使用git命令 （git reset --hard HEAD） 回退版本信息 - Java_HuiLong的博客 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/java_huilong/article/details/52136475\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"822\",\n" +
                "            \"name\": \"【Git】git使用 - 冲突conflict的解决演示 - 淡丶无欲 - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/VergiLyn/p/6701642.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"823\",\n" +
                "            \"name\": \"10篇写给Git初学者的最佳教程 – 帕兰映像\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://paranimage.com/best-git-tutoritals-for-beginners/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"824\",\n" +
                "            \"name\": \"github - Git 感觉无用/多余的 commit 状态可以删掉吗 ? - SegmentFault\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://segmentfault.com/q/1010000003089251\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037618096\",\n" +
                "        \"date_modified\": \"13178209037618097\",\n" +
                "        \"id\": \"707\",\n" +
                "        \"name\": \"git\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"779\",\n" +
                "            \"name\": \"web部署_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?wd=web%E9%83%A8%E7%BD%B2&pn=10&oq=web%E9%83%A8%E7%BD%B2&ie=utf-8&rsv_pq=caf8d1c60006e12c&rsv_t=2e6bVt%2BWsRs3hvu2ppuD2eBtTERVhiwaTgm4nkrnodmEbe%2FY8Ci8QklgwSg&rsv_page=1\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"780\",\n" +
                "            \"name\": \"Tomcat部署Web应用方法总结 - yangxueyong的专栏 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/yangxueyong/article/details/6130065\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"781\",\n" +
                "            \"name\": \"war包部署到tomcat这种方式不是很落后为什么还那么多人用_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=war%E5%8C%85%E9%83%A8%E7%BD%B2%E5%88%B0tomcat%E8%BF%99%E7%A7%8D%E6%96%B9%E5%BC%8F%E4%B8%8D%E6%98%AF%E5%BE%88%E8%90%BD%E5%90%8E%E4%B8%BA%E4%BB%80%E4%B9%88%E8%BF%98%E9%82%A3%E4%B9%88%E5%A4%9A%E4%BA%BA%E7%94%A8&oq=war%E5%8C%85&rsv_pq=de6e1956000544f3&rsv_t=c0c5GXFkVNpTnTIZhAifP5wjQ0J7LIrbGIU94yxHX3kWbR0J%2FE4X7doC%2FRs&rqlang=cn&rsv_enter=1&inputT=24950&rsv_sug3=28&rsv_sug1=4&rsv_sug7=100&sug=war%E5%8C%85%E9%83%A8%E7%BD%B2%E5%88%B0tomcat&rsv_n=1&rsv_sug2=0&rsv_sug4=29749\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"782\",\n" +
                "            \"name\": \"将web项目以war包形式部署到tomcat中的方法 - Baple的专栏 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/baple/article/details/41804109\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"783\",\n" +
                "            \"name\": \"部署WEB应用的三种方式 - Yeahui - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/yeahui/archive/2012/08/22/2650078.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"784\",\n" +
                "            \"name\": \"Tomcat的四种web应用部署方式详解 - 虽然我很菜 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/titilover/article/details/6822258\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"785\",\n" +
                "            \"name\": \"java web项目在部署时遇到了这样的问题 请大神指点下？ - Java EE - 知乎\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.zhihu.com/question/29597954\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"786\",\n" +
                "            \"name\": \"为什么要把Web项目的war包部署到Tomcat中，这个过程是必须的吗？_百度知道\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://zhidao.baidu.com/link?url=NsOaMy_sDesFQ3nphmQ1GrnUPHFZ9SJJr8YHLdqs-T0NrR1hLJjl-ogqfNDP0DkUUMFCddrYUX2PjdKqv09i8eHpailvG9zA3dVjU5FBylC\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"787\",\n" +
                "            \"name\": \"\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://separatethis.com/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"788\",\n" +
                "            \"name\": \"如何修改tomcat的端口_百度知道\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://zhidao.baidu.com/link?url=mRM3H49kVqrzBT8F1IpAEd2hWVUmcvcdpxFKDlxit-gGeDK0tWSZrgEopttEAxMRLe3A0JqWxv-X0lnbiMEXA_\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"789\",\n" +
                "            \"name\": \"同一个tomcat，不同端口启动各自程序 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/boy298/article/details/52083082\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"790\",\n" +
                "            \"name\": \"的Apache Tomcat 7（7.0.70） - Tomcat的安装\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://tomcat.apache.org/tomcat-7.0-doc/setup.html\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037618109\",\n" +
                "        \"date_modified\": \"13178209037618109\",\n" +
                "        \"id\": \"708\",\n" +
                "        \"name\": \"tomcat\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"766\",\n" +
                "            \"name\": \"Maven – Configuring Apache Maven\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://maven.apache.org/configure.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"767\",\n" +
                "            \"name\": \"Maven Repository: com.google.code.gson » gson » 2.8.0\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.0\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"768\",\n" +
                "            \"name\": \"\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://separatethis.com/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"769\",\n" +
                "            \"name\": \"maven国内镜像（maven下载慢的解决方法） - D调的华丽呢 - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/xiongxx/p/6057558.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"770\",\n" +
                "            \"name\": \"Maven2的配置文件settings.xml - Yakov - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/yakov/archive/2011/11/26/maven2_settings.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"771\",\n" +
                "            \"name\": \"Maven启用代理访问 - Maven教程\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.yiibai.com/maven/enable-proxy-setting-in-maven.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"772\",\n" +
                "            \"name\": \"eclipse maven plugin 插件 安装 和 配置 - fanlychie - BlogJava\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.blogjava.net/fancydeepin/archive/2015/06/21/eclipse_maven3_plugin.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"773\",\n" +
                "            \"name\": \"Index of /dist/maven/maven-3/3.2.2/binaries\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://archive.apache.org/dist/maven/maven-3/3.2.2/binaries/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"774\",\n" +
                "            \"name\": \"关于项目称谓、IDEA操作和环境配置的约定 - Debug的许乌龙\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://my.oschina.net/mzdbxqh/blog/837913?nocache=1499306029211\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"775\",\n" +
                "            \"name\": \"Maven最佳实践 划分模块 配置多模块项目 pom modules - 三积木 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/jiangkai528/article/details/24798943\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"776\",\n" +
                "            \"name\": \"Dynamic Web开发之版本分析 - fanxiaobin577328725的博客 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/fanxiaobin577328725/article/details/69661325\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"777\",\n" +
                "            \"name\": \"maven 教程_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?wd=maven%20%E6%95%99%E7%A8%8B&rsp=4&f=1&oq=maven&ie=utf-8&usm=1&rsv_pq=bede925800001d9a&rsv_t=bc09%2F3TDNqXvJW%2BIwSi%2Bc1RHhhFO8Purzgg7NbLKtWY45tVf2FPLLHixPhI&rqlang=cn&rsv_ers=xn1&rs_src=0\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"778\",\n" +
                "            \"name\": \"Cannot read property 'nodeType' of undefined - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/u010082526/article/details/51838684\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037618112\",\n" +
                "        \"date_modified\": \"13178209037618112\",\n" +
                "        \"id\": \"709\",\n" +
                "        \"name\": \"maven\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"760\",\n" +
                "            \"name\": \"UML类图几种关系的总结 - 飞龙在天 - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/dragonpeng2008/article/details/6836448\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"761\",\n" +
                "            \"name\": \"UML类图与类的关系详解\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.uml.org.cn/oobject/201104212.asp\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"762\",\n" +
                "            \"name\": \"uml 类图依赖与关联的区别 - 掸尘 - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/liuzhang/archive/2013/03/17/2964095.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"763\",\n" +
                "            \"name\": \"eclipse下安装和使用AmaterasUML、ModelSpoon生成Java类图 - - 博客频道 - CSDN.NET\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/wangmuming/article/details/38418881\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"764\",\n" +
                "            \"name\": \"UML中关联，聚合，组合的区别\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.360doc.com/content/07/0612/11/16903_553244.shtml\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"765\",\n" +
                "            \"name\": \"UML关系(泛化,实现,依赖,关联(聚合,组合)) - 不积跬步 无以至千里 不积小流 无以成江海 - ITeye技术网站\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://justsee.iteye.com/blog/808799\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037618116\",\n" +
                "        \"date_modified\": \"13178209037618116\",\n" +
                "        \"id\": \"710\",\n" +
                "        \"name\": \"uml\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"757\",\n" +
                "            \"name\": \"XPath Helper - Chrome插件(谷歌浏览器插件)\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://chromecj.com/web-development/2018-01/892.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"758\",\n" +
                "            \"name\": \"最新Chrome插件大全 - Chrome插件(谷歌浏览器插件)\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://chromecj.com/list/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"759\",\n" +
                "            \"name\": \"Chrome 网上应用店 - JetBrains IDE Support\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://chrome.google.com/webstore/search/JetBrains%20IDE%20Support?utm_campaign=en&utm_source=en-et-na-us-oc-webstrhm&utm_medium=et\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037618130\",\n" +
                "        \"date_modified\": \"13178209037618130\",\n" +
                "        \"id\": \"711\",\n" +
                "        \"name\": \"google插件\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"712\",\n" +
                "        \"name\": \"asta\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://separatethis.com/\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"746\",\n" +
                "            \"name\": \"Spring Security SAML Extension\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://docs.spring.io/spring-security-saml/docs/1.0.x-SNAPSHOT/reference/htmlsingle/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"747\",\n" +
                "            \"name\": \"4. Quick start guide\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://docs.spring.io/spring-security-saml/docs/current/reference/html/chapter-quick-start.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"748\",\n" +
                "            \"name\": \"4.快速入门指南\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://docs.spring.io/spring-security-saml/docs/current/reference/html/chapter-quick-start.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"749\",\n" +
                "            \"name\": \"4. Quick start guide\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://docs.spring.io/spring-security-saml/docs/current/reference/html/chapter-quick-start.html#quick-start-sp-metadata\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"750\",\n" +
                "            \"name\": \"11.示例应用程序\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://docs.spring.io/spring-security-saml/docs/current/reference/html/chapter-sample-app.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"751\",\n" +
                "            \"name\": \"Spring SAML Sample application\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://saml-federation.appspot.com/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"752\",\n" +
                "            \"name\": \"SSOCircle Identity Provider (Login)\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://idp.ssocircle.com/sso/UI/Login?module=peopleMembership&goto=https%3A%2F%2Fidp.ssocircle.com%2Fsso%2FSSORedirect%2FmetaAlias%2Fssocircle%3FReqID%3Da5622f016a453gad6gb1h82chgce1f%26index%3Dnull%26acsURL%3Dhttps%253A%252F%252Fsaml-federation.appspot.com%253A443%252Fsaml%252FSSO%26spEntityID%3Dsaml-federation.appspot.com%26binding%3Durn%253Aoasis%253Anames%253Atc%253ASAML%253A2.0%253Abindings%253AHTTP-Artifact&gx_charset=UTF-8\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"753\",\n" +
                "            \"name\": \"Spring SAML Sample application\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://saml-federation.appspot.com/saml/discovery?returnIDParam=idp&entityID=saml-federation.appspot.com\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"754\",\n" +
                "            \"name\": \"域名批量查询工具\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://tool.22.cn/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"755\",\n" +
                "            \"name\": \"SSO单点登录一（Spring+SpringMVC+固定密码）实现的简单的同域SSOdemo - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/li_cheng_liang/article/details/54600327\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"756\",\n" +
                "            \"name\": \"spring单点登录测试_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=baidu&wd=spring%E5%8D%95%E7%82%B9%E7%99%BB%E5%BD%95%E6%B5%8B%E8%AF%95&oq=%25E5%258D%2595%25E7%2582%25B9%25E7%2599%25BB%25E5%25BD%2595%25E6%25B5%258B%25E8%25AF%2595&rsv_pq=d5c3293200000a5f&rsv_t=12beXnbhhomClXQUIJj13KpC96agFUQXGgvpi6N9lEa6PGLR3JwSaYMAwA0&rqlang=cn&rsv_enter=1&inputT=2219&rsv_sug3=29&rsv_sug1=26&rsv_sug7=100&rsv_sug2=0&rsv_sug4=3155\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037618156\",\n" +
                "        \"date_modified\": \"13178209037618156\",\n" +
                "        \"id\": \"713\",\n" +
                "        \"name\": \"ss-saml\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"743\",\n" +
                "            \"name\": \"SAML2.0入门指南 - 简书\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.jianshu.com/p/636c1ee16eba\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"744\",\n" +
                "            \"name\": \"N多系统单点登录，实现、解决方案。四种解决方案 —技术博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.sojson.com/blog/80.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"745\",\n" +
                "            \"name\": \"Java实现SSO单点登录[视频教程]-慕课网\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.imooc.com/learn/633\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037618160\",\n" +
                "        \"date_modified\": \"13178209037618160\",\n" +
                "        \"id\": \"714\",\n" +
                "        \"name\": \"sso\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"date_added\": \"13177070296000000\",\n" +
                "        \"id\": \"715\",\n" +
                "        \"name\": \"project\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"url\",\n" +
                "        \"url\": \"http://separatethis.com/\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"731\",\n" +
                "            \"name\": \"例子 - Scrapy 中文指南 - 极客学院Wiki\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://wiki.jikexueyuan.com/project/scrapy/example.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"732\",\n" +
                "            \"name\": \"Scrapy 入门教程 - Scrapy 中文指南 - 极客学院Wiki\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://wiki.jikexueyuan.com/project/scrapy/scrapy-tutorial.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"733\",\n" +
                "            \"name\": \"Installation guide — Scrapy 1.5.0 documentation\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://docs.scrapy.org/en/latest/intro/install.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"734\",\n" +
                "            \"name\": \"Scrapy 1.5 documentation — Scrapy 1.5.0 documentation\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://doc.scrapy.org/en/latest/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"735\",\n" +
                "            \"name\": \"Scrapy 1.3.2 - 基础教程 - YGL_smile的博客 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/ygl_smile/article/details/58137421\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"736\",\n" +
                "            \"name\": \"Scrapy 1.3.2 - 基础教程 - YGL_smile的博客 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://blog.csdn.net/ygl_smile/article/details/58137421\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"737\",\n" +
                "            \"name\": \"数据收集(Stats Collection) — Scrapy 1.0.5 文档\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://scrapy-chs.readthedocs.io/zh_CN/1.0/topics/stats.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"738\",\n" +
                "            \"name\": \"Scrapy 0.25 文档 — Scrapy 0.24.1 文档\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://scrapy-chs.readthedocs.io/zh_CN/latest/index.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"739\",\n" +
                "            \"name\": \"Scrapy 中文指南_Scrapy 教程_Scrapy 指南_极客学院 Wiki\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://wiki.jikexueyuan.com/project/scrapy/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"740\",\n" +
                "            \"name\": \"Scrapy入门教程（Scrapy Tutorial-1.3\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://oner-wv.gitbooks.io/scrapy_zh/content/%E7%AC%AC%E4%B8%80%E6%AD%A5/scrapy%E5%85%A5%E9%97%A8%E6%95%99%E7%A8%8B.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"741\",\n" +
                "            \"name\": \"小白进阶之Scrapy第一篇 | 静觅\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://cuiqingcai.com/3472.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"742\",\n" +
                "            \"name\": \"利用爬虫技术能做到哪些很酷很有趣很有用的事情？ - 知乎\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.zhihu.com/question/27621722\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037618186\",\n" +
                "        \"date_modified\": \"13178209037618186\",\n" +
                "        \"id\": \"716\",\n" +
                "        \"name\": \"爬虫\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"728\",\n" +
                "            \"name\": \"有道网页翻译2.0\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"javascript: void((function() {var element = document.createElement('script');element.id = 'outfox_seed_js';element.charset = 'utf-8',element.setAttribute('src', 'http://fanyi.youdao.com/web2/seed.js?' + Date.parse(new Date()));document.body.appendChild(element);})())\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"729\",\n" +
                "            \"name\": \"How to check your network connections on Linux | Network World\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.networkworld.com/article/3262045/linux/checking-your-network-connections-on-linux.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"730\",\n" +
                "            \"name\": \"Installing on Linux — Conda documentation\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://conda.io/docs/user-guide/install/linux.html\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037618197\",\n" +
                "        \"date_modified\": \"13178209037618197\",\n" +
                "        \"id\": \"717\",\n" +
                "        \"name\": \"插件\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"725\",\n" +
                "            \"name\": \"Configuration API | Select2 - The jQuery replacement for select boxes\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://select2.org/configuration/options-api\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"726\",\n" +
                "            \"name\": \"Retrieving selections | Select2 - The jQuery replacement for select boxes\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://select2.org/programmatic-control/retrieving-selections\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"727\",\n" +
                "            \"name\": \"Selections | Select2 - The jQuery replacement for select boxes\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://select2.org/selections#clearable-selections\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037618201\",\n" +
                "        \"date_modified\": \"13178209037618202\",\n" +
                "        \"id\": \"718\",\n" +
                "        \"name\": \"select2\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"720\",\n" +
                "            \"name\": \"如何去掉a标签的下划线 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/mylitboy/article/details/6613518\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"721\",\n" +
                "            \"name\": \"手机浏览器的书签图标是从网站的哪里抓下来的呢？-CSDN论坛\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://bbs.csdn.net/topics/391050369\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"722\",\n" +
                "            \"name\": \"a标签置灰不可点击 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/fationyyk/article/details/51333336\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"723\",\n" +
                "            \"name\": \"鼠标悬停，背景色渐变 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/lp2659359879/article/details/52587455\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070296000000\",\n" +
                "            \"id\": \"724\",\n" +
                "            \"name\": \"Chrome怎么导出扩展程序（插件）为crx文件_百度经验\",\n" +
                "            \"sync_transaction_version\": \"220\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://jingyan.baidu.com/article/9158e0004ff9bba25512284d.html\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13178209037618206\",\n" +
                "        \"date_modified\": \"13178209037618206\",\n" +
                "        \"id\": \"719\",\n" +
                "        \"name\": \"url-plg\",\n" +
                "        \"sync_transaction_version\": \"1\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070304000000\",\n" +
                "            \"id\": \"546\",\n" +
                "            \"name\": \"java - \\\"from unexpected\\\" when createQuery - Stack Overflow\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://stackoverflow.com/questions/42871038/from-unexpected-when-createquery\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070304000000\",\n" +
                "            \"id\": \"547\",\n" +
                "            \"name\": \"GitHub - jonmiles/bootstrap-treeview: Tree View for Twitter Bootstrap -\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://github.com/jonmiles/bootstrap-treeview\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070304000000\",\n" +
                "            \"id\": \"548\",\n" +
                "            \"name\": \"JavaScript判断变量是否为undefined两种方式差异 - snandy - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/snandy/archive/2011/06/17/2083481.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070304000000\",\n" +
                "            \"id\": \"549\",\n" +
                "            \"name\": \"Linux内存占用大？ 简单说下内存机制 | LinuxVPS学习者 - CentOS(Linux)VPS教程、环境搭建、基础应用资源站。\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.kwx.gd/VpsPrimary/Linux-ram-cache.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070304000000\",\n" +
                "            \"id\": \"550\",\n" +
                "            \"name\": \"HTML标签嵌套规则 - 夕阳白雪 - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/xiyangbaixue/p/4090511.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070304000000\",\n" +
                "            \"id\": \"551\",\n" +
                "            \"name\": \"Java中对List集合的常用操作 - epeter - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.cnblogs.com/epeter/p/5648026.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070304000000\",\n" +
                "            \"id\": \"552\",\n" +
                "            \"name\": \"java 在线运行 - Google 搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.google.com.hk/search?q=java+%E5%9C%A8%E7%BA%BF%E8%BF%90%E8%A1%8C&oq=java+%E5%9C%A8%E7%BA%BF%E8%BF%90%E8%A1%8C&aqs=chrome..69i57j0.4667j0j7&sourceid=chrome&ie=UTF-8\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070304000000\",\n" +
                "            \"id\": \"553\",\n" +
                "            \"name\": \"idea设置两三事：如何设置html代码的style属性的代码 - 简书\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.jianshu.com/p/c5ac1085925d\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070304000000\",\n" +
                "            \"id\": \"554\",\n" +
                "            \"name\": \"mysql联表删除_百度经验\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://jingyan.baidu.com/article/9f7e7ec0b299a16f281554ea.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070304000000\",\n" +
                "            \"id\": \"555\",\n" +
                "            \"name\": \"\\u003Ca>标签中href=\\\"javascript:;\\\"表示什么意思？？_百度知道\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://zhidao.baidu.com/question/1987826329217404947.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070304000000\",\n" +
                "            \"id\": \"556\",\n" +
                "            \"name\": \"Java List\\u003CObject>去掉重复对象-java8 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/jiaobuchong/article/details/54412094\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070304000000\",\n" +
                "            \"id\": \"557\",\n" +
                "            \"name\": \"List、Set、Map、数组之间各种转换 - 我爱物联网 - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/yydcdut/p/3825721.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070304000000\",\n" +
                "            \"id\": \"558\",\n" +
                "            \"name\": \"java中的ArrayList 、List、LinkedList、Collection关系详解 - 李秋 - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.cnblogs.com/liqiu/p/3302607.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070304000000\",\n" +
                "            \"id\": \"559\",\n" +
                "            \"name\": \"list可以重复吗 - Google 搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.google.com.hk/search?q=list%E5%8F%AF%E4%BB%A5%E9%87%8D%E5%A4%8D%E5%90%97&oq=list%E5%8F%AF%E4%BB%A5%E9%87%8D%E5%A4%8D%E5%90%97&aqs=chrome..69i57j0.4589j0j1&sourceid=chrome&ie=UTF-8\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070304000000\",\n" +
                "            \"id\": \"560\",\n" +
                "            \"name\": \"Java学习笔记之ArrayList基本用法 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/gongchuangsu/article/details/51514389\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13177070552578348\",\n" +
                "        \"date_modified\": \"13178209037586686\",\n" +
                "        \"id\": \"27\",\n" +
                "        \"name\": \"0409\",\n" +
                "        \"sync_transaction_version\": \"80\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"492\",\n" +
                "            \"name\": \"如何安装多个版本的sqlserver - Google 搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.google.com.hk/search?q=%E5%A6%82%E4%BD%95%E5%AE%89%E8%A3%85%E5%A4%9A%E4%B8%AA%E7%89%88%E6%9C%AC%E7%9A%84sqlserver&oq=%E5%A6%82%E4%BD%95%E5%AE%89%E8%A3%85%E5%A4%9A%E4%B8%AA%E7%89%88%E6%9C%AC%E7%9A%84sqlserver&aqs=chrome..69i57.10474j0j7&sourceid=chrome&ie=UTF-8\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"493\",\n" +
                "            \"name\": \"服务器同时安装了两个版本的sql，如果分别连接不同版本的sql上的数据库 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/z542601362/article/details/45642023\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"494\",\n" +
                "            \"name\": \"同时在计算机上安装不同版本的SQL SERVER的问题 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/andrewniu/article/details/78498248\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"495\",\n" +
                "            \"name\": \"传入的请求具有过多的参数。该服务器支持最多 2100 个参数。请减少参数的数目，然后重新发送该请求。 - Google 搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.google.com.hk/search?q=%E4%BC%A0%E5%85%A5%E7%9A%84%E8%AF%B7%E6%B1%82%E5%85%B7%E6%9C%89%E8%BF%87%E5%A4%9A%E7%9A%84%E5%8F%82%E6%95%B0%E3%80%82%E8%AF%A5%E6%9C%8D%E5%8A%A1%E5%99%A8%E6%94%AF%E6%8C%81%E6%9C%80%E5%A4%9A+2100+%E4%B8%AA%E5%8F%82%E6%95%B0%E3%80%82%E8%AF%B7%E5%87%8F%E5%B0%91%E5%8F%82%E6%95%B0%E7%9A%84%E6%95%B0%E7%9B%AE%EF%BC%8C%E7%84%B6%E5%90%8E%E9%87%8D%E6%96%B0%E5%8F%91%E9%80%81%E8%AF%A5%E8%AF%B7%E6%B1%82%E3%80%82&oq=%E4%BC%A0%E5%85%A5%E7%9A%84%E8%AF%B7%E6%B1%82%E5%85%B7%E6%9C%89%E8%BF%87%E5%A4%9A%E7%9A%84%E5%8F%82%E6%95%B0%E3%80%82%E8%AF%A5%E6%9C%8D%E5%8A%A1%E5%99%A8%E6%94%AF%E6%8C%81%E6%9C%80%E5%A4%9A+2100+%E4%B8%AA%E5%8F%82%E6%95%B0%E3%80%82%E8%AF%B7%E5%87%8F%E5%B0%91%E5%8F%82%E6%95%B0%E7%9A%84%E6%95%B0%E7%9B%AE%EF%BC%8C%E7%84%B6%E5%90%8E%E9%87%8D%E6%96%B0%E5%8F%91%E9%80%81%E8%AF%A5%E8%AF%B7%E6%B1%82%E3%80%82&aqs=chrome..69i57.518j0j7&sourceid=chrome&ie=UTF-8\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"496\",\n" +
                "            \"name\": \"多个list存在相同的元素 - Google 搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.google.com.hk/search?q=%E5%A4%9A%E4%B8%AAlist%E5%AD%98%E5%9C%A8%E7%9B%B8%E5%90%8C%E7%9A%84%E5%85%83%E7%B4%A0&oq=%E5%A4%9A%E4%B8%AAlist%E5%AD%98%E5%9C%A8%E7%9B%B8%E5%90%8C%E7%9A%84%E5%85%83%E7%B4%A0&aqs=chrome..69i57.8452j0j7&sourceid=chrome&ie=UTF-8\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"497\",\n" +
                "            \"name\": \"Java-JAVA快速查找多个List中相同的元素 - 德问:编程社交问答\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.dewen.net.cn/q/12312/JAVA%E5%BF%AB%E9%80%9F%E6%9F%A5%E6%89%BE%E5%A4%9A%E4%B8%AAList%E4%B8%AD%E7%9B%B8%E5%90%8C%E7%9A%84%E5%85%83%E7%B4%A0\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"498\",\n" +
                "            \"name\": \"list根据某个相同的属性分组 - Google 搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.google.com.hk/search?q=list%E6%A0%B9%E6%8D%AE%E6%9F%90%E4%B8%AA%E7%9B%B8%E5%90%8C%E7%9A%84%E5%B1%9E%E6%80%A7%E5%88%86%E7%BB%84&oq=list%E6%A0%B9%E6%8D%AE%E6%9F%90%E4%B8%AA%E7%9B%B8%E5%90%8C%E7%9A%84%E5%B1%9E%E6%80%A7%E5%88%86%E7%BB%84&aqs=chrome..69i57.7780j0j7&sourceid=chrome&ie=UTF-8\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"499\",\n" +
                "            \"name\": \"关于ArrayList中对象按照属性进行分类(属性相同的对象放入新的arrayList里面) - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/wangjia55/article/details/10739663\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"500\",\n" +
                "            \"name\": \"对ArrayList按照某个属性进行分组 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/linsongbin1/article/details/54341078\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"501\",\n" +
                "            \"name\": \"Java中如何遍历Map对象的4种方法 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/tjcyjd/article/details/11111401\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"502\",\n" +
                "            \"name\": \"Java中List集合的遍历（三种遍历方式效率的比较） - 简书\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.jianshu.com/p/14ade693877d\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"503\",\n" +
                "            \"name\": \"Java 8：不要再用循环了 - ImportNew\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.importnew.com/14841.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"504\",\n" +
                "            \"name\": \"判断两个list是否相等 - Google 搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.google.com.hk/search?q=%E5%88%A4%E6%96%AD%E4%B8%A4%E4%B8%AAlist%E6%98%AF%E5%90%A6%E7%9B%B8%E7%AD%89&oq=%E5%88%A4%E6%96%AD%E4%B8%A4%E4%B8%AAlist%E6%98%AF%E5%90%A6&aqs=chrome.1.69i57j0l2.21263j0j7&sourceid=chrome&ie=UTF-8\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"505\",\n" +
                "            \"name\": \"Java判断两个List是否相同 - 简书\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.jianshu.com/p/e96216367a81\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"506\",\n" +
                "            \"name\": \"比较两个List是否相等（相同元素） - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/tiwerbao/article/details/42836305\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"507\",\n" +
                "            \"name\": \"Collection.containsAll() - Google 搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.google.com.hk/search?q=Collection.containsAll()&safe=strict&lr=lang_zh-CN&sa=X&ved=0ahUKEwjtx8Ksj9LaAhUEH5QKHW81AcYQuAEIIw&biw=1920&bih=949\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"508\",\n" +
                "            \"name\": \"MySQL 插入数据 | 菜鸟教程\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.runoob.com/mysql/mysql-insert-query.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"509\",\n" +
                "            \"name\": \"SQL INSERT INTO 语句 | 菜鸟教程\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.runoob.com/sql/sql-insert.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"510\",\n" +
                "            \"name\": \"spring如何返回多个数组 - Google 搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.google.com.hk/search?q=spring%E5%A6%82%E4%BD%95%E8%BF%94%E5%9B%9E%E5%A4%9A%E4%B8%AA%E6%95%B0%E7%BB%84&oq=spring%E5%A6%82%E4%BD%95%E8%BF%94%E5%9B%9E%E5%A4%9A%E4%B8%AA%E6%95%B0%E7%BB%84&aqs=chrome..69i57.6886j0j7&sourceid=chrome&ie=UTF-8\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"511\",\n" +
                "            \"name\": \"Appearance | Select2 - The jQuery replacement for select boxes\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://select2.org/appearance\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"512\",\n" +
                "            \"name\": \"CSS border边框属性教程(color style) - DIVCSS5\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.divcss5.com/rumen/r120.shtml\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"513\",\n" +
                "            \"name\": \"html 元素id命名规则 - Google 搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.google.com.hk/search?q=html+%E5%85%83%E7%B4%A0id%E5%91%BD%E5%90%8D%E8%A7%84%E5%88%99&oq=html+%E5%85%83%E7%B4%A0id%E5%91%BD%E5%90%8D%E8%A7%84%E5%88%99&aqs=chrome..69i57.11410j0j1&sourceid=chrome&ie=UTF-8\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"514\",\n" +
                "            \"name\": \"关于Html class id 命名规范 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/Luo_da/article/details/76195590\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"515\",\n" +
                "            \"name\": \"styleguide/html.md at master · fex-team/styleguide\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://github.com/fex-team/styleguide/blob/master/html.md#22-%E5%91%BD%E5%90%8D\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"516\",\n" +
                "            \"name\": \"styleguide/javascript.md at master · fex-team/styleguide\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://github.com/fex-team/styleguide/blob/master/javascript.md#23-%E5%91%BD%E5%90%8D\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"517\",\n" +
                "            \"name\": \"Intellij IDEA – Refactor 重构 – 大猫 (Madao)\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://ooxx.me/intellij-idea-refactor.orz\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"518\",\n" +
                "            \"name\": \"springmvc 接收对象参数 - Google 搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.google.com.hk/search?safe=strict&ei=HJTdWtXVOory8QWp15T4BA&q=springmvc+%E6%8E%A5%E6%94%B6%E5%AF%B9%E8%B1%A1%E5%8F%82%E6%95%B0&oq=springmvc+%E6%8E%A5%E6%94%B6%E5%AF%B9%E8%B1%A1%E5%8F%82%E6%95%B0&gs_l=psy-ab.3...1843.3473.0.3624.6.6.0.0.0.0.102.441.5j1.6.0....0...1c.4.64.psy-ab..0.0.0....0.gwu3eKbQ9hA\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"519\",\n" +
                "            \"name\": \"SpringMVC Controller接收参数总结 - 简书\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.jianshu.com/p/ed44e89a6f79\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"520\",\n" +
                "            \"name\": \"SpringMVC接收复杂集合参数 - 莫叹君临早，更有早行人 - ITeye博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://jxd-zxf.iteye.com/blog/2072300\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"521\",\n" +
                "            \"name\": \"SpringMVC 接收数组参数 | WEBINGLIN\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://webinglin.github.io/2015/11/01/SpringMVC-%E6%8E%A5%E6%94%B6%E6%95%B0%E7%BB%84%E5%8F%82%E6%95%B0/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"522\",\n" +
                "            \"name\": \"4种方法让SpringMVC接收多个对象 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/lutinghuan/article/details/46820023\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"523\",\n" +
                "            \"name\": \"spring MVC 前台传数组类型,后台用list类型接收也是可以的 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/qq_27093465/article/details/52094112\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"524\",\n" +
                "            \"name\": \"多个list存在相同的元素 - Google 搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.google.com.hk/search?q=%E5%A4%9A%E4%B8%AAlist%E5%AD%98%E5%9C%A8%E7%9B%B8%E5%90%8C%E7%9A%84%E5%85%83%E7%B4%A0&oq=%E5%A4%9A%E4%B8%AAlist%E5%AD%98%E5%9C%A8%E7%9B%B8%E5%90%8C%E7%9A%84%E5%85%83%E7%B4%A0&aqs=chrome..69i57.8452j0j7&sourceid=chrome&ie=UTF-8\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"525\",\n" +
                "            \"name\": \"Java-JAVA快速查找多个List中相同的元素 - 德问:编程社交问答\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.dewen.net.cn/q/12312/JAVA%E5%BF%AB%E9%80%9F%E6%9F%A5%E6%89%BE%E5%A4%9A%E4%B8%AAList%E4%B8%AD%E7%9B%B8%E5%90%8C%E7%9A%84%E5%85%83%E7%B4%A0\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"526\",\n" +
                "            \"name\": \"list根据某个相同的属性分组 - Google 搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.google.com.hk/search?q=list%E6%A0%B9%E6%8D%AE%E6%9F%90%E4%B8%AA%E7%9B%B8%E5%90%8C%E7%9A%84%E5%B1%9E%E6%80%A7%E5%88%86%E7%BB%84&oq=list%E6%A0%B9%E6%8D%AE%E6%9F%90%E4%B8%AA%E7%9B%B8%E5%90%8C%E7%9A%84%E5%B1%9E%E6%80%A7%E5%88%86%E7%BB%84&aqs=chrome..69i57.7780j0j7&sourceid=chrome&ie=UTF-8\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"527\",\n" +
                "            \"name\": \"关于ArrayList中对象按照属性进行分类(属性相同的对象放入新的arrayList里面) - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/wangjia55/article/details/10739663\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"528\",\n" +
                "            \"name\": \"对ArrayList按照某个属性进行分组 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/linsongbin1/article/details/54341078\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"529\",\n" +
                "            \"name\": \"Java中如何遍历Map对象的4种方法 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/tjcyjd/article/details/11111401\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"530\",\n" +
                "            \"name\": \"Java中List集合的遍历（三种遍历方式效率的比较） - 简书\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.jianshu.com/p/14ade693877d\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"531\",\n" +
                "            \"name\": \"Java 8：不要再用循环了 - ImportNew\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.importnew.com/14841.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"532\",\n" +
                "            \"name\": \"判断两个list是否相等 - Google 搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.google.com.hk/search?q=%E5%88%A4%E6%96%AD%E4%B8%A4%E4%B8%AAlist%E6%98%AF%E5%90%A6%E7%9B%B8%E7%AD%89&oq=%E5%88%A4%E6%96%AD%E4%B8%A4%E4%B8%AAlist%E6%98%AF%E5%90%A6&aqs=chrome.1.69i57j0l2.21263j0j7&sourceid=chrome&ie=UTF-8\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"533\",\n" +
                "            \"name\": \"Java判断两个List是否相同 - 简书\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.jianshu.com/p/e96216367a81\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"534\",\n" +
                "            \"name\": \"比较两个List是否相等（相同元素） - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/tiwerbao/article/details/42836305\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"535\",\n" +
                "            \"name\": \"JDK源码-Collection-contains()以及containsAll() - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/u012310056/article/details/75432871\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"536\",\n" +
                "            \"name\": \"containsAll_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?wd=containsAll\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"537\",\n" +
                "            \"name\": \"Java方法containsAll学习 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/baidu_15113429/article/details/53198625?locationNum=15&fps=1\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"538\",\n" +
                "            \"name\": \"java list - Google 搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.google.com.hk/search?q=java+list&oq=java+list&aqs=chrome..69i57j69i65l3j69i61j0.2174j0j7&sourceid=chrome&ie=UTF-8\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"539\",\n" +
                "            \"name\": \"List (Java Platform SE 7 )\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://docs.oracle.com/javase/7/docs/api/java/util/List.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"540\",\n" +
                "            \"name\": \"ArrayList (Java Platform SE 7 )\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"541\",\n" +
                "            \"name\": \"Easyui Datagrid 数据网格_EasyUI 插件\",\n" +
                "            \"sync_transaction_version\": \"111\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.jeasyui.net/plugins/183.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"542\",\n" +
                "            \"name\": \"Array.prototype.slice() - JavaScript | MDN\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Array/slice\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"543\",\n" +
                "            \"name\": \"java 按照属性拆分list - Google 搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.google.com.hk/search?safe=strict&ei=elzgWvGJDMau0gTEp5C4Bw&q=java+%E6%8C%89%E7%85%A7%E5%B1%9E%E6%80%A7%E6%8B%86%E5%88%86list&oq=java+%E6%8C%89%E7%85%A7%E5%B1%9E%E6%80%A7%E6%8B%86%E5%88%86list&gs_l=psy-ab.3...4746.9844.0.10851.13.10.3.0.0.0.118.768.9j1.10.0....0...1c.1j4.64.psy-ab..1.1.89...35i39k1.0.Hsi1NxyhkN0\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"544\",\n" +
                "            \"name\": \"分隔List集合，按指定大小，将集合分成多个 - 程序园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.voidcn.com/article/p-phmcnsfj-bch.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070315000000\",\n" +
                "            \"id\": \"545\",\n" +
                "            \"name\": \"Java中判断两个Long类型是否相等 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/hxxanyifree/article/details/68063641\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13177070552579848\",\n" +
                "        \"date_modified\": \"13179394008479892\",\n" +
                "        \"id\": \"28\",\n" +
                "        \"name\": \"0409-2\",\n" +
                "        \"sync_transaction_version\": \"80\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070317000000\",\n" +
                "            \"id\": \"490\",\n" +
                "            \"name\": \"解决tomcat文件上传的文件大小限制 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/lafengwnagzi/article/details/72846195\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070317000000\",\n" +
                "            \"id\": \"491\",\n" +
                "            \"name\": \"解决git pull/push每次都需要输入密码问题 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/nongweiyilady/article/details/77772602\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13177070552585133\",\n" +
                "        \"date_modified\": \"13178209037586998\",\n" +
                "        \"id\": \"29\",\n" +
                "        \"name\": \"0607\",\n" +
                "        \"sync_transaction_version\": \"80\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070319000000\",\n" +
                "            \"id\": \"485\",\n" +
                "            \"name\": \"浅谈contentType = false - 摸索着前端开发 - SegmentFault 思否\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://segmentfault.com/a/1190000007207128\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070319000000\",\n" +
                "            \"id\": \"486\",\n" +
                "            \"name\": \"css 边框阴影_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=baidu&wd=css%20%E8%BE%B9%E6%A1%86%E9%98%B4%E5%BD%B1&oq=css%2520Overlay&rsv_pq=c372e1be0001368d&rsv_t=2e78s1zpqt7FeOrB7WDWeWwtK0eMpoxSefEHQrVaH9TM09FusbP6o0QeGn0&rqlang=cn&rsv_enter=1&inputT=2098&rsv_sug3=25&rsv_sug1=19&rsv_sug7=100&bs=css%20Overlay\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070319000000\",\n" +
                "            \"id\": \"487\",\n" +
                "            \"name\": \"css 边框阴影_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=baidu&wd=css%20%E8%BE%B9%E6%A1%86%E9%98%B4%E5%BD%B1&oq=css%2520Overlay&rsv_pq=c372e1be0001368d&rsv_t=2e78s1zpqt7FeOrB7WDWeWwtK0eMpoxSefEHQrVaH9TM09FusbP6o0QeGn0&rqlang=cn&rsv_enter=1&inputT=2098&rsv_sug3=25&rsv_sug1=19&rsv_sug7=100&bs=css%20Overlay\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070319000000\",\n" +
                "            \"id\": \"488\",\n" +
                "            \"name\": \"DIV CSS 边框颜色如何设置 - DIVCSS5\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.divcss5.com/wenji/w520.shtml\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070319000000\",\n" +
                "            \"id\": \"489\",\n" +
                "            \"name\": \"HTML网页布局：静态、自适应、流式、响应式 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/iefreer/article/details/40155459\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13177070552585555\",\n" +
                "        \"date_modified\": \"13178209037587168\",\n" +
                "        \"id\": \"30\",\n" +
                "        \"name\": \"0608\",\n" +
                "        \"sync_transaction_version\": \"80\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177070321000000\",\n" +
                "            \"id\": \"469\",\n" +
                "            \"name\": \"为编程软件使用什么背景颜色比较不伤眼？ - 知乎\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.zhihu.com/question/20215618\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070321000000\",\n" +
                "            \"id\": \"470\",\n" +
                "            \"name\": \"白色主题护眼还是黑色主题 - Google 搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.google.com.hk/search?q=%E7%99%BD%E8%89%B2%E4%B8%BB%E9%A2%98%E6%8A%A4%E7%9C%BC%E8%BF%98%E6%98%AF%E9%BB%91%E8%89%B2%E4%B8%BB%E9%A2%98&oq=%E7%99%BD%E8%89%B2%E4%B8%BB%E9%A2%98%E6%8A%A4%E7%9C%BC%E8%BF%98%E6%98%AF%E9%BB%91%E8%89%B2%E4%B8%BB%E9%A2%98&aqs=chrome..69i57.8595j0j1&sourceid=chrome&ie=UTF-8\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070321000000\",\n" +
                "            \"id\": \"471\",\n" +
                "            \"name\": \"html select 输入 - Google 搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.google.com.hk/search?q=html+select+%E8%BE%93%E5%85%A5&oq=html+select+%E8%BE%93%E5%85%A5&aqs=chrome..69i57.8906j0j1&sourceid=chrome&ie=UTF-8\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070321000000\",\n" +
                "            \"id\": \"472\",\n" +
                "            \"name\": \"Specified VM install not found: type Standard VM, name jre7 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/u012401711/article/details/50773459\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070321000000\",\n" +
                "            \"id\": \"473\",\n" +
                "            \"name\": \"TeamView 无法捕捉画面问题的解决办法 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/vic0228/article/details/50606440\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070321000000\",\n" +
                "            \"id\": \"474\",\n" +
                "            \"name\": \"javascript Web上传文件夹的两种解决方案 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/binyao02123202/article/details/6990756\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070321000000\",\n" +
                "            \"id\": \"475\",\n" +
                "            \"name\": \"GenerationType - Google 搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.google.com.hk/search?q=GenerationType&oq=GenerationType&aqs=chrome..69i57j0l7.463j0j1&sourceid=chrome&ie=UTF-8\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070321000000\",\n" +
                "            \"id\": \"476\",\n" +
                "            \"name\": \"理解JPA注解@GeneratedValue - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/canot/article/details/51455967\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070321000000\",\n" +
                "            \"id\": \"477\",\n" +
                "            \"name\": \"Hibernate和UUID标示符 - ImportNew\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.importnew.com/12567.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070321000000\",\n" +
                "            \"id\": \"478\",\n" +
                "            \"name\": \"hibernate使用uuid - Google 搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.google.com.hk/search?q=hibernate%E4%BD%BF%E7%94%A8uuid&oq=hibern&aqs=chrome.0.69i59j69i65l3j0j69i57j69i61l2.2580j0j1&sourceid=chrome&ie=UTF-8\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070321000000\",\n" +
                "            \"id\": \"479\",\n" +
                "            \"name\": \"JPA Hibernate 使用UUID做为主键的问题 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/yutuyinchan/article/details/73729316\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070321000000\",\n" +
                "            \"id\": \"480\",\n" +
                "            \"name\": \"GenericGenerator - Google 搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.google.com.hk/search?q=GenericGenerator&oq=GenericGenerator&aqs=chrome..69i57&sourceid=chrome&ie=UTF-8\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070321000000\",\n" +
                "            \"id\": \"481\",\n" +
                "            \"name\": \"@GeneratorValue与@GenericGenerator注解使用心得 - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/TianXieZuoMaiKong/article/details/64930151\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070321000000\",\n" +
                "            \"id\": \"482\",\n" +
                "            \"name\": \"Hibernate中Session的get和load - 罗韬 - 博客园\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://www.cnblogs.com/luotaoyeah/p/3862974.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070327000000\",\n" +
                "            \"id\": \"483\",\n" +
                "            \"name\": \"新技能 get —— 如何校验 md5（windows） - CSDN博客\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://blog.csdn.net/lanchunhui/article/details/71439550\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177070330000000\",\n" +
                "            \"id\": \"484\",\n" +
                "            \"name\": \"Bandwagon Host - Client Area\",\n" +
                "            \"sync_transaction_version\": \"449\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://bwh1.net/clientarea.php\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13177070552586279\",\n" +
                "        \"date_modified\": \"13178209037587333\",\n" +
                "        \"id\": \"31\",\n" +
                "        \"name\": \"0717\",\n" +
                "        \"sync_transaction_version\": \"80\",\n" +
                "        \"type\": \"folder\"\n" +
                "    }, {\n" +
                "        \"children\": [ {\n" +
                "            \"date_added\": \"13177582331144377\",\n" +
                "            \"id\": \"71\",\n" +
                "            \"name\": \"Asta Document Server\",\n" +
                "            \"sync_transaction_version\": \"449\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://localhost:8080/welcome.htm\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177582331144936\",\n" +
                "            \"id\": \"72\",\n" +
                "            \"name\": \"edf文件_百度搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.baidu.com/s?wd=edf%E6%96%87%E4%BB%B6\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177582331145335\",\n" +
                "            \"id\": \"73\",\n" +
                "            \"name\": \"如何打开EDF文件 - 文件扩展名为EDF\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.solvusoft.com/zh-cn/file-extensions/file-extension-edf/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177582331145694\",\n" +
                "            \"id\": \"74\",\n" +
                "            \"name\": \"如何打开edf文件_百度知道\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://zhidao.baidu.com/question/149055107.html\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177582331145928\",\n" +
                "            \"id\": \"75\",\n" +
                "            \"name\": \"edf的是什么文件 用什么打开_百度知道\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://zhidao.baidu.com/question/136242862431893205.html?qbl=relate_question_0\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177582331146144\",\n" +
                "            \"id\": \"76\",\n" +
                "            \"name\": \"edf file - Google 搜索\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.google.com/search?newwindow=1&hl=zh-CN&q=edf%20file&cad=h\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177582331146362\",\n" +
                "            \"id\": \"77\",\n" +
                "            \"name\": \"EDFbrowser\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.teuniz.net/edfbrowser/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177582331146509\",\n" +
                "            \"id\": \"78\",\n" +
                "            \"name\": \"欧洲数据格式（EDF）\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.edfplus.info/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177582331146711\",\n" +
                "            \"id\": \"79\",\n" +
                "            \"name\": \"开始下载免费PDF24创建工具\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://zh.pdf24.org/pdf-creator-download-start.html#private\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177582331146924\",\n" +
                "            \"id\": \"80\",\n" +
                "            \"name\": \"EDF文件扩展名 - 什么是.edf以及如何打开？ - ReviverSoft\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.reviversoft.com/zh-cn/file-extensions/edf\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177582331147161\",\n" +
                "            \"id\": \"81\",\n" +
                "            \"name\": \"EDFExplorer\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"http://edfexplorer.sourceforge.net/\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177582331147298\",\n" +
                "            \"id\": \"82\",\n" +
                "            \"name\": \"EDF文件扩展名 - 什么是.edf以及如何打开？ - ReviverSoft\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://www.reviversoft.com/zh-cn/file-extensions/edf?ncr=1\"\n" +
                "        }, {\n" +
                "            \"date_added\": \"13177582331147472\",\n" +
                "            \"id\": \"83\",\n" +
                "            \"name\": \"在线将文件转换为PDF格式 - 100% 免费 - PDF24 Tools\",\n" +
                "            \"sync_transaction_version\": \"1\",\n" +
                "            \"type\": \"url\",\n" +
                "            \"url\": \"https://tools.pdf24.org/zh/convert-to-pdf\"\n" +
                "        } ],\n" +
                "        \"date_added\": \"13177582331143466\",\n" +
                "        \"date_modified\": \"13180603750009636\",\n" +
                "        \"id\": \"34\",\n" +
                "        \"name\": \"edf\",\n" +
                "        \"sync_transaction_version\": \"80\",\n" +
                "        \"type\": \"folder\"\n" +
                "    } ],\n" +
                "    \"date_added\": \"13177070552536729\",\n" +
                "    \"date_modified\": \"13178619433914111\",\n" +
                "    \"id\": \"21\",\n" +
                "    \"name\": \"web\",\n" +
                "    \"sync_transaction_version\": \"466\",\n" +
                "    \"type\": \"folder\"\n" +
                "} ]");
    }

    @RequestMapping(value = "/init")
    public void get(HttpServletRequest request, HttpServletResponse response) {
        List rootFolder = new ArrayList();
        rootFolder.add(1L);
        rootFolder.add(2L);

        List<Folder> folders = basicService.get(Folder.class, rootFolder);
        return2(folders, response);
    }

    @RequestMapping(value = "/get")
    public void get2(HttpServletRequest request, HttpServletResponse response, Long folderID) {
        if(folderID == null){
            return;
        }

        String hql = "from Folder where parentid = "+ folderID;

        List<Folder> folders = basicService.get(hql);
        return2(folders, response);
    }

    @RequestMapping(value = "/get/{folderID}")
    public void get3(HttpServletRequest request, HttpServletResponse response, @PathVariable Long folderID) {
        return;
    }

    public <T> void return2(List<Folder> folders, HttpServletResponse response){
        if(folders != null || folders.size() != 0) {
            JsonArray folderTree = new JsonArray();
            for (int i = 0; i < folders.size(); i++) {
                JsonObject node = new JsonObject();
                node.addProperty("id", folders.get(i).getId());
                node.addProperty("text", folders.get(i).getName());
                node.addProperty("state", CLOSED);

                folderTree.add(node);
            }
            writeResponse(folderTree.toString(), response);
        }else{
//            no data
        }
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