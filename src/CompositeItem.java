import java.util.ArrayList;
import java.util.List;

public class CompositeItem extends IndustrialSystem {

    private List<IndustrialSystem> items;
    
    public CompositeItem(){
        items = new ArrayList<>();
    }


    @Override
    public void add(IndustrialSystem is) throws IllegalAccessError {
        items.add(is);
    }

    @Override
    public void remove(IndustrialSystem is) throws IllegalAccessError {
        items.remove(is);

    }

    @Override
    public IndustrialSystem getChild(int i) throws IllegalAccessError {
        return items.get(i);
    }

    @Override
    public int getSize() throws IllegalAccessError {
        return items.size();
    }

}
