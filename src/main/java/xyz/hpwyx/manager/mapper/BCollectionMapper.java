package xyz.hpwyx.manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.hpwyx.manager.pojo.BCollection;

import java.util.List;

@Mapper
public interface BCollectionMapper {
    int insert(BCollection record);
    int insertSelective(BCollection record);
    BCollection selectByPrimaryKey(Integer cId);
    List<BCollection> findList(BCollection collection);
    int updateByPrimaryKeySelective(BCollection record);
    int updateByPrimaryKey(BCollection record);
}