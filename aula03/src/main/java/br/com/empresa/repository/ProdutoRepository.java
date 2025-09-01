package br.com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.empresa.entity.Produto;



public interface ProdutoRepository extends JpaRepository<Produto,Long>{

}
