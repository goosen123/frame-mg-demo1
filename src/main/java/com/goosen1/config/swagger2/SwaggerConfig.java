package com.goosen1.config.swagger2;

import io.swagger.models.parameters.Parameter;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Sets;  

import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.ComponentScan;  
import org.springframework.context.annotation.Configuration;  
import org.springframework.web.servlet.config.annotation.EnableWebMvc;  
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;  

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;  
import springfox.documentation.builders.RequestHandlerSelectors;  
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;  
import springfox.documentation.service.Contact;  
import springfox.documentation.spi.DocumentationType;  
import springfox.documentation.spring.web.plugins.Docket;  
import springfox.documentation.swagger2.annotations.EnableSwagger2;  
  
/** 
 * Created by Wilson on 2017/5/2. 
 */  
@Configuration  
@EnableSwagger2  
@EnableWebMvc
@ComponentScan(basePackages = "com.goosen1")  
public class SwaggerConfig extends WebMvcConfigurationSupport {  
	
	@Bean
	public Docket demo1ApiDocket() {
		//添加head参数start  
//		List<springfox.documentation.service.Parameter> pars = new ArrayList<springfox.documentation.service.Parameter>();
//        ParameterBuilder tokenPar = new ParameterBuilder();  
//        tokenPar.name(HeaderConstants.X_TOKEN).description("用户的登录token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();  
//        pars.add(tokenPar.build());
//        ParameterBuilder apiVersionPar = new ParameterBuilder();
//        apiVersionPar.name(HeaderConstants.API_VERSION).description("api的版本号").modelRef(new ModelRef("string")).parameterType("header").required(true).defaultValue("2.0").build();
//        pars.add(apiVersionPar.build());
//        ParameterBuilder appVersionPar = new ParameterBuilder();
//        appVersionPar.name(HeaderConstants.APP_VERSION).description("app版本号").modelRef(new ModelRef("string")).parameterType("header").required(true).defaultValue("v2").build();
//        pars.add(appVersionPar.build());
//        ParameterBuilder callSourcePar = new ParameterBuilder();
//        callSourcePar.name(HeaderConstants.CALL_SOURCE).description("调用来源").modelRef(new ModelRef("string")).parameterType("header").required(true).defaultValue("PC").build();
//        pars.add(callSourcePar.build());
        //添加head参数end  
		
		return new Docket(DocumentationType.SWAGGER_12)
				.groupName("frame-mg-demo1")
				.apiInfo(new ApiInfoBuilder().title("frame-mg-demo1").description("mg工程使用测试").build())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.goosen1.controller"))
				.paths(PathSelectors.any())
				//.paths(PathSelectors.none())//如果是线上环境，添加路径过滤，设置为全部都不符合
				.build()
//				.globalOperationParameters(pars)  
				;
	}
    
//	@Bean  
//    public Docket commonDocket() {  
//        return new Docket(DocumentationType.SWAGGER_2)  
//                .groupName("通用API接口文档")  
//                .apiInfo(apiInfo("提供通用接口"))  
//                .pathMapping("/")  
//                .select()  
//                .apis(RequestHandlerSelectors.basePackage("pers.graduation.controller.common"))  
//                .paths(PathSelectors.any())  
//                .build();  
//    }  
  
//    @Bean  
//    public Docket normalUserDocket() {  
//        return new Docket(DocumentationType.SWAGGER_2)  
//                .groupName("普通用户API文档")  
//                .apiInfo(apiInfo("提供普通用户接口"))  
//                .protocols(Sets.newHashSet("https","http"))  
//                .produces(Sets.newHashSet("html/text"))  
//                .pathMapping("/")  
//                .select()  
//                .apis(RequestHandlerSelectors.basePackage("pers.graduation.controller.candidate"))//设置生成的Docket对应的Controller为candidate下的所有Controller  
//                .paths(PathSelectors.any())  
//                .build();  
//    }  
  
//    @Bean  
//    public Docket companyUserDocket() {  
//        return new Docket(DocumentationType.SWAGGER_2)  
//                .groupName("企业用户API接口文档")  
//                .apiInfo(apiInfo("提供企业用户接口"))  
//                .pathMapping("/")  
//                .select()  
//                .apis(RequestHandlerSelectors.basePackage("pers.graduation.controller.company"))  
//                .paths(PathSelectors.any())  
//                .build();  
//    }  
    
//    <span style="white-space:pre;"> </span>//设置文档信息  
//    private ApiInfo apiInfo(String desc) {  
//        return new ApiInfo(  
//                "Test Website",<span style="white-space:pre;">              </span>//标题名称  
//                desc,<span style="white-space:pre;">                    </span>//文档描述  
//                "1.0.1",<span style="white-space:pre;">             </span>//版本号，自定义  
//                "http://blog.csdn.net/z28126308",<span style="white-space:pre;">    </span>//许可人URL  
//                contact(),<span style="white-space:pre;">               </span>//联系方式实体类  
//                "Wilson",<span style="white-space:pre;">                </span>//许可人，许可证  
//                "http://blog.csdn.net/z28126308");<span style="white-space:pre;">   </span>//许可URL  
//    } 
//    
//    <span style="white-space:pre;"> </span>//设置联系方式  
//    private Contact contact() {  
//        return new Contact("Wilson", "http://blog.csdn.net/z28126308", "z28126308@163.com");  
//    }  
    
}  
