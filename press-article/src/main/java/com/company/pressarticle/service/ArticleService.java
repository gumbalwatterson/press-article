package com.company.pressarticle.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.pressarticle.entity.Article;
import com.company.pressarticle.exception.DuplicateEntryException;
import com.company.pressarticle.exception.ResourceNotFoundException;
import com.company.pressarticle.repository.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	ArticleRepository repo;
	

	public List<Article> findAllArticlesSortedDesc() {
		List<Article> allArticles = repo.findAll();
	
		return	allArticles.stream()
						   .sorted(Comparator.comparing(Article::getPublishedAt)
						   .reversed()).collect(Collectors.toList());
	
	}
	
	public Article findOneArticle(long id) {
		return repo.findById(id).orElseThrow(()->new DuplicateEntryException());
	}
	
	public List<Article> findBykeyword(String keyWord) {
		
		return repo.findByKeyword(keyWord);
	}
	
	public Article persistArticle(Article article) throws Exception {
	
		return repo.save(article);
	
	}
	
	public Article updateArticle(Article article,String author,String title ) {
			
	Article current = repo.findByAuthorAndTitle(author, title)
						.orElseThrow(()->new ResourceNotFoundException());
	current.setTitle(article.getTitle());
	current.setAuthor(article.getAuthor());
	current.setSource(article.getSource());
	current.setContent(article.getContent());
	
	return repo.save(current);
	
	}
	
	public String deleteArticle(String author, String title) {
		
		Article current = repo.findByAuthorAndTitle(author, title)
		.orElseThrow(()->new ResourceNotFoundException());
		repo.delete(current);
		return "article of "+ author +" called "+ title+ " has been removed";
	}
	
}
