package com.example.kakaologin.client;

import java.net.URI;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.kakaologin.config.KakaoFeignConfiguration;
import com.example.kakaologin.dto.KakaoInfo;
import com.example.kakaologin.dto.KakaoToken;

@FeignClient(name = "kakaoClient", configuration = KakaoFeignConfiguration.class)
public interface KakaoClient {

    @PostMapping
    KakaoInfo getInfo(URI baseUrl, @RequestHeader("Authorization") String accessToken);

    @PostMapping
    KakaoToken getToken(URI baseUrl, @RequestParam("client_id") String restApiKey,
                        @RequestParam("redirect_uri") String redirectUrl,
                        @RequestParam("code") String code,
                        @RequestParam("grant_type") String grantType);

}
