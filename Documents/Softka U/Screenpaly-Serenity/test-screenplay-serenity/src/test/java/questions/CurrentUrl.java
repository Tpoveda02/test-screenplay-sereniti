package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.page.TheWebPage;



public class CurrentUrl implements Question<String> {


    private CurrentUrl() {
    }

    public static CurrentUrl currentUrl() {
        return new CurrentUrl();
    }

    @Override
    public String answeredBy(Actor actor) {
        return TheWebPage.currentUrl().answeredBy(actor);
    }
}