package com.example.demo.impls;

import com.example.demo.Services.ArticleService;
import com.example.demo.domains.ArticleDTO;
import com.example.demo.repositories.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired ArticleRepository articleRepository;
    @Override
    public int write(ArticleDTO article) {
        return articleRepository.insert(article);
    }
    
}
