package haagahelia.bookstore;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import haagahelia.bookstore.domain.Book;
import haagahelia.bookstore.domain.BookRepository;
import haagahelia.bookstore.domain.Category;

@ExtendWith(SpringExtension.class)
@DataJpaTest

public class BookRepositoryTest {
	
	@Autowired
	private BookRepository repository;
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("Historian kirja");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Joonas Niskanen");
	}

	@Test
	public void createNewBook() {
		Book book = new Book("Joku kirja", "Hannu Hanhi", 2020, "121212-1212", new Category("Sci-Fi"));
		 repository.save(book);
		 assertThat(book.getId()).isNotNull();
	}
}
