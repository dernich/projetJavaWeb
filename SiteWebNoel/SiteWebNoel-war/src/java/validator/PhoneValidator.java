
package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Degraux
 */
@FacesValidator("phoneValidator")
public class PhoneValidator implements Validator {

    private static final String PHONE_PATTERN = "^[0]+[0-9]{2,3}+[\\/]+[0-9]{6}";

	private Pattern pattern;
	private Matcher matcher;
	
	public PhoneValidator(){
		  pattern = Pattern.compile(PHONE_PATTERN);
	}
	
        
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
            
            if(!value.toString().equals("")){
                String lang = (String) component.getValueExpression("userPhoneVal").getValue(context.getELContext()).toString();
                matcher = pattern.matcher(value.toString());
                FacesMessage msg;
                if(!matcher.matches()){
                    if(lang.equals("fr")){
                        msg = new FacesMessage("Format de téléphone invalide. Example : 082/139684 ou 0498/135847");
                    }
                    else {
                        msg = new FacesMessage("Invalid Phone format. Example : 082/139684 or 0498/135847");
                    }
                    throw new ValidatorException(msg);
                }
            }
	}
}
