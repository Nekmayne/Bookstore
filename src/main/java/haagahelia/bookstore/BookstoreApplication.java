package haagahelia.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import haagahelia.bookstore.domain.Book;
import haagahelia.bookstore.domain.BookRepository;
import haagahelia.bookstore.domain.Category;
import haagahelia.bookstore.domain.CategoryRepository;
import haagahelia.bookstore.domain.User;
import haagahelia.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CategoryRepository cRepository, BookRepository repository, UserRepository uRepository) {
		return (args) -> {
			
			Category category1 = new Category("History");
			Category category2 = new Category("Fantasy");
			Category category3 = new Category("Sci-Fi");
			Category category4 = new Category("Action");
			Category category5 = new Category("Horror");
			
			cRepository.deleteAll();
			cRepository.save(category1);
			cRepository.save(category2);
			cRepository.save(category3);
			cRepository.save(category4);
			cRepository.save(category5);
		
			
			User user1 = new User("user", 
			"$2a$10$YL4Blc9I4hBe506GcqBFYeEWdAyvtP0pOBlKMgmgazt4hcPcGWqW6", "email", "USER");
			User user2 = new User("admin", 
			"$2a$10$AQAWFQlfwp95rf7kZCsd.eZXOk77CK1Jv8zQ.e8WfScGNzXF1NGMi", "email", "ADMIN");
			uRepository.deleteAll();
			uRepository.save(user1);
			uRepository.save(user2);

		};
	}

}
