package com.spring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Sample {
	public static void main(String[] args) throws IOException {

		try {
			
			String urlString = "http://localhost:8080/user/articles";

			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE1MzMyMDkwMjQsImlzcyI6ImF1dGhTZXJ2ZXIiLCJleHAiOjE1MzMyMDk2MjQsInN1YiI6IjEwMjciLCJqdGkiOiIyN2IyZjdjZi0xODczLTQwY2YtOTdmNC0yZTZmZWQ1YWRlZGIiLCJ0eXBlIjoiQWRtaW5pc3RyYXRvciIsInJvbGVzIjpbIlN1cGVyQWRtaW4iXSwiY29tcGFueUlkIjoxLCJhdWRpdElkIjoiMTgxYzYyZDktZTE4Yi00YzRiLThlZDQtN2NkN2VkZjEzNzVhIn0.3aY6cEdERdooLf7KjQdrR9mHFxyTlK9QueiGU486EKQ-XasRvLHX76FAgrKNslQv5phfKHjc6-EpAsAkESWW7g");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			String[] split=output.split("\"data\":");
			System.out.println(split);
			conn.disconnect();

			
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
