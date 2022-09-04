package Aqua.com.example.Aqua.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import Aqua.com.example.Aqua.model.AggregatedPriceEntity;
import Aqua.com.example.Aqua.model.BinanceEntity;

public interface AggregatedPriceRepository extends CrudRepository<AggregatedPriceEntity, Long> {
	
	Optional<AggregatedPriceEntity> findBySymbol(String symbol);

}
