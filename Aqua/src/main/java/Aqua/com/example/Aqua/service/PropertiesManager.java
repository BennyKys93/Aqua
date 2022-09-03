package Aqua.com.example.Aqua.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class PropertiesManager {

	@Autowired
	private Environment env;
	
	public int getRestClientMaxAttempts() {
		String maxRetryAttemptStr = env.getProperty("restclient.max.attempts", "4");
		return Integer.parseInt(maxRetryAttemptStr);
	}
	
	public String getBinanceUrl() {
		return env.getProperty("url.binance");
	}
	
}
