package com.techbee.selenium.demo2;

import java.io.IOException;

public class targettest extends base{
	public static void main(String[] args) throws IOException {
		base targetWeb = new base();
		targetWeb.invokeBrowserT();
		targetWeb.searchProductT("iPhone");
		targetWeb.first3Products();
	}

}
