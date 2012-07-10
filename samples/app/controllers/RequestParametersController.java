package controllers;

import play.mvc.Controller;

public class RequestParametersController extends Controller {

    public static void answerGet(String parameter) {
        renderText("Parameter passed: " + parameter);
    }

    public static void answerPost(String parameter){
        renderText("Parameter passed: " + parameter);
    }

}
