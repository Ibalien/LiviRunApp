package monapp.dreams.com.myapplication.models;

import java.io.Serializable;

public class Article implements Serializable {

    private Long id;
    private String designation;
    private String gencod;
    private Depot idDepot;

    public Article() {
    }

    public Article(Long id, String designation, String gencod, Depot id_Depot) {
        this.id = id;
        this.designation = designation;
        this.gencod = gencod;
        this.idDepot = id_Depot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getGencod() {
        return gencod;
    }

    public void setGencod(String gencod) {
        this.gencod = gencod;
    }

    public Depot getIdDepot() {
        return idDepot;
    }

    public void setIdDepot(Depot idDepot) {
        this.idDepot = idDepot;
    }

    @Override
    public String toString() {
        return "Article [designation=" + designation + ", gencod=" + gencod + ", id=" + id + ", id_Depot=" + idDepot
                + "]";
    }

}
