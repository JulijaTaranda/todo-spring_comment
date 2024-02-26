package com.example.spring_todo.Modul;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;


//pieverst uzmanibu, lai importejas jakarta, nevis cita
@Entity
public class Todo {
    //tas bus sql table struktura, bet izmantojot java. Taisam kolonnas, nevajag parslegties atseviski uz sql

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //bus kolonna ar unikalo id


    @NotBlank(message = "Title cannot be empty..")
    private String title;

    private boolean completed = false;

    //lai mes varam redzet jaunaakus ierakstus, automatiski tie pievienosies apaksaa, bet pec datetime mes varam saskirot no jaunaka uz jaunako
    //tapec ir vajadzig timestamp
    @CreationTimestamp
    private LocalDateTime createdAt;

    //constructor
    //izpildisies tad, kad mes inicializesim objektu
    public Todo(){

    }

    //getter and setter
    //prieks id
    public long getId(){
        return id;
    }

    public void setId(Long id){
        //tas nav tas pats ka private id koda sakumaa
        this.id = id;
        //var ari izmantot citu nosaukumu, lai nesajaukt id, jo tagad seit id ir parametrs


    }

    //uztaisijam to automatiski,uzpiezot uz title ar labo taustinu -> generate, getter and setter, ok
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


}
