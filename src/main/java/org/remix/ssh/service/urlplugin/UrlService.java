package org.remix.ssh.service.urlplugin;

import com.google.gson.JsonArray;
import org.remix.ssh.domain.urlplugin.Url;

public interface UrlService {
    public Url saveUrl(Url url, String tag);
}
