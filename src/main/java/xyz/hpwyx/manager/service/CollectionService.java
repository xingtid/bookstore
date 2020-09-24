package xyz.hpwyx.manager.service;

import org.springframework.stereotype.Service;
import xyz.hpwyx.manager.pojo.BCollection;

@Service
public interface CollectionService {
    void addCollection(BCollection collection);
}
