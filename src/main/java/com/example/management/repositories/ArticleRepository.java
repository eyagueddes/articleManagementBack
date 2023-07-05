package com.example.management.repositories;

import com.example.management.entities.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<Article,Long> {

}
