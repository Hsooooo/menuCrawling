package main;

import java.io.IOException;

import crawling.Crawlling;

public class Main {

	public static void main(String[] args) {
		Crawlling craw = new Crawlling();
		System.out.println("tt");
		try {
			craw.getNutrition("스크램블 에그 롤", "food");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
