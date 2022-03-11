package com.example.kakaologin.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class KakaoAccount {
    private Profile profile;
    private String gender;
    private String birthday;
    private String email;
}
