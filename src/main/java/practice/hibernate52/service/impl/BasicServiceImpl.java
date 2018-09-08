package practice.hibernate52.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.hibernate52.dao.BasicDao;
import practice.hibernate52.service.BasicService;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class BasicServiceImpl implements BasicService{

    @Resource
    @Qualifier("basicDaoImpl2")
    private BasicDao basicDao;

    @Override
    public <T> T get(Class<T> tClass, long id) {
        return basicDao.get(tClass, id);
    }

    @Override
    public <T> List<T> get(Class<T> tClass) {
        return basicDao.get(tClass);
    }

    @Override
    public <T> List<T> get(Class<T> tClass, List ids) {
        return basicDao.get(tClass, ids);
    }

    @Override
    public <T> List<T> get(String hql) {
        return basicDao.getHqlResult(hql);
    }
}
