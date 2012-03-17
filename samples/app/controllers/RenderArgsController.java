package controllers;

import models.Person;
import play.mvc.Controller;

import java.util.Date;

import static com.google.common.collect.Lists.newArrayList;

@SuppressWarnings("UnusedDeclaration")
public class RenderArgsController extends Controller {

	public static void arg1() {
		addRenderArg("arg1");
	}


	public static void arg2() {
		addRenderArg("arg2");
	}

	private static void addRenderArg(String argName) {
		renderArgs.put(argName, "the current time is: " + new Date());
	}
	
	public static void people(){		
		renderArgs.put("people", newArrayList(
				new Person("Alex"), 
				new Person("Ben"),
				new Person("Caroline")
		));
	}
}
