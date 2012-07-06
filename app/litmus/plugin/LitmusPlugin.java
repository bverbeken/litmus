package litmus.plugin;

import play.Play;
import play.PlayPlugin;

import static play.mvc.Router.prependRoute;

public class LitmusPlugin extends PlayPlugin {

    @Override
    public void onRoutesLoaded() {
        if (isLitmusTestrunnerEnabled()){
            prependRoute("GET", "/@tests", "LitmusTestRunner.testList");
            prependRoute("GET", "/@tests/init", "LitmusTestRunner.init");
            prependRoute("GET", "/@tests/end", "LitmusTestRunner.end");
            prependRoute("GET", "/@tests/run", "LitmusTestRunner.run");
        }
    }

    private boolean isLitmusTestrunnerEnabled() {
        String property = Play.configuration.getProperty("litmus.runner");
        return property == null || !property.equalsIgnoreCase("false");
    }


}
