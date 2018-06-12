public class Room {

    public Item[] contents;
    private String[] dirs;

    private String desc;

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

}
