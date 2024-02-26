package com.example.spring_todo.Repository;

import com.example.spring_todo.Modul.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface TodoRepository extends JpaRepository <Todo, Long> {
    //Long kaa id bus izmantots
    //reposotiry kaa tilts starp service un modul

    List<Todo> findAllByOrderByCreatedAtDesc();
    //sort by created at in descending order





}
