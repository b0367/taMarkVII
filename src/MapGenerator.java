import java.util.Scanner;

public class MapGenerator {
    public static String makeItem() {
        String retString = "new Item(";
        Scanner s = new Scanner(System.in);
        System.out.println("id:");
        retString += "" + s.nextLine() + "" + ", ";
        System.out.println("name:");
        retString += "" + s.nextLine() + "" + ", ";
        System.out.println("desc:");
        retString += "" + s.nextLine() + "" + ", ";
        System.out.println("Smell desc:");
        retString += "" + s.nextLine() + "" + ", ";
        System.out.println("Taste desc:");
        retString += "" + s.nextLine() + "" + ", ";
        System.out.println("sound:");
        retString += "" + s.nextLine() + "" + ", ";
        System.out.println("on desc:");
        retString += "" + s.nextLine() + "" + ", ";
        System.out.println("off desc:");
        retString += "" + s.nextLine() + "" + ", ";
        System.out.println("on:");
        retString += s.nextLine() + ", ";
        System.out.println("grabable:");
        retString += s.nextLine() + ", ";
        System.out.println("insertable:");
        retString += s.nextLine() + ", ";
        System.out.println("edible:");
        retString += s.nextLine() + ", ";
        System.out.println("switchable:");
        retString += s.nextLine() + ", ";
        System.out.println("openable:");
        retString += s.nextLine() + ")";
        return retString;
    }

    public static void main(String[] args) {
        System.out.println(makeItem());
    }
}