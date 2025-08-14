package template;


public interface CommandExecutor {

    <REQUEST, RESULT> RESULT execute(Class<? extends Command<REQUEST, RESULT>> commandClass, REQUEST request );

}
