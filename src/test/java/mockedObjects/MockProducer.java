package mockedObjects;

import mockHelpers.MockBuffer;
import org.example.Item;
import org.example.Producer;

public class MockProducer implements Producer {
    MockBuffer mockBuffer;
    static int id = 0;

    static int itemId = 0;
    public MockProducer(MockBuffer buffer){
        this.mockBuffer = buffer;
    }

    @Override
    public void run() {
    }

    public Item addItem(){
        itemId ++;
        Item item = new Item(String.valueOf(itemId));
        mockBuffer.add(item);
        return item;
    }

    public boolean addItem(Item item){
        return mockBuffer.add(item);
    }

    @Override
    public void stopRunning() {

    }
}
