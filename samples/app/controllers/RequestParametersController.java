package controllers;

import play.mvc.Controller;

public class RequestParametersController extends Controller {

    public static void answerGet(String parameter) {
        renderText("Parameter passed: " + parameter);
    }

    public static void answerGetMultipleParams(String parameter1, String parameter2) {
        renderText("Parameters: (parameter1, " + parameter1 + "), (parameter2, " + parameter2 + ")");
    }

    public static void answerPost(String parameter) {
        renderText("Parameter passed: " + parameter);
    }

}
