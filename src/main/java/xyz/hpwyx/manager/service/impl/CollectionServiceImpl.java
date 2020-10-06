package xyz.hpwyx.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.hpwyx.manager.mapper.BCollectionMapper;
import xyz.hpwyx.manager.pojo.BCollection;
import xyz.hpwyx.manager.service.CollectionService;

import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private BCollectionMapper dao;

    @Override
    public void addCollection(BCollection collection) {
        dao.insertSelective (collection);
    }

    @Override
    public List<BCollection> getMyCollection(BCollection collection) {
        return dao.findList (collection);
    }
}
