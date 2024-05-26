import java.time.LocalDate;

public class ServiceConsulaire {

// Méthode static pour délivrer un visa
    public static Visa delivrerVisa(Passport passport, String type, LocalDate deliveryDate, LocalDate expiryDate) {
        // Vérifie si la date d'expiration du visa est valide par rapport à date d'expiration du passeport
        if (expiryDate.isAfter(passport.getDateExpiration()) || expiryDate.isBefore(passport.getDateDelivrance())) {
            expiryDate = passport.getDateExpiration();
            deliveryDate = passport.getDateDelivrance();
        }
        String numeroVisa = PassportService.generateNumber();
        Visa visa = new Visa(type, deliveryDate, expiryDate);
        passport.setVisa(visa);
        return visa;
    }

// Méthode static pour prolonger un visa
    public static void prolongerVisa(Visa visa, LocalDate nouvelleDate) {
        // Vérifie si la nouvelle date est valide par rapport a dates de délivrance et d'expiration du visa
        if (visa.getDateExpiration().isBefore(nouvelleDate) || visa.getDateDelivrance().isBefore(nouvelleDate)){
            visa.setDateExpiration(nouvelleDate);
        }
    }

}
