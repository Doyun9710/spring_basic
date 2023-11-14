# spring_basic


<br>


< DIEx01 >   
(com.exam.di01)   
HelloBean1, HelloBean2 : sayHello()   
MainEx : 객체 생성 / 사용 / 소멸   

(com.exam.di02)   
Hello : Interface, 인터페이스, sayHello()   
HelloBean1, HelloBean2 : implements Hello   
MainEx : Hello hello = new HelloBean1(), HelloBean2()   

(com.exam.di03)   
context.xml :    
HelloBean1, HelloBean2 : 생성자 추가   
MainEx : GenericXmlApplicationContext - XML로부터 객체 설정 정보를 가져온다   

(com.exam.di04)   
context.xml :    
Hello : Interface, 인터페이스, sayHello()   
HelloBean1, HelloBean2 : implements Hello   
MainEx : Hello hello = new HelloBean1(), HelloBean2()   

(com.exam.di05)   
context.xml : scope="singleton", scope="prototype"   
HelloBean : sayHello()   
MainEx : Singleton, Prototype   

(com.exam.di06)   
context.xml : <constructor-arg><value>매개변수 값</value></constructor-arg>   
HelloBean : 생성자 매개변수 Override   
MainEx : Singleton, Prototype   


<br>


< DIEx02 >   
(com.exam.di01)   
context.xml : 사용자 설정 매개변수   
BoardTO : 생성자()   
WriteAction, ViewAction : execute()   
MainEx : viewAction.execute()   

(com.exam.di02)   
context.xml : 사용자 설정 매개변수 TO   
BoardTO : seq, subject, lombok - @AllArgsConstructor   
ListAction : execute()   
MainEx : listAction.execute()   

(com.exam.di03)   
Lombok Dependency - https://mvnrepository.com/artifact/org.projectlombok/lombok   
context.xml : Setter 설정   
BoardTO : lombok - Getter, Setter   
WriteAction : lombok - @AllArgsConstructor, execute()   
MainEx : Print Getter   

(com.exam.di04)   
context.xml : namespace p 설정   
BoardTO : lombok - Getter, Setter   
WriteAction : lombok - @AllArgsConstructor, execute()   
MainEx : Print Getter   

(com.exam.di05)   
context.xml : namespace p 설정   
BoardListTO : ArrayList<String> userLists, ArrayList<BoardTO> boardLists;   
BoardTO : lombok - Getter, Setter   
WriteAction : lombok - @AllArgsConstructor, execute()   
MainEx01 : ArrayList<TO> Setter and Getter   
MainEx02 : MainEx01 + context.xml (Bean Configuration File)   

BoardMapTO : HashMap<String, String> userMaps, HashMap<String, BoardTO> boardMaps   
MainEx03 : HashMap + Bean Configuration File   


<br>









