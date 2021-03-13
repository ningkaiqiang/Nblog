package ml.nkqnkq.mapper;

import ml.nkqnkq.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    User getById(Long id);

    User getByUsername(String username);
}
