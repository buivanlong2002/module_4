package codegym.vn.productlist.service;

import codegym.vn.productlist.model.Product;
import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Long id);
    List<Product> searchProductsByName(String name);
}
