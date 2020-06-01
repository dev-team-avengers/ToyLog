package team.avengers.toylog.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .components(new Components())
                .info(openApiInfo());
    }

    private Info openApiInfo() {
        return new Info()
                .title("ToyLog API Documentation")
                .description("ToyLog API 개발에 사용되는 문서입니다.");
    }
}
