import mockHelpers.MockItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
    private MockItem mockItem;

    @BeforeEach
    void setUp() {
        mockItem = new MockItem("1");
    }

    @DisplayName("Test constructor with valid lowercase ID")
    @Test
    void constructorValidLowercaseId() {
        MockItem mockItem1 = new MockItem("valid_id");
        assertEquals(mockItem1.getId(), "valid_id");
    }

    @DisplayName("Test constructor with valid mixed case ID")
    @Test
    void constructorValidMixedCaseId() {
        MockItem mockItem1 = new MockItem("Mixed Case");
        assertEquals(mockItem1.getId(), "mixed case");
    }

    @DisplayName("Test constructor with numbers")
    @Test
    void constructorNumbers() {
        MockItem mockItem1 = new MockItem("1234");
        assertEquals(mockItem1.getId(), "1234");
    }

    @DisplayName("Test constructor with valid uppercase ID")
    @Test
    void constructorValidUppercaseId() {
        MockItem mockItem1 = new MockItem("UPPERCASE");
        assertEquals(mockItem1.getId(), "uppercase");
    }

    @DisplayName("Test constructor with null ID")
    @Test
    void constructorNullId() {
        assertThrows(NullPointerException.class, () -> {
            MockItem mockItem1 = new MockItem(null);
        });
    }

    @DisplayName("Test constructor with empty ID")
    @Test
    void constructorEmptyId() {
        MockItem mockItem1 = new MockItem("");
        assertEquals(mockItem1.getId(), "");
    }

    @DisplayName("Test constructor with valid ID containing spaces")
    @Test
    void constructorValidIdWithSpaces() {
        mockItem.setId(" ID with Spaces ");
        assertEquals(mockItem.getId(), " id with spaces ");
    }

    @DisplayName("Test toString-method for default ID")
    @Test
    void toStringDefaultId() {
        assertEquals(mockItem.toString(), "1");
    }

    @DisplayName("Test setId-method for numbers")
    @Test
    void toStringNumbers() {
        mockItem.setId("1234");
        assertEquals(mockItem.toString(), "1234");
    }

    @DisplayName("Test setId-method for upper case")
    @Test
    void toStringUpperCase() {
        mockItem.setId("UPPERCASE");
        assertEquals(mockItem.toString(), "uppercase");
    }

    @DisplayName("Test setId-method for upper- and lower case mixed")
    @Test
    void toStringMixedCase() {
        mockItem.setId("Mixed Case");
        assertEquals(mockItem.toString(), "mixed case");
    }

    @DisplayName("Test toString-method after setting a new ID")
    @Test
    void toStringAfterSetId() {
        mockItem.setId("new_id");
        assertEquals(mockItem.toString(), "new_id");
    }

    @DisplayName("Test toString-method for empty ID")
    @Test
    void toStringEmptyId() {
        mockItem.setId("");
        assertEquals(mockItem.toString(), "");
    }

    @DisplayName("Test setId-method for null")
    @Test
    void setIdNull() {
        assertThrows(NullPointerException.class, () ->
                mockItem.setId(null));
    }

    @DisplayName("Test setId-method for empty string")
    @Test
    void setIdEmptyString() {
        mockItem.setId("");
        assertEquals(mockItem.getId(), "");
    }

    @DisplayName("Test setId-method for upper case")
    @Test
    void setIdUpperCase() {
        mockItem.setId("UPPERCASE");
        assertEquals(mockItem.getId(), "uppercase");
    }

    @DisplayName("Test setId-method for upper- and lower case mixed")
    @Test
    void setIdMixedCase() {
        mockItem.setId("Mixed Case");
        assertEquals(mockItem.getId(), "mixed case");
    }

    @DisplayName("Test setId-method for numbers")
    @Test
    void setIdNumbers() {
        mockItem.setId("1234");
        assertEquals(mockItem.getId(), "1234");
    }
}
