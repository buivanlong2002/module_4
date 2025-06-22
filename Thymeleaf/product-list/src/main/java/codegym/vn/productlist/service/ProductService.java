package codegym.vn.productlist.service;

import codegym.vn.productlist.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    private List<Product> products = new ArrayList<>();

    // Khởi tạo một số sản phẩm mẫu khi ứng dụng chạy
    public ProductService() {
        // Thêm một số sản phẩm mẫu
        products.add(new Product(1L, "Sản phẩm 1", 100, "Mô tả sản phẩm 1", "Nhà sản xuất A"));
        products.add(new Product(2L, "Sản phẩm 2", 200, "Mô tả sản phẩm 2", "Nhà sản xuất B"));
        products.add(new Product(3L, "Sản phẩm 3", 300, "Mô tả sản phẩm 3", "Nhà sản xuất C"));
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null); // Trả về null nếu không tìm thấy sản phẩm
    }

    @Override
    public void addProduct(Product product) {
        // Tạo id tự động cho sản phẩm mới (có thể thay bằng UUID hoặc auto-generated trong DB)
        product.setId((long) (products.size() + 1));  // Giả sử tăng dần id
        products.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(product.getId())) {
                products.set(i, product);  // Cập nhật sản phẩm
                return;
            }
        }
    }

    @Override
    public void deleteProduct(Long id) {
        products.removeIf(product -> product.getId().equals(id));  // Xóa sản phẩm theo id
    }

    @Override
    public List<Product> searchProductsByName(String name) {
        List<Product> result = new ArrayList<>();
        // Kiểm tra nếu tên rỗng hoặc null thì trả về tất cả sản phẩm
        if (name == null || name.trim().isEmpty()) {
            return products;
        }
        // Tìm kiếm sản phẩm có chứa chuỗi name (không phân biệt hoa/thường)
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

}
