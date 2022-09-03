package Aqua.com.example.Aqua.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Aqua.com.example.Aqua.dao.HuobiRepository;
import Aqua.com.example.Aqua.dto.Data;
import Aqua.com.example.Aqua.dto.Huobi;
import Aqua.com.example.Aqua.model.HuobiEntity;
import Aqua.com.example.Aqua.service.HuobiService;

@Service
public class HuobiServiceImpl implements HuobiService {

	@Autowired
	private HuobiRepository huobiRepository;

	@Override
	public void saveHuobi(Huobi huobi) {

		for (Data data : huobi.getData()) {

			HuobiEntity obj = huobiRepository.findBySymbol(data.getSymbol());

			if (obj != null) {
				obj.setOpen(data.getOpen());
				obj.setHigh(data.getHigh());
				obj.setLow(data.getLow());
				obj.setClose(data.getClose());
				obj.setAmount(data.getAmount());
				obj.setVol(data.getVol());
				obj.setCount(data.getCount());
				obj.setBid(data.getBid());
				obj.setBidSize(data.getBidSize());
				obj.setAsk(data.getAsk());
				obj.setAskSize(data.getAskSize());
				huobiRepository.save(obj);
			} else {
				HuobiEntity newHuobi = new HuobiEntity();
				newHuobi.setSymbol(data.getSymbol());
				newHuobi.setOpen(data.getOpen());
				newHuobi.setHigh(data.getHigh());
				newHuobi.setLow(data.getLow());
				newHuobi.setClose(data.getClose());
				newHuobi.setAmount(data.getAmount());
				newHuobi.setVol(data.getVol());
				newHuobi.setCount(data.getCount());
				newHuobi.setBid(data.getBid());
				newHuobi.setBidSize(data.getBidSize());
				newHuobi.setAsk(data.getAsk());
				newHuobi.setAskSize(data.getAskSize());

				huobiRepository.save(newHuobi);

			}
		}
	}

}
