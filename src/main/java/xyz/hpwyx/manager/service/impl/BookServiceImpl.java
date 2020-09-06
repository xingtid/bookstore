package xyz.hpwyx.manager.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.hpwyx.manager.mapper.BBookMapper;
import xyz.hpwyx.manager.pojo.BBook;
import xyz.hpwyx.manager.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BBookMapper dao;
    @Override
    public PageInfo<BBook> findBookByType(BBook bBook) {
        PageHelper.startPage (bBook.getPageNum (),12);
        List<BBook> list = dao.findList (bBook);
        PageInfo<BBook> pageInfo = new PageInfo<BBook>(list);
        return pageInfo;
    }

    @Override
    public BBook get(Integer bId) {
        return dao.selectByPrimaryKey (bId);
    }
}
