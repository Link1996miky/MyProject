package com.example.myproject.service;

import com.example.myproject.model.Article;
import org.springframework.jdbc.core.JdbcTemplate;

public interface ArticleService {

    void savaArticle(Article article);
}
