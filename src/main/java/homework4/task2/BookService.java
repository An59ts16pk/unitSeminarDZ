package homework4.task2;

/*
У вас есть класс BookService, который использует интерфейс BookRepository для получения
информации о книгах из базы данных. Ваша задача написать unit-тесты для BookService,
используя Mockito для создания мок-объекта BookRepository.
*/

import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findBookById(String id) {
        return bookRepository.findById(id);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
}
