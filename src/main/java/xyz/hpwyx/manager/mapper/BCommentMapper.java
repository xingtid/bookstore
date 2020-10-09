package xyz.hpwyx.manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.hpwyx.manager.pojo.BComment;

import java.util.List;

@Mapper
public interface BCommentMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(BComment record);

    BComment selectByPrimaryKey(Integer cId);
    List<BComment> findList(BComment record);

    int updateByPrimaryKeySelective(BComment record);
}