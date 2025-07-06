
## Package Structure
```text
me.seungwon.screaming
├── domain name                  # 특정 도메인
│   ├── domain                   # 핵심 모델과 도메인 서비스
│   │   ├── model                # Entity, ValueObject
│   │   └── service              # 도메인 규칙
│   ├── application              # 유스케이스
│   │   ├── port
│   │   │   ├── in               # 입력 포트 (서비스 인터페이스)
│   │   │   └── out              # 출력 포트 (DB, 외부 시스템 인터페이스)
│   │   └── service              # 유스케이스 구현
│   ├── adapter                  # 기술 어댑터
│   │   ├── in                   # 입력 어댑터 (Controller, API 수신 등)
│   │   │   └── web              # REST API Controller
│   │   └── out                  # 출력 어댑터 (DB, 외부 API)
│   │       └── persistence      # JPA, DB 접근 구현체
│   └── infrastructure           # 설정, 구성 등 (선택)
│       └── config               # 설정 클래스
│
├── ...
│
└── ScreamingArchitectureApplication.java          # Spring Boot 진입점

```

## Dependency Flow
```text
adapter.in (Web)  ─▶ application.service ─▶ domain.model
                                  │
                          adapter.out (DB, API)

```
* 기술 → 도메인 방향의 의존성만 허용
* 각 도메인은 서로 독립적으로 설계됨
* 도메인 간 호출이 필요하면 반드시 포트를 통해서 연결하거나, application 계층 간 인터페이스를 공유해야 합니다.

## Example
```text
me.seungwon.screaming
├── order           
│   ├── domain            
│   │   ├── model         
│   │       └── Order.java  
│   ├── application       
│   │   ├── port
│   │   │   ├── in      
│   │   │   │   └── PlaceOrderUseCase.java  
│   │   │   └── out       
│   │   │       └── OrderRepositoryPort.java
│   │   └── service       
│   └── adapter           
│       ├── in            
│       │   └── web       
│       │       └── OrderController.java
│       └── out           
│           └── persistence         
│                   ├── OrderJpaEntity.java
│                   ├── OrderJpaRepository.java
│                   └── OrderRepositoryAdapter.java            
│
└── ScreamingArchitectureApplication.java          # Spring Boot 진입점
```