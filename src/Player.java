import java.util.ArrayList;

public class Player {

    int x;
    int y;

    ArrayList<Item> inventory = new ArrayList<>();
    public boolean hasItem(Item item){
        for(Item i : inventory){
            if(i.getName().equals(item.getName())){
                return true;
            }

        }
        return false;
    }

}
