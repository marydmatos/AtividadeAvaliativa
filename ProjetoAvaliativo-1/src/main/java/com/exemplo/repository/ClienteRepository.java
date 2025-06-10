package com.exemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.entities.cliente;


public interface ClienteRepository extends JpaRepository<cliente, Long> {
}


