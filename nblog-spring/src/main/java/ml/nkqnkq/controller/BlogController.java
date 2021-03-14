package ml.nkqnkq.controller;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.Page;
import ml.nkqnkq.lang.Result;
import ml.nkqnkq.pojo.Blog;
import ml.nkqnkq.service.BlogService;
import ml.nkqnkq.utils.PageResultUtils;
import ml.nkqnkq.utils.ShiroUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/blogs")
    public Result blogs(@RequestParam(defaultValue = "1") Integer currentPage) {
        if(currentPage == null || currentPage < 1) currentPage = 1;
        Page page = new Page(currentPage, 5);
        PageResultUtils result = blogService.findPage(page);
        return Result.succ(result);
    }

    @GetMapping("/blog/{id}")
    public Result detail(@PathVariable(name = "id") Long id) {
        Blog blog = blogService.getById(id);
        Assert.notNull(blog, "该博客已删除！");
        return Result.succ(blog);
    }

    @RequiresAuthentication
    @PostMapping("/blog/edit")
    public Result edit(@Validated @RequestBody Blog blog) {
//        System.out.println(blog.toString());
        Blog temp = null;
        // 修改
        if(blog.getId() != null) {
            temp = blogService.getById(blog.getId());
            Assert.isTrue(temp.getUser_id() == ShiroUtil.getProfile().getId(), "没有权限编辑");
            BeanUtil.copyProperties(blog, temp, "id", "user_id", "created", "status");
            blogService.updateBlog(temp);
        } else {
            // 新建
            temp = new Blog();
            Long id = ShiroUtil.getProfile().getId();
            temp.setUser_id(id);
            temp.setCreated(LocalDateTime.now());
            temp.setStatus(0);
            BeanUtil.copyProperties(blog, temp, "id", "user_id", "created", "status");
            blogService.addBlog(temp);
        }
        return Result.succ(null);
    }
}
