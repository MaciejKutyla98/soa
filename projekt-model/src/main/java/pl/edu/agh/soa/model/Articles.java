package pl.edu.agh.soa.model;

public class Articles {
    private String tittle;

    public Articles(String tittle) {
        this.tittle = tittle;
    }

    public Articles() {
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }
}
