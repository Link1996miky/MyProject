package com.example.myproject;

import com.example.myproject.controller.ArticleController;
import com.example.myproject.model.Article;
import com.example.myproject.service.ArticleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@AutoConfigureMockMvc
@WebMvcTest(ArticleController.class)  //比springbootTest注解加载的Bean更少
@ExtendWith(SpringExtension.class)
public class ArticleServiceTestControllerTest3 {

    @Resource
    private MockMvc mockMvc;

    @MockBean
    private ArticleService articleService;

    @Test
    public void saveArticle() throws Exception {
        String article = "{\n" +
                "    \"id\":123456,\n" +
                "    \"pw\":123456,\n" +
                "    \"name\":\"link\"\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        Article articleobj = objectMapper.readValue(article, Article.class);
        //打桩
//        when(articleService.savaArticle(articleobj)).thenReturn("ok");


        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders
                        .request(HttpMethod.POST, "/articles")
                        .contentType("application/json;UTF-8")
                        .content(article)
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value("123456"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.pw").value("123456"))
                .andDo(print())
                .andReturn();

        result.getResponse().setCharacterEncoding("UTF-8");
        log.info(result.getResponse().getContentAsString());
    }
}

