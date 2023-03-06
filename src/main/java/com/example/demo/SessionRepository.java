package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface SessionRepository extends JpaRepository<Session, Long> {
    @Query("SELECT p FROM  Session p WHERE CONCAT(p.name, ' ', p.film_studio, ' ', p.data, ' ', p.count_tickets) LIKE %?1%")
    List<Session> search(String keyword);


}
