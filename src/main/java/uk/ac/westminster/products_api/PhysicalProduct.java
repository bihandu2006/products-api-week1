// A PhysicalProduct IS-A Product because it inherits common properties & methods from Product.
// A ShoppingCart IS-NOT-A Product because it HAS-A-relationship with ShoppingCart rather than a type of Product.

package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product implements Discountable {
    private double weightKg;
    private String dimensions;
    private double discountedPrice;

    public PhysicalProduct() {}

    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
        this.discountedPrice = price;
    }

    @Override
    public String getSummary() {
        return "Physical: " + getName() + " | Weight: " + weightKg + "kg";
    }

    // Shipping is never discounted, so the discount is capped at 20%.
    @Override
    public void applyDiscount(double rate) {
        double capped = Math.min(rate, 0.20);
        this.discountedPrice = getPrice() * (1 - capped);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }

    // Get & return weightKg
    public double getWeightKg() {
        return weightKg;}
    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;}

    // Get & return dimensions
    public String getDimensions() {
        return dimensions;}
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;}
}