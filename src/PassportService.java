import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PassportService {
   private static final Map<String, Passport> passeportsDelivres = new HashMap<>(); // Map pour stocker les passeports délivrés (numéro de passeport -> objet Passport)
   static char checkMark = '\u2713';

   // Méthode static pour délivrer un passeport
   public static Passport delivrerPassport(Person personne, LocalDate dateDelivrance, LocalDate dateExpiration) {
      String numeroPassport = generateNumber();
      Passport passport = new Passport(numeroPassport, dateDelivrance, dateExpiration);
      passeportsDelivres.put(numeroPassport, passport);
      personne.setPasseport(passport);
      return passport;
   }

   // Méthode static pour invalider un passeport
   public static void invaliderPasseport(String numeroPasseport) {
      Passport passport = passeportsDelivres.get(numeroPasseport);
      if (passport != null) {
         passport.invalider();
      }
   }

   // Verifier si le passport a toujours une date valide
   public static void isPassportExpired(String numeroPassport) {
      Passport passport = passeportsDelivres.get(numeroPassport);
      if (passport != null) {
         LocalDate expirationDate = passport.getDateExpiration();
         if (expirationDate.isBefore(LocalDate.now())) {
            System.out.println("\t" + checkMark + " Passport number "+passport.getNumero()+" is expired");
            passport.invalider();
         } else {
            System.out.println("\t" + checkMark + " This Passport still valid, the expiration date is : " + expirationDate);
         }

      } else {
         System.out.println("\t" + checkMark + " The Passport " + numeroPassport + " n'existe pas");
      }
   }

   // Méthode static pour prolonger un passeport
   public static void prolongerPasseport(String numeroPasseport, LocalDate nouvelleDate) {
      Passport passport = passeportsDelivres.get(numeroPasseport);
      if (passport != null) {
         passport.prolongerDateExpiration(nouvelleDate);
      }
   }

   // Méthode static pour generer des numero du passport aleatoirement
   public static String generateNumber() {
      String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
      Random rdm = new Random();
      StringBuilder sb = new StringBuilder(10);

      for (int i = 0; i < 10; i++) {
         int index = rdm.nextInt(characters.length());
         sb.append(characters.charAt(index));
      }

      return sb.toString();
   }

}