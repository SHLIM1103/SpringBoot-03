package com.example.demo.repositories;

import java.util.List;

import com.example.demo.domains.ArticleDTO;

public interface ArticleRepository {
	public int insert(ArticleDTO article);
	public int count();
	public List<ArticleDTO> selecAll();
}
