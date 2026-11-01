package uk.ac.westminster.products_api;

public class DigitalProduct extends Product implements Discountable {
    private String downloadUrl;
    private double fileSizeMB;
    private double discountedPrice;

    public DigitalProduct() {}

    public DigitalProduct(Long id, String name, double price, String downloadUrl, double fileSizeMB) {
        super(id, name, price);
        this.downloadUrl = downloadUrl;
        this.fileSizeMB = fileSizeMB;
        this.discountedPrice = price;
    }

    @Override
    public String getSummary() {
        return "Digital: " + getName() + " | Download: " + downloadUrl;
    }

    // Nothing is shipped, so the full rate applies.
    @Override
    public void applyDiscount(double rate) {
        this.discountedPrice = getPrice() * (1 - rate);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }

    // Get & return downloadUrl
    public String getDownloadUrl() {
        return downloadUrl;}
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;}

    // Get & return fileSizeMB
    public double getFileSizeMB() {
        return fileSizeMB;}
    public void setFileSizeMB(double fileSizeMB) {
        this.fileSizeMB = fileSizeMB;}

}