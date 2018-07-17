package io.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-04T05:46:55.451-05:00")

@Configuration
public class SwaggerDocumentationConfig {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Petstore")
            .description("A simple Petstore API")
            .license("")
            .licenseUrl("http://unlicense.org")
            .termsOfServiceUrl("")
            .version("0.3.1")
            .contact(new Contact("","", ""))
            .build();
    }

    /**
     * After the Docket bean is defined, its select() method returns an instance of ApiSelectorBuilder,
     * which provides a way to control the endpoints exposed by Swagger.
     *
     * Predicates for selection of RequestHandlers can be configured with the help of RequestHandlerSelectors
     * and PathSelectors. Using basePackage will make documentation for your entire API available through Swagger.
     *
     * This configuration is enough to integrate Swagger 2 into existing Spring Boot project.
     * For other Spring projects, some additional tuning is required.
     * @return
     */

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                    .apis(RequestHandlerSelectors.basePackage("io.swagger.api"))
                    .build()
                .directModelSubstitute(org.joda.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(org.joda.time.DateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());
    }

}
