package practice.hibernate52.service;

import com.google.gson.JsonArray;

/**
 * Created by astaJerry on 2017/7/24.
 */

public interface IndexContentService {
    public JsonArray getIndexFolder(int parentId);
}
