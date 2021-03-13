package ml.nkqnkq.service;

import ml.nkqnkq.mapper.BlogMapper;
import ml.nkqnkq.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Override
    public Blog getById(Long id) {
        return blogMapper.getById(id);
    }
}
