package ml.nkqnkq.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ml.nkqnkq.mapper.BlogMapper;
import ml.nkqnkq.pojo.Blog;
import ml.nkqnkq.utils.PageResultUtils;
import ml.nkqnkq.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Override
    public Blog getById(Long id) {
        return blogMapper.getById(id);
    }

    @Override
    public PageResultUtils findPage(Page pageRequest) {

        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        List<Blog> blogs = blogMapper.selectPage();
        PageHelper.startPage(pageNum,pageSize);
        PageResultUtils result = PageUtils.getPageResult(pageRequest, new PageInfo<>(blogs));

        return result;
    }

    @Override
    public int updateBlog(Blog blog) {
        return blogMapper.updateBlog(blog);
    }

    @Override
    public int addBlog(Blog blog) {
        return blogMapper.addBlog(blog);
    }

}
