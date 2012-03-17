package controllers;

import play.mvc.Controller;

@SuppressWarnings("UnusedDeclaration")
public class CookieController extends Controller {

	public static final boolean SECURE = true;
	public static final boolean INSECURE = false;

	public static void foo() {
		response.setCookie("foo", "bar", "localhost", "", 3600, false, true);
	}

	public static void secure() {
		response.setCookie("secure", "contentIsNotImportant", "not important", "not important", 3600, SECURE, true);
	}

	public static void insecure() {
		response.setCookie("insecure", "contentIsNotImportant", "not important", "", 3600, INSECURE, true);
	}

}
