package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;

import org.springframework.stereotype.Component;

@Entity
public class Book {
	
	@Id
	private String bid;
	private String bname;
	private String aname;
	private String genre;
	 
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String bid, String bname, String aname, String genre) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.aname = aname;
		this.genre = genre;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "bid=" + bid + ", bname=" + bname + ", aname=" + aname + ", genre=" + genre + "";
	}
	
	
	
}
