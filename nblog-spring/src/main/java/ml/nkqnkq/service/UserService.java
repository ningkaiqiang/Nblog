package ml.nkqnkq.service;

import ml.nkqnkq.pojo.User;

public interface UserService {
    User getById(Long id);

    User getByUsername (String username);
}
