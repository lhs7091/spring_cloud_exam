# Spring Cloud Netflix Eureka

1. preject생성
    - spring boot : 2.4.x, 2.5.x (Starting with 2020.0.3)
    - cloud : 2020.0.x
    - dependency 추가
      - spring-cloud-starter-netflix-eureka-server

2. application.yml initial setting
    ```
        server:
          port: 8761
   
        spring:
          application:
            name: discoveryservice
   
        eureka:
          client:
            register-with-eureka: false
            fetch-registry: false
    ```
3. annotation 등록
   - @EnableEurekaServer in DiscoveryserviceApplication
4. 서버 실행
   - localhost:port  
   ![image](https://drive.google.com/file/d/1CU_89e_62nyLxLWJ5qGtGrkNXJMYmTie/view?usp=sharing)
      