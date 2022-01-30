package pl.s461997.pracowniaprogramowaniaprzypominadlo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.model.Tasks;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.repository.TasksRepository;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.service.TaskService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    private final TasksRepository tasksRepository;

    @Autowired
    public TaskServiceImpl(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    @Override
    public List<Tasks> findAll() {
        return tasksRepository.findAll();
    }

    @Override
    public Optional<Tasks> findById(Long id) {
        return tasksRepository.findById(id);
    }

    @Override
    public Tasks save(Tasks task) {
        return tasksRepository.save(task);
    }

    @Override
    public Tasks update(Long id, Tasks task) {
        return null;
    }

    @Override
    public void delete(Long id) {
        tasksRepository.deleteById(id);
    }
}
