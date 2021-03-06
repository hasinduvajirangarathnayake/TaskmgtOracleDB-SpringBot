package com.hasi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hasi.exception.ResourceNotFoundException;
import com.hasi.model.Task;
import com.hasi.repository.TaskRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TaskController {

	
	 @Autowired
	 private TaskRepository taskRepository;
	 
	 @GetMapping("/tasks")
	 public List < Task > getAllTasks() {
	        return taskRepository.findAll();
	   }
	 
	 @GetMapping("/tasks/{id}")
	    public ResponseEntity < Task > getTaskById(@PathVariable(value = "id") Long  id)
	    throws ResourceNotFoundException {
	        Task task = taskRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Task not found for this id :: " + id));
	        return ResponseEntity.ok().body(task);
	    }
	 
	 @PostMapping("/tasks")
	    public Task createTask( @RequestBody Task task) {
	        return taskRepository.save(task);
	    }
	 
	 @PutMapping("/tasks/{id}")
	    public ResponseEntity < Task > updateTask(@PathVariable(value = "id") Long TaskId,
	       @RequestBody Task TaskDetails) throws ResourceNotFoundException {
	        Task Task = taskRepository.findById(TaskId)
	            .orElseThrow(() -> new ResourceNotFoundException("Task not found for this id :: " + TaskId));
            
	        Task.setCompletedate(TaskDetails.getCompletedate());
	        Task.setStartdate(TaskDetails.getStartdate());
	        Task.setStatus(TaskDetails.getStatus());
	        Task.setTaskname(TaskDetails.getTaskname());
	        final Task updatedTask = taskRepository.save(Task);
	        return ResponseEntity.ok(updatedTask);
	    }
	 
	  @DeleteMapping("/tasks/{id}")
	    public Map < String, Boolean > deleteTask(@PathVariable(value = "id") Long taskId)
	    throws ResourceNotFoundException {
	        Task task = taskRepository.findById(taskId)
	            .orElseThrow(() -> new ResourceNotFoundException("Task not found for this id :: " + taskId));

	        taskRepository.delete(task);
	        Map < String, Boolean > response = new HashMap < > ();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
}
