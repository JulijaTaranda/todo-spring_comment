package com.example.spring_todo.Service;

import com.example.spring_todo.Modul.Todo;
import com.example.spring_todo.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    //inicializet repository
    //final - nemainigs
    private final TodoRepository todoRepository;
    //pirmais tororep ir tips, otrais ir nosaukums

    //anotacija auto-wired, darbs ar bids, lai dazas lietas notiek automatiski, setups, lai manuali nevaj frameworkaa to darit
    //contructor metode
    @Autowired
    public TodoService(TodoRepository todoRepository_1) {
        this.todoRepository = todoRepository_1;
        //this reprezente esoso klasi

    }

    //return all data from table
    public List<Todo> findAll() {
        //findAll=select
        return todoRepository.findAllByOrderByCreatedAtDesc();
    }

    //save data, save todos
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
        //caur controlieri iszaukta metode save, tad seit tik iazpildita save

        //tod - seit ir tips
        //te tips ir tas, ko mes atgriezam atpakal
    }

    //single todoo
    public Optional<Todo> findById(Long id) {
        return todoRepository.findById(id);
    }
    //datu tipi ar lielo burtu - nepremitivie datu tipi
    //int ar mazo, bez ja butu objekta datu tips, butu ar lielo, Integer


    // uodate todoo
    public Todo update(Long id, String title, boolean completed) {
        //boolean completed - var aiznest vel atseviska metodee
        //tu iveido todoo, grib atzimet ka tas ir izpildiits ar keksiti, tad vajag to complete


        Todo todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid todo id: " + id));


        //ir japaredz un japadomaa, kas varetu nostradat netaa, kada varetu buut kluda seit, piemeram cilveks ievadis nepareizo id, tas ir japaredz un jaapstrada

        todo.setTitle(title);
        todo.setCompleted(completed);
        return todoRepository.save(todo);

    }

    //delete single todoo
    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }


}
