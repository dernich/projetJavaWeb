package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("streetValidator")
public class StreetValidator implements Validator {

    private static final String STREET_PATTERN = "^[a-zA-Z][a-zA-Z -]*[a-zA-Z]$";

	private Pattern pattern;
	private Matcher matcher;
	
	public StreetValidator(){
		  pattern = Pattern.compile(STREET_PATTERN);
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
            String lang = (String) component.getValueExpression("userStreetVal").getValue(context.getELContext()).toString();
            matcher = pattern.matcher(value.toString());
            FacesMessage msg;
            if(!matcher.matches()){
                if(lang.equals("fr")){
                    msg = new FacesMessage("Format de rue invalide. N'entrez pas de chiffres ni d'espace en premiere ou derniere lettre");
                }
                else {
                    msg = new FacesMessage("Invalid street format. Don't enter space at first/last or digit at all");
                }
                throw new ValidatorException(msg);
            }
	}
}
