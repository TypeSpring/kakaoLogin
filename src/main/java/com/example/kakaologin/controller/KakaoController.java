package com.example.kakaologin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kakaologin.dto.KakaoAccount;
import com.example.kakaologin.service.KakaoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class KakaoController {

    private final KakaoService kakaoService;

    /**
     * https://kauth.kakao.com/oauth/authorize?response_type=code&client_id={여기에 REST API KEY를 입력해주세요}&redirect_uri={여기에 지정한 RedirectURL을 입력해주세요}
     * 위의 결과로 code를 받아와서, 해당 코드를 통해 카카오 인증 서버에서 accessToken/refreshToken을 받아옵니다.
     */
    @GetMapping("/callback")
    public KakaoAccount getKakaoAccount(@RequestParam("code") String code) {
        log.debug("code = {}", code);
        return kakaoService.getInfo(code).getKakaoAccount();
    }
}
