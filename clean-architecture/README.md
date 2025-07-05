
## Package Structure
```text
me.seungwon.clean
├── application       # 유스케이스, 서비스 계층 (비즈니스 로직 중심)
│   ├── port
│   │   ├── in        # 입력 포트 (인터페이스) → Controller 등에서 호출
│   │   └── out       # 출력 포트 (인터페이스) → 외부 시스템 호출 (DB, API 등)
│   └── service       # 입력 포트를 구현한 유스케이스 서비스
│
├── domain            # 도메인 계층 (비즈니스 엔티티, 규칙, 도메인 서비스 등)
│   ├── model         # 엔티티, 값 객체 (Entity, ValueObject)
│   └── service       # 도메인 규칙 또는 도메인 서비스
│
├── infrastructure    # 외부 구현체 계층 (DB, 외부 API, 메시지 브로커 등)
│   ├── adapter
│   │   ├── out
│   │   │   └── persistence   # JPA 등 Repository 구현체
│   │   └── config            # 설정 클래스
│   └── repository            # JPA 엔티티, JpaRepository 등
│
├── interfaces                # 입력 어댑터 계층 (Web, CLI 등)
│   └── web
│       ├── controller        # REST API, Controller
│       └── dto               # 요청/응답 DTO
│
└── CleanArchitectureApplication.java
```

## Dependency Flow
```text
domain --> application --> interface/infrastructure
```
* **domain**: 어떤 기술에도 의존하지 않음 (순수 자바)
* **application**: use case, port 정의 → 인터페이스 기반
* **interface**, infrastructure: 구현체

## Example
```text
me.seungwon.clean
├── application
│   ├── port
│   │   ├── in
│   │   │   └── CreateUserUseCase.java
│   │   └── out
│   │       └── SaveUserPort.java
│   └── service
│       └── CreateUserService.java
│
├── domain
│   └── model
│       └── User.java
│
├── infrastructure
│   └── adapter
│       └── out
│           └── persistence
│               ├── UserJpaEntity.java
│               ├── UserRepository.java
│               └── UserPersistenceAdapter.java
│
├── interfaces
│   └── web
│       ├── controller
│       │   └── UserController.java
│       └── dto
│           ├── CreateUserRequest.java
│           └── CreateUserResponse.java
│      
└── CleanArchitectureApplication.java
```