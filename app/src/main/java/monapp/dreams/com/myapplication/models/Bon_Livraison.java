package monapp.dreams.com.myapplication.models;

import monapp.dreams.com.myapplication.models.Adresse;
import monapp.dreams.com.myapplication.models.Client;
import monapp.dreams.com.myapplication.models.Livreur;
import monapp.dreams.com.myapplication.models.Magasin;

import java.io.Serializable;
import java.util.Date;
public class Bon_Livraison implements Serializable {

    private Long id;
    private Client idClient;
    private Magasin idMagasinAchat;
    private Livreur idLivreur;
    private Date dateAchat;
    private Date dateLivraison;
    private String commentaire;
    private Adresse idAdresse;
    private String signature;

    public Bon_Livraison() {
    }

    public Bon_Livraison(Long id, Client idClient, Magasin idMagasinAchat, Livreur idLivreur, Date dateAchat,
                         Date dateLivraison, String commentaire, Adresse idAdresse, String signature) {
        this.id = id;
        this.idClient = idClient;
        this.idMagasinAchat = idMagasinAchat;
        this.idLivreur = idLivreur;
        this.dateAchat = dateAchat;
        this.dateLivraison = dateLivraison;
        this.commentaire = commentaire;
        this.idAdresse = idAdresse;
        this.signature = signature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public Magasin getIdMagasinAchat() {
        return idMagasinAchat;
    }

    public void setIdMagasinAchat(Magasin idMagasinAchat) {
        this.idMagasinAchat = idMagasinAchat;
    }

    public Livreur getIdLivreur() {
        return idLivreur;
    }

    public void setIdLivreur(Livreur idLivreur) {
        this.idLivreur = idLivreur;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Adresse getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Adresse idAdresse) {
        this.idAdresse = idAdresse;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Bon_Livraison [commentaire=" + commentaire + ", date_Achat=" + dateAchat + ", date_Livraison="
                + dateLivraison + ", id=" + id + ", id_Adresse=" + idAdresse + ", id_Client=" + idClient
                + ", id_Livreur=" + idLivreur + ", id_Magasin_Achat=" + idMagasinAchat + ", signature=" + signature
                + "]";
    }

}
