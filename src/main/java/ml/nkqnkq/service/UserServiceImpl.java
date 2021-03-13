package ml.nkqnkq.service;

import ml.nkqnkq.mapper.UserMapper;
import ml.nkqnkq.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getById(Long id) {
        return userMapper.getById(id);
    }

    @Override
    public User getByUsername(String username) {
        return userMapper.getByUsername(username);
    }

}
