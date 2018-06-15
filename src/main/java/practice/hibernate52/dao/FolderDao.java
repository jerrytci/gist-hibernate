package practice.hibernate52.dao;

import java.util.List;

public interface FolderDao {
    public <T> List<T> get(Class<T> clazz);
}
