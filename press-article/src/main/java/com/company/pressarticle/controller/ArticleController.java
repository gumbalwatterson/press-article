package com.company.pressarticle.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.pressarticle.entity.Article;
import com.company.pressarticle.exception.DuplicateEntryException;
import com.company.pressarticle.exception.ResourceNotFoundException;
import com.company.pressarticle.repository.ArticleRepository;
import com.company.pressarticle.service.ArticleService;

@RestController
@RequestMapping("/")
public class ArticleController {
	
	@Autowired
	ArticleRepository repo;
	
	@Autowired
	ArticleService service;
	
	@GetMapping("/getall/sorteddesc")
	public List<Article> getAllArticlesSortedDesc() {
	
	return service.findAllArticlesSortedDesc();
	}
	
	@GetMapping("/get/{id}")
	public Article getOneArticle(@PathVariable("id") long id) {
		return service.findOneArticle(id);
	}
	
	@GetMapping("/findby/{keyWord}")
	public List<Article> getBykeyword(@PathVariable(value ="keyWord") String keyWord ) {
		
		return service.findBykeyword(keyWord);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveArticle(@Valid @RequestBody Article article) throws Exception {
	
		Article artSaved = service.persistArticle(article);
		return ResponseEntity.ok().body("article of title " 
				+ artSaved.getTitle()  + " and author " + artSaved.getAuthor() + " has been stored successfuly");
		
	}
	@PutMapping("/update/{author}/{title}")
	public  ResponseEntity<String> putArticle(@Valid @RequestBody Article article,
			@PathVariable("author") String author,
			@PathVariable("title") String title ) {
			
	Article current = service.updateArticle(article, author, title);
	
	return ResponseEntity.ok()
			.body("article has been updated under id:" + current.getId());
	
	}
	@DeleteMapping("/delete/{author}/{title}")
	public ResponseEntity<String> deleteArticle(@PathVariable("author") String author,
							  @PathVariable("title")  String title) {
		
		String rezult = service.deleteArticle(author, title);
		
		return ResponseEntity.ok().body(rezult);
	}
}
