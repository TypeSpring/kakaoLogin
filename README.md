# kakaoLogin Front/Back version

### 사전준비

1. 카카오 로그인을 위해 https://developers.kakao.com/ 에서 개발자 계정을 생성한 후, 어플리케이션을 등록한다.

2. 내 어플리케이션 > 앱 설정 > 요약 정보에서 해당하는 key값들을 확인한다.

3. 내 애플리케이션 > 제품 설정 > 카카오 로그인 redirect url 을 설정한다.

4. 해당하는 키값을 코드에 대입한다.

<br/>

### 흐름

1. `https://kauth.kakao.com/oauth/authorize?response_type=code&client_id={RestAPI Key}&redirect_uri={redirectUrl}` 요청합니다.
2. 위의 요청을 통해 code를 얻어올 수 있고, 이 코드를 받아서 지정한 RedirectUrl로 이동되며, 이 때 파라미터로 code가 넘어갑니다.
3. 예를 들어 code = 1234567이라고 하면, `localhost:3000/callback?code=1234567` 과 같은 방식입니다.
4. 이 받아온 코드를 통해 `https://kauth.kakao.com/oauth/token?client_id={RestAPI Key}&redirect_uri={redirectUrl}&code={받아온 코드}&grant_type=authorization_code`로 Request를 날리면, accessToken, refreshToken을 받아올 수 있습니다.
5. 이 accessToken을 통해서, 이제 kakao에서 제공하는 서비스 API들을 사용할 수 있게 됩니다.
6. 예를 들어 유저에 대한 정보를 가져올 수 있는 api는 `https://kapi.kakao.com/v2/user/me`와 같은 도메인에 각 요청을 보낼 때 Authorization 필드에 Bearer 타입으로 accessToken을 넣어주면 됩니다. `'Authorization' : "Bearer {accessToken}"`
7. 이 예제 프로젝트는 필수로 닉네임을 받고, 성별, 생일, 이메일 등은 선택적으로 받을 수 있도록 구현한 Simple한 예제입니다.

<br/>

### 카카오 로그인 이미지 다운받기

카카오 로그인 버튼 이미지는 이곳 (https://developers.kakao.com/tool/resource/login) 에서 다운받을 수 있습니다.

<br/>

### RestAPI 명세서

RestAPI 명세서 : https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api
