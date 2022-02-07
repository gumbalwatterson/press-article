package com.company.pressarticle.entity;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "articles",
	   uniqueConstraints={@UniqueConstraint(columnNames={"title", "author"})})
public class Article  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="author" ,nullable = false)
	@NotEmpty(message = "author name must not be empty")
	@Size(min=3 , message = "author name must have more than 2 characters")
	private String author;

	@Column(name="title" ,nullable = false)
	@NotEmpty(message = "title must not be empty")
	private String title;
	
	@UpdateTimestamp 
	private LocalDateTime publishedAt;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(nullable = false)
	@NotEmpty(message = "content must not be empty")
	@Size(min=100 , message = "the content of article is too small. At least 100 characters")
	private String content;
	
	@CreationTimestamp
	private LocalDateTime savedAt;
	
	@Column(nullable = false )
	private String source;
	
    public Article() {
    	
    }
    
	public Article(String author, String title, String content ,String source) {
		super();
		this.author = author;
		this.title = title;
		this.content = content;
		this.source = source;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(LocalDateTime publishedAt) {
		this.publishedAt = publishedAt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getSavedAt() {
		return savedAt;
	}

	public void setSavedAt(LocalDateTime savedAt) {
		this.savedAt = savedAt;
	}

/*
	@Override
	public int compare(Article a1, Article a2) {
		
		return a1.getPublishedAt().compareTo(a2.getPublishedAt());
		
	}

*/
    
}
