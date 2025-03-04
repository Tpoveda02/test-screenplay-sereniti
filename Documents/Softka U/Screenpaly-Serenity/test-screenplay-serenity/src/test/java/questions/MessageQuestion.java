package questions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageQuestion implements Question<Boolean> {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageQuestion.class);

    private final String text;
    private final Target target;

    public MessageQuestion(String text, Target target) {
        this.text = text;
        this.target = target;
    }

    public static MessageQuestion verifyContentOfMessage(String text, Target target) {
        return new MessageQuestion(text, target);
    }

    @Step("{0} visualizará el mensaje esperado: '#text'")
    @Override
    public Boolean answeredBy(Actor actor) {
        String actualMessage = target.resolveFor(actor).getText();

        LOGGER.info("Verificando mensaje esperado: '{}'", text);
        LOGGER.info("Mensaje actual en la UI: '{}'", actualMessage);

        boolean result = actualMessage.contains(text);

        if (result) {
            LOGGER.info("El mensaje es correcto.");
        } else {
            LOGGER.warn("El mensaje NO coincide. Esperado: '{}', Encontrado: '{}'", text, actualMessage);
        }

        return result;
    }
}
