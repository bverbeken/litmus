package controllers;

import play.mvc.Controller;
import play.mvc.results.Forbidden;
import play.mvc.results.NotFound;

@SuppressWarnings("UnusedDeclaration")
public class ResponseController extends Controller {
	
	public static void ok(){

	}

	public static void notFound(){
		throw new NotFound("not found. Sorry");
	}

	public static void forbidden(){
		throw new Forbidden("Forbidden. Forbidden I tell ya!");
	}
	
	public static void redirect(){
		redirectTo();
	}
	
	public static void redirectTo(){

	}
	
}
