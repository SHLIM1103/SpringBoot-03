package com.example.demo.Services;

import java.util.List;

import com.example.demo.domains.ArticleDTO;

import org.springframework.stereotype.Component;

@Component
public interface ArticleService {
	public int write(ArticleDTO article);
	public List<ArticleDTO> list();
	public int crawling(String url);
    public int count();
	public ArticleDTO getArticleById(String artNum);
	public int increaseCount(String artNum);
	public int update(ArticleDTO article);
	public int delete(ArticleDTO article);
}
