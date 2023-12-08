package com.tekion.cricket.repository;

import com.tekion.cricket.entity.Innings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InningsRepository extends JpaRepository<Innings, Long> {
}
