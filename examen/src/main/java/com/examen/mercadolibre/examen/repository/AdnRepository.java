package com.examen.mercadolibre.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.mercadolibre.examen.entity.Adn;

@Repository
public interface AdnRepository extends JpaRepository<Adn, Long>{

}
