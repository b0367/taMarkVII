import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Player p1 = new Player();
    static ArrayList<ArrayList<Room>> map = new ArrayList<>();
    static Scanner s = new Scanner(System.in);

    public static void main(String args[]) {
        initialize();
        run();
    }

    public static void initialize() {
        Room[] line = {new Room(new Item[]{new Item("key","A simple iron key.", "Doesn't smell like much", "", "", "", "", false, true, true, false, false, false)}, "room number 1", new String[]{"e"}), new Room(new Item[]{}, "room number 2", new String[]{"w"})};
        map.add(new ArrayList<>(Arrays.asList(line)));

    }

    static String input = "";

    public static void run() {
        while (!input.equals("quit")) {
            input = s.nextLine();
            String[] inputList = input.split("\\s+");
            if (inputList.length >= 2) {
                Game.doAction(p1, map.get(p1.y).get(p1.x), input.split("\\s+")[0], input.split("\\s+")[1]);
            } else {
                Game.doAction(p1, map.get(p1.y).get(p1.x), input.split("\\s+")[0], "");
            }
        }
    }

}