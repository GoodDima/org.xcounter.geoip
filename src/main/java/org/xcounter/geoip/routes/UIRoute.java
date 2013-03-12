package org.xcounter.geoip.routes;

import spark.Route;

public abstract class UIRoute extends Route {

	protected UIRoute(String path) {
		super(path);
	}

	protected String renderLayout(String content){
		
		return "";
		
	}
	
}
