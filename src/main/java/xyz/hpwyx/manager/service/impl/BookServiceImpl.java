package xyz.hpwyx.manager.service.impl;

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
    public List<BBook> findBookList(BBook bBook) {
        return dao.findListRandom (bBook);
    }
    public List<BBook> findList() {
        return dao.findList (new BBook ());
    }
    public List<BBook> findListBySale() {
        return dao.findListBySale (new BBook ());
    }

    @Override
    public BBook get(Integer bId) {
        return dao.selectByPrimaryKey (bId);
    }

    @Override
    public int countBookByType(BBook bBook) {
        return dao.countBookByType (bBook);
    }

    @Override
    public int addGood(BBook book) {
        book.setbBeSales (0);
        book.setbDiscount (0);
        book.setbIsNew (0);
        book.setbPress ("1");
        book.setbIsSole (1);
        return dao.insert (book);
    }

    @Override
    public int delGood(BBook book) {
        return dao.deleteByPrimaryKey (book.getbId ());
    }

    @Override
    public int updateGood(BBook book) {
        return dao.updateByPrimaryKeySelective (book);
    }

    @Override
    public int updateGoodBuyNum(BBook book) {
        return dao.updateByBuyNum (book);
    }
}
