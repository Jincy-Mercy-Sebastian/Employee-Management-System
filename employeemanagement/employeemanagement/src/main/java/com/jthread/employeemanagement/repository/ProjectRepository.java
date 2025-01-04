package com.jthread.employeemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jthread.employeemanagement.dto.TasksOfProjectDto;
import com.jthread.employeemanagement.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{

	 @Query("SELECT new com.jthread.employeemanagement.dto.TasksOfProjectDto(t.taskId, t.taskName, t.deadline)"
	 		+ "FROM Task t inner join t.project p where p.projectId = :projectId")
	    List<TasksOfProjectDto> getTasksByProjectId(Integer projectId);

	 @Query( "SELECT SUM(p.budget) FROM Project p inner join p.employees e where e.id = :employeeId")
	 public Integer getProjectBudgetbyEmployeeId(Integer employeeId);
}
