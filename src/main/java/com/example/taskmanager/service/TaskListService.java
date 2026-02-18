package com.example.taskmanager.service;

import com.example.taskmanager.entity.TaskList;
import com.example.taskmanager.repository.TaskListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskListService {

    private final TaskListRepository taskListRepository;

    public TaskListService(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    public TaskList createTaskList(TaskList taskList) {
        return taskListRepository.save(taskList);
    }

    public List<TaskList> getAllTaskLists() {
        return taskListRepository.findAll();
    }

    public TaskList getTaskListById(Long id) {
        return taskListRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TaskList not found"));
    }

    public void deleteTaskList(Long id) {
        taskListRepository.deleteById(id);
    }
}
