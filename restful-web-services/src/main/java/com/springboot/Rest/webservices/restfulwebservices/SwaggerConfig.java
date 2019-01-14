package com.springboot.Rest.webservices.restfulwebservices;


import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    public static final Contact DEFAULT_CONTACT = new Contact("Biruk", "localhost", "bm2019@gmail.com");
    public static final ApiInfo DEFAULT_API_INFO= new ApiInfo("Great Api", " Great Api Documentation",
            "1.0", "urn:tos", DEFAULT_CONTACT,
            "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
    @Bean
    public Docket Api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO);
    }


    @Entity
    public static class Employee {
        @Size(min = 2)
        @ApiModelProperty(notes ="name should have atleast 2 characters")
        private String name;
        @Id
        @GeneratedValue
        private Long id ;
        private String role;
        @Past()
        @ApiModelProperty(notes ="dateofBirth should be in the past.")
        private Date birthday;

        protected Employee()
        {

        }
        protected Employee(String name , String role , Date birthday)
        {
            super();
            this.name =name;
            this.role = role;
            this.birthday=birthday;
        }

        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getRole() {
            return role;
        }

        public Date getBirthday() {
            return birthday;
        }

        @Override
        public String toString() {
                    super.toString();
                    return getName() + ',' +getRole() + ',' + getBirthday( );
        }

        public void setRole(String role) {
            this.role = role;
        }
    }
}