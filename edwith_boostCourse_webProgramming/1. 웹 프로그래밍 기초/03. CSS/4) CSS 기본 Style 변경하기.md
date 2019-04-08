## 3. CSS
### 4) CSS 기본 Style 변경하기
#### 1. em
* HTML에서 기본 font 사이즈를 지정하지 않는다면 16px이다.
* em : 기본 픽셀  대비 상대적인 크기를 배수로 지정할 때 사용(상대적인 값)
ex) 기본 픽셀값 : 16px(픽셀)
  - 1em : 16*1=16px
  - 2em : 16*2=32px

* 꼭 기준 픽셀값은 16px이다? No!
  - if, body나 element에 font-size를 지정했다?
    - font-size 값은 자식 노드에 상속이 되기 때문에 그 font-size를 기준으로 책정
```CSS
div{
  font-size: 32px;
  /* div 엘리먼트의 기본 픽셀값은 32px로 변경 */
}

div > #myDiv1{
  font-size: 1em;
  /* font size는 32*1=32px로 책정 */
  /* div 밑의 class이기 때문에 div element에 지정한 font-size가 상속됨 */
}

div > #myDiv2{
  font-size: 2em;
  /* font size는 32*2=64px로 책정 */
}
```

#### 2. 웹 폰트
```css
body{
  font-family: sans-serif, "돋움";
}
```
* 가장 왼쪽에 쓰여진 폰트부터 적용
* 작성한 폰트가 존재하지 않다면 그 다음에 작성한 웹 폰트를 적용
  - 가장 마지막에는 기본 폰트를 지정하는 것이 좋다.
