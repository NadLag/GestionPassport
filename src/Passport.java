import java.time.LocalDate;

public class Passport {
    private String numero;
    private LocalDate dateDelivrance;
    private LocalDate dateExpiration;
    private boolean estValide;
    private Visa visa; // Le visa associé au passeport

// Constructeur de la classe Passport
    public Passport(String numero, LocalDate dateDelivrance, LocalDate dateExpiration) {
        this.numero = numero;
        this.dateDelivrance = dateDelivrance;
        this.dateExpiration = dateExpiration;
        this.estValide = true;
    }

// Méthode pour associer un visa au passeport
    public void setVisa(Visa visa) {
        this.visa = visa;
    }

// Méthode pour obtenir le visa associé au passeport
    public Visa getVisa() {
        return visa;
    }

// Méthode pour obtenir le numéro du passeport
    public String getNumero() {
        return numero;
    }

// Méthode pour obtenir la date de délivrance du passeport
    public LocalDate getDateDelivrance() {
        return dateDelivrance;
    }

// Méthode pour obtenir la date d'expiration du passeport
    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

// Méthode pour vérifier si le passeport est valide
    public boolean estValide() {
        return estValide;
    }

// Méthode pour invalider le passeport
    public void invalider() {
        this.estValide = false;
        if (visa != null) {
            visa.invalider();
        }
    }

// Méthode pour prolonger la date d'expiration du passeport
    public void prolongerDateExpiration(LocalDate nouvelleDate) {
        dateExpiration = nouvelleDate;
        if (visa != null && visa.getDateExpiration().isAfter(nouvelleDate)) {
            visa.setDateExpiration(nouvelleDate);
        }
    }
}
