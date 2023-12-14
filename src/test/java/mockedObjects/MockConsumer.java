package mockedObjects;

import mockHelpers.MockBuffer;
import org.example.Consumer;
import org.example.Item;

public class MockConsumer implements Consumer {
    MockBuffer buffer;

    public MockConsumer(MockBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
    }

    public Item removeItem() {
        return buffer.remove();
    }

    @Override
    public void stopRunning() {

    }
}
