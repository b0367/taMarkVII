public class Game {

    public static void doAction(Player player, Room room, String verb, String argument) {
        Item item = null;
        for (Item i : room.getContents()) {
            //if(item.getName() == argument){
            item = i;
            //}
        }
        switch (verb.toLowerCase()) {

            case "look":

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

            case "walk":
                //case "step":
                //case "move":
                //case "go":

                //north, south, east, west

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

                break;

            case "switch":

                break;

            case "smell":

                break;

            case "taste":

                break;

            case "listen":

                break;

            case "show":

                break;

            case "open":

                break;

            //player w/o object

            case "say":
                //when we get chat function
                break;

            case "sleep":

                break;

            case "sit":

                break;
        }

    }

}
