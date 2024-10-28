package converter;

import entities.Localite;
import org.apache.log4j.Logger;
import services.SvcLocalite;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Named;


@Named
@FacesConverter(value = "localiteConverter")
public class LocaliteConverter implements Converter {
    private static final Logger log = Logger.getLogger(LocaliteConverter.class);
    private final SvcLocalite service = new SvcLocalite();

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s != null && s.trim().length() > 0) {
            int id = Integer.parseInt(s);

            return service.getById(id);
        } else
            return null;

    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o != null) {
            return String.valueOf(((Localite) o).getId());
        }
        else
            return null;
    }
}