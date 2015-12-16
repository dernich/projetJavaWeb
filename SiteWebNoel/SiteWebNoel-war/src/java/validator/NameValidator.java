package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("nameValidator")
public class NameValidator implements Validator {

    private static final String NAME_PATTERN = "^[a-zA-ZÀÉÈÊÏÔ][a-zA-Z1-9àéèêîïô ]*[a-zA-Z1-9àéèêîïô]$";

	private Pattern pattern;
	private Matcher matcher;
	
	public NameValidator(){
		  pattern = Pattern.compile(NAME_PATTERN);
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {	
            String lang = (String) component.getValueExpression("userNameVal").getValue(context.getELContext()).toString();
            matcher = pattern.matcher(value.toString());
            FacesMessage msg;
            if(!matcher.matches()){
                if(lang.equals("fr")){
                    msg = new FacesMessage("Format du nom invalide. N'entrez pas d'espace en première place ou entièrement des chiffres");
                }
                else {
                    msg = new FacesMessage("Invalid Name format. Don't enter space at first or digit at all");
                }
                throw new ValidatorException(msg);
            }
	}
}
