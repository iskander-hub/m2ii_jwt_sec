package org.m2ii.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import org.m2ii.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {


}
