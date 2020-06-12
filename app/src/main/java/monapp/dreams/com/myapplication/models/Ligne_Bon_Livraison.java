package monapp.dreams.com.myapplication.models;

import java.io.Serializable;

public class Ligne_Bon_Livraison implements Serializable {

    private Long id;
    private Article idArticle;
    private Long quantite;
    private Bon_Livraison idBonLivraison;

    public Ligne_Bon_Livraison() {
    }

    public Ligne_Bon_Livraison(Long id, Article idArticle, Long quantite, Bon_Livraison idBonLivraison) {
        this.id = id;
        this.idArticle = idArticle;
        this.quantite = quantite;
        this.idBonLivraison = idBonLivraison;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Article getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Article idArticle) {
        this.idArticle = idArticle;
    }

    public Long getQuantite() {
        return quantite;
    }

    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }

    public Bon_Livraison getIdBonLivraison() {
        return idBonLivraison;
    }

    public void setIdBonLivraison(Bon_Livraison idBonLivraison) {
        this.idBonLivraison = idBonLivraison;
    }

    @Override
    public String toString() {
        return "Ligne_Bon_Livraison [id=" + id + ", id_Article=" + idArticle + ", id_Bon_Livraison=" + idBonLivraison
                + ", quantite=" + quantite + "]";
    }

}
