package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("passwordValidator")
public class PasswordValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        UIInput passwordField = (UIInput)context.getViewRoot().findComponent("signInForm:password");
        String lang = (String) component.getValueExpression("userPasswordVal").getValue(context.getELContext()).toString();
        if (passwordField == null) {
            throw new IllegalArgumentException(String.format("Unable to find component."));
        }
        String password = (String)passwordField.getValue();
        String confirmPassword = (String)value;
        FacesMessage message;
        if (!confirmPassword.equals(password)) {
            if(lang.equals("fr")){
                message = new FacesMessage("Mot de passe doit être le même");
            }
            else {
                message = new FacesMessage("Password must be the same");
            }
            throw new ValidatorException(message);
        }
    }
    
}
