
## 1. Web 개발의 이해(Front-end/Back-end)
### 4) browser에서의 웹 개발

*  웹 클라이언트 코드는 브라우저 안에서 동작

```html
<!DOCTYPE html>
<html>
  <head>
  <!-- HTML의 추가적인 내용, 즉 HTML 문서에 대한 추가적인 설명, 문서에 대한 자세한 정보들이 포함(우리 눈에 보이지는 X) -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <!-- meta 태그, 이 문서가 어떤 것인지 브라우저에게 알려주는 것 -->
    <title>edwith</title>
    <script>
      console.log("Test code");
      <!-- 이 코드를 이렇게 위에다가 넣게 되면 이 script 코드를 먼저 해석하게 되고, 그렇게 되면 밑의 code들은 해석은 뒤로 밀리면서 늦어지게 된다. -->
      <!-- console: 개발자들 콘솔 -->
    </script>
  </head>
  <body>
    <div>browser의 웹 개발 강의</div>
  </body>
  <script>
      console.log("Test code");
      <!-- console: 개발자들 콘솔 -->
  </script>
</html>
```

* Javascript 코드는 일반적으로 html 끝나는 부분에 넣어주는 것이 좋다.
→ 이유 : 위쪽(\<head> 태그 안)에 넣으면 브라우저가 HTML을 해석하는 동안 Javascript 코드를 다운받고 해석하느라고 밑의 HTML 해석이 느려진다. Javascript가 브라우저 렌더링을 방해하는 것이다.
  (렌더링 : 화면에 어떻게 보여줘야 될지 결정해주는 것)
→ 이런 방해를 조금이라도 줄일려면 가급적 Javascript 코드를 html 아래쪽(\<body> 끝나고 나서)에 위치하는 것이 좋다.

- CSS 코드는 주로 <head> 안에 넣는다.
- CSS이든 Javascript 코드이든 길어지게 되면 가독성 등을 위해 코드를 외부 파일로 따로 생성하고 링크를 달아서 이용

Q) 그렇다면 파일을 어떻게 가져오느냐?
  A) 브라우저에서 서버로 요청을 보내서 받는다. 그러면 서버에서 이 파일을 받은 다음에 바로 해석에 들어간다. 해석을 해서 혹시 바로 실행되야 할 Javascript 코드가 있다면 그걸 먼저 보여준다. 실행을 한 뒤 그 실행이 다 끝났다 그러면 다시 원래 코드로 돌아가서 이어진다.

* 브라우저는 한 라인씩 해석한다.
