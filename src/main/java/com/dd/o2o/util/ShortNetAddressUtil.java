package com.dd.o2o.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ShortNetAddressUtil {
	private static Logger log = LoggerFactory.getLogger(ShortNetAddressUtil.class);

	public static int TIMEOUT = 30 * 1000;
	public static String ENCODING = "UTF-8";

	// 根据传入的url，通过访问百度短链接接口，将其转换成短的url
	public static String getShortURL(String originURL) {
		String tinyUrl = null;
		try {
			// 指定百度短链接接口
			URL url = new URL("http://dwz.cn/create.php");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setConnectTimeout(TIMEOUT);
			connection.setRequestMethod("POST");
			String postData = URLEncoder.encode(originURL.toString(), "utf-8");
			connection.getOutputStream().write(("url=" + postData).getBytes());
			connection.connect();
			String responseStr = getResponseStr(connection);
			log.info("response string:" + responseStr);
			tinyUrl = getValueByKey(responseStr, "tinyurl");
			log.info("tinyurl:" + tinyUrl);
			connection.disconnect();
		} catch (Exception e) {
			log.error("getshortURL error:" + e.toString());
		}
		return tinyUrl;
	}

	private static String getResponseStr(HttpURLConnection connection) throws IOException {
		StringBuffer result = new StringBuffer();
		int responseCode = connection.getResponseCode();
		// System.out.println(responseCode);
		// System.out.println(HttpURLConnection.HTTP_OK);
		if (responseCode == HttpURLConnection.HTTP_OK) {
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, ENCODING));
			String inputLine = "";
			while ((inputLine = reader.readLine()) != null) {
				result.append(inputLine);

			}
		}
		return String.valueOf(result);
	}

	private static String getValueByKey(String replyText, String key) {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node;
		String targetValue = null;
		try {
			node = mapper.readTree(replyText);
			targetValue = node.get(key).asText();
		} catch (JsonProcessingException e) {
			log.error("getValueByKey error:" + ENCODING.toString());
			e.printStackTrace();
		} catch (IOException e) {
			log.error("getValueByKey error:" + ENCODING.toString());
			e.printStackTrace();
		}
		return targetValue;
	}
}
