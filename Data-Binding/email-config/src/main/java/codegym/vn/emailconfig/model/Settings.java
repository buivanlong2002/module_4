package codegym.vn.emailconfig.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Settings {
    private String language;
    private int pageSize;
    private boolean spamFilter;
    private String signature;
}

