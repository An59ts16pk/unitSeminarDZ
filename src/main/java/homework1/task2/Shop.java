package homework1.task2;

/*
 * Мы хотим улучшить функциональность нашего интернет-магазина.
 * Ваша задача - добавить два новых метода в класс Shop:
 * Метод sortProductsByPrice(), который сортирует список продуктов по стоимости.
 * Метод getMostExpensiveProduct(), который возвращает самый дорогой продукт.
 * Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов
 * (правильное количество продуктов, верное содержимое корзины).
 * Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
 * Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
 * Используйте класс Product для создания экземпляров продуктов и класс Shop для написания методов сортировки и тестов.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        // Допишите реализацию метода самостоятельно
        if (products == null || products.isEmpty()) {
            throw new IllegalArgumentException("Product list cannot be empty");
        };

        List<Product> sortedList = new ArrayList<>(products);
        sortedList.sort(Comparator.comparingInt(Product::getCost));
        return sortedList;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        // Допишите реализацию метода самостоятельно
        if (products == null || products.isEmpty()) {
            throw new IllegalArgumentException("Product list cannot be empty");
        }

        //Product mostExpensiveProduct = new Product();
        Product mostProduct = new Product();
        mostProduct.setTitle("");
        mostProduct.setCost(0);
        for (Product product : products) {
            if (product.getCost() > mostProduct.getCost()) {
                mostProduct = product;
            }
        }
        return mostProduct;
    }
}