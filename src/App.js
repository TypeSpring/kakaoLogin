
import './App.css';
import Auth from "./Auth";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import KakaoLogin from './component/kakaoLogin';
import ProfilePath from './component/profilePath';

/*global Kakao*/

const kakaoClientId = '여기에 REST API KEY를 입력하세요';
const kakaoRedirectUri = 'developers.kakao에서 Application 등록 이후 Redirect 설정한 값을 넣어주세요';
const loginUri = `https://kauth.kakao.com/oauth/authorize?client_id=${kakaoClientId}\
&redirect_uri=${kakaoRedirectUri}&response_type=code`;

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={ <KakaoLogin KAKAO_AUTH_URL={loginUri}/>} />
        <Route path="/설정한 Redirect Path를 입력하세요" element={<Auth />} />
        <Route path="/profile" element={<ProfilePath />} />
      </Routes>
    </Router>
  );
}

export default App;
