public class Item {

    String desc; //examine

    boolean grabable;

    public Item(String _desc, boolean _grabable){

        desc = _desc;
        grabable = _grabable;

    }

    public String getDesc() {
        return desc;
    }
}
