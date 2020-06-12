package monapp.dreams.com.myapplication.models;

import java.io.Serializable;

public class Adresse implements Serializable {

    private Long id;
    private String adresse;
    private String ville;
    private String codePostal;

    public Adresse() {
    }

    public Adresse(Long id, String adresse, String ville, String codePostal) {
        this.id = id;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    @Override
    public String toString() {
        return "Adresse [adresse=" + adresse + ", code_postal=" + codePostal + ", id=" + id + ", ville=" + ville + "]";
    }
}
