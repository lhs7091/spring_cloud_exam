# Spring Cloud Netflix Eureka

1. preject생성
    - spring boot : 2.4.x, 2.5.x (Starting with 2020.0.3)
    - cloud : 2020.0.x
    - dependency 추가
      - spring-cloud-starter-netflix-eureka-server
      - spring-boot-devtools
      - lombok
      - spring web

   1. application.yml initial setting
       ```
      server:
        port: 9001
   
      spring:
        application:
        name: user-service
   
      eureka:
        client:
          register-with-eureka: true
          fetch-registry: true # Eureka서버로부터 인스턴스들의 정보를 주기적으로 가져올 것인지를 설정하는 속성
          service-url:
            defaultZone: http://127.0.0.1:8761/eureka
       ```
2. annotation 등록
   - @EnableDiscoveryClient in UserServiceApplication
3. 서버 실행
   - localhost:port  
   ![image](https://drive.google.com/file/d/1iuiInwXW5Dk4qXZdveeg0kbkZkgF-MlC/view?usp=sharing)
   - 2개 실행할경우 
     - Edit Configurations... > vm > -Dserver.port=9002 > apply  
   
     ![image](https://drive.google.com/file/d/1GYgA8APiFNVdyt-OAUo0OVmXGgcaEbv3/view?usp=sharing)
   - 다른 실행방법 
   ```
   mvn spring-boot:run -Dspring-boot.run.jvmArguments='-Dserver.port3'
   ```
4. load balancer
   - instance id 추가 : container가 실행될때마다 random port가 부여되고 자동으로 eureka에 표시된다.
   ```
   eureka:
     instance:
       instance-id: ${spring.cloud.client.hostname}:${spring.application.instance_id:${random.value}}
   ```
   ![image](https://drive.google.com/file/d/1BoSgBfhcuMbQl-el1S5FQwXie15iI3Ym/view?usp=sharing)