package com.example.rukanjidictionaryapp.controller;

import com.example.rukanjidictionaryapp.dto.JwtAuthenticationResponse;
import com.example.rukanjidictionaryapp.dto.SignInRequest;
import com.example.rukanjidictionaryapp.dto.SignUpRequest;
import com.example.rukanjidictionaryapp.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//ユーザーの認証コントローラ
@RestController
@RequestMapping("api/v1/kanjidic/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    //新しいユーザーを登録するメソッド
    @PostMapping("/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody @Validated SignUpRequest request) {
        return authenticationService.signUp(request);
    }
    //既存のユーザーをログインさせるメソッド
    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody @Validated SignInRequest request) {
        return authenticationService.signIn(request);
    }

}
