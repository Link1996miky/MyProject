package com.example.myproject.service;

import com.example.myproject.Mapper.ArticleDAO;
import com.example.myproject.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleDAO articleDAO;


    @Override
    @Transactional
    public void savaArticle(Article article) {
        articleDAO.save(article);
    }
}
