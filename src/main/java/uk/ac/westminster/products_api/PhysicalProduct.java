// A PhysicalProduct IS-A Product because it inherits common properties & methods from Product.
// A ShoppingCart IS-NOT-A Product because it HAS-A-relationship with ShoppingCart rather than a type of Product.

package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product{
    private double weightKg;
    private String dimensions;

    public PhysicalProduct() {}

    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
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