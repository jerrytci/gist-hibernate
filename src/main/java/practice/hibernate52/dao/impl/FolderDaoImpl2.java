package practice.hibernate52.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import practice.hibernate52.dao.FolderDao;

import java.util.ArrayList;
import java.util.List;


@Repository
public class FolderDaoImpl2 implements FolderDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public <T> T get(Class<T> tClass, long id) {
        String sql = "from "+tClass.getTypeName() + " where id = " + id;
        return sessionFactory.getCurrentSession().createQuery(sql, tClass).uniqueResult();
    }

    @Override
    public <T> List<T> get(Class<T> tClass) {
        String sql = "from "+tClass.getTypeName();
        return sessionFactory.getCurrentSession().createQuery(sql, tClass).list();
    }

    @Override
    public <T> List<T> get(Class<T> tClass, List ids) {
        String sql = "from "+tClass.getTypeName() + " where id in (:ids)";
        return sessionFactory.getCurrentSession().createQuery(sql, tClass)
                .setParameterList("ids", ids)
                .list();
    }
}
