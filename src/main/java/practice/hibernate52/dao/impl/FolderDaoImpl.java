package practice.hibernate52.dao.impl;

import org.springframework.stereotype.Repository;
import practice.hibernate52.dao.FolderDao;

import java.util.List;


@Repository
public class FolderDaoImpl implements FolderDao {

    @Override
    public <T> List<T> get(Class<T> clazz) {
        return null;
    }
}
