package haagahelia.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import haagahelia.bookstore.domain.Book;
import haagahelia.bookstore.domain.BookRepository;
import haagahelia.bookstore.domain.Category;
import haagahelia.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CategoryRepository cRepository, BookRepository repository) {
		return (args) -> {
			
			Category category1 = new Category("History");
			Category category2 = new Category("Fantasy");
			Category category3 = new Category("Sci-Fi");
			Category category4 = new Category("Action");
			Category category5 = new Category("Horror");
			
			cRepository.save(category1);
			cRepository.save(category2);
			cRepository.save(category3);
			cRepository.save(category4);
			cRepository.save(category5);
			
			Book a = new Book("Historian kirja", "Joonas Niskanen", 2020, "1232323-21", category1);
			Book b = new Book("Fantasia kirja", "Pekka Pouta", 2020 , "2112343-5", category2);
			
			repository.save(a);
			repository.save(b);
		};
	}

}
