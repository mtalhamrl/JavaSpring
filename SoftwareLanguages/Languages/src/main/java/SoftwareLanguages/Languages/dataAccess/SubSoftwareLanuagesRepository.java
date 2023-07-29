package SoftwareLanguages.Languages.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SoftwareLanguages.Languages.entities.SubSoftwareLanguage;
@Repository
public interface SubSoftwareLanuagesRepository extends JpaRepository<SubSoftwareLanguage, Integer>{
	
}
