package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Conge;


@Repository
public interface CongeRepository extends JpaRepository<Conge, Integer>{

}
