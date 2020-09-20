package xyz.hpwyx.manager.service;

import com.github.pagehelper.PageInfo;
import xyz.hpwyx.manager.pojo.BBook;

import java.util.List;


public interface BookService {
    PageInfo<BBook> findBookByType(BBook bBook);

    List<BBook> findBookList();
    BBook get(Integer bBook);

    int countBookByType(BBook bBook);
}
