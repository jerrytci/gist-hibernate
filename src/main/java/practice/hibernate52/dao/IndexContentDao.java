package practice.hibernate52.dao;

import com.google.gson.JsonArray;

/**
 * Created by astaJerry on 2017/7/24.
 */

public interface IndexContentDao {
    public JsonArray getIndexFolder(int parentId);
}
