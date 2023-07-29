package kodlama.io.rentACar.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarRequest {
	private String name;
	private String plate;
	private String dailyPrice;
	private double modelYear;	
	private int state;
	private int modelId;
	
	
	
}
