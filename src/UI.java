public class UI {

    public static void welcome() {
        // Welcoming Message
        System.out.println("*".repeat(100));
        System.out.println(">> Bienvenue dans le programme de gestion de passeports et de visas (NADIRLAGNADI)");
        System.out.println(">> Vous serez guidé à travers plusieurs étapes pour entrer les informations nécessaires.");
        System.out.println(">> Veuillez suivre les instructions et entrer les données au format demandé.");
        System.out.println("*".repeat(100));

    }

    public static void createPassport() {
        System.out.println("\n>>>>> Demande de passeport :");
        System.out.print("\tEntrez la date de délivrance (yyyy-mm-dd) : ");
    }

    public static void createVisa() {
        System.out.println("\n>>>>> Demande de visa :");
        System.out.print("\tEntrez le type de visa | Student | Visitor | Work | : ");
    }

    public static void extendVisa() {
        System.out.println("\n>>>>> Simulation de prolongation de visa :");
        System.out.print("\tEntrez la nouvelle date d'expiration (yyyy-mm-dd) : ");
    }

    public static void extendPassport() {
        System.out.println("\n>>>>> Simulation de prolongation de passeport :");
        System.out.print("\tEntrez la nouvelle date d'expiration (yyyy-mm-dd) : ");
    }


}
