public class Item {

    String name;
    int id;

    String desc; //examine
    String smellDesc;
    String tasteDesc;
    String sound;

    //takeable, insertable, edible, switchable, openable
    boolean[] ables = new boolean[5];

    Item[] contains;

    public Item(String _desc, String _smellDesc, String _tasteDesc, String _sound, boolean _grabable, boolean _insertable, boolean _edible, boolean _switchable, boolean _openable){

        desc = _desc;
        smellDesc = _smellDesc;
        tasteDesc = _tasteDesc;
        sound = _sound;

        ables[0] = _grabable;
        ables[1] = _insertable;
        ables[2] = _edible;
        ables[3] = _switchable;
        ables[4] = _openable;

    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }

    public void addContains(Item entry) {

        for(int i = 0; i < contains.length;  i++){

            if(contains[i] == null){

                contains[i] = entry;

            }

        }

    }
}
