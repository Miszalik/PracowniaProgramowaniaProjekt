package pl.s461997.pracowniaprogramowaniaprzypominadlo.service;

import pl.s461997.pracowniaprogramowaniaprzypominadlo.model.Lists;

import java.util.List;
import java.util.Optional;

public interface ListService {
    List<Lists> findAll();

    Optional<Lists> findById(Long id);

    Lists save(Lists user);

    Lists update(Long id, Lists lists);

    void delete(Long id);
}
