package practice.hibernate52.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import practice.hibernate52.dao.FolderDao;
import practice.hibernate52.domain.Folder;
import practice.hibernate52.util.HibernateUtils;

import java.util.List;

@Repository
public class FolderDaoImpl implements FolderDao {

    @Override
    public void saveFolder(List<Folder> folders) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        for(Folder folder : folders){
            session.save(folder);
        }
        transaction.commit();
    }
}


