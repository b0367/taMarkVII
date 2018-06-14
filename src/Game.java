import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Game {

    private static String input;

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        try {

            input = console.nextLine();

        } catch (Exception e) {

            System.out.println("Invalid Input");

        }

        String[] entries = input.split(" ");

        Objects.equals(entries[0], "say");

        //doAction( player, room found by player's x and y, entries[0], find stuff);

    }

    public static void doAction(Player player, Room room, String verb, String argument) {

        Item item = null;
        String[] argumentList = argument.split("\\s+");
        for (String anArgumentList : argumentList) {
            for (Item i : player.inventory) {
                if (i.getName().toLowerCase().equals(anArgumentList)) {
                    item = i;
                }
            }
        }


        switch (verb.toLowerCase()) {

            case "look": //done

                System.out.println(room.getDesc());

                break;

            case "examine": //done
            case "check":
            case "inspect":
            case "investigate":
            case "study":

                if (item == null) {
                    System.out.println("You have not provided an item.");
                    break;
                } else {
                    System.out.println(item.getDesc());
                }

                break;

            case "take": //done
            case "collect":
            case "grab":
            case "hold":
            case "pick up":
                Item invItem = null;
                for (Item i : room.getContents()) {
                    if (i.getName().toLowerCase().equals(item.name.toLowerCase())) {
                        invItem = i;
                    }
                }
                if (invItem != null) {
                    player.inventory.add(invItem);
                    room.contents[Arrays.asList(room.contents).indexOf(invItem)] = null;
                    System.out.println("You picked up the " + invItem.getName());
                }

                break;

            case "put": //unfinished
            case "insert":
            case "place":
            case "set":
            case "use":
                if (argument.split("\\s+").length == 3) {
                    if (!player.hasItem(Item.createBlankItem(argument.split("\\s+")[0]))) {
                        System.out.println("You do not have that item.");
                    } else {
                        for (int i = 0; i < room.getLocks().length; i++) {

                            try {
                                if (item != null && item.id.equals(room.getLocks()[i])) {

                                    room.getLocks()[i] = null;
                                    System.out.println("You have unlocked the door to the " + Room.directions.get(room.getDirs()[i]));

                                }

                            } catch (Exception e) {

                                System.out.println("You have no keys for the doors in this room!");

                            }
                        }
                    }
                } else {
                    System.out.println("Wrong number of arguments");
                }
                break;

            case "give": //need server stuffs (pull?)

                break;

            case "eat": //done
                try {
                    if (item.ables[2]) {

                        for (int i = 0; i < player.inventory.size(); i++) {

                            if (item.id.equals(player.inventory.get(i).id)) {

                                player.inventory.set(i, null);
                                System.out.println("You ate the " + item.name);

                            }

                        }

                    } else {
                        System.out.println("You can't eat the " + item.getName());
                    }
                } catch (NullPointerException e) {
                    System.out.println("You do not have that item.");
                }


                break;

            case "switch": //done

                if (item.onDesc == null && item.offDesc == null) {

                    System.out.println("You cannot switch the " + item.name + " on or off.");

                } else {

                    item.on = !item.on;

                }

                break;

            case "smell": //done
                if (item != null) {
                    System.out.println(item.smellDesc == "" || item.smellDesc == null ? "Doesn't smell like much" : item.smellDesc);
                } else {
                    System.out.println("You do not have that item.");
                }

                break;

            case "taste": //done
                if (item != null) {
                    System.out.println(item.tasteDesc == "" || item.tasteDesc == null ? "Doesn't taste like much" : item.tasteDesc);
                } else {
                    System.out.println("You do not have that item.");
                }
                break;

            case "listen": //done

                if (item.sound == null) {

                    System.out.println("You can hear no sound from the " + item.name);

                } else {

                    System.out.println(item.sound);

                }

                break;

            case "open": //done

                if (item != null && item.ables[4]) {

                    System.out.print("The " + item.name + " has inside a/an ");

                    for (int i = 0; i < item.contains.length; i++) {

                        System.out.print(item.contains[i].name + ", ");

                    }

                    System.out.println();

                    for (int j = 0; j < item.contains.length; j++) {

                        for (int l = 0; l < room.contents.length; l++) {

                            room.contents[j] = item.contains[j];

                        }

                    }

                } else {
                    System.out.println("That is not a valid item to open.");
                }

                break;

            //player w/o object

            case "sleep": //done

                System.out.println("You aren't tired.");

                break;

            case "sit": //done

                System.out.println("You are now sitting.");

                break;

            case "walk": //needs map
            case "step":
            case "move":
            case "go":

                switch (argument.toLowerCase()) {

                    case "n":
                        if (player.y >= 1) {

                            for (int i = 0; i < room.getDirs().length; i++) {

                                if (room.getDirs()[i].equals("n")) {

                                    if (room.getLocks()[i] == null) {

                                        player.y--;

                                    } else {

                                        System.out.println("Please Insert a Key.");

                                    }

                                }

                            }

                        } else {
                            System.out.println("You can't go that way.");
                        }
                        break;

                    case "s":
                        if (player.y < Main.map.size() - 1) {
                            try {
                                for (int i = 0; i < room.getDirs().length; i++) {

                                    if (room.getDirs()[i].equals("s")) {

                                        if (room.getLocks()[i] == null) {

                                            player.y++;

                                        } else {

                                            System.out.println("Please Insert a Key.");

                                        }

                                    }

                                }

                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("You can't go that way.");
                            }
                        } else {
                            System.out.println("You can't go that way.");
                        }
                        break;

                    case "e":
                        if (player.x < Main.map.get(player.y).size() - 1) {
                            for (int i = 0; i < room.getDirs().length; i++) {

                                if (room.getDirs()[i].equals("e")) {

                                    if (room.getLocks()[i] == null) {

                                        player.x++;

                                    } else {

                                        System.out.println("Please Insert a Key.");

                                    }

                                }

                            }
                        } else {
                            System.out.println("You can't go that way.");
                        }
                        break;

                    case "w":
                        if (player.x >= 1) {
                            for (int i = 0; i < room.getDirs().length; i++) {

                                if (room.getDirs()[i].equals("w")) {

                                    if (room.getLocks()[i] == null) {

                                        player.x--;

                                    } else {

                                        System.out.println("Please Insert a Key.");

                                    }

                                }

                            }
                        } else {
                            System.out.println("You can't go that way.");
                        }
                        break;

                }

                break;
            default:
                System.out.println("Unknown command");
                break;

        }

    }

}
