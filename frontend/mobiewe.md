# 모바일 개발환경 구축 (Mac os)
---------------------------------------------------

1. <https://nodejs.org/ko/>에서 운영체제에 맞는 Node.js설치 (12.13.1LTS 버전 다운받았음)
2. Apatana Studio 설치 <http://www.aptana.com> (3.7.2.201807301111 버전 다운 받음)
3. Java가 설치 되어있지 않을 경우 설치 - 팝업창에 뜬거 시키는대로 해봤자 1.6.0_65버전 설치됨 (애플 19년 05월 지원자료 기준)
+ <https://stackoverflow.com/questions/47444326/download-legacy-jvm-version-1-8-for-mac-high-sierra> <br>
여러가지 글 찾다 찾은 구원글<br>
이 글을 따라 the full Java SE Development Kit 8u231을 설치했다. 귀찮지만 오라클도 가입&#128529;
4. 드.디.어 Apatana Studio 실행 가능

# Apatana Studio 설정
---------------------------------------------------
* 처음 default 주소를 잘못 설정했다면 환경설정에 들어가서 <br>
General > Startup and Shutdown > Propt for workspace on startup 체크 > restart
* Appearance에서 글꼴,크기 등 변경 가능<br>
- 나눔고딕 코딩글꼴 <https://github.com/naver/nanumfont>
*  코드를 실행할 프로그램 설정은 Run configueration에서

### Project 시작하기
1. Web Project 만들기
2. New From Template > HTML > HTML5
