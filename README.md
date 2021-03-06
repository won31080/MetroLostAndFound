<div align="center">
  
# __🚇분실물아대답해🚇__
# 2021/12/26 서버 종료
## 🚀오픈소스소프트웨어개발🚀

### 🤝Created by 이정원, 안은기, 장민석, 권승환🤝

</div>
  
  
# 📖목차

### 1. [프로젝트 내용](#1.-프로젝트-내용)
### 2. [사용 방법](#2.-사용-방법)
### 3. [설치 방법 및 기타 등등](#3.-설치-방법-및-기타-등등)

---
## 1. 프로젝트 내용
  
  - `🚇분실물아대답해🚇`는 기존에 존재하던 `경찰 LOST112`사이트의 문제점을 보완하고, 사용자가 편하게 사용할 수 있도록 개발했다. 기존에 존재하던 `경찰 LOST112`는 웹 사이트와 어플리케이션을 통해서 사용할 수 있다. 사이트는 2021년 8월 기준 약 21만회의 준수한 트래픽을 보여주지만, 어플리케이션은 관리가 제대로 이루어지지 않아 사용함에 있어 어려움이 있다. 자료 조사를 통해 어플리케이션에 어떤 문제점이 있는지 파악했다.

  <pre>
  <code>
  1. 웹에는 업로드된 분실물이 앱에는 업로드 되지 않았다.
  2. 게시되는 분실물의 내용에 사진이 포함되어 있지 않다.
  3. 검색 필터의 세부 사항이 부족하다.
  </pre>
  </code>
  
  - 위처럼 세 가지 문제점이 존재하며, 아래의 해당 기사를 확인해보면 송석준 의원이 지하철 분실물 회수율에 대한 지적을 담고 있다. 의원은 계속해서 줄어드는 분실물 회수율에 대해 지적하며 분실물에 관한 시스템 개선이 필요하다고 한다. 이 기사의 작성년도는 17년도이며, 아직 `경찰 LOST112`의 시스템 개선이 이루어지지 않았다. 따라서 유실물 관리 시스템의 단점을 보완하고자 프로젝트를 제안했다. 

  - 📰[기사 바로가기](https://www.gokorea.kr/news/articleView.html?idxno=28434)

---
## 2. 사용 방법
  
  이 프로젝트에서 사용자들이 이용할 수 있는 기능은 두가지로 나뉜다. 분실물을 등록하는 기능과 분실물을 찾는 기능이다.
  
  - ### ⌨️분실물 등록 기능⌨️
    분실물을 등록하려면, 메인화면에서 하단의 메뉴 바에 존재하는 `등록 메뉴`, 또는 `분실물 등록 버튼`을 누른다. 버튼을 누르게 되면, `비밀번호`를 입력하는 창이 뜬다. `비밀번호`를 입력한 후, 습득한 분실물의 대분류를 선택할 수 있는 화면이 등장한다. 사용자가 대분류를 선택하면, 다시 그 `대분류`에 대한 `소분류`를 선택할 수 있는 화면이 뜬다. 소분류까지 선택하게 되면, `습득한 일자`, `시간`, `호선과 역명`을 입력할 수 있게 된다. 다음 단계로 넘어가면 `사진과 보관 장소`, `추가 사항`을 입력할 수 있다. `완료` 버튼을 누르면 데이터베이스에 입력한 정보들이 들어가게 된다. 만약 등록 중에 취소하고 싶다면 `뒤로가기` 버튼을 눌러 등록을 취소할 수 있다.

- ### 🔎분실물 찾기 기능🔎
    분실물을 찾기 위해서 먼저 기본 화면에서 메뉴바의 `찾기` 메뉴를 클릭한다. `찾기` 메뉴에 들어가서 `새로고침 버튼`을 누르면 데이터베이스에 저장된 모든 분실물이 창에 뜨게 된다. 만약 세부적인 검색이 필요하다면 오른쪽 위의 `세부 검색` 버튼을 눌러 검색을 진행하게 된다. `세부 검색`의 검색 내용은 `잃어버린 호선과 역명`, `잃어버린 시간`, `분류`를 선택한 후에 `검색` 버튼을 누르고 다시 `새로고침`을 누르게 되면, 자신의 세부 검색 내용에 따라 검색이 완료되어 해당하는 내용들이 화면에 표시되게 된다. 각각의 내용을 누르게 되면, 분실물의 `세부 정보`와 `사진`이 뜨는 화면이 보여지게 된다. 위 화면에서 `삭제` 버튼을 누르고 입력했던 `비밀번호`를 누르면 데이터가 삭제된다.

---
## 3. 설치 방법 및 기타 등등
  - GitHub의 초록색의 Code를 눌러 zip 파일을 다운로드한다. 그리고 압축을 풀어 파일의 경로 `MetroLostAndFound/app/release/` 으로 이동한다. 그리고 `app-release.apk`을 실행한다.
  - 본 프로젝트는 베타 버전이기 때문에 기능 구현이 목적이므로, 수인분당선을 기준으로 만든 버전입니다.
  - 🖥️[실행 영상](https://www.youtube.com/watch?v=YD5QkSLnxhw)
