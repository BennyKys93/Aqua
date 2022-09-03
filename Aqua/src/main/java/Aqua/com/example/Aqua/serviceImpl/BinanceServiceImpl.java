package Aqua.com.example.Aqua.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Aqua.com.example.Aqua.dao.BinanceRepository;
import Aqua.com.example.Aqua.dto.Binance;
import Aqua.com.example.Aqua.model.BinanceEntity;
import Aqua.com.example.Aqua.service.BinanceService;

@Service
public class BinanceServiceImpl implements BinanceService {

	@Autowired
	private BinanceRepository binanceRepository;

	@Override
	public void saveBinance(Binance[] binance) {

		for (Binance bin : binance) {

			BinanceEntity obj = binanceRepository.findBySymbol(bin.getSymbol());

			if (obj != null) {
				obj.setAskPrice(bin.getAskPrice());
				obj.setAskQty(bin.getAskPrice());
				obj.setBidPrice(bin.getBidPrice());
				obj.setBidQty(bin.getBidQty());
				binanceRepository.save(obj);
			} else {
				BinanceEntity bina = new BinanceEntity();
				bina.setAskPrice(bin.getAskPrice());
				bina.setAskQty(bin.getAskPrice());
				bina.setSymbol(bin.getSymbol());
				bina.setBidPrice(bin.getBidPrice());
				bina.setBidQty(bin.getBidQty());

				binanceRepository.save(bina);
			}
		}

	}

}
