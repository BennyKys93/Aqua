package Aqua.com.example.Aqua.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import Aqua.com.example.Aqua.model.BinanceEntity;

public interface BinanceRepository extends CrudRepository<BinanceEntity, Long> {

	BinanceEntity findBySymbol(String symbol);
	
	List<BinanceEntity> findAll();

}
