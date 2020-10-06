package xyz.hpwyx.manager.service;

import org.springframework.stereotype.Service;
import xyz.hpwyx.manager.pojo.BCollection;

import java.util.List;

@Service
public interface CollectionService {
    void addCollection(BCollection collection);
    List<BCollection> getMyCollection(BCollection collection);
}
