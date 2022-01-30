package pl.s461997.pracowniaprogramowaniaprzypominadlo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.model.Tasks;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.model.Tasks;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Tasks> findAll();

    Optional<Tasks> findById(Long id);

    Tasks save(Tasks task);

    boolean update(Long id, Tasks tasks);

    boolean delete(Long id);

    String exportData() throws JsonProcessingException;

    void importData(String data) throws JsonProcessingException;
}
