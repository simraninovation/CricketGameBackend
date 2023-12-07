package com.tekion.cricket.repository;

import com.tekion.cricket.models.Toss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TossRepository extends JpaRepository<Toss,Long> {
}
