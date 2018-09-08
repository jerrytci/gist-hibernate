package practice.hibernate52.dao.impl;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
//public class BasicDaoImpl implements BasicDao {
public class BasicDaoImpl{

    public <T> T get(Class<T> tClass, long id) {
        return null;
    }

    public <T> List<T> get(Class<T> tClass) {
        return null;
    }

    public <T> List<T> get(Class<T> tClass, List ids) {
        return null;
    }

    public <T> List<T> getHqlResult(String hql) {
        return null;
    }
}
