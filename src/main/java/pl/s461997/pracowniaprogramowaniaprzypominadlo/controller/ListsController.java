package pl.s461997.pracowniaprogramowaniaprzypominadlo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.model.Lists;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.service.ListService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lists")
public class ListsController {
    private final ListService listService;

    @Autowired
    public ListsController(ListService listService) {
        this.listService = listService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Lists>> findAllLists() {
        List<Lists> allLists = this.listService.findAll();
        return ResponseEntity.ok()
                .body(allLists);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lists> findList(@PathVariable("id") Long id) {
        Optional<Lists> list = this.listService.findById(id);
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok()
                .body(list.get());
    }

    @PostMapping("/")
    public ResponseEntity<Lists> addList(@RequestBody Lists list) {
        return new ResponseEntity<>(listService.save(list), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Lists> deleteList(@PathVariable("id") Long id) {
        boolean isDeleted = this.listService.delete(id);

        if(!isDeleted){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lists> updateList(@PathVariable("id") Long id, Lists list) {
        boolean isEmpty = this.listService.update(id, list);

        if(!isEmpty){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/export")
    public ResponseEntity<String> exportData() throws JsonProcessingException {
        String data = listService.exportData();
        return ResponseEntity.ok().body(data);
    }

    @PostMapping("/import")
    public ResponseEntity<String> importData(@RequestBody String data) throws JsonProcessingException {
        listService.importData(data);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
