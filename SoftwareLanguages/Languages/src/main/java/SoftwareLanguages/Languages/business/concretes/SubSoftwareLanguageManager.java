package SoftwareLanguages.Languages.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import SoftwareLanguages.Languages.business.abstracts.SubSoftwareLanguageService;
import SoftwareLanguages.Languages.business.requests.CreateSubSoftwareLanguages;
import SoftwareLanguages.Languages.business.requests.UpdateSubSoftwareLanguagesRequest;
import SoftwareLanguages.Languages.business.responses.GetAllSubSoftwareLanguagesResponse;
import SoftwareLanguages.Languages.business.responses.GetByIdSubSoftwareLanguagesResponse;
import SoftwareLanguages.Languages.core.utilities.mappers.ModelMapperService;
import SoftwareLanguages.Languages.dataAccess.SubSoftwareLanuagesRepository;
import SoftwareLanguages.Languages.entities.SubSoftwareLanguage;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class SubSoftwareLanguageManager implements SubSoftwareLanguageService{
	private SubSoftwareLanuagesRepository subSoftwareLanuagesRepository;
	private ModelMapperService modelMapperService;
	

	@Override
	public List<GetAllSubSoftwareLanguagesResponse> getAllsub() {
		List<SubSoftwareLanguage> subSoftwareLanguages = subSoftwareLanuagesRepository.findAll();
		List<GetAllSubSoftwareLanguagesResponse> getAllSubSoftwareLanguagesResponses= subSoftwareLanguages.stream()
				.map(subsoftwareLanguages->this.modelMapperService.forResponse()
				.map(subsoftwareLanguages, GetAllSubSoftwareLanguagesResponse.class)).collect(Collectors.toList());
		return getAllSubSoftwareLanguagesResponses;
								
	}
	@Override
	public void add(CreateSubSoftwareLanguages createSubSoftwareLanguages) {
		SubSoftwareLanguage subSoftwareLanguage = this.modelMapperService.forRequest()
						.map(createSubSoftwareLanguages, SubSoftwareLanguage.class);
		this.subSoftwareLanuagesRepository.save(subSoftwareLanguage);
	}

	@Override
	public void update(UpdateSubSoftwareLanguagesRequest updateSubSoftwareLanguagesRequest) {
		SubSoftwareLanguage subSoftwareLanguage = this.modelMapperService.forRequest()
				.map(updateSubSoftwareLanguagesRequest, SubSoftwareLanguage.class);
		this.subSoftwareLanuagesRepository.save(subSoftwareLanguage);
		
	}

	@Override
	public void delete(int id) {
		this.subSoftwareLanuagesRepository.deleteById(id);
		
	}
	@Override
	public GetByIdSubSoftwareLanguagesResponse getBySubId(int id) {
		SubSoftwareLanguage subSoftwareLanguage = this.subSoftwareLanuagesRepository.findById(id).orElseThrow();
		GetByIdSubSoftwareLanguagesResponse getByIdSubSoftwareLanguagesResponse = this.modelMapperService.forResponse()
				.map(subSoftwareLanguage, GetByIdSubSoftwareLanguagesResponse.class);
		return getByIdSubSoftwareLanguagesResponse;
	}

}
