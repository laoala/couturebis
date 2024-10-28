package validators;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("rawtypes")
@FacesValidator("nomPrenomValidator")

public class NomPrenomValidator implements Validator{

    private static final String NOMPRE = "^[a-zA-Zéèàùûêâôëç]{1}[a-zA-Zéèàùûêâôëç \\'-]*[a-zA-Zéèàùûêâôëç]$";

    private Pattern pattern;
    private Matcher matcher;

    public NomPrenomValidator()
    {
        pattern = Pattern.compile(NOMPRE);
    }

    @Override
    public void validate(FacesContext context, UIComponent component, 	Object value)
            throws ValidatorException {

        matcher = pattern.matcher(value.toString());
        if(!matcher.matches()){

            FacesMessage msg = new FacesMessage("Le nom/prenom n'est pas valide, il doit contenir entre 2 et 100 caractères et uniquelement lettre et caractère accentué.","Le nom/prenom n'est pas valide, il doit contenir entre 2 et 100 caractères et uniquelement lettre et caractère accentué.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }
}
