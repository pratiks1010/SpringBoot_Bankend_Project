package com.app.userDto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserDto {
	
	
	private Integer userId;
	
	@NotBlank(message = "Please Entre you User Name!!")
	private String userName;

	@NotBlank(message = "Please Entre you User FullName!!")
	private String userFullName;
	
	@NotBlank(message = "Please Entre you User password!!")
	private String password;

}
