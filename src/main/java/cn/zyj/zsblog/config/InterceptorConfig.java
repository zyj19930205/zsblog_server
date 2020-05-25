package cn.zyj.zsblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 37980
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/**");
    }

    /**
     * 自定义拦截器
     * @return
     */
    @Bean
     public AuthenticationInterceptor authenticationInterceptor() {
                 return new AuthenticationInterceptor();
             }
}
