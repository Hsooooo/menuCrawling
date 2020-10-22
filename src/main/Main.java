package main;

import java.io.IOException;

import crawling.Crawlling;

public class Main {

	public static void main(String[] args) {
		Crawlling craw = new Crawlling();
		System.out.println("tt");
		try {
			craw.getNutrition("나이트로 콜드 브루", "drink");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
