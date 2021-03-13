package ml.nkqnkq.mapper;

import ml.nkqnkq.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogMapper {
    Blog getById(Long id);

    List<Blog> selectPage();

    int updateBlog(Blog blog);

    int addBlog(Blog blog);
}
