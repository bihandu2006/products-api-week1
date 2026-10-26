package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

@Service
public class ProductService {
    private Map<Long, Product> products = new HashMap<>();
    private Long nextId = 1L;

    // id, name, price properties came along with the Product class when extending to DigitalProduct & PhysicalProduct
    // Initialize two objects
    public ProductService() {
        products.put(nextId, new DigitalProduct(
                nextId++, "Clean Code (E-book)", 29.99,
                "/downloads/clean-code.pdf", 4.2));

        products.put(nextId, new PhysicalProduct(
                nextId++, "27-inch monitor", 249.99,
                5.4, "61cm x 41cm x 18cm"));
    }

    // Get all the product from Product List
    public List<Product> getAllProducts() {
        return new ArrayList<> (products.values());
    }

    // Insert each product in a JASON format
    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.put(product.getId(), product);
        return product;
    }

    // Search product using ID
    public Optional<Product> getProductById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    // Delete product using ID
    public void deleteProduct(Long id) {
        products.remove(id);
    }

    // Search product by referring product name
    public List <Product> findByName(String name) {
        return products.values().stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }

    // Search products less than the user entered price value
    public List<Product> findProductsBelowPrice(double price) {
        return products.values().stream()
                .filter(p -> p.getPrice() < (price))
                .toList();
    }

}
