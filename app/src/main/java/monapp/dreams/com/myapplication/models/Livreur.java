package monapp.dreams.com.myapplication.models;

import java.io.Serializable;

public class Livreur implements Serializable {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String tel;

    public Livreur() {
    }

    public Livreur(Long id, String nom, String prenom, String email, String tel) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Livreur [email=" + email + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + "]";
    }


}
