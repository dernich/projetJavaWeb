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
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
            String lang = (String) component.getValueExpression("userCityVal").getValue(context.getELContext()).toString();
            matcher = pattern.matcher(value.toString());
            FacesMessage msg;
            if(!matcher.matches()){
                if(lang.equals("fr")){
                    msg = new FacesMessage("Format du nom de ville invalide. N'entrez pas d'espace en première place ou entièrement des chiffres");
                }
                else {
                    msg = new FacesMessage("Invalid city's name format.  Don't enter space at first and digit at all");
                }
                throw new ValidatorException(msg);
            }
	}
}

