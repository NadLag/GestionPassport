import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UI.welcome();

        // Création d'un objet Scanner pour lire les entrées de l'utilisateur.
        Scanner input = new Scanner(System.in);
        char checkMark = '\u2713';

        try {
            System.out.print("\nEntrez le nom de la personne : ");
            String nom = input.nextLine();
            System.out.print("Entrez le prénom de la personne : ");
            String prenom = input.nextLine();

            Person personne = new Person(nom, prenom);

            // Creation du Passports
            LocalDate dateDelivrancePasseport = null;
            LocalDate dateExpirationPasseport = null;
            try {
                UI.createPassport();
                dateDelivrancePasseport = LocalDate.parse(input.nextLine());
                System.out.print("\tEntrez la date d'expiration (yyyy-mm-dd) : ");
                dateExpirationPasseport = LocalDate.parse(input.nextLine());
            } catch (DateTimeParseException e) {
                System.err.println("Erreur de format de date pour le passeport. Veuillez entrer la date au format yyyy-mm-dd.");
                return; // Exit if date format is incorrect
            }

            Passport passeport = PassportService.delivrerPassport(personne, dateDelivrancePasseport, dateExpirationPasseport);
            System.out.println("\t" + checkMark + " Passeport délivré : " + passeport.getNumero());

            // Creation du Visa
            LocalDate dateDelivranceVisa = null;
            LocalDate dateExpirationVisa = null;
            try {
                UI.createVisa();
                String typeVisa = input.nextLine();
                System.out.print("\tEntrez la date de délivrance (yyyy-mm-dd) : ");
                dateDelivranceVisa = LocalDate.parse(input.nextLine());
                System.out.print("\tEntrez la date d'expiration (yyyy-mm-dd) : ");
                dateExpirationVisa = LocalDate.parse(input.nextLine());

                Visa visa = ServiceConsulaire.delivrerVisa(passeport, typeVisa, dateDelivranceVisa, dateExpirationVisa);
                System.out.println("\t" + checkMark + " Visa délivré : " + visa.getType());

                // Afficher les information des personnes
                System.out.println("\n>>>>> Informations de la personne :");
                System.out.println("\t>> Nom : " + personne.getNom().toUpperCase());
                System.out.println("\t>> Prénom : " + personne.getPrenom().toUpperCase());
                System.out.println("\t>> Passeport : " + passeport.getNumero());
                System.out.println("\t>> Date de délivrance du passeport : " + passeport.getDateDelivrance());
                System.out.println("\t>> Date d'expiration du passeport : " + passeport.getDateExpiration());
                System.out.println("\t>> Visa : " + visa.getType().toUpperCase());
                System.out.println("\t>> Date de délivrance du visa : " + visa.getDateDelivrance());
                System.out.println("\t>> Date d'expiration du visa : " + visa.getDateExpiration());

                // Simulation d'invalidité de passeport
                System.out.println("\n>>>>> Simulation d'invalidité de passeport :");
                PassportService.invaliderPasseport(passeport.getNumero());
                System.out.println("\t" + checkMark + " Le Passeport numero : "+passeport.getNumero()+" est invalid.");

                // Simulation de verifier si la date du Passport est toujours valide ou pas
                System.out.println("\n>>>>> Simulation de verifier si le passeport est expirer:");
                PassportService.isPassportExpired(passeport.getNumero());

                // Simulation de prolongation de visa
                try {
                    UI.extendVisa();
                    LocalDate nouvelleDateExpirationVisa = LocalDate.parse(input.nextLine());
                    ServiceConsulaire.prolongerVisa(visa, nouvelleDateExpirationVisa);
                    System.out.println("\t" + checkMark + " Visa prolongé jusqu'au " + visa.getDateExpiration());
                } catch (DateTimeParseException e) {
                    System.err.println("Erreur de format de date pour la prolongation de visa. Veuillez entrer la date au format yyyy-mm-dd.");
                }

                // Simulation de prolongation de passeport
                try {
                    UI.createPassport();
                    LocalDate nouvelleDateExpirationPasseport = LocalDate.parse(input.nextLine());
                    PassportService.prolongerPasseport(passeport.getNumero(), nouvelleDateExpirationPasseport);
                    System.out.println("\t" + checkMark + " Le Passeport est prolongé jusqu'au " + passeport.getDateExpiration());
                } catch (DateTimeParseException e) {
                    System.err.println("Erreur de format de date pour la prolongation de passeport. Veuillez entrer la date au format yyyy-mm-dd.");
                }
            } catch (DateTimeParseException e) {
                System.err.println("Erreur de format de date pour le visa. Veuillez entrer la date au format yyyy-mm-dd.");
            }
        } catch (Exception e) {
            System.err.println("Une erreur est survenue : " + e.getMessage());
        } finally {
            input.close();
        }
    }
}