package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(exclude = "password")
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "User_name", nullable = false, length = 150)
	@NotBlank(message = "Please Entre you User Name!!")
	private String userName;
	@Column(name = "User_full_name", nullable = false, length = 150)
	@NotBlank(message = "Please Entre you User FullName!!")
	private String userFullName;
	@Column(name = "password", nullable = false, length = 150)
	@NotBlank(message = "Please Entre you password!!")
	private String password;

}
