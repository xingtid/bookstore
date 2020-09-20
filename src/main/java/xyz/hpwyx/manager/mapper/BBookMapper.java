package xyz.hpwyx.manager.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import xyz.hpwyx.manager.pojo.BBook;

import java.util.List;

@Mapper
public interface BBookMapper {

    int deleteByPrimaryKey(Integer bId);
    int insert(BBook record);
    int insertSelective(BBook record);
    BBook selectByPrimaryKey(Integer bId);
    List<BBook> findList(BBook record);
    List<BBook> findListRandom(BBook record);
    int updateByPrimaryKeySelective(BBook record);
    int updateByPrimaryKey(BBook record);
    int countBookByType(BBook bBook);
}