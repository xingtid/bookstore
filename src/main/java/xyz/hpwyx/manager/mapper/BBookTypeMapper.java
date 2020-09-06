package xyz.hpwyx.manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.hpwyx.manager.pojo.BBookType;

import java.util.List;

@Mapper
public interface BBookTypeMapper {

    int insert(BBookType record);

    int insertSelective(BBookType record);
    int delete(BBookType record);
    int update(BBookType record);

    List<BBookType> findList();
}