package controllers;

import play.data.validation.MinSize;
import play.data.validation.Required;
import play.data.validation.Validation;
import play.mvc.Controller;

public class HtmlController extends Controller {

	public static void aPage() {
		render();
	}

	public static void helloWorld() {
		render();
	}

	public static void sayHello(@Required @MinSize(4) String name) {
		if (Validation.hasErrors()) {
			params.flash();
			Validation.keep();
			helloWorld();
		}
		renderText("Hello " + name + "!");
	}


}
