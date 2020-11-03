package com.berg.api.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "swagger", name ="enabled" ,havingValue = "true",matchIfMissing = true)
public class SwaggerConfig {

    public static final String VERSION = "1.0.0";

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("openapi接口文档")
                .version(VERSION)
                .build();
    }

    @Bean
    public Docket customImplementation() {
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        ticketPar.name("Authentication").description("登录校验")//name表示名称，description表示描述
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(true).build();//required表示是否必填，defaultvalue表示默认值
        pars.add(ticketPar.build());//添加完此处一定要把下边的带***的也加上否则不生效

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
    }

//    多模块分组示例
//    public static final String VERSION = "1.0.0";
//
//    ApiInfo apiInfo(String name) {
//        return new ApiInfoBuilder()
//                .title(name)
//                .version(VERSION)
//                .build();
//    }
//
//    @Bean
//    public Docket openApi() {
//        ParameterBuilder ticketPar1 = new ParameterBuilder();
//        ParameterBuilder ticketPar2 = new ParameterBuilder();
//        ParameterBuilder ticketPar3 = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<Parameter>();
//        ticketPar1.name("Sign").description("请求校验")
//                .modelRef(new ModelRef("string")).parameterType("header")
//                .required(false).build();
//        ticketPar2.name("Service").description("请求服务")
//                .modelRef(new ModelRef("string")).parameterType("header")
//                .required(false).build();
//        ticketPar3.name("Timestamp").description("请求时间")
//                .modelRef(new ModelRef("string")).parameterType("header")
//                .required(false).build();
//        pars.add(ticketPar1.build());
//        pars.add(ticketPar2.build());
//        pars.add(ticketPar3.build());
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("open接口文档")
//                .apiInfo(apiInfo("open接口文档"))
//                .select()
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .paths(PathSelectors.ant("/open/**"))
//                .build()
//                .globalOperationParameters(pars);
//    }
//
//    @Bean
//    public Docket systemApi() {
//        ParameterBuilder ticketPar1 = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<Parameter>();
//        ticketPar1.name("Authentication").description("登录校验")
//                .modelRef(new ModelRef("string")).parameterType("header")
//                .required(false).build();
//        pars.add(ticketPar1.build());
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("system接口文档")
//                .apiInfo(apiInfo("system接口文档"))
//                .select()
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .paths(PathSelectors.ant("/system/**"))
//                .build()
//                .globalOperationParameters(pars);
//    }

}
