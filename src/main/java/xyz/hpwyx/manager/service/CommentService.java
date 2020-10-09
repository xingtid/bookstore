package xyz.hpwyx.manager.service;

import org.springframework.stereotype.Service;
import xyz.hpwyx.manager.pojo.BComment;

import java.util.List;

@Service
public interface CommentService {
    int addComment(BComment comment);
    List<BComment> findList(BComment comment);
}
