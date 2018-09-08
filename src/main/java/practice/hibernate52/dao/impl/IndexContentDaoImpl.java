package practice.hibernate52.dao.impl;

import com.google.gson.JsonArray;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import practice.hibernate52.dao.IndexContentDao;
import practice.hibernate52.domain.IndexFolderEntity;
import practice.hibernate52.util.HibernateUtils;

/**
 * Created by astaJerry on 2017/7/24.
 */
@Repository
public class IndexContentDaoImpl implements IndexContentDao {

    @Override
    public JsonArray getIndexFolder(int parentId) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        IndexFolderEntity indexFolderEntity = session.get(IndexFolderEntity.class,3);
        transaction.commit();
        System.out.println(indexFolderEntity.getName());
        return null;
    }
}
