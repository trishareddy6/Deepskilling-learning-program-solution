import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // Step 1: Create a mock of ExternalApi
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Optional: Stub method if needed
        when(mockApi.getData()).thenReturn("Mock Data");

        // Step 2: Inject mock into service and call method
        MyService service = new MyService(mockApi);
        service.fetchData();

        // Step 3: Verify that getData() was called exactly once
        verify(mockApi).getData();
    }
}
