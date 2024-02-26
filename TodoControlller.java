package com.example.spring_todo.Controller;

import com.example.spring_todo.Modul.Todo;
import com.example.spring_todo.Service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoControlller {
    private final TodoService todoService;

    @Autowired
    public TodoControlller(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    //home
    public String listTodos(Model model) {

        model.addAttribute("todos", todoService.findAll());

        if(!model.containsAttribute("todo")){
            model.addAttribute("todo", new Todo());

        }
        return "index";

    }
    @PostMapping("/add")
    public String addTodo(@Valid Todo todo, BindingResult result, Model model ) {
        if(result.hasErrors()) {

            model.addAttribute("todos", todoService.findAll());
            return "index";
        }
        todoService.save(todo);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    //id ir parametrs seit, jo mes gribam atskirot pec id
    public String updateTodo(@PathVariable Long id, @RequestParam String title, @RequestParam(defaultValue = "false") boolean completed ) {
        todoService.update(id, title, completed);

        //caur so anotaciju spring boot atpazit {id} ir Long id


        return "redirect:/";
        //to izmantojam, lai nebutu dubultais submit

    }

    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteById(id);

        return "redirect:/";
        //lai nebutu dubult delete, redirect uz saakumu

    }



}
