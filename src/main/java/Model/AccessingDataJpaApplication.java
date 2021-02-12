// I had a ton of trouble being able to pull the list of buddies into a view.  Aside from that everything works!


package Model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repository) {
        return (args) -> {
            // save a few customers
            AddressBook addressBook = new AddressBook();
            BuddyInfo buddy1 = new BuddyInfo("Jack", "613-250-2222");
            BuddyInfo buddy2 = new BuddyInfo("Chloe", "121-323-6456");
            addressBook.addBuddy(buddy1);
            addressBook.addBuddy(buddy2);
            repository.save(buddy1);
            repository.save(buddy2);
            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            BuddyInfo customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // for (Customer bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");
        };
    }
}
