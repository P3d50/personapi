package com.p3d50.personapi.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@Api(value = "MerchantControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class SwaggerConfig {

    @Bean
    public Docket personAPI(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.p3d50.personapi"))
                .paths(regex("/api/v1/people.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo(){
        ApiInfo apiInfo = new ApiInfo(
                "Person API REST",
                "REST API for User registration",
                "1.0",
                "Terms of Service",
                new Contact(
                        "Pedro Ramos",
                        "https://www.linkedin.com/in/pedro-ramos-3b35aaa0/",
                        "rpedromarcos@gmail.com"),
                "MIT License",
                "https://www.mit.edu/~amini/LICENSE.md",
                new ArrayList<VendorExtension>());
        return apiInfo;
    }

}
