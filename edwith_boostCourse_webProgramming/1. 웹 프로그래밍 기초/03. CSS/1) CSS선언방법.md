## 3. CSS
### 1) CSS 선언방법
* CSS의 선언은 선택자와 그다음 property, value로 구성
* CSS 선언 방법
1. inline
* HTML 태그 안에다가 넣는 방법
2. internal
* 장점 : 별도의 CSS파일을 관리하지 않아도 되며 서버에 CSS파일을 부르기 위해 별도의 브라우저가 요청을 보낼 필요가 X
3. external
* 외부파일(.css)로 지정하는 방식
* external 방식을 가장 권장

* inline은 별도의 우선순위를 갖지만, internal과 external은 우선순위가 동등합니다. 따라서 겹치는 선언이 있을 경우 나중에 선언된 속성이 반영됩니다.
  - 예를 들어, 같은 id에 해당하는 css를 internal과 external을 등록해두었다면, 어떤걸 먼저 선언하냐에 따라 적용하는 것이 다르다.
```HTML
<head>
<!-- external 방식 -->
<link rel="stylesheet" href="style.css">
<!-- internal 방식 -->
<style>
p{
	color: red;
}

.str{
	color: red;
}
</style>
</head>
```
* 이렇게 선언한다면 internal 방식이 나중에 선언되었기 때문에 겹치는 것이 존재한다면, internal 방식으로 선언된 것이 사용
```HTML
<head>
<!-- internal 방식 -->
<style>
p{
	color: red;
}

.str{
	color: red;
}
</style>
<!-- external 방식 -->
<link rel="stylesheet" href="style.css">
</head>
```
* external 방식이 나중에 선언되었기 때문에 겹치는 것이 존재한다면, external 방식으로 선언된 것이 사용

#### 참고
https://www.hostinger.com/tutorials/difference-between-inline-external-and-internal-css

#### 생각해보기
1. javascript로 동적으로 css코드를 수정하려고 하면 어떻게 해야 할까요? 나중에 차츰 알게 되지만, 미리 어떤 방법이 있을지 고민해보세요.
2. 구글 웹사이트는 어떻게 css를 선언하고 있을까요? 구글 웹사이트(구글 내 여러가지 웹사이트중 하나)에서 소스보기를 해서 CSS 코드를 한번 찾아보세요. internal 방식이나 external 방식 등을 목격할 수 있을 겁니다.
