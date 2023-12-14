package homework1.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ShopTest {

    /*
    1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов,
      верное содержимое корзины).
    2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
    3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
    */

    public homework1.task2.Shop shop;

    @BeforeEach
    public void init() {
        Product product1 = new Product();
        product1.setTitle("Milk");
        product1.setCost(58);

        Product product2 = new Product();
        product2.setTitle("Cheese");
        product2.setCost(250);

        Product product3 = new Product();
        product3.setTitle("Cracker");
        product3.setCost(120);

        List<Product> listProduct = new ArrayList<>();
        listProduct.add(product1);
        listProduct.add(product2);
        listProduct.add(product3);

        shop = new Shop();
        shop.setProducts(listProduct);
    }


    @Test
    @DisplayName("Проверка списка продуктов на пустоту")
    void emptyProducts () {
        assertFalse(shop.getProducts().isEmpty());
    }

    @Test
    @DisplayName("Список продуктов магазина содержит список продуктов")
    void productsProduct () {
        List<Product> arrProduct = new ArrayList<>();
        assertSame(shop.getProducts().getClass(), arrProduct.getClass());
    }

    @Test
    @DisplayName("Проверка метода сортировки")
    void checkSortProductsByPrice () {
        List<Product> products = shop.getProducts();
        List<Product> sortProducts = shop.sortProductsByPrice();
        products.sort(Comparator.comparingInt(Product::getCost));

        int[] costProducts = new int[products.size()];
        for (int i = 0; i < products.size(); i++) {
            costProducts[i] = products.get(i).getCost();
        }

        int[] costSortProducts = new int[sortProducts.size()];
        for (int i = 0; i < sortProducts.size(); i++) {
            costSortProducts[i] = sortProducts.get(i).getCost();
        }

        assertArrayEquals(costProducts, costSortProducts);
    }

    @Test
    @DisplayName("Проверка метода получения самого дорогого продукта")
    void checkGetMostExpensiveProduct () {
        List<Product> products = shop.getProducts();
        Product mostExpensive = shop.getMostExpensiveProduct();

        Product newMostExpensive = new Product();
        newMostExpensive.setTitle("");
        newMostExpensive.setCost(0);
        for (Product product : products) {
            if (product.getCost() > newMostExpensive.getCost()) {
                newMostExpensive = product;
            }
        }

        assertSame(mostExpensive, newMostExpensive);
    }
}
