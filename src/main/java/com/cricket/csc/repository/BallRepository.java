package com.cricket.csc.repository;

import com.cricket.csc.model.Ball;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BallRepository extends JpaRepository<Ball, Long> {
}
