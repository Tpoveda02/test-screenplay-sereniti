package hook;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;


public class OpenBrowser implements Task {

    public OpenBrowser(String url){
        this.url = url;
    }
    private String url;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }

    public static OpenBrowser openBrowser(String url){
        return Tasks.instrumented(OpenBrowser.class, url);
    }
}
