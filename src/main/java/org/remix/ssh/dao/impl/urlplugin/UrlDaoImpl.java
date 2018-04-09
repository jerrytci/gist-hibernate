package org.remix.ssh.dao.impl.urlplugin;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.remix.ssh.dao.urlplugin.UrlDao;
import org.remix.ssh.domain.urlplugin.Folder;
import org.remix.ssh.domain.urlplugin.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UrlDaoImpl implements UrlDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Url saveUrl(Url url) {
        sessionFactory.getCurrentSession().save(url);
        return url;
    }

    @Override
    public Folder getFolder(String folder) {
        Folder folder1 = (Folder) sessionFactory.getCurrentSession().get(Folder.class,"tag");
        return folder1;
    }

    @Override
    public List<Folder> getAllFolder() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Folder");
        List<Folder> folders = query.list();
        return folders;
    }
}
