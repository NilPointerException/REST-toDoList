package com.todo.service;

import com.todo.entity.Task;
import com.todo.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;


    public Task insertTask(Task task) {
        return taskRepository.save(task);
    }

    public void updateTaskById(Task task) {
        Task taskToUpdate = taskRepository.findOne(task.getId());
        task.setId(taskToUpdate.getId());
        taskRepository.save(task);
    }

    public void deleteTaskById(int id) {
        taskRepository.delete(id);
    }

    public Task getTaskById(int id) {
        return taskRepository.findOne(id);
    }

    public Collection<Task> getAllTasks() {
        return (Collection<Task>) taskRepository.findAll();
    }
}
