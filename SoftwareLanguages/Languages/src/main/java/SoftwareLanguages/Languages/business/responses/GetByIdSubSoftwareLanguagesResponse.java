package SoftwareLanguages.Languages.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdSubSoftwareLanguagesResponse {

	private int id;
	private String subName;
}
