package practice.hibernate52.dao.impl;

import org.springframework.stereotype.Repository;
import practice.hibernate52.dao.FolderDao;

import java.util.List;


@Repository
public class FolderDaoImpl implements FolderDao {

    @Override
    public <T> T get(Class<T> tClass, long id) {
        return null;
    }

    @Override
    public <T> List<T> get(Class<T> tClass) {
        return null;
    }

    @Override
    public <T> List<T> get(Class<T> tClass, List ids) {
        return null;
    }
}
