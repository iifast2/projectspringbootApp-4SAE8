package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Client;
import com.example.demo.entities.Produit;
import com.example.demo.entities.Stock;
import com.example.demo.repos.stockRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class stockServiceImpl implements stockService {
	@Autowired
	stockRepository cr;

	@Override
	public Stock saveStock(Stock p) {
		return cr.save(p);
	}

	@Override
	public Stock updateStock(Stock p) {
		return cr.save(p);
	}

	@Override
	public void deleteStock(Stock p) {
		cr.delete(p);
	}

	@Override
	public void deleteStockById(Long id) {
		cr.deleteById(id);
	}

	@Override
	public Stock getStock(Long id) {
		return cr.findById(id).get();
	}

	@Override
	public List<Stock> getAllStocks() {
		return cr.findAll();
	}
	@Override
	@Transactional
	@Scheduled(fixedRate=6000)
	public void getAllStocksbyStatus() {
		List<Stock> stk=cr.findAll();
		for(Stock st:stk) {
			for (Produit p : st.getProduits()) {


				if(st.getQte()<st.getQteMin())
				{
					log.info("le produit "+p.getLabelle()+" un stock de"+st.getQte()+"inferiere a qte min a ne pas depasser "+st.getQteMin() );
				}
				else {
					log.info("wrong");
				}
				}

		}

	}




}
