package xyz.hpwyx.manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.hpwyx.manager.pojo.BUser;
@Mapper
public interface BUserMapper {
    BUser findByUserName(BUser record);
    int deleteByPrimaryKey(Integer uId);
    int insert(BUser record);
    int insertSelective(BUser record);
    BUser selectByPrimaryKey(Integer uId);
    int updateByPrimaryKeySelective(BUser record);
    int updateByPrimaryKey(BUser record);
    int countUser();
}