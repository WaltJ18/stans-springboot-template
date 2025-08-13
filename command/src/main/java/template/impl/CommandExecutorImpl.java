package template.impl;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import template.Command;
import template.CommandExecutor;

@Component
public class CommandExecutorImpl implements CommandExecutor, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public  <REQUEST, RESULT> RESULT  execute(Class<? extends Command<REQUEST, RESULT>> commandClass, REQUEST request) {
        Command<REQUEST, RESULT> command = applicationContext.getBean(commandClass);
        return command.execute(request);
    }
}
