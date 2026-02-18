package com.example.taskmanager.controller;

import com.example.taskmanager.entity.TaskList;
import com.example.taskmanager.service.TaskListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasklists")
public class TaskListController {

    private final TaskListService taskListService;

    public TaskListController(TaskListService taskListService) {
        this.taskListService = taskListService;
    }

    @PostMapping
    public TaskList createTaskList(@RequestBody TaskList taskList) {
        return taskListService.createTaskList(taskList);
    }

    @GetMapping
    public List<TaskList> getAllTaskLists() {
        return taskListService.getAllTaskLists();
    }

    @GetMapping("/{id}")
    public TaskList getTaskListById(@PathVariable Long id) {
        return taskListService.getTaskListById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTaskList(@PathVariable Long id) {
        taskListService.deleteTaskList(id);
    }
}
