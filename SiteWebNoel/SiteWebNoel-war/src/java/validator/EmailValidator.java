package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        UIInput emailField = (UIInput)context.getViewRoot().findComponent("signInForm:mail");
        if (emailField == null) {
            throw new IllegalArgumentException(String.format("Unable to find component."));
        }
        String email = (String)emailField.getValue();
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        Boolean b = email.matches(EMAIL_REGEX);
        if(!b) {
            FacesMessage message = new FacesMessage("Email should be like user@domain.com");
            throw new ValidatorException(message);
        }
    }
}
