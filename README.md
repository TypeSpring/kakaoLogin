# kakaoLogin Front/Back version

RestAPI 명세서 : https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api

### 흐름

**사전 준비 : developers kakao에서, application 등록 후 얻는 RestAPI Key가 필요하며, redirectUrl을 지정해야 합니다.**

1. `https://kauth.kakao.com/oauth/authorize?response_type=code&client_id={RestAPI Key}&redirect_uri={redirectUrl}` 요청합니다.
2. 위의 요청을 통해 code를 얻어올 수 있고, 이 코드를 받아서 지정한 RedirectUrl로 이동되며, 이 때 파라미터로 code가 넘어갑니다. 
3. 예를 들어 code = 1234567이라고 하면, `localhost:3000/callback?code=1234567` 과 같은 방식입니다.
4. 이 받아온 코드를 통해 `https://kauth.kakao.com/oauth/token?client_id={RestAPI Key}&redirect_uri={redirectUrl}&code={받아온 코드}&grant_type=authorization_code`로 Request를 날리면, accessToken, refreshToken을 받아올 수 있습니다.
5. 이 accessToken을 통해서, 이제 kakao에서 제공하는 서비스 API들을 사용할 수 있게 됩니다.
6. 예를 들어 유저에 대한 정보를 가져올 수 있는 api는 `https://kapi.kakao.com/v2/user/me`와 같은 도메인에 각 요청을 보낼 때 Authorization 필드에 Bearer 타입으로 accessToken을 넣어주면 됩니다. `'Authorization' : "Bearer {accessToken}"`
7. 이 예제 프로젝트는 필수로 닉네임을 받고, 성별, 생일, 이메일 등은 선택적으로 받을 수 있도록 구현한 Simple한 예제입니다.
