package xyz.hpwyx.manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.hpwyx.manager.pojo.BCollection;
@Mapper
public interface BCollectionMapper {
    int insert(BCollection record);
    int insertSelective(BCollection record);
    BCollection selectByPrimaryKey(Integer cId);
    int updateByPrimaryKeySelective(BCollection record);
    int updateByPrimaryKey(BCollection record);
}