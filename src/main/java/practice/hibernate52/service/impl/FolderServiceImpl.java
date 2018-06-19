package practice.hibernate52.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.hibernate52.service.FolderService;

import java.util.List;

@Transactional
@Service
public class FolderServiceImpl implements FolderService{

    @Override
    public <T> List<T> get(Class<T> tClass) {
        return null;
    }
}
