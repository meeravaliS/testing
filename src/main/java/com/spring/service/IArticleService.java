package com.spring.service;

import java.util.List;

import com.spring.entity.Article;

public interface IArticleService {
	
	public List<Article> getAllArticles();

	public Article getArticleById(int articleId);

	public boolean addArticle(Article article);

	public void updateArticle(Article article);

	public void deleteArticle(int articleId);
}
