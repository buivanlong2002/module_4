package codegym.vn.productlist.controller;

import codegym.vn.productlist.model.Product;
import codegym.vn.productlist.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService;

    // Tiêm service vào thông qua constructor
    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    // Hiển thị danh sách sản phẩm
    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product-list"; // File HTML: product-list.html
    }

    // Hiển thị form thêm sản phẩm
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product(0L, "", 0, "", ""));
        return "product-form"; // File HTML: product-form.html (dùng cho thêm và sửa)
    }

    // Thêm sản phẩm mới
    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/products";
    }

    // Hiển thị form chỉnh sửa sản phẩm
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "product-form"; // Trả về form để sửa sản phẩm
        }
        return "redirect:/products"; // Nếu không tìm thấy sản phẩm, quay lại danh sách
    }

    // Cập nhật sản phẩm
    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
        // Đảm bảo sản phẩm được chỉnh sửa có ID đúng từ URL
        product.setId(id);
        productService.updateProduct(product);
        return "redirect:/products"; // Quay lại danh sách sản phẩm sau khi cập nhật
    }

    // Xóa sản phẩm
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }

    // Xem chi tiết sản phẩm
    @GetMapping("/details/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "product-details"; // File HTML: product-details.html
        }
        return "redirect:/products";
    }

    // Tìm kiếm sản phẩm theo tên
    @PostMapping("/search")
    public String searchProducts(@RequestParam(required = false) String name, Model model) {
        if (name == null || name.trim().isEmpty()) {
            model.addAttribute("products", productService.getAllProducts());
        } else {
            // Tìm kiếm sản phẩm theo tên
            List<Product> products = productService.searchProductsByName(name);

            // Kiểm tra xem có sản phẩm nào không
            if (products.isEmpty()) {
                model.addAttribute("message", "Không có sản phẩm nào được tìm thấy.");
            } else {
                model.addAttribute("products", products);
            }
        }
        return "product-search";
    }
}
