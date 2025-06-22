package codegym.vn.springuploadfile.controller;

import codegym.vn.springuploadfile.model.Product;
import codegym.vn.springuploadfile.model.ProductForm;
import codegym.vn.springuploadfile.service.IProductService;
import codegym.vn.springuploadfile.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Value("${file-upload}")
    private String fileUpload;

    private final IProductService productService = new ProductService();

    @GetMapping("")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/index";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("productForm", new ProductForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute ProductForm productForm) {
        // Kiểm tra nếu file được chọn
        MultipartFile multipartFile = productForm.getImage();
        String fileName = null;

        if (!multipartFile.isEmpty()) {
            // Lấy tên file từ MultipartFile
            fileName = multipartFile.getOriginalFilename();

            try {
                // Lưu file vào thư mục
                FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        // Cập nhật tên file vào productForm (chỉ cập nhật tên file, không phải MultipartFile)
        // Sử dụng tên file đã lưu
        productForm.setImage(null);  // Đặt image thành null, vì đã lưu tên file, không cần MultipartFile nữa

        // Lưu sản phẩm vào cơ sở dữ liệu
        Product product = new Product(productForm.getId(), productForm.getName(),
                productForm.getDescription(), fileName);  // Sử dụng tên file để lưu vào Product
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        modelAndView.addObject("productForm", productForm);

        // Chuyển hướng về trang index sau khi lưu thành công
//        return "redirect:/product"; // Chuyển hướng về trang index
        return modelAndView;
    }


}
