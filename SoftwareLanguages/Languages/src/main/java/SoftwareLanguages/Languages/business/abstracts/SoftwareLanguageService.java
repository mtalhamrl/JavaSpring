package SoftwareLanguages.Languages.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import SoftwareLanguages.Languages.business.requests.CreateSoftwareLanguages;
import SoftwareLanguages.Languages.business.requests.UpdateSoftwareLanguagesRequest;
import SoftwareLanguages.Languages.business.responses.GetAllSoftwareLanguagesResponse;
import SoftwareLanguages.Languages.business.responses.GetByIdSoftwareLanguagesResponse;

@Service
public interface SoftwareLanguageService {
	List<GetAllSoftwareLanguagesResponse> getAll();
	GetByIdSoftwareLanguagesResponse getById(int id);
	void add(CreateSoftwareLanguages createSoftwareLanguages);
	void update(UpdateSoftwareLanguagesRequest updateSoftwareLanguagesRequest);
	void delete(int id);
}
