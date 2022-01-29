package pl.s461997.pracowniaprogramowaniaprzypominadlo.service;

import pl.s461997.pracowniaprogramowaniaprzypominadlo.model.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<Users> findAll();

    Optional<Users> findById(Long id);

    Users save(Users user);

    Users update(Long id, Users users);

    void delete(Long id);
}
