package xyz.hpwyx.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.hpwyx.manager.mapper.BBookTypeMapper;
import xyz.hpwyx.manager.pojo.BBookType;
import xyz.hpwyx.manager.service.BookTypeService;

import java.util.List;
@Service
public class BookTypeServiceImpl implements BookTypeService {
    @Autowired
    private BBookTypeMapper dao;

    public List<BBookType> findAllType(){
        return dao.findList ();
    }

    @Override
    public int addType(BBookType type) {
        dao.insertSelective (type);
        return 0;
    }
    @Override
    public int delType(BBookType type) {
        dao.delete (type);
        return 0;
    }
    @Override
    public int updateType(BBookType type) {
        dao.update (type);
        return 0;
    }
}
