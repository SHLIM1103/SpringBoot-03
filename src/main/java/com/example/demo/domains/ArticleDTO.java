package com.example.demo.domains;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component @Getter @Setter
public class ArticleDTO {
    String artNum, writerId, title, content, regDate;
}
