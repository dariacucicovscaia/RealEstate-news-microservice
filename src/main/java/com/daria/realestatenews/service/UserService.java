package com.daria.realestatenews.service;

import com.daria.realestatenews.dto.UserCreationDTO;
import com.daria.realestatenews.model.User;

public interface UserService {
    User saveUser(UserCreationDTO user);
}
