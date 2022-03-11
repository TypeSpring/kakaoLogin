import KaKaoLogin from "react-kakao-login";
import styled from "styled-components";
const KaKaoBtn = styled(KaKaoLogin)`
  padding: 0;
  width: 190px;
  height: 44px;
  line-height: 44px;
  color: #783c00;
  background-color: #ffeb00;
  border: 1px solid transparent;
  border-radius: 3px;
  font-size: 16px;
  font-weight: bold;
  text-align: center;
  cursor: pointer;
  &:hover {
    box-shadow: 0 0px 15px 0 rgba(0, 0, 0, 0.2);
  }
`;

const KakaoLogin = ({ KAKAO_AUTH_URL }) => {
  return (
    <div>
      <a href={KAKAO_AUTH_URL}>
        <img src="/kakao_login_medium_narrow.png" />
      </a>
    </div>
  );
};
export default KakaoLogin;
