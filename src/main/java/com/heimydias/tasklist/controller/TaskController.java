package com.heimydias.tasklist.controller;

import com.heimydias.tasklist.model.Task;
import com.heimydias.tasklist.model.TaskUpdateRequest;
import com.heimydias.tasklist.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @PostMapping
    public void createTask(@RequestBody Task task) {
        taskService.createTask(task);
    }

    @PutMapping(value = "/{id}")
    public void updateTask(@PathVariable Integer id, @RequestBody @Valid TaskUpdateRequest task) {
        taskService.updateTask(id, task);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
    }

}
