package br.com.empresa.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.empresa.entity.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo,UUID>{

}
