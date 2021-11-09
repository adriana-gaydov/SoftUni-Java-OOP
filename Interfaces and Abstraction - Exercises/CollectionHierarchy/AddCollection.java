package CollectionHierarchy;

public class AddCollection extends Collection implements Addable{
    @Override
    public int add(String str) {
        super.getItems().add(str);
        return super.getItems().indexOf(str);
    }
}
