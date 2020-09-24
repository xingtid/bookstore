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
        return new PageInfo<BBook>(list);
    }

    @Override
    public List<BBook> findBookList() {
        return dao.findListRandom (new BBook ());
    }

    @Override
    public BBook get(Integer bId) {
        return dao.selectByPrimaryKey (bId);
    }

    @Override
    public int countBookByType(BBook bBook) {
        return dao.countBookByType (bBook);
    }
}
