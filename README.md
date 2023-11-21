# spring_basic


<br><br>


### < DIEx01 >   
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


<br><br>


### < DIEx02 >   
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

(com.exam.di06)   
Maven - MariaDB 3.2.0 https://mvnrepository.com/artifact/org.mariadb.jdbc/mariadb-java-client/3.2.0   
com.exam.di06.model1   
	BoardDAO   
	BoardTO   
com.exam.di06.model2   
	Action   
	ListAction : dao.boardLists()   
com.exam.di06   
	MainEx01 : 기본 JDBC   
	MainEx02 : context.xml 사용   


<br><br>


### < DIEx03 >   
(com.exam.di01)   
MainEx01 : 다형성 호출   
MainEx02 : Default scope : singleton   
(./model1)   
Hello : Interface   
HelloBean1, HelloBean2 : print(name)   
(./config)   
BeanConfig : @Bean, 다형성 + Option(name, scope)   

(com.exam.di02)   
MainEx : new AnnotationConfigApplicationContext( BeanConfig.class )   
(./model)   
Hello : Interface   
HelloBean : sayHello()   
(./config)   
BeanConfig : Annotation @Bean   

(com.exam.di03)   
MainEx : Annotation   
(./model1)   
BoardTO : seq, subject   
WriteAction : 생성자()   
(./config)   
BeanConfig : @Bean WriteAction   

(com.exam.di04)   
DIEx02/src/com/exam/di06 + Annotation   
(./model1)   
BoardDAO : boardList2()   
BoardTO : seq, subject, writer, mail, password, content, hit, wip, wdate, wgap   
(./model2)   
Action : Interface   
ListAction : execute()   
(./config)   
BeanConfig : @Bean ListAction   

(com.exam.lifecycle)   
MainEx : Bean Lifecycle 빈 라이프사이클 https://blog.naver.com/edy5016/221280377077   
(./model)   
Action : Interface   
WriteAction : implements Action, InitializingBean, DisposableBean, ApplicationContextAware, BeanNameAware, BeanClassLoaderAware, BeanFactoryAware   
(./config)   
BeanConfig : @Bean( initMethod = "init_method", destroyMethod = "destroy_method" )   
CustomBeanPostProcessor : postProcessAfterInitialization(), postProcessBeforeInitialization()   

(com.exam.di05)   
MainEx : 다중 Config.class 가져오기   
(./model)   
Hello : Interface   
HelloBean1, HelloBean2 : Print Hello + name   
(./config)   
BeanConfig : @Import( { BeanConfig1.class, BeanConfig2.class } )   
BeanConfig1, BeanConfig2 : @Bean HelloBean1, HelloBean2   

(com.exam.di06)   
MainEx : call getDAO()
(./model)   
BoardDAO : Print Log   
WriteAction : @Autowired, getDAO()   
(./config)   
BeanConfig : @Configuration   

(com.exam.di06_fz)   
실습코드   


<br><br>


### < AOPEx01 >   
(com.exam.aop01)   
MainEx : getBean( "writeAction", Action.class ), execute() 전처리/후처리   
**<span style="color:red">Context.xml : AOP 설정</span>**   
(./model)   
Action : Interface   
WriteAction : constructor, setWriter(), execute()   
(./advice)   
BasicAdvice1, BasicAdvice2 : 전처리, 후처리 LOG   

(com.exam.aop02)   
AOPEx01/pom.xml : <dependency> AspectJ => com.exam.aop02.advice 의 implements 불필요   
Context.xml : AOP 환경 설정
(./model)   
Action : Interface   
WriteAction : constructor, execute()   
(./advice)   
BasicAdvice1, BasicAdvice2 : Print LOG   

(com.exam.aop03)   
MainEx : Call Action   
Context.xml : Annotation 자동 검사 <aop:aspectj-autoproxy />   
(./model)   
Action : Interface   
WriteAction : constructor, execute()   
(./advice)   
BasicAdvice1, BasicAdvice2 : Print LOG   
BasicAdvice3 : 전처리, 후처리만 실행 @Before( "execution(* execute())" ), @After( "execution(* execute())" )   
(./config)   
BeanConfig : @Bean WriteAction   


<br><br>


### < BoardModel2Ex >   
URL 방식 Board Project   


<br><br>


### < WebEx01 >   
** Spring MVC + URL 방식 Maven Project **   
pom.xml : artifactId => mvc01   
web.xml : Spring5 239p DispatcherServlet 설정   
servlet-context.xml : <bean> *.do -> .jsp   

index : href="./list1.do"   
list1, list2 : Print Hello   


<br><br>


### **< WebEx02 >**   
< WebEx01 > 복습, artifactId = mvc02   
servlet-context.xml : property name="prefix", "suffix" 옵션   
(com.exam.mvc.model)
ListAction1, ListAction2 : return new ModelAndView( "listview1" );   


<br><br>


### < GugudanEx01 > & < GugudanModel2Ex02 >   
http://localhost:8080/gugudan/gugudan.do	GugudanAction	/WEB-INF/views/gugudan.jsp(form)   
http://localhost:8080/gugudan/gugudan_ok.do	GugudanOkAction	/WEB-INF/views/gugudan_ok.jsp(form)   

GugudanOkAction : modelAndview.addObject( "result", sbHtml.toString() );   


<br><br>


### < ZipcodeEx01 >   
추가 라이브러리   
1. mariadb-java-client   
2. lombok   

우편번호 검색 프로젝트를 Spring MVC 로 변경하기   


<br><br>


### <BoardModel2Ex > -> < BoardEx01 > -> < BoardModel2Ex01 >   
model2 구조의 프로젝트를 Spring MVC Project로 변경하기   
servlet-context.xml 다수 연결   


<br><br>


### < WebEx03 >   
servlet-context.xml : xmlns:context, Controller 파일 자동 스캔   
(com.exam.mvc.controller)   
ConfigController : @Controller, @RequestMapping   


<br><br>


### < WebEx04 >   
servlet-context.xml : xmlns:context, Controller 파일 자동 스캔   
(com.exam.mvc.controller)   
ConfigController : GET, POST 별 개별 호출 함수 설정   


<br><br>


### < WebEx04 >   
(com.exam.mvc.controller)   
ConfigController : Controller 방법 1 ~ 6   


<br><br>


### < ZipcodeEx02 >   
< WebEx04 > 응용   
(com.exam.mvc.controller)   
ZipcodeController : ZipcodeAction + ZipcodeOkAction   
ConfigServlet : servlet-context.xml -> Annotation 방식   

web.xml : ConfigServlet 등록, <param-name>contextClass</param-name>   









<br>

