package Aqua.com.example.Aqua.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import com.sun.istack.Nullable;

public interface RestTemplateRetryableService {
	@Nullable
	<T> T postForObject(String url, @Nullable Object request, Class<T> responseType, Object... uriVariables)
			throws RestClientException;

	@Nullable
	<T> T getForObject(String url, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException;

	@Nullable
	<T> T getForObject(String url, Class<T> responseType) throws RestClientException;

	@Nullable
	<T, R> ResponseEntity<T> putForObject(String url, @Nullable Object request, Class<T> responseType,
			Object... uriVariables) throws RestClientException;
}