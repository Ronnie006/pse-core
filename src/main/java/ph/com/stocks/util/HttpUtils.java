package ph.com.stocks.util;

import java.net.InetSocketAddress;
import java.net.Proxy;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;

@Component
public class HttpUtils {
	
	public SimpleClientHttpRequestFactory getProxyAccess(String proxyAddress, int proxyPort){
		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyAddress, proxyPort));
		clientHttpRequestFactory.setProxy(proxy);
		return clientHttpRequestFactory;
	}
}
