import mockHelpers.MockBuffer;
import mockHelpers.MockItem;

import mockedObjects.MockConsumer;
import mockedObjects.MockProducer;
import org.example.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


class BufferTest {

    private MockBuffer mockBuffer;
    private MockProducer mockProducer;
    private MockConsumer mockConsumer;

    @BeforeEach
    void setUp() {
        mockBuffer = new MockBuffer();
        mockProducer = new MockProducer(mockBuffer);
        mockConsumer = new MockConsumer(mockBuffer);
    }

    @DisplayName("Make sure that items are stored in buffer")
    @Test
    void addCheckItemIsAdded() {
        assertTrue(mockBuffer.isBufferEmpty());
        mockProducer.addItem();
        assertFalse(mockBuffer.isBufferEmpty());
    }

    @DisplayName("Adding 3 items using producer thread")
    @Test
    void addCheckItemsAreAdded() {
        assertTrue(mockBuffer.isBufferEmpty());
        mockProducer.addItem();
        mockProducer.addItem();
        mockProducer.addItem();
        assertEquals(3, mockBuffer.getBufferSize());
    }

    @DisplayName("Control that buffer is being printed")
    @Test
    void addPrints() {
        assertTrue(mockBuffer.isBufferEmpty());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        MockItem mockItem = new MockItem("1");
        mockProducer.addItem(mockItem);
        System.setOut(System.out);
        String consoleOutput = outputStream.toString();
        assertTrue(consoleOutput.contains(mockItem.toString()));
        System.setOut(originalOut);
    }

    @DisplayName("Checks that the add-method successfully return true")
    @Test
    void addVerifyTrue() {
        assertTrue(mockProducer.addItem(new MockItem("test")));
    }

    @DisplayName("Shows that its possible to add item with null value to buffer")
    @Test
    void addItemWithNullValue() {
        assertTrue(mockBuffer.isBufferEmpty());
        mockProducer.addItem(null);
        assertEquals(mockBuffer.getBufferSize(), 1);
    }

    @DisplayName("Testing that first in first out principle works")
    @Test
    void removeFIFO() {
        MockItem mockedItem1 = new MockItem("1");
        MockItem mockedItem2 = new MockItem("2");
        assertTrue(mockProducer.addItem(mockedItem1));
        assertTrue(mockProducer.addItem(mockedItem2));
        Item removedItem = mockConsumer.removeItem();
        assertEquals(mockedItem1, removedItem);
    }

    @DisplayName("Control that wait sets affected threads in waiting state")
    @Test
    void removeWait() throws InterruptedException {
        assertTrue(mockBuffer.isBufferEmpty());
        Thread mockConsumerThread = new Thread(() -> {
            mockConsumer.removeItem();
        });
        mockConsumerThread.start();
        Thread.sleep(100);
        assertEquals(Thread.State.WAITING, mockConsumerThread.getState());
    }

    @DisplayName("Check that interrupted exception is being throws when a waiting thread is being interrupted")
    @Test
    void removeInterruptWaitingThread() throws InterruptedException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setErr(new PrintStream(outputStream));
        assertTrue(mockBuffer.isBufferEmpty());
        Thread mockConsumerThread = new Thread(() -> {
            assertThrows(InterruptedException.class, () -> mockConsumer.removeItem());
        });
        mockConsumerThread.start();
        Thread.sleep(100);
        mockConsumerThread.interrupt();
        String errorMessage = outputStream.toString();
        assertTrue(errorMessage.contains("InterruptedException"));
        System.setErr(System.err);
    }

    @DisplayName("Control that remove-method throws NoSuchElementException when the waiting thread is interrupted with a empty buffer")
    @Test
    void removeNoSuchElementException() throws InterruptedException {
        assertTrue(mockBuffer.isBufferEmpty());
        Thread interruptThread = new Thread(() -> {
            try {
                assertThrows(NoSuchElementException.class, () -> mockConsumer.removeItem());
            } catch (Exception e) {
                System.out.println(e);
            }
        });
        interruptThread.start();
        Thread.sleep(100);
        interruptThread.interrupt();
    }

    @DisplayName("Control that item is being removed")
    @Test
    void removeItemRemoved() {
        mockProducer.addItem();
        assertEquals(1, mockBuffer.getBufferSize());
        mockConsumer.removeItem();
        assertEquals(0, mockBuffer.getBufferSize());
    }

    @DisplayName("Control that remove method returns an Item")
    @Test
    void removeReturn() {
        assertEquals(mockProducer.addItem(), mockConsumer.removeItem());
    }
}
