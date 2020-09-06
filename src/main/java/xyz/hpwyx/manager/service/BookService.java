package xyz.hpwyx.manager.service;

import com.github.pagehelper.PageInfo;
import xyz.hpwyx.manager.pojo.BBook;


public interface BookService {
    PageInfo<BBook> findBookByType(BBook bBook);

    BBook get(Integer bBook);
}
