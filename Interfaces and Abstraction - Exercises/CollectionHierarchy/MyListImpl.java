package CollectionHierarchy;

public class MyListImpl extends Collection implements MyList{
    @Override
    public String remove() {
        return super.getItems().remove(0);
    }

    @Override
    public int add(String str) {
        super.getItems().add(0, str);
        return 0;
    }

    @Override
    public int getUsed() {
        return super.getItems().size();
    }
}
