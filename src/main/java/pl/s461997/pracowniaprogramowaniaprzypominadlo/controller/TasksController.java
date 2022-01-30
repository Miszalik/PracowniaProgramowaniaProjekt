package pl.s461997.pracowniaprogramowaniaprzypominadlo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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
        boolean isDeleted = this.taskService.delete(id);

        if(!isDeleted){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tasks> updateTask(@PathVariable("id") Long id, Tasks task) {
        boolean isEmpty = this.taskService.update(id, task);

        if(!isEmpty){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/export")
    public ResponseEntity<String> exportData() throws JsonProcessingException {
        String data = taskService.exportData();
        return ResponseEntity.ok().body(data);
    }

    @PostMapping("/import")
    public ResponseEntity<String> importData(@RequestBody String data) throws JsonProcessingException {
        taskService.importData(data);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
