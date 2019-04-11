## 3. CSS
### 5) Element가 배치되는 방법(CSS layout)
#### CSS 통해 HTML 배치되는 방식
* Layout 작업 : HTML 요소들을 화면에 배치하는 것(=Rendering 과정)
* 기본적으로 HTML은 위에서 아래로 배치된다.

* 속성 종류
1. display 속성
* block, inline, inline-block
ⅰ. block
*  \<div\>, \<p\> 등 대부분 element는 block 속성에 소속
ⅱ. inline
* \<span\>, \<a\>, \<strong\> 태그...
* block 속성이라도 inline 속성을 준다면 inline 속성을 가질 수 있다.
2. position 속성
ex) static, absolute, relative, fixed
  1. static
  * position에 대한 설정이 없다면 기본은 static이다.
  * 그냥 순서대로 배치됩니다.
  2. absolute
  * 기준점에 따라서 특별한 위치에 위치
  * top/left/right/bottom으로 설정합니다.
  * 기준점을 상위엘리먼트로 단계적으로 찾아가는데 static이 아닌 position이 기준점
  3. relative
  * 원래 자신이 위치해야 할 곳을 기준으로 이동
  * top/left/right/bottom으로 설정합니다.
  4. fixed
  * viewport(전체화면) 좌측, 맨 위를 기준으로 동작합니다.
3. margin 속성
* 위/아래/좌/우로 엘리먼트간의 간격
4. float 속성


참고.
* p 태그는 위아래에 margin 값을 기본으로 가지고 있다.
