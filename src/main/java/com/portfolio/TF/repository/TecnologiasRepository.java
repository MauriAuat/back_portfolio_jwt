package com.portfolio.TF.repository;

import com.portfolio.TF.entity.Tecnologias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnologiasRepository extends JpaRepository<Tecnologias, Integer> {

}
