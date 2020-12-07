package com.example.demo.repositories;

import com.example.demo.domains.ArticleDTO;

import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository {
	public int insert(ArticleDTO article);
}
