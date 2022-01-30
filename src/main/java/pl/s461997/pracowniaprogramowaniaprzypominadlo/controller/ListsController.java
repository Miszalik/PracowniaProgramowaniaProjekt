package pl.s461997.pracowniaprogramowaniaprzypominadlo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.model.Lists;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.service.ListService;

import java.util.List;
import java.util.Optional;

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
        this.listService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
