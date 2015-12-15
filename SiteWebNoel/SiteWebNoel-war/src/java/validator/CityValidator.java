package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("cityValidator")
public class CityValidator implements Validator {

    private static final String CITY_PATTERN = "^[a-zA-Z]+([a-zA-Z -])*";
    private Pattern pattern;
    private Matcher matcher;
	
	public CityValidator(){
		  pattern = Pattern.compile(CITY_PATTERN);
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		matcher = pattern.matcher(value.toString());
		if(!matcher.matches()){
			
			FacesMessage msg = 
				new FacesMessage("City validation failed.", 
						"Invalid city's name format.  Don't enter space at first and digit at all");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}

	}
}

