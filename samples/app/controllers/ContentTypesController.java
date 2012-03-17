package controllers;

import play.mvc.Controller;

@SuppressWarnings("UnusedDeclaration")
public class ContentTypesController extends Controller {

	public static void html() {
		renderHtml("Hello World");
	}

	public static void xml() {
		renderXml("Hello World");
	}

	public static void json() {
		renderJSON("Hello World");
	}

	public static void text() {
		renderText("Hello World");
	}

}
