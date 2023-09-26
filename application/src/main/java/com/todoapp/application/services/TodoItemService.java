package com.todoapp.application.services;

import com.todoapp.application.models.TodoItem;
import com.todoapp.application.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class TodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    public Iterable<TodoItem> getAll(){
        return todoItemRepository.findAll();
    }

    public Optional<TodoItem> getById(Long id){
        return todoItemRepository.findById(id);
    }

    public TodoItem save(TodoItem t) {
        if(t.getId() == null) {
            t.setCreatedAt(Instant.now());
        }
        t.setUpdatedAt(Instant.now());
        return todoItemRepository.save(t);
    }

    public void delete(TodoItem todoItem){
        todoItemRepository.delete(todoItem);
    }
}
