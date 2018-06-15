package practice.hibernate52.service;

import java.util.List;

public interface FolderService {
    <T> List<T> get(Class<T> tClass);
}
