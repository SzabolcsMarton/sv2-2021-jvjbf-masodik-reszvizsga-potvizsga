package filemanipulation;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductFileManager {

    private List<Product> products = new ArrayList<>();

    public void readProductsFromFile(Path path) {
        try {
            addToProductsList(Files.readAllLines(path));
        } catch (IOException exception) {
            throw new IllegalStateException("Can't read file!", exception);
        }
    }

    public void writePriceOverToFile(Path path, int minPrice) {
        try {
            Files.write(path, getLinesOverPrice(minPrice));
        } catch (IOException exception) {
            throw new IllegalStateException("Can not write file");
        }
    }

    private List<String> getLinesOverPrice(int price) {
        return products
                .stream()
                .filter(product -> product.getPrice() > price)
                .map(Product::toString)
                .toList();
    }

    private void addToProductsList(List<String> lines) {
        lines.forEach(s -> {
            String[] parts = s.split(";");
            products.add(new Product(parts[0], parts[1], Integer.parseInt(parts[2])));
        });
    }

    public List<Product> getProducts() {
        return products;
    }

}