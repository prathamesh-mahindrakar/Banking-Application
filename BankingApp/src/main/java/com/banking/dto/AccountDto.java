package com.banking.dto;


public class AccountDto {
	private Long id;
	private String name;
	private double balance;
	
	public AccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountDto(Long id, String name, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountDto [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}
	
	
	
	
}
