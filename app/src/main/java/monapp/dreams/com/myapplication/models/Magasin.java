package monapp.dreams.com.myapplication.models;

public class Magasin {
    private Long id;
    private String address;
    private String email;

    public Magasin() {
    }

    public Magasin(Long id, String address, String email, String nom) {
        this.id = id;
        this.address = address;
        this.email = email;
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    private String nom;
}
