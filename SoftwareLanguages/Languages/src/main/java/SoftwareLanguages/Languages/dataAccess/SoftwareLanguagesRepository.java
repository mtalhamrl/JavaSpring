package SoftwareLanguages.Languages.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SoftwareLanguages.Languages.entities.SoftwareLanguages;
@Repository
public interface SoftwareLanguagesRepository extends JpaRepository<SoftwareLanguages, Integer>{

}
