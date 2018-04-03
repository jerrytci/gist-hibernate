package org.remix.ssh.dao.impl.urlplugin;

import org.hibernate.SessionFactory;
import org.remix.ssh.dao.urlplugin.UrlDao;
import org.remix.ssh.domain.urlplugin.Folder;
import org.remix.ssh.domain.urlplugin.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
