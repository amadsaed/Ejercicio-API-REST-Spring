package com.example.rest.demo.simplerest.model;

import javax.validation.Valid;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.bytebuddy.asm.Advice.This;

@Entity
public class User {

 

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

 
    
    @JsonProperty("user_name")
    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Valid
    private String userName;

 
    @Valid
    @JsonProperty("last_name")
    @NotBlank
    private String lastName;


    @JsonProperty("gender")
    @NotNull
    private Gender gender;

 

    @JsonProperty("dire")
    @NotNull
    private String dire;

 

    @JsonProperty("age")
    @Min(value = 18)
    @Max(value = 150)
    @NotNull
    private Integer age;

 

    @JsonProperty("birth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Past
    @NotNull
    private Date dateOfBirth;

 
    public User() {
        super();
        
    }
  
  public User(Long id, @NotBlank String userName, @NotBlank String lastName, @NotNull String dire) {
		super();
		this.id = id;
		this.userName = userName;
		this.lastName = lastName;
		this.dire = dire;
	}


    public Long getId() {
        return id;
    }

 

    public void setId(long userId) {
        this.id = id;
    }

 

    public String getUserName() {
        return userName;
    }

 

    public void setUserName(String userName) {
        this.userName = userName;
    }

 

    public String getDire() {return dire;  }

 

    public void setDire(String dire) {
        this.dire = dire;
    }

 

    public String getLastName() {
        return lastName;
    }

 

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

 

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

 

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

 

    public Gender getGender() {
        return gender;
    }

 

    public void setGender(Gender gender) {
        this.gender = gender;
    }

 

    public Integer getAge() {
        return age;
    }

 

    public void setAge(Integer age) {
        this.age = age;
    }
    
    public Map<String , Object> usreDTO(){
    	Map<String , Object> userDTO = new LinkedHashMap ();
    	userDTO.put("id", this.getId());
    	userDTO.put("userName", this.getUserName());
    	userDTO.put("lastName", this.getLastName());
    	userDTO.put("dire",this.getDire());
    	return userDTO;
    	
    }

	
    
}
