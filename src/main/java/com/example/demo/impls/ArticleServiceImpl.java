package com.example.demo.impls;

import java.sql.Date;
import java.time.LocalDate;

import com.example.demo.Services.ArticleService;
import com.example.demo.domains.ArticleDTO;
import com.example.demo.repositories.ArticleRepository;
import com.example.demo.utils.Printer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired Printer printer;
    @Autowired ArticleRepository articleRepository;
    @Override
    public int write(ArticleDTO article) {
        article.setRegDate(LocalDate.now().toString());
        printer.accept("서비스로 전송된 데이터: " + article.toString());
        return articleRepository.insert(article);
    }
}
