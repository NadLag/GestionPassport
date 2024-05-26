import java.time.LocalDate;

public class Visa {
    private String type;
    private LocalDate dateDelivrance;
    private LocalDate dateExpiration;
    private boolean estValide;

// Constructeur de ma classe Visa
    public Visa(String type, LocalDate dateDelivrance, LocalDate dateExpiration) {
        this.type = type;
        this.dateDelivrance = dateDelivrance;
        this.dateExpiration = dateExpiration;
        this.estValide = true;
    }

// Méthode pour obtenir le type de visa
    public String getType() {
        return type;
    }

// Méthode pour obtenir la date de délivrance du visa
    public LocalDate getDateDelivrance() {
        return dateDelivrance;
    }

// Méthode pour obtenir la date d'expiration du visa
    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

// Méthode pour vérifier si le visa est valide
    public boolean estValide() {
        return estValide;
    }

// Méthode pour invalider le visa
    public void invalider() {
        this.estValide = false;
    }

// Méthode pour modifier la date d'expiration du visa
    public void setDateExpiration(LocalDate nouvelleDate) {
        dateExpiration = nouvelleDate;
    }
}
