package cn.zyj.zsblog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 37980
 */
@Configuration
public class FileConfig implements WebMvcConfigurer {

    @Value("${imagesPath}")
    private String imagePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/picture/img/**").addResourceLocations(imagePath);
    }
}
