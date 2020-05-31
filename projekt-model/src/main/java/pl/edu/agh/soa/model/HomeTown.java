package pl.edu.agh.soa.model;

public class HomeTown {
    private String postalCode;

    public HomeTown(String postalCode) {
        this.postalCode = postalCode;
    }

    public HomeTown() {
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
