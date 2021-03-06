package com.example.myproject.controller;


import com.example.myproject.config.AjaxResponse;
import com.example.myproject.model.Article;
import com.example.myproject.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@Controller
public class ArticleController {


    @Resource
    private ArticleService articleService;

    @GetMapping("/articles/{id}")
    public @ResponseBody
    AjaxResponse getArticle(@PathVariable("id") Long id) {
        Article article = Article.builder()
                .id("myid")
                .pw("mypw")
                .name("link")
                .build();
        return AjaxResponse.success();
    }

    @PostMapping("/articles")
    public @ResponseBody
    AjaxResponse addArticle(@RequestBody Article article) {
        articleService.savaArticle(article,null);
        return AjaxResponse.success(article);
    }

    @PutMapping("/articles")
    public @ResponseBody
    AjaxResponse updateArticle(@RequestBody Article article) {

        return AjaxResponse.success();
    }

    @DeleteMapping("/articles/{id}")
    public @ResponseBody
    AjaxResponse deleteArticle(@PathVariable("id") Long id) {

        return AjaxResponse.success();
    }


}
