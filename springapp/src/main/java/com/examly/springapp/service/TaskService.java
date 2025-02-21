package com.examly.springapp.service;

import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // ✅ Get All Tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // ✅ Get Task by ID
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    // ✅ Create Task
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    // ✅ Bulk Insert Tasks
    public List<Task> saveTasks(List<Task> tasks) {
        return taskRepository.saveAll(tasks);
    }

    // ✅ Update Task
    public Task updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());
            task.setDueDate(updatedTask.getDueDate());
            return taskRepository.save(task);
        }).orElseThrow(() -> new RuntimeException("Task not found with ID: " + id));
    }

    // ✅ Delete Task
    public boolean deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
