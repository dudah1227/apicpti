package br.com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.empresa.entity.Proprietario;

public interface ProprietarioRepository extends JpaRepository<Proprietario,Long>{
	

}
