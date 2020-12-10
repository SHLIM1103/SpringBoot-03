package com.example.demo.repositories;

import java.util.List;

import com.example.demo.domains.ArticleDTO;

public interface ArticleRepository {
	public int insert(ArticleDTO article);
	public int count();
	public List<ArticleDTO> selectAll();
	public ArticleDTO selectById(String artNum);
	public int updateCount(String artNum);
	public int update(ArticleDTO article);
	public int delete(ArticleDTO article);
}
