# Spring Cloud로 개발하는 마이크로서비스 애플리케이션

## Section 1. Mycroservice와 Spring Cloud 소개
1. Antifragile : 잘 깨지지 않는 서비스
    - Auto scaling : 자동 확장성을 갖는다. 시스템을 구성하는 instance를 사용량에 따라 자동으로 구성
    -  microservices : 전체 서비스를 구축하고 있는 개별적인 모듈이나 기능을 독립적으로 개발하고 배포하고 운영할 수 있는 세분화된 서비스
    -  chaos engineering : 예측하지 못한 상황에도 대응하고 신뢰성을 쌓기 위해 운영중인 시스템의 실행방법, 규칙
    -  Continuous deployments : CI/CD로 지속가능한 통합,개발을 가능하고 파이프라인으로 각각을 연결하면 update등의 대응에도 빠르게 가능

2. Cloud Native Architecture
    - 확장가능한 아키텍쳐
        - 시스템의 수평적 확장에 유연
        - 확장된 서버로 시스템의 부하분산, 가용성 보장
        - 시스템 또는 서비스 애플리케이션 단위의 패키지(컨테이너 기반 패키지)
        - 모니터링
    - 탄력적 아키텍처
        - 서비스 생성, 통합, 배포, 비즈니스 환경변화에 대응시간 단축
        - 분할된 서비스 구조
        - 무상태 통신 프로토콜
        - 서비스의 추가와 삭제를 자동으로 감지
        - 변경된 서비스 요청에 따라 사용자 요청처리(동적처리)
    - 장애격리
        - 특정 서비스에 오류가 발생해도 다른 서비스에 영향을 주지않음
3. Cloud Native Application
    - microservices
    - CI/CD : 지속적인 통합, 배포
        - 통합서버, 소스관리, 빌드도구, 테스트도구
        - jenkins, team CI, travis CI
        - 지속적인 전달, 배포
        - 카나리 배포와 블루그린배포
            |  | 카나리 | 블루그린 |
            | :---: | :---: | :---: |
            | 이전버전:새버전 | 95%:5% | 100%:0%->0%:100% 점진적으로 이전 |
    - DevOps : 개발조직과 운영조직의 통합으로 고객의 요구사항을 빠르게 반영, 높은 수준의 결과물 제공
    - Containers : 공통적인 라이브러리, 리소스를 공유해서 사용, 각자 필요한 부분에 대해서만 독립적 실행으로 빠르고 가볍게 운영가능함
4. 12Factors[https://12factor.net]
    - base code : 코드의 통일적인 관리
    - dependency isolation : 전체 시스템에 영향을 주지 않는 상태에서 변경, 실행
    - configuration : 외부의 구성관리를 통해서 설정
    - Linkable backing services : db, 캐시, 메시지 브로커등 응용프로그램 자체에서 필요한 backing 시스템을 분리, 개발시 간섭되지 않도록 한다.
    - stages of creation : 빌드, 릴리즈, 실행을 엄격하게 분리할것
    - stateless processes : 각각의 마이크로서비스는 반드시 분리되어 독립적인 process로 실행
    - port binding : 각각의 마이크로 서비스는 자체포트에서 노출되는 인터페이스, 기능과함께 기능을 갖고 있어야 함
    - concurrency : 하나의 인스턴스가 동일한 형태로 복사되어 동시성을 갖고 있어야함
    - disposablity : 서비스 인스턴스 자체가 삭제가능해야 함
    - Development & Production parity : 개발, prod단계를 나눠야함
    - Logs : logging을 이벤트 스트림으로 처리, app이 실행되지 않아도 로그는 정상 작동해야 한다.
    - Admin Processes for eventual processes : 현재 모든 인스턴스의 리소스관리가 가능한 시스템이 있어야함(레포팅, 데이터 분석기능 포함)
    
5. 12Factors + 3
    - API first
    - Telemetry : 모든 지표는 수치화, 시각화되어 관리
    - Authentication and Authorization

6. Spring Cloud[https://spring.io/projects/spring-cloud]
    - Centralized configuration management
        - Spring Cloud Config Server
    - Location transparency
        - Naming Server(Eureka)
    - Load Distribution(Load Balancing)
        - Ribbon(Client side)
        - Spring Cloud Gateway
    - Easier Rest Clients
        - FeignClient
    - Visiblity and monitoring
        - Zipkin Distributed Tracing
        - Netflix API gateway
    - Fault Tolerance
        - Hystrix
