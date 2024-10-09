package services;

import entities.Utilisateur;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SvcUtilisateur extends Service<Utilisateur> implements Serializable {
    //Déclaration des variables
    private static final Logger log = Logger.getLogger(SvcArticle.class);
    private static final long serialVersionUID = 1L;
    Map<String, Object> params = new HashMap<String, Object>();

    public SvcUtilisateur() {
        super();
    }

    // Méthode qui permet de sauver un utilisateur et de le mettre en DB
    @Override
    public Utilisateur save(Utilisateur utilisateur) {
        if (utilisateur.getId() == 0) {
            em.persist(utilisateur);
        } else {
            utilisateur = em.merge(utilisateur);
        }

        return utilisateur;
    }

    public List<Utilisateur> findByLogin(String login) {
        Map<String, String> param = new HashMap<>();
        param.put("login", login);

        return finder.findByNamedQuery("Utilisateur.findByLogin", param);
    }

}