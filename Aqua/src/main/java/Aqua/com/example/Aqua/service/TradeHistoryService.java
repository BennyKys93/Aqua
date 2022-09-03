package Aqua.com.example.Aqua.service;

import java.util.List;
import java.util.Optional;

import Aqua.com.example.Aqua.dto.TradeHistory;


public interface TradeHistoryService {
	
	List<TradeHistory> getTradeHistory(Long id);

}
