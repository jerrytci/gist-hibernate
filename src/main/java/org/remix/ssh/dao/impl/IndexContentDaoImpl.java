package org.remix.ssh.dao.impl;

import com.google.gson.JsonArray;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.remix.ssh.dao.IndexContentDao;
import org.remix.ssh.domain.IndexFolderEntity;
import org.remix.ssh.util.HibernateUtils;
import org.springframework.stereotype.Repository;

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
