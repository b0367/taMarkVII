import java.util.Arrays;
import java.util.HashMap;

public class Room {

    public Item[] contents;
    private String[] dirs;
    private String[] locks;

    private String desc;
    public static final HashMap<String, String> directions = new HashMap<>();

    static {
        directions.put("w", "west");
        directions.put("n", "north");
        directions.put("s", "south");
        directions.put("e", "east");

    }

    public Room(Item[] contents, String desc, String[] dirs, String[] locks) {
        this.contents = contents;
        this.desc = desc;
        this.dirs = dirs;
        this.locks = locks;

    }

    public Item[] getContents() {
        return contents;
    }

    public void setContents(Item[] contents) {
        this.contents = contents;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String[] getDirs() {
        return dirs;
    }

    public void setDirs(String[] dirs) {
        this.dirs = dirs;
    }

    public String fullDesc() {
        String contentsStr;
        if (contents.length == 0) {
            contentsStr = "No visible items in the room.";
        } else {
            contentsStr = Arrays.toString(contents);
        }
        StringBuilder dirString = new StringBuilder();
        for(String d : dirs){
            dirString.append(directions.get(d));
        }
        return desc + "\n" + "The visible exits in this room are to the " + dirString + "\n" + contentsStr;
    }

    public String[] getLocks() {
        return locks;
    }

    public boolean leaveRoom(){



        return true;

    }
}
