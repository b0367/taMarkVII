import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Player p1 = new Player();
    static ArrayList<ArrayList<Room>> map = new ArrayList<>();
    static Scanner s = new Scanner(System.in);

    public static void main(String args[]) {
        initialize2();
        try {
            run2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initialize() {
        Room[] line = {new Room(new Item[]{new Item("A1","key","A simple iron key.", "Doesn't smell like much", "", "", "", "", false, true, true, false, false, false)},"room number 1", new String[]{"e"}, new String[] {"A1"}), new Room(new Item[]{}, "room number 2", new String[]{"w"},new String[] {null})};
        map.add(new ArrayList<>(Arrays.asList(line)));
    }

    static String input = "";

    private static void run() throws IOException, InterruptedException {
        System.out.println(map.get(p1.y).get(p1.x).fullDesc());
        while (!input.equals("quit")) {

            input = s.nextLine();
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            String[] inputList = input.split("\\s+", 2);
            if (inputList.length >= 2) {
                Game.doAction(p1, map.get(p1.y).get(p1.x), input.split("\\s+")[0], inputList[1]);
            } else {
                Game.doAction(p1, map.get(p1.y).get(p1.x), input.split("\\s+")[0], "");
            }
            System.out.println(map.get(p1.y).get(p1.x).fullDesc());
        }
    }

    public static void initialize2() {
        Room[] line = new Room[]{new Room(new Item[]{ new Item("A1", "Red key", "A small key painted red.", "Smells Like Paint", "Tastes like paint", "Doesn't sound like much.", "a", "a", false, true, true, false, false, false), new Item("A2", "Blue Key", "A blue key.", "A small hint of paint is smelled.", "Tastes faintly like iron.", "You hear nothing from the key.", "a", "a", false, true, true, false, false, false)
        }, "A decent sized room with an exit on the east wall.", new String[]{"e"}, new String[]{"A1"}), new Room(new Item[]{}, "A giant room with lots of loot.", new String[]{"e", "s", "w"}, new String[]{null,"A2",null})};
        map.add(new ArrayList<>(Arrays.asList(line)));
    }

    private static void run2() throws IOException, InterruptedException {
        System.out.println(map.get(p1.y).get(p1.x).fullDesc());
        while (!input.equals("quit")) {

            input = s.nextLine();
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            String[] inputList = input.split("\\s+", 2);
            if (inputList.length >= 2) {
                Game.doAction(p1, map.get(p1.y).get(p1.x), input.split("\\s+")[0], inputList[1]);
            } else {
                Game.doAction(p1, map.get(p1.y).get(p1.x), input.split("\\s+")[0], "");
            }
            System.out.println(map.get(p1.y).get(p1.x).fullDesc());
        }
    }

}