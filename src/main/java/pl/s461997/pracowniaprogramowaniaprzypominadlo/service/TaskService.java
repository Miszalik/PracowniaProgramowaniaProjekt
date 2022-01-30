package pl.s461997.pracowniaprogramowaniaprzypominadlo.service;

import pl.s461997.pracowniaprogramowaniaprzypominadlo.model.Tasks;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Tasks> findAll();

    Optional<Tasks> findById(Long id);

    Tasks save(Tasks task);

    Tasks update(Long id, Tasks tasks);

    void delete(Long id);
}
