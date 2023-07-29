package SoftwareLanguages.Languages.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSubSoftwareLanguagesRequest {
	private int id;
	private String name;
}
