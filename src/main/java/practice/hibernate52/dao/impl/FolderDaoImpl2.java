package practice.hibernate52.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import practice.hibernate52.dao.FolderDao;

import java.util.List;


@Repository
public class FolderDaoImpl2 implements FolderDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public <T> List<T> get(Class<T> clazz) {
        String sql = "from "+clazz.getTypeName();
        Query<T> query = sessionFactory.getCurrentSession().createQuery(sql, clazz);
        return query.list();
    }


}
