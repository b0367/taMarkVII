import com.sun.deploy.util.StringUtils;

import java.util.Arrays;

public class Room {

    public Item[] contents;
    private String[] dirs;

    private String desc = "";

    public Room(Item[] contents, String desc, String[] dirs) {
        this.contents = contents;
        this.desc = desc;
        this.dirs = dirs;

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

    public String fullDesc(){
        String contentsStr = "";
        if(contents.length == 0) {
            contentsStr = "No visible items in the room.";
        }else{
            contentsStr = Arrays.toString(contents);
        }
        return desc + "\n" + StringUtils.join(Arrays.asList(dirs), ", ") + "\n" + contentsStr;
    }
}
