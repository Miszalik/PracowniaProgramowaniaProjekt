package pl.s461997.pracowniaprogramowaniaprzypominadlo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public boolean update(Long id, Tasks task) {
        Optional<Tasks> existingTask = tasksRepository.findById(id);
        if(existingTask.isEmpty()){
            return false;
        }
        tasksRepository.save(task);

        return true;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Tasks> task = tasksRepository.findById(id);
        if(task.isEmpty()){
            return false;
        }
        tasksRepository.deleteById(id);

        return true;
    }

    @Override
    public String exportData() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Tasks> tasks = tasksRepository.findAll();
        return objectMapper.writeValueAsString(tasks);
    }

    @Override
    public void importData(String data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Tasks> tasks = objectMapper.readValue(data, new TypeReference<List<Tasks>>() {});
        for(Tasks task:tasks){
            tasksRepository.save(task);
        }
    }
}
