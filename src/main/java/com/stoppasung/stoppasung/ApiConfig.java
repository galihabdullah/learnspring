package com.stoppasung.stoppasung;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApiConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).
                select().
                apis(RequestHandlerSelectors.basePackage("com.stoppasung.stoppasung.controller")).
                paths(PathSelectors.any()).
                build();
    }

    private ApiInfo getApiInfo(){
        springfox.documentation.service.Contact contact = new springfox.documentation.service.Contact("galih abdullah", "simplpostapi.herokuapp.com", "galihabdullah471@gmail.com");
        return new ApiInfoBuilder()
                .title("Simple Post Api Documentation").
                        description("description").
                        version("version 1.0").
                        license("Apache 2.0").
                        contact(contact).
                        build();
    }
}
