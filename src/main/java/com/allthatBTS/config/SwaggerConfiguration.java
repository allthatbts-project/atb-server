package com.allthatBTS.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Swagger 사용을 위한 설정 클래스
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    //students
    @Bean
    public Docket crawlerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(crawlerAPIInfo()).select()
                .apis(RequestHandlerSelectors.any()).paths(crawlerPaths())
                .build().
                        securitySchemes(Arrays.asList(basicAuth()));
    }

    private Predicate<String> crawlerPaths() {
        return Predicates.or(
                regex("/api/crawler.*"));
    }

    private ApiInfo crawlerAPIInfo() {
        return new ApiInfoBuilder().title("crawler API")
                .description("The super heroic crawler API ")
                .license("Apache License Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .version("1.0").build();
    }

    private SecurityScheme basicAuth() {
        return new BasicAuth("Basic Authentication");
    }

}
