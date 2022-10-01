package product.Manager.service;

import product.Manager.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
        private static final ArrayList<Product> products = new ArrayList<>();

        static {
            products.add(new Product(1,"samsung",1000,"samsung galaxy","samsung"));
            products.add(new Product(2,"iphone",900,"iphone 13-pro","apple"));
            products.add(new Product(3,"iphone",800,"iphone 12","apple"));
            products.add(new Product(4,"iphone",800,"iphone 12","apple"));
            products.add(new Product(5,"iphone",400,"iphone 10","apple"));
        }




    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.add(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productsFounded = new ArrayList<>();
        for (Product product: products) {
                if (product.getName().equals(name)) {
                    productsFounded.add(product);
                }
        }
        return productsFounded;
    }
}
