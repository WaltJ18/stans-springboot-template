package template;


public interface Command<REQUEST, RESULT> {

    RESULT execute(REQUEST request);

}
