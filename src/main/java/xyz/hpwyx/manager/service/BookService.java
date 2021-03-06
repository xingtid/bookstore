package xyz.hpwyx.manager.service;

import com.github.pagehelper.PageInfo;
import xyz.hpwyx.manager.pojo.BBook;

import java.util.List;


public interface BookService {
    PageInfo<BBook> findBookByType(BBook bBook);

    List<BBook> findBookList(BBook bBook);
    BBook get(Integer bBook);

    int countBookByType(BBook bBook);

    int addGood(BBook book);
    int delGood(BBook book);
    int updateGood(BBook book);
    int updateGoodBuyNum(BBook book);
}
