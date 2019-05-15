package br.com.hivecloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hivecloud.models.Pratos;

public interface PratosRepository extends JpaRepository<Pratos, String> {

}
