package com.springboot.Rest.webservices.restfulwebservices.user;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
@ApiModel(description = "All details about the user. ")
public class User {
    @Size(min = 2)
    @ApiModelProperty(notes ="name should have atleast 2 characters")
    private String name;
    private Integer id ;
    private String sex;
    @Past()
    @ApiModelProperty(notes ="dateofBirth should be in the past.")
    private Date birthday;
    public User(int id, String name , String sex , Date birthday){
        this.id = id;
        this.name =name;
        this.sex = sex;
        this.birthday=birthday;
    }
    protected User()
    {

    }
    protected User(String name , String sex , Date birthday)
    {
        this.name =name;
        this.sex = sex;
        this.birthday=birthday;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public Integer getId() {
        return id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getSex() {
        return sex;
    }
}
