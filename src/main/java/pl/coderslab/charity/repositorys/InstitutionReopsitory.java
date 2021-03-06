package pl.coderslab.charity.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Institution;

public interface InstitutionReopsitory extends JpaRepository<Institution, Long> {

    Institution findInstitutionById(Long id);
}
