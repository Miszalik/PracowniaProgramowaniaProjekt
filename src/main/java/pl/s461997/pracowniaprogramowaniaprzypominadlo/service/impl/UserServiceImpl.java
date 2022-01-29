package pl.s461997.pracowniaprogramowaniaprzypominadlo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.model.Users;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.repository.UsersRepository;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.service.UserService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<Users> findById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public Users save(Users user) {
        /*Users newUser = new Users();
        newUser.setUsername(user.getUsername());
        newUser.setListname(user.getListname());*/

        return usersRepository.save(user);
    }

    @Override
    public Users update(Long id, Users user) {
        return null;
    }

    @Override
    public void delete(Long id) {
        usersRepository.deleteById(id);
    }
}
