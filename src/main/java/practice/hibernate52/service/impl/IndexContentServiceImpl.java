package practice.hibernate52.service.impl;

import com.google.gson.JsonArray;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.hibernate52.dao.IndexContentDao;
import practice.hibernate52.service.IndexContentService;

import javax.annotation.Resource;

/**
 * Created by astaJerry on 2017/7/24.
 */
@Transactional
@Service
public class IndexContentServiceImpl implements IndexContentService {

    @Resource
    private IndexContentDao IndexContentDaoImpl;

    @Override
    public JsonArray getIndexFolder(int parentId) {
//        JsonArray result = new JsonArray();
        IndexContentDaoImpl.getIndexFolder(parentId);
        return null;
    }
}
