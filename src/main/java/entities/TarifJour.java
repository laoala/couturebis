package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tarif_jour")
public class TarifJour {
    @Id
    @Column(name = "IdTarifJour", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "TarifIdTarif", nullable = false)
    private Tarif tarifIdTarif;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "JourIdJour", nullable = false)
    private Jour jourIdJour;

    @NotNull
    @Column(name = "Prix", nullable = false)
    private Double prix;

    @NotNull
    @Column(name = "DateDebut", nullable = false)
    private Date dateDebut;

    @NotNull
    @Column(name = "DateFin", nullable = false)
    private Date dateFin;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ArticleIdArticle", nullable = false)
    private Article articleIdArticle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tarif getTarifIdTarif() {
        return tarifIdTarif;
    }

    public void setTarifIdTarif(Tarif tarifIdTarif) {
        this.tarifIdTarif = tarifIdTarif;
    }

    public Jour getJourIdJour() {
        return jourIdJour;
    }

    public void setJourIdJour(Jour jourIdJour) {
        this.jourIdJour = jourIdJour;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Article getArticleIdArticle() {
        return articleIdArticle;
    }

    public void setArticleIdArticle(Article articleIdArticle) {
        this.articleIdArticle = articleIdArticle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TarifJour tarifJour = (TarifJour) o;
        return Objects.equals(id, tarifJour.id) && Objects.equals(tarifIdTarif, tarifJour.tarifIdTarif) && Objects.equals(jourIdJour, tarifJour.jourIdJour) && Objects.equals(prix, tarifJour.prix) && Objects.equals(dateDebut, tarifJour.dateDebut) && Objects.equals(dateFin, tarifJour.dateFin) && Objects.equals(articleIdArticle, tarifJour.articleIdArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tarifIdTarif, jourIdJour, prix, dateDebut, dateFin, articleIdArticle);
    }
}