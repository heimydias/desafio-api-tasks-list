package com.heimydias.tasklist.service;

import com.heimydias.tasklist.model.Task;
import com.heimydias.tasklist.model.TaskUpdateRequest;
import com.heimydias.tasklist.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public void createTask(Task task) {
        taskRepository.save(task);
    }

    public void updateTask(Integer id, TaskUpdateRequest task) {
        Task obj = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada!"));
        obj.setTitle(task.getTitle());
        if (task.getDescription() != null) {
            obj.setDescription(task.getDescription());
        }
        taskRepository.save(obj);
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }
}