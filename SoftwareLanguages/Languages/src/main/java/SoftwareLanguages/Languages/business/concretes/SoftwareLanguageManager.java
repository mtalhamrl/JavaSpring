package SoftwareLanguages.Languages.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import SoftwareLanguages.Languages.business.abstracts.SoftwareLanguageService;
import SoftwareLanguages.Languages.business.requests.CreateSoftwareLanguages;
import SoftwareLanguages.Languages.business.requests.UpdateSoftwareLanguagesRequest;
import SoftwareLanguages.Languages.business.responses.GetAllSoftwareLanguagesResponse;
import SoftwareLanguages.Languages.business.responses.GetByIdSoftwareLanguagesResponse;
import SoftwareLanguages.Languages.core.utilities.mappers.ModelMapperService;
import SoftwareLanguages.Languages.dataAccess.SoftwareLanguagesRepository;
import SoftwareLanguages.Languages.entities.SoftwareLanguages;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class SoftwareLanguageManager implements SoftwareLanguageService{
	private  SoftwareLanguagesRepository softwareLanguagesRepository; //final'i sildim.
	private ModelMapperService modelMapperService;
	
	

	@Override
	public List<GetAllSoftwareLanguagesResponse> getAll() {
		List<SoftwareLanguages> softwareLanguages= softwareLanguagesRepository.findAll();
		List<GetAllSoftwareLanguagesResponse> getAllSoftwareLanguagesResponses = softwareLanguages.stream()
				.map(softwarelanguages->this.modelMapperService.forResponse()
				.map(softwarelanguages,GetAllSoftwareLanguagesResponse.class)).collect(Collectors.toList());
				return getAllSoftwareLanguagesResponses;
	}
				
	

	@Override
	public void add(CreateSoftwareLanguages createSoftwareLanguages) {
		SoftwareLanguages softwareLanguages = this.modelMapperService.forRequest()
										.map(createSoftwareLanguages, SoftwareLanguages.class);
		this.softwareLanguagesRepository.save(softwareLanguages);
	}

	@Override
	public void update(UpdateSoftwareLanguagesRequest updateSoftwareLanguagesRequest) {
		SoftwareLanguages softwareLanguages = this.modelMapperService.forRequest()
										.map(updateSoftwareLanguagesRequest, SoftwareLanguages.class);
		this.softwareLanguagesRepository.save(softwareLanguages);
	}

	@Override
	public void delete(int id) {
		this.softwareLanguagesRepository.deleteById(id);
		
	}



	@Override
	public GetByIdSoftwareLanguagesResponse getById(int id) {
		SoftwareLanguages softwareLanguages =this.softwareLanguagesRepository.findById(id).orElseThrow();
		GetByIdSoftwareLanguagesResponse getByIdSoftwareLanguagesResponse =
				this.modelMapperService.forResponse().map(softwareLanguages, GetByIdSoftwareLanguagesResponse.class);
		return getByIdSoftwareLanguagesResponse;
		
	}

}
