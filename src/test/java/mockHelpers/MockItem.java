package mockHelpers;

import org.example.Item;


public class MockItem extends Item {

    public MockItem(String id) {
        super(id);
    }

    public String getId(){
        return super.id;
    }
}
