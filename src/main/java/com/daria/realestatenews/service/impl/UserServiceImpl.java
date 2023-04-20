package com.daria.realestatenews.service.impl;

import com.daria.realestatenews.dao.UserDAO;
import com.daria.realestatenews.dto.UserCreationDTO;
import com.daria.realestatenews.model.User;
import com.daria.realestatenews.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User saveUser(UserCreationDTO user) {
        if(userDAO.findByExternalId(user.getExternalId()) != null){
            logger.info("user already exists");
            return userDAO.findByExternalId(user.getExternalId());
        }
        return userDAO.save(new User(user.getExternalId(), user.getFirstName(), user.getLastName()));
    }
}
