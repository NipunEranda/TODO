package com.dev.todo.todo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TodoRepository {
    private final List<Todo> todos = new ArrayList<>();

    List<Todo> findAll() {
        return todos;
    }

    Optional<Todo> findById(Integer id) {
        return todos.stream().filter(todo -> todo.id() == id).findFirst();
    }

    void create(Todo todo) {
        todos.add(todo);
    }

    void update(Todo todo, Integer id) {
        Optional<Todo> existingTodo = findById(id);
        existingTodo.ifPresent(value -> todos.set(todos.indexOf(value), todo));
    }

    void delete(Integer id) {
        todos.removeIf(todo -> todo.id().equals(id));
    }

    @PostConstruct
    private void init() {
        todos.add(new Todo(1, "test 1", "test 1 body", LocalDateTime.now(), Boolean.FALSE));
        todos.add(new Todo(2, "test 2", "test 2 body", LocalDateTime.now(), Boolean.FALSE));
    }
}
