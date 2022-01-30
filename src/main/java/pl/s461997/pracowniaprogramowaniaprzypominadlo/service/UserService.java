package pl.s461997.pracowniaprogramowaniaprzypominadlo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.model.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<Users> findAll();

    Optional<Users> findById(Long id);

    Users save(Users user);

    boolean update(Long id, Users users);

    boolean delete(Long id);

    String exportData() throws JsonProcessingException;

    void importData(String data) throws JsonProcessingException;
}
