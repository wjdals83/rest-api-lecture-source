package com.ohgiraffers.restapi.section03.valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.charset.Charset;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(UserNotFoundException e) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("appliaction", "json", Charset.forName("UTF-8")));

        String code = "ERROR_CODE_0001";
        String description = "회원 정보 조회에 실패했습니다.";
        String detail = e.getMessage();

        return new ResponseEntity<>(new ErrorResponse(code,description,detail),headers, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleNotValidException(MethodArgumentNotValidException e) {

        String code = null;
        String description = null;
        String detail = null;

        if(e.getBindingResult().hasErrors()){

        String bindingErrorCode = e.getBindingResult().getFieldError().getCode();
        detail=e.getBindingResult().getFieldError().getDefaultMessage();

        switch (bindingErrorCode) {
            case "NotNull":
                code = "ERROR_CODE_0002";
                description = "필수 값이 누락되었습니다!!!";
                break;
            case "Size" :
                code = "ERROR_CODE_0003";
                description = "글자 수를 확인해주세요...";
                break;
            case "NotBlank":
                code = "ERROR_CODE_0004";
                description = "공백은 불가합니다!!!";
                break;
            case "Past":
                    code = "ERROR_CODE_0005";
                    description = "past 값을 입력해주세요!!!";
                break;
        }
        }

        return ResponseEntity
                .badRequest()
                .body(new ErrorResponse(code, description, detail));
    }


}
