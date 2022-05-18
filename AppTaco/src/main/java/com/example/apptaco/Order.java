package com.example.apptaco;

import lombok.Data;

import java.util.List;

@Data
public class Order {
	private Long id;
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String ccNumber;
	private String ccExpiration;
	private String ccCVV;
	private String placedAt;
	private List<Taco> tacos;
}
