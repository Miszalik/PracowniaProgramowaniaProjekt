package pl.s461997.pracowniaprogramowaniaprzypominadlo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.model.Lists;

import java.util.List;
import java.util.Optional;

public interface ListService {
    List<Lists> findAll();

    Optional<Lists> findById(Long id);

    Lists save(Lists user);

    boolean update(Long id, Lists lists);

    boolean delete(Long id);

    String exportData() throws JsonProcessingException;

    void importData(String data) throws JsonProcessingException;
}

