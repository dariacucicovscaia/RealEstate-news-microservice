package com.daria.realestatenews.dao;

import com.daria.realestatenews.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Long> {
    User findByExternalId(Long externalId);
}
