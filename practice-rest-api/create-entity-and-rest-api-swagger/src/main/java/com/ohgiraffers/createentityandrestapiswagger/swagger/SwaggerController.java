package com.ohgiraffers.createentityandrestapiswagger.swagger;

import com.ohgiraffers.createentityandrestapiswagger.model.dto.InstaDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "Spring Boot Swagger")
public class SwaggerController {

    private List<InstaDTO> insta;
    public SwaggerController() {

        insta = new ArrayList<>();

        insta.add(new InstaDTO(1, LocalDateTime.now(), 3, "내용을 입력해주세요"));
    }


    @Operation(summary = "전체 정보 조회", description = "insta 전체 정보 조회하기")
    @GetMapping("/insta")
    public ResponseEntity<ResponseMessage> findAllInsta() {

        HttpHeaders headers = new HttpHeaders();    // 헤더의 정보를 바꾸기
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("insta", insta );

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공!!!", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

}
