package com.bridgelabz.bookstoreapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class BookStoreConfig {

    // Implementing swagger API for quick UI integration
    //DocumentationType.SWAGGER_2 for documentation plugin
    //.paths(regex("/bookstore.*")) for setting the REST API controller path
    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("Spring Swagger").apiInfo(apiInfo()).select()
                .paths(regex("/bookstore.*")).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Book Service")
                .description("Sample Documentation Generateed Using SWAGGER2 for our Book Rest API")
                .termsOfServiceUrl("https://www.bridgelabz.com")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licesen.html").version("2.0").build();
    }
}
