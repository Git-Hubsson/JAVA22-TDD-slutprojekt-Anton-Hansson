package mockHelpers;

import org.example.Buffer;
import org.example.Item;

import java.util.Queue;

public class MockBuffer extends Buffer {

    public Queue<Item> getBuffer() {
        return super.buffer;
    }

    public boolean isBufferEmpty() {
        return getBuffer().isEmpty();
    }


    public int getBufferSize() {
        return getBuffer().size();
    }
}
