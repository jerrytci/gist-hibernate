package practice.hibernate52.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.hibernate52.service.FolderService;

import java.util.List;

@Transactional
@Service
public class FolderServiceImpl implements FolderService{

    @Override
    public <T> T get(Class<T> tClass, long id) {
        return null;
    }

    @Override
    public <T> List<T> get(Class<T> tClass) {
        return null;
    }

    @Override
    public <T> List<T> get(Class<T> tClass, List ids) {
        return null;
    }
}
