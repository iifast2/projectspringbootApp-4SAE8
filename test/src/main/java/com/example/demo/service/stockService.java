package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Stock;

public interface stockService {
	Stock saveStock(Stock p);
	Stock updateStock(Stock p);
	void deleteStock(Stock p);
	void deleteStockById(Long id);
	Stock getStock(Long id);
	List<Stock> getAllStocks();
	void getAllStocksbyStatus();

}
