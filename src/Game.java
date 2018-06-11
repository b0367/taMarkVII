public class Game {

    public static void verbCheck(Player player, Item item, Room room, String verb){

        switch(verb.toLowerCase()){

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

                for(int i = 0; i < player.inventory.length; i++){

                    if(player.inventory[i] == null){

                        player.inventory[i] = item;

                        for(int j = 0; j < room.getContents().length; j++){

                            if(room.getContents()[j].name.equals(" ")){

                                room.getContents()[j] = null;

                            }

                        }

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
