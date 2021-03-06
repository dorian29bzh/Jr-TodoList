/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.jstodolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;

@SpringBootApplication
public class App {

    public static void main(String[] args) {

        SpringApplication.run(App.class);
    }
}

@RestController
@RequestMapping("/todos")
class TicketController {

    ArrayList<Todo> todos = new ArrayList<>();

    ArrayList<Todo> getTodos(){
        Todo t1 = new Todo(Todo.getCurrentid(),"todo1",false);
        Todo t2 = new Todo(Todo.getCurrentid(),"todo2",false);
        todos.add(t1);
        todos.add(t2);

        return todos;
    }

    @GetMapping("/{id}")
    public Todo getTicketById(@PathVariable int id) {
        for (int i=0; i<todos.size() ; i++){
            if (id == todos.get(i).getId()) {
                return todos.get(i);
            }
        }
        return null;
    }

    @RequestMapping("")
    ArrayList<Todo> helloWorld() {
        return getTodos();
    }
}



