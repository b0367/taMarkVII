import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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

    private static void run() {
        System.out.println(map.get(p1.y).get(p1.x).fullDesc());
        while (!input.equals("quit")) {

            input = s.nextLine();
            printManyTimes("\b", 200);
            System.out.flush();
            String[] inputList = input.split("\\s+", 2);
            if (inputList.length >= 2) {
                Game.doAction(p1, map.get(p1.y).get(p1.x), input.split("\\s+")[0], inputList[1]);
            } else {
                Game.doAction(p1, map.get(p1.y).get(p1.x), input.split("\\s+")[0], "");
            }
            System.out.println(map.get(p1.y).get(p1.x).fullDesc());
        }
    }
    public static void printManyTimes(String toPrint, int times){
        for(int i = 0; i < times; i++){
            System.out.print(toPrint);
        }
        System.out.println();
    }

}