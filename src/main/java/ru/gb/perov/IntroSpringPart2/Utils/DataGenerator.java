package ru.gb.perov.IntroSpringPart2.Utils;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.gb.perov.IntroSpringPart2.Data.Product;
import ru.gb.perov.IntroSpringPart2.Data.Role;
import ru.gb.perov.IntroSpringPart2.Data.User;
import ru.gb.perov.IntroSpringPart2.Repository.ProductRepositiry;
import ru.gb.perov.IntroSpringPart2.Repository.RoleRepository;
import ru.gb.perov.IntroSpringPart2.Repository.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DataGenerator {
    private static final int NUMBER_START_PRODUCTS = 20;
    private static final int NUMBER_START_CUSTOMERS = 5;
    private static final int NUMBER_START_ORDERS = 15;
    private static final int NUMBER_START_ORDER_STRINGS = 100;
    private static final int NUMBER_START_USER = 3;


    private final ProductRepositiry productRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

//    @Autowired
//    private CustomerRepository customerRepository;
//    @Autowired
//    private OrderRepository orderRepository;
//    @Autowired
//    private OrderStringRepository orderStringRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void generateProductsOnStartUp() {
        Faker faker = new Faker();

//        Role r1 = new Role();
//        r1.setName("ADMIN");
//        roleRepository.saveAndFlush(r1);
//        Role r2 = new Role();
//        r2.setName("MANAGER");
//        roleRepository.saveAndFlush(r2);
//
//
//        for (int i = 1; i <= NUMBER_START_USER; i++) {
//            User u = new User();
//            u.setUsername("user" + i);
//            u.setPassword("password" + i);
//            ArrayList roles = new ArrayList<>(Collections.singleton(roleRepository.findByName("MANAGER")));
//            u.setRoles(roles);
//            userRepository.saveAndFlush(u);
//        }

        for (int i = 1; i <= NUMBER_START_PRODUCTS; i++) {
            Product p = new Product();
            p.setTitle(faker.food().ingredient());
            p.setPrice(faker.number().randomDouble(2, 1, 100));
            p.setCost(faker.number().randomDouble(2, 0, (int) (p.getPrice() + 1)));
            productRepository.saveAndFlush(p);
        }

//        for (int i = 1; i <= NUMBER_START_CUSTOMERS; i++) {
//            Customer c = new Customer();
//            c.setCustomerName(faker.name().fullName());
//            customerRepository.saveAndFlush(c);
//        }

//        for (int i = 1; i <= NUMBER_START_ORDERS; i++) {
//            Order o = new Order();
//            o.setDate(DateUtils.toCalendar(faker.date().between(new Date(new Date().getTime() - 1000L * 60 * 60 * 24 * 365), new Date())));
//            if (i <= NUMBER_START_CUSTOMERS) {
//                o.setCustomer(customerRepository.getReferenceById((long) i));
//            } else {
//                o.setCustomer(customerRepository.getReferenceById((long) (Math.random() * NUMBER_START_CUSTOMERS) + 1));
//            }
//            orderRepository.saveAndFlush(o);
//        }

//        for (int i = 1; i <= NUMBER_START_ORDER_STRINGS; i++) {
//            OrderString os = new OrderString();
//
//            if (i <= NUMBER_START_ORDERS) {
//                os.setOrder(orderRepository.getReferenceById((long) i));
//            } else {
//                os.setOrder(orderRepository.getReferenceById((long) (Math.random() * NUMBER_START_ORDERS + 1)));
//            }
//            os.setProduct(productRepository.getReferenceById((long) (Math.random() * NUMBER_START_PRODUCTS + 1)));
//            os.setOrderStringPrice((double) Math.round(Math.random() * 5000 + 25 * 100d) / 100d);
//            orderStringRepository.saveAndFlush(os);
//        }

        for (int i = 1; i <= NUMBER_START_CUSTOMERS; i++) {
            Product p = new Product();
            p.setTitle(faker.food().ingredient());
            p.setPrice(faker.number().randomDouble(2, 1, 100));
            p.setCost(faker.number().randomDouble(2, 0, (int) (p.getPrice() + 1)));
            productRepository.saveAndFlush(p);
        }

    }
}