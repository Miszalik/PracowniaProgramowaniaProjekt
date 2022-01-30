package pl.s461997.pracowniaprogramowaniaprzypominadlo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.model.Tasks;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.service.TaskService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    private final TaskService taskService;

    @Autowired
    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Tasks>> findAllTasks() {
        List<Tasks> allTasks = this.taskService.findAll();
        return ResponseEntity.ok()
                .body(allTasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tasks> findTask(@PathVariable("id") Long id) {
        Optional<Tasks> task = this.taskService.findById(id);
        if(task.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok()
                .body(task.get());
    }

    @PostMapping("/")
    public ResponseEntity<Tasks> addTask(@RequestBody Tasks task) {
        return new ResponseEntity<>(taskService.save(task), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tasks> deleteTask(@PathVariable("id") Long id) {
        this.taskService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
