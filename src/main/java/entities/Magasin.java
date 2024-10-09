package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "magasin")
public class Magasin {
    @Id
    @Column(name = "IdMagasin", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "Nom", nullable = false)
    private String nom;

    @NotNull
    @Column(name = "Actif", nullable = false)
    private Boolean actif = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magasin magasin = (Magasin) o;
        return Objects.equals(id, magasin.id) && Objects.equals(nom, magasin.nom) && Objects.equals(actif, magasin.actif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, actif);
    }
}