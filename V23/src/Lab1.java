import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

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
        scanner.close();
    }

    private static void findLongestWord(String word1, String word2, String word3) {
        int len1 = word1.length();
        int len2 = word2.length();
        int len3 = word3.length();
        ArrayList<Integer> wordLengths = new ArrayList<>(Arrays.asList(len1, len2, len3));
        Integer maxLen = wordLengths.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);

        if (Objects.equals(len1, maxLen)) {
            System.out.println(word1);
        }
        if (Objects.equals(len2, maxLen)) {
            System.out.println(word2);
        }
        if (Objects.equals(len3, maxLen)) {
            System.out.println(word3);
        }
    }

    private static boolean isLeapYear(int year) {
        if (year % 100 == 0 && year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else return year % 4 == 0;
    }

    private static boolean isEvenPositiveInt(int num) {
        return num >= 0 && num % 2 ==0;
    }

    private static void multiplesOfSeven(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 7 == 0) {
                System.out.println(i);
            }
        }
    }

    private static void multiplicationTable(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(i + ": ");
            for (int j = 1; j <= n; j++) {
                System.out.print(i*j + " ");
            }
            System.out.println();
        }
    }

    private static int crossSum(int n) {
        int crossSum = 0;
        String s = Integer.toString(n);
        ArrayList<String> a = new ArrayList<>(Arrays.asList(s.split("")));
        for (String s1 : a) {
            crossSum += Integer.parseInt(s1);
        }
        return crossSum;
    }

    private static ArrayList<Integer> removeThrees(ArrayList<Integer> list) {
        ArrayList<Integer> ret = new ArrayList<>();
        for (Integer i : list) {
            if (i != 3) {
                ret.add(i);
            }
        }
        return ret;
    }

    private static ArrayList<Integer> uniqueValues(ArrayList<Integer> list) {
        ArrayList<Integer> ret = new ArrayList<>();
        for (Integer s : list) {
            if (!ret.contains(s)){
                ret.add(s);
            }
        }
        return ret;
    }

    private static void addList(ArrayList<Integer> a, ArrayList<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            a.set(i, a.get(i) + b.get(i));
        }
    }

    private static void removeRow(ArrayList<ArrayList<Integer>> grid, int row) {
        grid.remove(row);
    }

    private static boolean allRowsAndColsAreEqualSum(ArrayList<ArrayList<Integer>> grid) {
        int sum = 0;
        for (Integer dig : grid.get(0)) {
            sum += dig;
        }

        for (int i = 1; i < grid.size(); i++) {
            int temp = 0;
            System.out.println(grid.get(i));
            for (int j = 0; j < grid.get(i).size(); j++) {
                temp += grid.get(i).get(j);
            }
            System.out.println(temp);
            if (temp != sum) {
                return false;
            }
        }
        return true;
    }

    private static void run() {
        Scanner scanner = new Scanner(System.in);
        int round = 1;
        int humanScore = 0;
        int computerScore = 0;
        boolean play = true;
        List<String> choices = Arrays.asList("scissors", "paper", "rock");
        while (play) {
            System.out.println("Let's play round " + round);
            String input = "";
            while (true) {
                System.out.println("Your choice (Rock/Paper/Scissors)? ");
                input = scanner.nextLine().toLowerCase();
                if (!choices.contains(input)) {
                    System.out.println("I do not understand " + input + ". Could you try again?");
                } else break;
            }

            Random rand = new Random();
            String computerChoice = choices.get(rand.nextInt(choices.size()));
            String outcome = play(input, computerChoice);

            System.out.print("Human chose " + input + ", computer chose " + computerChoice + ".");
            if (outcome.equals("t")) {
                System.out.println("It's a tie! ");
            } else if (outcome.equals("w")) {
                humanScore++;
                System.out.println("Human wins!");
            } else {
                computerScore++;
                System.out.println("Computer wins!");
            }
            round++;
            System.out.println("Score: human " + humanScore + ", computer " + computerScore);
            System.out.println("Do you wish to continue playing (y/n)?");
            String playContinue = scanner.nextLine().toLowerCase();
            if (playContinue.equals("n")) {
                play = false;
            }
        }
        System.out.println("bye bye");
        scanner.close();
    }

    public static String play(String input, String computer) {
        if (input.equals(computer)) {
            return "t";
        } else if ((input.equals("rock") && computer.equals("scissors"))
                || input.equals("scissors") && computer.equals("paper")) {
            return "w";
        } else return "l";
    }

    public static void main(String[] args) {
        // Lab 1
//        Lab1Task1();
//        Lab1Task2();
        // Lab 2
//        findLongestWord("Game", "Action", "Champion");
//        findLongestWord("apple", "carrot", "ananas");
//        findLongestWord("Four", "Five", "Nine");
//        boolean leapYear1 = isLeapYear(2022);
//        System.out.println(leapYear1); // false
//        boolean leapYear2 = isLeapYear(1996);
//        System.out.println(leapYear2); // true
//        boolean leapYear3 = isLeapYear(1900);
//        System.out.println(leapYear3); // false
//        boolean leapYear4 = isLeapYear(2000);
//        System.out.println(leapYear4); // true
//        boolean evenPositive1 = isEvenPositiveInt(123456);
//        System.out.println(evenPositive1); // true
//        boolean evenPositive2 = isEvenPositiveInt(-2);
//        System.out.println(evenPositive2); // false
//        boolean evenPositive3 = isEvenPositiveInt(123);
//        System.out.println(evenPositive3); // false
        // Lab 3
//        multiplesOfSeven(49);
//        multiplicationTable(5);
//        System.out.println(crossSum(4321));
        // Lab 5
//        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
//        ArrayList<Integer> arrayList1 = new ArrayList<>(list1);
//        ArrayList<Integer> removedList1 = removeThrees(arrayList1);
//        System.out.println(removedList1); // [1, 2, 4]
//        List<Integer> list2 = Arrays.asList(1, 2, 3, 3);
//        ArrayList<Integer> arrayList2 = new ArrayList<>(list2);
//        ArrayList<Integer> removedList2 = removeThrees(arrayList2);
//        System.out.println(removedList2); // [1, 2]
//        List<Integer> list3 = Arrays.asList(3, 3, 1, 3, 2, 4, 3, 3, 3);
//        ArrayList<Integer> arrayList3 = new ArrayList<>(list3);
//        ArrayList<Integer> removedList3 = removeThrees(arrayList3);
//        System.out.println(removedList3); // [1, 2, 4]
//        List<Integer> list4 = Arrays.asList(3, 3);
//        ArrayList<Integer> arrayList4 = new ArrayList<>(list4);
//        ArrayList<Integer> removedList4 = removeThrees(arrayList4);
//        System.out.println(removedList4); // []
//        List<Integer> list1 = Arrays.asList(1, 1, 2, 1, 3, 3, 3, 2);
//        ArrayList<Integer> arrayList1 = new ArrayList<>(list1);
//        ArrayList<Integer> removedList1 = uniqueValues(arrayList1);
//        System.out.println(removedList1); // [1, 2, 3]
//        List<Integer> list2 = Arrays.asList(4, 4, 4, 4, 4, 4, 4, 4, 4, 5);
//        ArrayList<Integer> arrayList2 = new ArrayList<>(list2);
//        ArrayList<Integer> removedList2 = uniqueValues(arrayList2);
//        System.out.println(removedList2); // [4, 5]
//        ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(1, 2, 3));
//        ArrayList<Integer> b1 = new ArrayList<>(Arrays.asList(4, 2, -3));
//        addList(a1, b1);
//        System.out.println(a1); // [5, 4, 0]
//        ArrayList<Integer> a2 = new ArrayList<>(Arrays.asList(1, 2, 3));
//        ArrayList<Integer> b2 = new ArrayList<>(Arrays.asList(47, 21, -30));
//        addList(a2, b2);
//        System.out.println(a2); // [48, 23, -27]
//        ArrayList<ArrayList<Integer>> grid1 = new ArrayList<>();
        // Lab 7
//        grid1.add(new ArrayList<>(Arrays.asList(11, 12, 13)));
//        grid1.add(new ArrayList<>(Arrays.asList(21, 22, 23)));
//        grid1.add(new ArrayList<>(Arrays.asList(31, 32, 33)));
//
//        removeRow(grid1, 0);
//        for (int i = 0; i < grid1.size(); i++) {
//            System.out.println(grid1.get(i));
//        }
//// [21, 22, 23]
//// [31, 32, 33]
//
//        ArrayList<ArrayList<Integer>> grid2 = new ArrayList<>();
//        grid2.add(new ArrayList<>(Arrays.asList(11, 12, 13)));
//        grid2.add(new ArrayList<>(Arrays.asList(21, 22, 23)));
//        grid2.add(new ArrayList<>(Arrays.asList(31, 32, 33)));
//
//        removeRow(grid2, 1);
//        for (int i = 0; i < grid2.size(); i++) {
//            System.out.println(grid2.get(i));
//        }
//// [11, 12, 13]
//// [31, 32, 33]
//        ArrayList<ArrayList<Integer>> grid1 = new ArrayList<>();
//        grid1.add(new ArrayList<>(Arrays.asList(3, 0, 9)));
//        grid1.add(new ArrayList<>(Arrays.asList(4, 5, 3)));
//        grid1.add(new ArrayList<>(Arrays.asList(6, 8, 1)));
//        boolean equalSums1 = allRowsAndColsAreEqualSum(grid1);
//        System.out.println(equalSums1); // false
//        ArrayList<ArrayList<Integer>> grid2 = new ArrayList<>();
//        grid2.add(new ArrayList<>(Arrays.asList(3, 4, 6)));
//        grid2.add(new ArrayList<>(Arrays.asList(0, 5, 8)));
//        grid2.add(new ArrayList<>(Arrays.asList(9, 3, 1)));
//        boolean equalSums2 = allRowsAndColsAreEqualSum(grid2);
//        System.out.println(equalSums2); // true
//        ArrayList<ArrayList<Integer>> grid3 = new ArrayList<>();
//        grid3.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
//        grid3.add(new ArrayList<>(Arrays.asList(2, 3, 4, 1)));
//        grid3.add(new ArrayList<>(Arrays.asList(3, 4, 1, 2)));
//        grid3.add(new ArrayList<>(Arrays.asList(4, 1, 2, 3)));
//        boolean equalSums3 = allRowsAndColsAreEqualSum(grid3);
//        System.out.println(equalSums3); // true
        // Ekstra
        run();





    }
}
