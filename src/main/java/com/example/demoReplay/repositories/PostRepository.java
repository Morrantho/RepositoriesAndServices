package com.example.demoReplay.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demoReplay.models.Post;

@Repository
public interface PostRepository extends CrudRepository<Post,Long>{

}
