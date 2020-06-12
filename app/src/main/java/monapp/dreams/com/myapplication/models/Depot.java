package monapp.dreams.com.myapplication.models;

import java.io.Serializable;

public class Depot implements Serializable {

    private Long id;
    private String adresse;
    private String codePostal;
    private String tel;
    private String email;

    public Depot() {
    }

    public Depot(Long id, String adresse, String codePostal, String tel, String email) {
        this.id = id;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.tel = tel;
        this.email = email;
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

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Depot [adresse=" + adresse + ", code_Postal=" + codePostal + ", email=" + email + ", id=" + id
                + ", tel=" + tel + "]";
    }


}
