package pl.s461997.pracowniaprogramowaniaprzypominadlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
