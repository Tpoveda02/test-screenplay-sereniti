package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GoToOtherPage implements Task {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoToOtherPage.class);

    private final Target link;
    private final String description;

    public GoToOtherPage(Target link, String description) {
        this.link = link;
        this.description = description;
    }

    @Step("{0} {description}")
    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} está navegando a: {}", actor.getName(), description);
        actor.attemptsTo(Click.on(link));
    }

    public static GoToOtherPage on(Target link, String description) {
        return Tasks.instrumented(GoToOtherPage.class, link, description);
    }

}
