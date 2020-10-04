package xyz.hpwyx.manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.hpwyx.manager.pojo.BUser;

import java.util.List;

@Mapper
public interface BUserMapper {
    BUser findByUserName(BUser record);
    int deleteByPrimaryKey(Integer uId);
    int insert(BUser record);
    int insertSelective(BUser record);
    BUser selectByPrimaryKey(Integer uId);
    List<BUser> findList(BUser record);
    int updateByPrimaryKeySelective(BUser record);
    int updateByPrimaryKey(BUser record);
    int countUser();
}