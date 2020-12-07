package com.example.demo.domains;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component @Data
public class ArticleDTO {
    public String artNum, writerId, title, content, regDate, count;
}
