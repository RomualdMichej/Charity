package pl.coderslab.charity.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findAllByEmail(String email);
}
