package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.requests.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.responses.GetByIdModelResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service

public class ModelManager implements ModelService{
	
	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = modelRepository.findAll();
		
		List<GetAllModelsResponse> modelsResponse = models.stream()
				.map(model->this.modelMapperService.forResponse()
						.map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
			return modelsResponse;
		
	}
	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model = this.modelMapperService .forRequest() 
				.map(createModelRequest, Model.class);
		this.modelRepository.save(model);
		
	}
	@Override
	public void update(UpdateModelRequest updateModelRequest) {
		Model model = this.modelMapperService.forRequest()
				.map(updateModelRequest, Model.class);
		this.modelRepository.save(model);
	}
	@Override
	public void delete(int id) {
		this.modelRepository.deleteById(id);
	}
	@Override
	public GetByIdModelResponse getById(int id) {
		Model model = this.modelRepository.findById(id).orElseThrow();
		GetByIdModelResponse getByIdModelResponse =	
				this.modelMapperService.forResponse().map(model, GetByIdModelResponse.class);
		
		return getByIdModelResponse;
	}
	
	

		
	}

