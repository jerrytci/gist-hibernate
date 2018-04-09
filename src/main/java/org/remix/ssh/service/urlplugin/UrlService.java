package org.remix.ssh.service.urlplugin;

import com.google.gson.JsonArray;
import org.remix.ssh.domain.urlplugin.Folder;
import org.remix.ssh.domain.urlplugin.Url;

import java.util.List;

public interface UrlService {
    public Url saveUrl(Url url, String tag);
    public List<Folder> getAllFolder();
}
