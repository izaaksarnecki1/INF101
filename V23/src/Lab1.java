import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Lab1 {

    private static void Lab1Task1() {
        System.out.println("Hei, det er meg, datamaskinen.");
        System.out.println("Hyggelig å se deg her.");
        System.out.println("Lykke til med INF101!");
    }

    private static void Lab1Task2() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hva er ditt navn?");
        String name = scanner.nextLine();
        System.out.println("Hva er din adresse?");
        String adr = scanner.nextLine();
        System.out.println("Hva er ditt postnummer og poststed?");
        String postOgSted = scanner.nextLine();

        System.out.println(name + "s adresse er: ");
        System.out.println('\n' + name);
        System.out.println(adr);
        System.out.println(postOgSted);
    }

    private

    public static void main(String[] args) {
//        Lab1Task1();
//        Lab1Task2();


    }
}
