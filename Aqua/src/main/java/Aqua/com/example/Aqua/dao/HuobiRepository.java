package Aqua.com.example.Aqua.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import Aqua.com.example.Aqua.model.HuobiEntity;

public interface HuobiRepository extends CrudRepository<HuobiEntity, Long> {
	
	HuobiEntity findBySymbol(String symbol);
	
	List<HuobiEntity> findAll();

}
