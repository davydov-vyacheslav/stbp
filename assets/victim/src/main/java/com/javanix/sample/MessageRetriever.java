package com.javanix.sample;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;

public class MessageRetriever {

	private static String getMessage(String url) throws IOException {
		URI uri = URI.create(url);
		try (InputStream in = uri.toURL().openStream()) {
			return IOUtils.toString(in, StandardCharsets.UTF_8);
		}
	}

	public static String getSimpleTextFromGithub() throws IOException {
		String userDetails = getMessage("https://api.github.com/users/davydov-vyacheslav");
		JSONObject jsonObject = new JSONObject(userDetails);
		return jsonObject.getString("name");
	}

	public static String getSimpleTextFromIp() throws IOException {
		String webpage = getMessage("http://128.32.244.190/~raluca/cs261-f15/");
		return webpage.substring(webpage.toLowerCase().indexOf("<title>\n") + "<title>\n".length(), webpage.toLowerCase().indexOf("</title>")).trim();
	}

}
