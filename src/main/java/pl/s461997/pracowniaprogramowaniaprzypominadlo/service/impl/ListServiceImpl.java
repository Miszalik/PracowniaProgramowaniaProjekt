package pl.s461997.pracowniaprogramowaniaprzypominadlo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public Lists update(Long id, Lists list) {
        return null;
    }

    @Override
    public void delete(Long id) {
        listsRepository.deleteById(id);
    }
}
