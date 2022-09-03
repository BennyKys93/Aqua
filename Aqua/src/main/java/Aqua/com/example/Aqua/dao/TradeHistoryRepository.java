package Aqua.com.example.Aqua.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import Aqua.com.example.Aqua.model.TradeHistoryEntity;


public interface TradeHistoryRepository extends CrudRepository<TradeHistoryEntity, Long> {

	List<TradeHistoryEntity> findAllByPersonId(long id);

}
