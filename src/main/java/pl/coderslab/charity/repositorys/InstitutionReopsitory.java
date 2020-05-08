package pl.coderslab.charity.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.model.Institution;

public interface InstitutionReopsitory extends JpaRepository<Institution, Long> {
}
