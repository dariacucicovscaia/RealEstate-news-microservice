package com.daria.realestatenews.dao;

import com.daria.realestatenews.model.ArticleContent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ArticleContentDAO extends CrudRepository<ArticleContent, Long> {
}
