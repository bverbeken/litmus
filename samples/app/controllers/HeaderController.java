package controllers;

import play.mvc.Controller;

@SuppressWarnings("UnusedDeclaration")
public class HeaderController extends Controller {

	public static void foo(){
		response.setHeader("foo", "bar");
	}

}
