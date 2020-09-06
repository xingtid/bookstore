package xyz.hpwyx.manager.service;

import xyz.hpwyx.manager.pojo.BBookType;

import java.util.List;

public interface BookTypeService {
    List<BBookType> findAllType();

    int addType(BBookType type);
    int delType(BBookType type);
    int updateType(BBookType type);
}
