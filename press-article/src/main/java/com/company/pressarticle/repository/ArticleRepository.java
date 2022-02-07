package com.company.pressarticle.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.company.pressarticle.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{

	@Query(nativeQuery = true ,
			value ="select * from articles where content like %?1% or title like %?1%" )
	public List<Article> findByKeyword(String keyWord);
	
	public  Optional<Article> findByAuthorAndTitle(String author , String title);

	public void deleteByAuthorAndTitle(String author , String title);
}
