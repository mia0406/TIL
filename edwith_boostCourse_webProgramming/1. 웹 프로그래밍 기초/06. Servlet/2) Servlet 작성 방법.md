## 6. Servlet(Back-end)
### 2) Servlet 작성 방법
#### 버전에 따른 Servlet 작성 방법
1. servlet 3.0 이상
* web.xml 파일 대신, 자바 어노테이션(annotation) 사용
```java
@WebServlet("/sample")
public class sampleServlt extends HttpServlet{ ... }
```

2. servlet 3.0 미만
* web.xml 작성하여 사용
* 서블릿을 등록할 때 web.xml 파일에다가 직접 등록
```xml
<servlet>
    <description>sampleServlet</description>
    <display-name>sampleServlet</display-name>
    <servlet-name>mia.sampleServlet</servlet-name>
</servlet>
<servlet-mapping>
    <servlet-name>sampleServlet</servlet-name>
    <url-pattern>/sample</url-pattern>
</servlet-mapping>
```



#### Servlet 3.0 작성
* servlet 3.0 이상이면 web.xml이 꼭 필요하지는 않지만, 스프링 등 다른 것을 사용할 때 서블릿을 3.0 이상으로 만들었다 하더라도 다른 설정 부분은 web.xml에 추해야 할 필요가 있기 때문에 반드시 web.xml을 만들어야 한다.

* 동적으로 만들어낸다는 것은 이미 응답할 페이지를 만들어서 가지고 있는 게 아니라 요청이 들어왔을 때 이 프로그램이 실행되면서(요청된 url에 맞는 서블릿이 실행) 응답할 코드를 만들어내고 그 코드로 응답

 * 클라이언트가 요청할 때 서버는 요청을 받아내는 객체와 응답을 하기 위해 객체를 자동으로 생성
 ```java
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// request : 브라우저로부터 들어오는 요청 객체
// response : 브라우저로 보낼 응답 객체
 }
 ```
 * 요청에 대한 정보들은 전부 request 객체 안에 추상화시켜 가지고 있다. (response도 동일)
 * 응답으로 무언가를 돌려주려고 한다면 반드시 response 객체에다가 내용을 넣어주어야 한다.

 * response를 보낼 때 브라우저가 응답을 받았을 때 그 데이터가 이미지, 동영상 등 어떤 데이터 종류인지 알아야 하기 때문에 알려주어야 한다.
    → setContenttype() 이용
* 알려주어야만 브라우저가 거기에 맞게 해석해서 데이터를 알맞게 뿌려준다.
* 데이터 종류뿐만 아니라 chart도 같이 추가해서 보내주는 것이 좋다.
```java
response.setContentType("text/html;charset=utf-8");
// text/html 종류의 데이터를 보내고 character encoding은 utf-8로 사용하겠다!
```

* response에 데이터를 그냥 넣는 것이 아니라 보낼 내용을 넣어줄 통로를 하나 얻어야 한다.
  → getWriter() 이용
* response가 가진 getWriter()를 수행하여 PrinterWriter 객체를 얻어서 그 곳에 response로 보낼 내용을 넣는다.

* HTML에서는 반드시 <br> 태그를 써야만 줄이 바뀐다.
  → print(), println() 둘 다 써도 같은 결과 출력

* 똑같은 servlet이라도 url mapping에 따라 요청하는 주소값은 달라진다.
```java
@WebServlet("/ten")
public class TenServlet extends HttpServlet {...}

@WebServlet("/ten10")
public class TenServlet extends HttpServlet {...}

// 둘 다 같은 servlet이지만, 요청하려면 서로 다른 url 주소(/ten, /ten10)를 입력해야 한다.
```



#### Servlet 2.x 작성
* 서블릿은 요청이 들어왔을 때 반드시 서블릿 이름으로 요청하지는 않기 때문에 web.xml은 클라이언트가 url로 요청을 하면 servlet-name이 같은 서블릿을 찾아서 그 servlet에 명시되어 있는 servlet-class 클래스를 실행한다.

* <servlet-mapping>에서 해당 url과 맞는 servlet-name이라는 엘리먼트 확인
* 찾은 servlet-name 가지고 <servlet> 태그 안에서 동일한 servlet-name을 찾는다.

* 3.0 이전 버전에서는 반드시 서블릿이 하나 만들어지면 web.xml에 해당 서블릿을 반드시 등록해야만 실행할 수 있다.

* 주의점: web.xml이 바뀌면 서버는 반드시 restart를 해야 한다.



#### Q.서블릿 파일을 작성할 때 HttpServlet을 상속하지 않았다면 어떻게 동작할까요?
* HttpServlet을 상속하지 않는다면 servlet이라고 인식하지 않는지 그대로 java 파일로 인식되서 url도 보면 웹 url 주소 구조가 아니라 java 파일이라고 뜬다.
* WAS(서블릿컨테이너)는 servlet 호출규칙에 따라 서블릿(.class)을 실행한다. servlet 규칙에 따라 만들어진 class가 HttpServlet이다. 즉 HttpServlet는 서블릿 규칙에 따라 만들어진 것이다. doGet, doPost 등이 서블릿 호출 규칙인데, HttpServlet을 상속하지 않으면 Servlet 규칙에 어긋나기 때문에 에러가 발생
* 500 Error 발생, Class를 Servlet으로 변환할 수 없게 되므로 ClassCastException을 받게되고, 결과적으로 이 클래스는 서블릿이 아니라는 오류 메세지와 함께 ServletException을 받게 된다.
