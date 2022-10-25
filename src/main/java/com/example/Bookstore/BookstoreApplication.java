package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;


@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book s1 = new Book("And Then There Were None", "Agatha Christie", "1939", "978-0062073488", 20.00);
			Book s2 = new Book("To Kill A Mockingbird", "Harper Lee", "1988", "978-0446310789", 15.99);
			Book s3 = new Book("The Boy in the Striped Pajamas", "John Boyne", "2006", "978-0385751063", 17.99);
			
			repository.save(s1);
			repository.save(s2);
			repository.save(s3);
		};
	}
}
