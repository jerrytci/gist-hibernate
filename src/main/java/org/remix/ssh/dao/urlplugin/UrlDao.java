package org.remix.ssh.dao.urlplugin;

import org.remix.ssh.domain.urlplugin.Folder;
import org.remix.ssh.domain.urlplugin.Url;

import java.util.List;

public interface UrlDao {
    public Url saveUrl(Url url);
    public Folder getFolder(String folder);
    public List<Folder> getAllFolder();
}
