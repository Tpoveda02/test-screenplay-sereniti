    package tasks;

    import net.serenitybdd.annotations.Step;
    import net.serenitybdd.screenplay.Actor;
    import net.serenitybdd.screenplay.Task;
    import net.serenitybdd.screenplay.Tasks;
    import net.serenitybdd.screenplay.actions.SelectFromOptions;

    import static userinterface.PageProduct.SORT_DROPDOWN;

    public class SortTask implements Task {
        private String sort;

        public SortTask(String sort){
            this.sort = sort;
        }

        @Step("El usuario selecciona el criterio de ordenamiento")
        @Override
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    SelectFromOptions.byVisibleText(sort).from(SORT_DROPDOWN)
            );
        }

        public static SortTask by(String sort){
            return Tasks.instrumented(SortTask.class, sort);
        }
    }
