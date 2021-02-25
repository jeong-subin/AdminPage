# AdminPage
스프링 부트를 사용한 관리자페이지 만들기  
21.01.26 ~ 21.02.08

## 21.02.02
1.ERD 생성  
2.mySql 테이블생성  
3.entity 생성  
4.Repository 생성  
5.Repository db 연동 Test 완료  


## 21.02.03  
1.연관관계설정  
2.사용자 CRUD 만들기  

## 21.02.07  
1.상품 CRUD만들기  
2.주문내역 CRUD 만들기
  

## 21.02.08  
1.enum 형태의 값관리  
  User - status //REGISTERED / UNREGISTERED / WAITING  
  item - status  // 등록/해지/검수중(등록대기중)  
  OrderGroup - orderType  //주문형태 일괄/개별  
2.controller 추상화 적용  
 원래는 CrudInterface를 implements 해서 사용했으나    
 @PostMapping .. 등등 중복되는 코드를 없애기 위해  
  CrudController 추상클래스 생성 후 
  ItemApiController 상속  
  OrderGroupApiController  상속 
  받아서 중복되는 부분을 없앰  
3.PartnerApiLogicService 추가
 

## 21.02.09 
user페이징 기능 추가  
user 상세검색  
view랑 연결  
