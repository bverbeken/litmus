package controllers;

import play.mvc.Controller;

@SuppressWarnings("UnusedDeclaration")
public class FlashController extends Controller {

	public static void oneFlashParam() {
		flash("foo", "bar");
	}

	public static void twoFlashParams() {
		flash("foo", "message1");
		flash("bar", "message2");
	}

}
