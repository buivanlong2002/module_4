package codegym.vn.springuploadfile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductForm {
    private int id;
    private String name;
    private String description;
    private MultipartFile image;
}
