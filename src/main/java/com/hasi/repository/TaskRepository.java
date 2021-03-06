package com.hasi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hasi.model.Task;
@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

}