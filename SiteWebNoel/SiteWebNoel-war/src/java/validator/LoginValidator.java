package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("loginValidator")
public class LoginValidator implements Validator {

    private static final String LOGIN_PATTERN = "^[a-z0-9_-]{3,15}$";

	private Pattern pattern;
	private Matcher matcher;
	
	public LoginValidator(){
		  pattern = Pattern.compile(LOGIN_PATTERN);
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
            String lang = (String)component.getValueExpression("userLoginVal").getValue(context.getELContext()).toString();
            matcher = pattern.matcher(value.toString());
            FacesMessage msg;
            if(!matcher.matches()){
                if(lang.equals("fr")){
                    msg = new FacesMessage("Format du login invalide. Il doit comporter entre 3 et 15 caractères avec des lettres, chiffres, - ou _");
                }
                else {
                    msg = new FacesMessage("Invalid Login format. Must be between 3 and 15 character with letter, digit, - or _");
                }
                throw new ValidatorException(msg);
            }
	}
}
