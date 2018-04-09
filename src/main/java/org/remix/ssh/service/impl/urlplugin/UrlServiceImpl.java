package org.remix.ssh.service.impl.urlplugin;

import org.remix.ssh.dao.urlplugin.UrlDao;
import org.remix.ssh.domain.urlplugin.Folder;
import org.remix.ssh.domain.urlplugin.Url;
import org.remix.ssh.service.urlplugin.UrlService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class UrlServiceImpl implements UrlService {

    @Resource
    private UrlDao urlDaoImpl;

    @Override
    public Url saveUrl(Url url, String folder) {
        Folder folder1 = urlDaoImpl.getFolder(folder);
        if(folder1 != null){
            urlDaoImpl.saveUrl(url);
        }
        return url;
    }

    @Override
    public List<Folder> getAllFolder() {
        return null;
    }
}
