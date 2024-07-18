package kr.re.kitri.springposts.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@ControllerAdvice
@RestController
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BadSqlGrammarException.class)
    public String handleBSGE(BadSqlGrammarException exception) {
        return "고객님 불편을 드려 죄송합니다.";
    }

    @ExceptionHandler(Throwable.class)
    public String handleException(Throwable exception) {
        log.info(exception.toString());
        return "문제가있어요..";
    }

}
