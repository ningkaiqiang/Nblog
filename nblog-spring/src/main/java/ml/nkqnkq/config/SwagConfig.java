package ml.nkqnkq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwagConfig {

    @Bean
    public Docket getDocket(Environment environment) {

//      设置需要swagger显示的特定环境变量
        Profiles profile = Profiles.of("dev", "test");
//      检测是否在特定的环境变量下
        boolean flag = environment.acceptsProfiles(profile);


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("nkq") // 设置用户组，可以设置多个Docket类装配到spring实现分组
                .enable(flag) // 检测，如果环境变量不符合条件，则将enable设置为false，否则为true
                .select()
                /*
                apis.(RequestHandlerSelectors.XXX())配置扫描的方式
                   any()扫描所有包
                   none()不扫描
                   basePackage()设置要扫描的包
                   withClassAnnotation()通过类的注解扫描
                   withMethodAnnotation()通过方法的注解扫描
                */
                .apis(RequestHandlerSelectors.withMethodAnnotation(GetMapping.class))
//                path()指定过滤的路径,过滤后将不被扫描
//                .paths(PathSelectors.ant("/nnn/**"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Spring-Vue",
                "Spring Boot",
                "0.0.1",
                "nnn:tos",
                new Contact("nkq", "https://nkqnkq.ml", "nkq_1998@outlook.com"),
                "Apache 2.0",
                "https://nkqnkq.ml",
                new ArrayList<>());
    }
}
