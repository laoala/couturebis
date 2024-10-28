package validators;

import org.apache.log4j.Logger;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("checkMdpValidator")
public class CheckMdpValidator implements Validator {
    private static final Logger log = Logger.getLogger(CheckMdpValidator.class);

    @Override
    public void validate(FacesContext context, UIComponent uic, Object confmdp) throws ValidatorException {
        // TODO Auto-generated method stub

        // récupère le mot de passe de confirmation
        String confirmPassword = (String)confmdp;
        log.debug("confirmPassword: "+confirmPassword);

        // récupère le 1er mot de passe tapé
        UIInput uiInputPassword = (UIInput) uic.findComponent("mdp");
        String password = uiInputPassword.getLocalValue() == null ? "..."
                : uiInputPassword.getLocalValue().toString();
        String passwordId = uiInputPassword.getClientId();
        log.debug("newPassword: "+password);


        //on compare les deux mots de passe tapé afin de vérifier qu'il correspondent bien.
        if (!password.equals(confirmPassword)) {
            FacesMessage msg = new FacesMessage("Les mots de passe ne correspondent pas!!!");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(passwordId, msg);
            context.renderResponse();
        }
    }
    //------------------------------------------------------------------------------------------------
    public static Logger getLog() {
        return log;
    }

}
