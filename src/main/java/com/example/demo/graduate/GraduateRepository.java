package com.example.demo.graduate;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GraduateRepository extends JpaRepository<Graduate, Long> {
  //@Query("SELECT g From Graduate g WHERE g.email = ?1")
  Optional<Graduate> findGraduateByEmail(String email);
}
