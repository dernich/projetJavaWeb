package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator {


	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private Pattern pattern;
	private Matcher matcher;
	
	public EmailValidator(){
		  pattern = Pattern.compile(EMAIL_PATTERN);
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
            String lang = (String) component.getValueExpression("userEmailVal").getValue(context.getELContext()).toString();
            matcher = pattern.matcher(value.toString());
            FacesMessage msg;
            if(!matcher.matches()){
                if(lang.equals("fr")){
                    msg = new FacesMessage("Format d'email invalide. Example : me@mail.com or you.at@mail.my.com");
                }
                else {
                    msg = new FacesMessage("Invalid E-mail format. Example : me@mail.com or you.at@mail.my.com");
                }
                throw new ValidatorException(msg);
            }
	}
}