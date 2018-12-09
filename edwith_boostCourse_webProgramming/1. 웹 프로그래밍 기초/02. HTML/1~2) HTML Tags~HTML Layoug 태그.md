
## 1. Web 개발의 이해(Front-end/Back-end)
### 1) HTML Tags
* 각각의 스타일은 HTML이 아니고 CSS로 표현해주는 것이 좋다.
* \<div>
    * block 엘리먼트라고 하는데, 일반적인 영역을 표현할 때 가장 많이 사용
* HTML5에서부터 HTML4에서는 사용 가능한 것이 사용할 수 없게 된 것도 있다. 그건 필요할 때 찾아보도록!


### 2) HTML Layout 태그
* 레이아웃이란?
  * '배치'란 뜻
  * HTML 태그로 감싸진 각 정보 요소를 화면상의 어느 위치에 어떻게 자리잡을지를 결정하는 것

* PC에서는 대게 \<header>, \<footer> 이런 식의 태그를 사용하기보다는 div 태그를 이용하여 생성하고 거기에다 클래스로 이름을 header, footer 사용하는 방식을 주로 사용
```HTML
    <header></header>
    <footer></footer>
    <!-- 이런 방식보다는 -->

    <div class="header">
    </div>
    <div id="footer">
    </div>
    <!-- 이런 방식으로 div 태그를 이용해서 레이아웃 -->
```

* 모바일에서는 \<header>와 같이 이런 태그들로 많이 사용
