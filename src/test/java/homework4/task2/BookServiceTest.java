package homework4.task2;

/*
У вас есть класс BookService, который использует интерфейс BookRepository для получения
информации о книгах из базы данных. Ваша задача написать unit-тесты для BookService,
используя Mockito для создания мок-объекта BookRepository.
*/

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {
    @Test
    void testFindBookByIdWithMockRepository() {
        // Создаем мок BookRepository
        BookRepository bookRepository = mock(BookRepository.class);
        // Создаем объект BookService, передавая ему мок BookRepository
        BookService bookService = new BookService(bookRepository);

        // Задаем ожидаемый результат
        String bookId = "1";
        String bookTitle = "Book1";
        String bookAuthor = "Author1";

        // Устанавливаем ожидание вызова метода findById с bookId и возвращаем ожидаемый объект Book
        when(bookRepository.findById(bookId)).thenReturn(new Book(bookId, bookTitle, bookAuthor));

        // Вызываем метод findBookById и проверяем, что результат соответствует ожиданиям
        Book checkBook = bookService.findBookById(bookId);
        assertEquals(bookTitle, checkBook.getTitle());
        assertEquals(bookAuthor, checkBook.getAuthor());

        // Проверяем, что метод findById был вызван ровно один раз с правильными аргументами
        verify(bookRepository, times(1)).findById(bookId);
    }

    @Test
    void testFindAllBooksWithMockRepository() {
        // Создаем мок BookRepository
        BookRepository bookRepository = mock(BookRepository.class);
        // Создаем объект BookService, передавая ему мок BookRepository
        BookService bookService = new BookService(bookRepository);

        // Задаем ожидаемый результат
        List<Book> listBook = new ArrayList<>();
        Book book1 = new Book("1", "Book1", "Author1");
        Book book2 = new Book("2", "Book2", "Author2");
        Book book3 = new Book("3", "Book3", "Author3");
        listBook.add(book1);
        listBook.add(book2);
        listBook.add(book3);

        // Устанавливаем ожидание вызова метода findAll и возвращаем ожидаемый объект List<Book>
        when(bookRepository.findAll()).thenReturn(listBook);

        // Вызываем метод findAllBooks и проверяем, что результат соответствует ожиданиям
        List<Book> checkListBook = bookService.findAllBooks();
        assertArrayEquals(listBook.toArray(), checkListBook.toArray());

        // Проверяем, что метод findAll был вызван ровно один раз с правильными аргументами
        verify(bookRepository, times(1)).findAll();
    }
}