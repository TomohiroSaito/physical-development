package physicaldevelopment.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * SpringSecurityの設定クラス
 */
@Configuration
@ImportResource("classpath:/META-INF/spring/security-config.xml")
public class SecurityConfig {

}
