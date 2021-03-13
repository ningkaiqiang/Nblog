package ml.nkqnkq.service;

import com.github.pagehelper.Page;
import ml.nkqnkq.pojo.Blog;
import ml.nkqnkq.utils.PageResultUtils;

import java.util.List;

public interface BlogService {
    Blog getById(Long id);

    PageResultUtils findPage(Page pageRequest);

    int updateBlog(Blog blog);

    int addBlog(Blog blog);
}
