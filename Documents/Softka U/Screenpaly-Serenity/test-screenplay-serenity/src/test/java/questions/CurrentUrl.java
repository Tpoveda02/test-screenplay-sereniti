package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CurrentUrl implements Question<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUrl.class);
    private CurrentUrl() {
    }
    public static CurrentUrl currentUrl() {
        return new CurrentUrl();
    }
    @Override
    public String answeredBy(Actor actor) {
        String url = TheWebPage.currentUrl().answeredBy(actor);
        LOGGER.info("[Current URL] - Actor '{}' está en la URL: {}", actor.getName(), url);
        return url;
    }
}
