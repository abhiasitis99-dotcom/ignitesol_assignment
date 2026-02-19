
package com.example.taskmanager.service;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.data.domain.Sort;   // ✅ ADDED
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // ✅ UPDATED METHOD
    public List<Task> getAllTasks(String sortBy, String sortDirection) {

        if (sortBy == null || sortBy.isBlank()) {
            return taskRepository.findAll(Sort.by("id")); // deterministic default
        }

        Sort.Direction direction = sortDirection.equalsIgnoreCase("desc")
                ? Sort.Direction.DESC
                : Sort.Direction.ASC;

        String[] fields = sortBy.split(",");

        Sort sort = Sort.unsorted();

        for (String field : fields) {
            field = field.trim();

            if (!field.equals("priority") && !field.equals("effort")) {
                throw new IllegalArgumentException("Invalid sort field: " + field);
            }

            sort = sort.and(Sort.by(direction, field));
        }

        // deterministic tie-breaker
        sort = sort.and(Sort.by(direction, "id"));

        return taskRepository.findAll(sort);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}

