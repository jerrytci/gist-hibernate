package org.remix.ssh.domain.urlplugin;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "folder")
public class Folder {
    @Id
    private int id;
    private int parent;
    private String folder;

    public Folder() {
    }

    public Folder(int id, int parent, String folder) {
        this.id = id;
        this.parent = parent;
        this.folder = folder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }
}

