package codegym.vn.springusermodel.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("codegym.vn.springusermodel")
public class AppConfiguration implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");  // Thư mục chứa file JSP
        resolver.setSuffix(".jsp");             // Đuôi file
        resolver.setContentType("text/html; charset=UTF-8");
        resolver.setExposeContextBeansAsAttributes(true); // nếu muốn expose các bean trong JSP
        return resolver;
    }
}

