package controllers;

import play.mvc.Controller;
import play.mvc.With;

@SuppressWarnings("UnusedDeclaration")
@With(Secure.class)
public class SecuredController extends Controller {


	public static void secured() {
		render();
	}
}
