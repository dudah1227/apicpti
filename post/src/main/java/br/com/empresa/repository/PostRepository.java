package br.com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.empresa.entity.Post;

public interface PostRepository extends JpaRepository<Post,Long>{

}
