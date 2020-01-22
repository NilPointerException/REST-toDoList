package com.todo.controller;

import com.todo.entity.Task;
import com.todo.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Task getTaskById(@PathVariable("id") int id) {
        LOGGER.info(String.format("Getting task : %s", id));
        return taskService.getTaskById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTaskById(@PathVariable("id") int id) {
        LOGGER.info(String.format("Deleting task : %s", id));
        taskService.deleteTaskById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateTask(@RequestBody Task task) {
        LOGGER.info(String.format("Updating task : %s", task.getId()));
        taskService.updateTaskById(task);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Task insertTask(@RequestBody Task task) {
        LOGGER.info(String.format("Creating task : %s", task.toString()));
        return taskService.insertTask(task);
    }
}
