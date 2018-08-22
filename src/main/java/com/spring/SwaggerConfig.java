/*
 *
 * 2015 - 2016 Wombat Security Technologies
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Wombat Security Technologies, and may be
 * covered by one or more patents.  Dissemination of any parts
 * of this code is strictly prohibited unless written permission
 * is obtained from Wombat Security Technologies.
 */
package com.spring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

/**
 * SpringMVC-Swagger UI config file.
 *
 * @author Bikram Kundu
 *
 */
@Configuration
@EnableSwagger
public class SwaggerConfig {

    private SpringSwaggerConfig springSwaggerConfig;

    /**
     * Required to autowire SpringSwaggerConfig
     */
    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    /**
     * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc
     * framework - allowing for multiple swagger groups i.e. same code base
     * multiple swagger resource listings.
     */
    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(apiInfo()).includePatterns("/.*");
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Wombat Security Admin-app API",
                "Application developed by AccionLabs",
                "http://localhost:8080/api-docs",
                "contact@wombatsecurity.com",
                "The Apache Software License, Version 2.0",
                "http://commons.apache.org/proper/commons-daemon/license.html");
        return apiInfo;
    }

}
