package practice.hibernate52.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.hibernate52.domain.Folder;
import practice.hibernate52.service.FolderService;

import java.util.List;

@Transactional
@Service
public class FolderServiceImpl implements FolderService{

    @Override
    public Folder get(Class<Folder> folderClass, long id) {
        return null;
    }

    @Override
    public Folder getSub(Class<Folder> folderClass, long id) {
        return null;
    }

    @Override
    public List<Folder> get(Class<Folder> folderClass) {
        return null;
    }

    @Override
    public List<Folder> get(Class<Folder> folderClass, List ids) {
        return null;
    }
}
