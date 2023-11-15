# spring_basic


<br>


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


<br>


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


<br>


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

(com.exam.di05)   
MainEx :   
(./model)   
BoardDAO : Print Log   
WriteAction : Print Log   
(./config)   
BeanConfig : @Autowired   













<br>

