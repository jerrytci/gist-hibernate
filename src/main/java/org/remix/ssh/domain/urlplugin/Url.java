package org.remix.ssh.domain.urlplugin;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "url")
public class Url {
    @Id
    private long id;
    private String title;
//    @Column(name = "tagid")
    private String url;
    private String tagid;

    public Url() {
    }

    public Url(String title, String url, String tagid) {
        this.title = title;
        this.url = url;
        this.tagid = tagid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTagid() {
        return tagid;
    }

    public void setTagid(String tagid) {
        this.tagid = tagid;
    }
}

