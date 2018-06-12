import java.util.Scanner;

public class Game {

    public static void main(String[]args){



    }

    public static void doAction(Player player, Room room, String verb, String argument) {

        Item item = null;
        for (Item i : room.getContents()) {
            if(item.getName().equals(argument)) {
                item = i;
                }
            }

        switch (verb.toLowerCase()) {

            case "look":

                room.getDesc();

                break;

            case "examine":
                //case "check":
                //case "inspect":
                //case "investigate":
                //case "study":

                System.out.println(item.getDesc());

                break;

            case "take":
                //case "collect":
                //case "grab":
                //case "hold":
                //case "pick up":

                for (int i = 0; i < player.inventory.size(); i++) {

                    if (player.inventory.get(i) == null) {

                        player.inventory.set(i, item);


                    }

                }

                break;

            case "put":
                //case "insert":
                //case "place":
                //case "set":
                //case "use":

                //use object in another

                break;

            case "give":

                break;

            case "eat":

                if(item.ables[2]){

                    for(int i = 0; i < player.inventory.size(); i++){

                        if(item.id == player.inventory.get(i).id){

                            player.inventory.set(i,null);
                            System.out.println("You ate the " + item.name);

                        }

                    }

                }

                break;

            case "switch":

                break;

            case "smell":

                System.out.println(item.smellDesc);

                break;

            case "taste":

                System.out.println(item.tasteDesc);

                break;

            case "listen":

                if(item.sound == null){

                    System.out.println("You can hear no sound from the " + item.name);

                }
                else{

                    System.out.println(item.sound);

                }

                break;

            case "open":

                if(item.ables[4]){

                    System.out.print("The " + item.name + " has inside a/an ");

                    for(int i = 0; i < item.contains.length; i++){

                        System.out.print(item.contains[i].name + ", ");

                    }

                    System.out.println();

                }

                break;

            //player w/o object

            case "say":

                //when we get chat function



                break;

            case "sleep":

                break;

            case "sit":

                break;

            case "walk":
                //case "step":
                //case "move":
                //case "go":

                switch (argument.toLowerCase()){

                    case "north":

                        break;

                    case "south":

                        break;

                    case "east":

                        break;

                    case "west":

                        break;

                }

                break;

        }

    }

}
