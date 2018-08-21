package org.davingci.resig.security;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IPInfo {
	
	private String country;
	
	private String area;
	
	private String region;
	
	private String city;
	
	private String county;
	

	
	public static String ip2Location(String ip) {
		Client client = ClientBuilder.newClient();


		String entity = client.target("http://ip.taobao.com")
	            .path("service/getIpInfo.php")
	            .queryParam("ip", ip)
	            .request(MediaType.APPLICATION_JSON)
	            .get(String.class);
		
		JSONObject ru = JSON.parseObject(entity);
		String code = ru.getString("code");
		IPInfo ipInfo = JSON.parseObject(ru.getString("data"),IPInfo.class);
		
		String location = ipInfo.getCountry() + " " +
						  ipInfo.getArea() + " " +
						  ipInfo.getRegion() + " " +
						  ipInfo.getCity() + " " + 
						  ipInfo.getCounty();

		return location;
	}

}
