package practice.hibernate52.service;

import practice.hibernate52.domain.Folder;

import java.util.List;

public interface FolderService{
    public Folder get(Class<Folder> folderClass, long id);
    public Folder getSub(Class<Folder> folderClass, long id);
    public List<Folder> get(Class<Folder> folderClass);
    public List<Folder> get(Class<Folder> folderClass, List ids);


    void saveFolder(List<Folder> folders);
}
