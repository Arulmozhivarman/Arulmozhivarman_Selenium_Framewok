package com.DemoWebShop_GenericUtility;

import java.time.LocalDateTime;

public class javautility {
	
	public String localDateAndTime() {
		
		String time = LocalDateTime.now().toString().replace(".", "").replace(":", "").replace("-", "");
		return time;
	}

}
