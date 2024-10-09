package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "pays")
public class Pays {
    @Id
    @Column(name = "IdPays", nullable = false)
    private Integer id;

    @Size(max = 150)
    @NotNull
    @Column(name = "Nom", nullable = false, length = 150)
    private String nom;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pays pays = (Pays) o;
        return Objects.equals(id, pays.id) && Objects.equals(nom, pays.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom);
    }
}