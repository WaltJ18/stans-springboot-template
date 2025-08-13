package template;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.ErrorResponseException;

import java.util.Set;

public abstract class AbstractCommand<REQUEST, RESULT>
    implements Command<REQUEST, RESULT>, ApplicationContextAware, InitializingBean {

    protected Validator validator;

    protected ApplicationContext applicationContext;

    @Override
    public final void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public final void afterPropertiesSet() throws Exception {
        this.validator = applicationContext.getBean(Validator.class);
    }


    @Override
    public final RESULT execute(REQUEST request) {
        Set<ConstraintViolation<REQUEST>> constraintViolations = validator.validate(request);
        if (constraintViolations.isEmpty()) {
            return doExecute(request);
        } else {
            throw new ErrorResponseException(HttpStatusCode.valueOf(400));
        }
    }

    public abstract RESULT doExecute(REQUEST request);
}
