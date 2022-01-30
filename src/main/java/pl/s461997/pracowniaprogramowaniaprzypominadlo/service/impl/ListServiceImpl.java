package pl.s461997.pracowniaprogramowaniaprzypominadlo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.model.Lists;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.model.Lists;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.repository.ListsRepository;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.service.ListService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ListServiceImpl implements ListService {
    private final ListsRepository listsRepository;

    @Autowired
    public ListServiceImpl(ListsRepository listsRepository) {
        this.listsRepository = listsRepository;
    }

    @Override
    public List<Lists> findAll() {
        return listsRepository.findAll();
    }

    @Override
    public Optional<Lists> findById(Long id) {
        return listsRepository.findById(id);
    }

    @Override
    public Lists save(Lists list) {
        return listsRepository.save(list);
    }

    @Override
    public boolean update(Long id, Lists list) {
        Optional<Lists> existingList = listsRepository.findById(id);
        if(existingList.isEmpty()){
            return false;
        }
        listsRepository.save(list);

        return true;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Lists> list = listsRepository.findById(id);
        if(list.isEmpty()){
            return false;
        }
        listsRepository.deleteById(id);

        return true;
    }

    @Override
    public String exportData() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Lists> lists = listsRepository.findAll();
        return objectMapper.writeValueAsString(lists);
    }

    @Override
    public void importData(String data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Lists> lists = objectMapper.readValue(data, new TypeReference<List<Lists>>() {});
        for(Lists list:lists){
            listsRepository.save(list);
        }
    }
}
