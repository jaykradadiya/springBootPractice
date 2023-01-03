package com.customer.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gardian {
	
	@Column(name="gardian_name")
	private String name;
	@Column(name ="gardian_email")
	private String email;
	@Column(name="gardian_mobile")
	private String mobile;

}
