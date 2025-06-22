package codegym.vn.springusermodel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String account;
    private String password;
    private String name;
    private String email;
    private int age;
}
