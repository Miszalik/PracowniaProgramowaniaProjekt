package pl.s461997.pracowniaprogramowaniaprzypominadlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.model.Tasks;

public interface TasksRepository extends JpaRepository<Tasks, Long> {
}
