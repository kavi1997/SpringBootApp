package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Book;

public interface Repo extends JpaRepository<Book, String> {

	Book findBybid(String bid);

}
