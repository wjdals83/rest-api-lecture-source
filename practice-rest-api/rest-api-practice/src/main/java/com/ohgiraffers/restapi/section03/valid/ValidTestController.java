package com.ohgiraffers.restapi.section03.valid;

import jakarta.validation.Valid;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/valid")
public class ValidTestController {

    private List<UserDTO> users;

    public ValidTestController() {

        users = new ArrayList<>();

        users.add(new UserDTO(1, "user01", "pass01", "너구리", LocalDate.now()));
        users.add(new UserDTO(2, "user02", "pass02", "코알라", LocalDate.now()));
        users.add(new UserDTO(3, "user03", "pass03", "푸바오", LocalDate.now()));
    }

    @GetMapping("/users/{userNo}")
    public ResponseEntity<ResponseMessage> findUserByNo(@PathVariable int userNo) throws UserNotFoundException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("applilcation", "json", Charset.forName("UTF-8")));

        List<UserDTO> foundUserList = users.stream().filter(user -> user.getNo() == userNo).collect(Collectors.toList());
        UserDTO foundUser = null;
        if(foundUserList.size() > 0) {
            foundUser = foundUserList.get(0);
        } else {
            throw new UserNotFoundException("회원 정보를 찾을 수 없습니다.");
        }

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("user", foundUser);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseMessage(200, "조회 성공", responseMap));

    }

    @PostMapping("/users")
    public ResponseEntity<?> registUser(@Valid @RequestBody UserDTO newUser) {

        users.add(newUser);

        return ResponseEntity
                .created(URI.create("/valid/users/" + newUser.getNo())).build();

    }


}
