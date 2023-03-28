package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Supervisor;


@Repository
public interface SupervisorRepository extends JpaRepository<Supervisor, Integer>{

}
