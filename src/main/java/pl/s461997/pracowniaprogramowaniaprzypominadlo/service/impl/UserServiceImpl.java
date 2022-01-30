package pl.s461997.pracowniaprogramowaniaprzypominadlo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.model.Users;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.repository.ListsRepository;
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
        return usersRepository.save(user);
    }

    @Override
    public boolean update(Long id, Users user) {
        Optional<Users> existingUser = usersRepository.findById(id);
        if(existingUser.isEmpty()){
            return false;
        }
        usersRepository.save(user);

        return true;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Users> user = usersRepository.findById(id);
        if(user.isEmpty()){
            return false;
        }
        usersRepository.deleteById(id);

        return true;
    }

    @Override
    public String exportData() throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        List<Users> users = usersRepository.findAll();
        return objectMapper.writeValueAsString(users);
    }

    @Override
    public void importData(String data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Users> users = objectMapper.readValue(data, new TypeReference<List<Users>>() {});
        for(Users user:users){
            usersRepository.save(user);
        }
    }
}
