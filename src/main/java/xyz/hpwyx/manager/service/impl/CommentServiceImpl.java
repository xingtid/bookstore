package xyz.hpwyx.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.hpwyx.manager.mapper.BCommentMapper;
import xyz.hpwyx.manager.pojo.BComment;
import xyz.hpwyx.manager.service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private BCommentMapper dao;
    @Override
    public int addComment(BComment comment) {
        return dao.insert (comment);
    }

    @Override
    public List<BComment> findList(BComment comment) {
        return dao.findList (comment);
    }
}
