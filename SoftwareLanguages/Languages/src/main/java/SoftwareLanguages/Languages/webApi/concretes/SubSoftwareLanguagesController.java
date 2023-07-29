package SoftwareLanguages.Languages.webApi.concretes;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SoftwareLanguages.Languages.business.abstracts.SubSoftwareLanguageService;
import SoftwareLanguages.Languages.business.requests.CreateSubSoftwareLanguages;
import SoftwareLanguages.Languages.business.requests.UpdateSubSoftwareLanguagesRequest;
import SoftwareLanguages.Languages.business.responses.GetAllSubSoftwareLanguagesResponse;
import SoftwareLanguages.Languages.business.responses.GetByIdSubSoftwareLanguagesResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/subLanguages")
@RequiredArgsConstructor
public class SubSoftwareLanguagesController {
	private final SubSoftwareLanguageService subSoftwareLanguageService;

	
	@GetMapping()
	public List<GetAllSubSoftwareLanguagesResponse> getAllsub(){
		return subSoftwareLanguageService.getAllsub();
	}
	@PostMapping()
	public void add(@RequestBody CreateSubSoftwareLanguages createSubSoftwareLanguages) {
		this.subSoftwareLanguageService.add(createSubSoftwareLanguages);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.subSoftwareLanguageService.delete(id);
	}
	@PutMapping()
	public void update(UpdateSubSoftwareLanguagesRequest updateSubSoftwareLanguagesRequest) {
		this.subSoftwareLanguageService.update(updateSubSoftwareLanguagesRequest);
	}
	@GetMapping("/{id}")
	public GetByIdSubSoftwareLanguagesResponse getBySubId(@PathVariable int id) {
		return subSoftwareLanguageService.getBySubId(id);
	}
	
}
