package com.jthread.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jthread.employeemanagement.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

}
