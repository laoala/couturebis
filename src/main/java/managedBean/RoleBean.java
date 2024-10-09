package managedBean;

import entities.Role;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import services.SvcRole;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class RoleBean implements Serializable {
    // Déclaration des variables globales
    private static final long serialVersionUID = 1L;
    private Role role;
    private static final Logger log = Logger.getLogger(RoleBean.class);

    @PostConstruct
    public void init()
    {
        role = new Role();
    }

// todo : décider si fonction est utile
/*
    public boolean verifRoleExist(Role rol)
    {
        SvcRole serviceR = new SvcRole();
        if(serviceR.findRole(rol.getDenomination()).size() > 0)
        {
            serviceR.close();
            return false;
        }
        else {
            serviceR.close();
            return true;
        }

    }

 */


// todo : redo the function for check if user is allowed
/*
    public boolean checkPermission(String permission)
    {
        try
        {
            log.debug("test permissions de checkPermission ");
            log.debug(SecurityUtils.getSubject().isPermitted(permission));
            return SecurityUtils.getSubject().isPermitted(permission);

        }
        catch(Error nre)
        {
            log.debug("une erreur est survenue...");
        }
        return false;

    }

 */

    // todo : décidé si fonction est inutile
    /*
    public void save()
    {
        SvcRole service = new SvcRole();
        EntityTransaction transaction = service.getTransaction();
        transaction.begin();
        try {
            service.save(role);
            transaction.commit();
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.getExternalContext().getFlash().setKeepMessages(true);
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"L'operation a reussie",null));
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.getExternalContext().getFlash().setKeepMessages(true);
                fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"L'operation n'a pas reussie",null));
            }
            service.close();
        }

    }
*/
    public String flushRol()
    {
        init();
        return "/tableRoles?faces-redirect=true";
    }

    /*
     * Méthode qui permet via le service de retourner la liste de tous les roles
     */
    //todo : correct the function that gives the list of all the roles
    /*
    public List<Role> getReadAll()
    {
        SvcRole service = new SvcRole();
        List<Role> listRole = new ArrayList<Role>();
        listRole = service.findAllRoles();


        return listRole;
    }
    */

    //-------------------------------Getter & Setter--------------------------------------------

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
