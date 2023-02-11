package com.example.oophometask.repositories;

import com.example.oophometask.entities.Adam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdamRepository extends JpaRepository<Adam, Integer> {

    Adam findByEmail(String email);
}
