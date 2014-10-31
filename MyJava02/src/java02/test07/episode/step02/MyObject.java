package java02.test07.episode.step02;



/*
  클래스에 애노테이션 추가
*/

//사용법1 =>@애노테이션명(속성=값)
//@MyAnnotation(value="홍길동")


//사용ㅇ법2
//만약 속성명이 "value"고, 이 속성의 값만 설정한다면 생략가능
//default 값이 설정되지 않은 속성은 필수 입력 항목이다.
//2개 이상의 속성을 설정할 때는 value 이름을 생략할 수 없다.
@MyAnnotation(
    value ="okok",
    name = "홍길동",
    //language = {"korean", "english"},
    //배열에 값을 하나만 넣을 때는 중관호{}를 생략할 수 있따.
    
   //language ={"korean"}, 정석,        아래도 가능..
    
    language ="korean",
    
    age = 20
    )
public class MyObject {

}
