/**
 * Main class Spring Boot.
 * It class contains whole project configs
 * @autor Jose Luis Lopez
 * @email joseluis.lopezhernandez@gmail.com
 */
package com.us.graphite.recipeservice;

import com.us.graphite.recipeservice.controller.RecipeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackageClasses = {RecipeController.class})
public class RecipeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeServiceApplication.class, args);
	}
}
