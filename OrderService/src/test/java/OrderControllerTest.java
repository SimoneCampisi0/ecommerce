import com.ecommerce.OrderService.controller.OrderController;
import com.ecommerce.OrderService.model.Orders;
import com.ecommerce.OrderService.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = new ObjectMapper().writer();


    @Mock
    private OrderRepository repository;

    @InjectMocks
    private OrderController controller;

    Orders RECORD_1 = Orders.builder()
            .idOrders(1L)
            .costoTotale(10.0)
            .codCliente(1L)
            .build();

    Orders RECORD_2 = Orders.builder()
            .idOrders(2L)
            .costoTotale(20.0)
            .codCliente(2L)
            .build();

    Orders RECORD_3 = Orders.builder()
            .idOrders(3L)
            .costoTotale(30.0)
            .codCliente(3L)
            .build();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    //TODO: terminare implementazione test.
    //LINK: https://youtu.be/Xl9DnGlHpmc?si=5U82GtKcDoiBtguV
}
