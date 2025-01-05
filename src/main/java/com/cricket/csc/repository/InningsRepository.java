package com.cricket.csc.repository;

import com.cricket.csc.model.Innings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InningsRepository extends JpaRepository<Innings, Long> {
}
