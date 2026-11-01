package uk.ac.westminster.products_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // Get all products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get every product's summary in one call
    @GetMapping("/products/summaries")
    public List<String> getSummaries() {
        return productService.getAllSummaries();
    }

    // Get a product by ID
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id).orElse(null);
    }

    // Add a new product
    // Temporary: Product is abstract so Jackson cannot build it from JSON; use a concrete subclass for now (fixed properly in Lectures 6-7).
    @PostMapping("/products")
    public Product addProduct(@RequestBody DigitalProduct product) {
        return productService.addProduct(product);
    }

    // Delete a product by ID
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    // Search products by name
    @GetMapping("/products/search")
    public List<Product> search(@RequestParam String name) {
        return productService.findByName(name);
    }
}