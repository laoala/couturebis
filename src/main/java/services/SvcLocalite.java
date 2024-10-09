package services;

import entities.Localite;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SvcLocalite extends Service<Localite> implements Serializable {
    //Déclaration des variables
    private static final Logger log = Logger.getLogger(SvcArticle.class);
    private static final long serialVersionUID = 1L;
    Map<String, Object> params = new HashMap<String, Object>();

    public SvcLocalite() {
        super();
    }

    // Méthode qui permet de sauver une localite et de la mettre en DB
    @Override
    public Localite save(Localite localite) {
        if (localite.getId() == 0) {
            em.persist(localite);
        } else {
            localite = em.merge(localite);
        }

        return localite;
    }
}