package practice.hibernate52.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.hibernate52.dao.BasicDao;
import practice.hibernate52.domain.Folder;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class FolderServiceImpl2{

    @Resource
    @Qualifier("basicDaoImpl2")
    private BasicDao basicDao;

    /*
    @Override
    public <T> T get(Class<T> tClass, long id) {
        T t = folderDao.get(tClass, id);
        return t;
    }

    @Override
    public <T> List<T> get(Class<T> tClass) {
        return folderDao.get(tClass);
    }

    @Override
    public <T> List<T> get(Class<T> tClass, List ids) {
        return folderDao.get(tClass, ids);
    }
    */

    public Folder get(long id) {
        return null;
    }

    public List<Folder> getSub(String hql) {
        return basicDao.getHqlResult(hql);
    }

    public List<Folder> get() {
        return basicDao.get(Folder.class);
    }

    public List<Folder> get(List ids) {
        return basicDao.get(Folder.class, ids);
    }


}
