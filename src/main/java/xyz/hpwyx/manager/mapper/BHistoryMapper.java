package xyz.hpwyx.manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.hpwyx.manager.pojo.BHistory;
@Mapper
public interface BHistoryMapper {
    int deleteByPrimaryKey(Integer hId);
    int insert(BHistory record);
    int insertSelective(BHistory record);
    BHistory selectByPrimaryKey(Integer hId);
    int updateByPrimaryKeySelective(BHistory record);
    int updateByPrimaryKey(BHistory record);
}