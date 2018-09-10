package practice.hibernate52.dao;

import practice.hibernate52.domain.Folder;

import java.util.List;

public interface FolderDao {
    void saveFolder(List<Folder> folders);
}
