public class Person {

    private String nom;
    private String prenom;
    private Passport passport; // Le passeport associé à la personne

// Constructeur de ma classe Person
    public Person(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

// Méthode pour associer un passeport à la personne
    public void setPasseport(Passport passeport) {
        this.passport = passeport;
    }

// Méthode pour obtenir le passeport associé à la personne
    public Passport getPasseport() {
        return passport;
    }

// Méthode pour obtenir le nom de la personne
    public String getNom() {
        return nom;
    }

// Méthode pour obtenir le prénom de la personne
    public String getPrenom() {
        return prenom;
    }
}
