package org.afc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
public class Swagger2Configuration {
    //版本
    public static final String VERSION = "1.0.0";

    /**
     * 门户api，接口前缀：portal
     *
     * @return
     */
    @Bean
    public Docket portalApi(Environment env) {
        // 设置要显示swagger的环境
        Profiles of = Profiles.of("dev", "test");
        boolean b = env.acceptsProfiles(of);
        return new Docket(DocumentationType.SWAGGER_12).enable(b)
                .apiInfo(portalApiInfo())
                .select()
//                .apis(RequestHandlerSelectors.basePackage("net.sjw.blog.controller.portal"))
                .apis(RequestHandlerSelectors.basePackage("org.afc.controller"))
                .paths(PathSelectors.any()) // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build()
                .groupName("test测试group");
    }

    private ApiInfo portalApiInfo() {
        return new ApiInfoBuilder()
                .title("test1portalApiInfo接口文档") //设置文档的标题
                .description("test接口文档") // 设置文档的描述
                .version(VERSION) // 设置文档的版本信息-> 1.0.0 Version information
                .build();
    }


    /**
     * 管理中心api，接口前缀：admin
     *
     * @return
     */
//    @Bean
//    public Docket adminApi(Environment env) {
//        Profiles of = Profiles.of("dev", "test");
//        boolean b = env.acceptsProfiles(of);
//        return new Docket(DocumentationType.SWAGGER_12).enable(b)
//                .apiInfo(adminApiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("net.sjw.blog.controller.admin"))
//                .paths(PathSelectors.any()) // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
//                .build()
//                .groupName("管理中心");
//    }
//
//
//    private ApiInfo adminApiInfo() {
//        return new ApiInfoBuilder()
//                .title("czy管理中心接口文档") //设置文档的标题
//                .description("管理中心接口") // 设置文档的描述
//                .version(VERSION) // 设置文档的版本信息-> 1.0.0 Version information
//                .build();
//    }


//    @Bean
//    public Docket UserApi(Environment env) {
//        Profiles of = Profiles.of("dev", "test");
//        boolean b = env.acceptsProfiles(of);
//        return new Docket(DocumentationType.SWAGGER_12).enable(b)
//                .apiInfo(userApiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("net.sjw.blog.controller.user"))
//                .paths(PathSelectors.any()) // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
//                .build()
//                .groupName("用户中心");
//    }
//
//    private ApiInfo userApiInfo() {
//        return new ApiInfoBuilder()
//                .title("czy博客系统用户接口") //设置文档的标题
//                .description("用户接口的接口") // 设置文档的描述
//                .version(VERSION) // 设置文档的版本信息-> 1.0.0 Version information
//                .build();
//    }
}