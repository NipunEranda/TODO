package com.dev.todo.repository;

import com.dev.todo.model.Todo;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TodoRepository {
    private final List<Todo> todos = new ArrayList<>();

    public List<Todo> findAll() {
        return todos;
    }

    public Optional<Todo> findById(Integer id) {
        return todos.stream().filter(todo -> todo.id() == id).findFirst();
    }

    public void create(Todo todo) {
        todos.add(todo);
    }

    public void update(Todo todo, Integer id) {
        Optional<Todo> existingTodo = findById(id);
        existingTodo.ifPresent(value -> todos.set(todos.indexOf(value), todo));
    }

    public void delete(Integer id) {
        todos.removeIf(todo -> todo.id().equals(id));
    }

    @PostConstruct
    private void init() {
        todos.add(new Todo(1, "test 1", "test 1 body", LocalDateTime.now(), Boolean.FALSE));
        todos.add(new Todo(2, "test 2", "test 2 body", LocalDateTime.now(), Boolean.FALSE));
    }
}
