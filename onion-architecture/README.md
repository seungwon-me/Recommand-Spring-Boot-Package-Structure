
## Package Structure
```text
me.seungwon.onion
├── domain                    # 가장 안쪽 - 핵심 비즈니스 모델
│   ├── model                # Entity, Value Object
│   └── service              # 도메인 서비스 (규칙 중심)
│
├── application               # 유스케이스 / 도메인 로직의 조합
│   ├── service              # 비즈니스 흐름, use case
│   └── port                 # 인터페이스 정의 (입/출력)
│       ├── in               # 입력 포트 (예: 서비스 인터페이스)
│       └── out              # 출력 포트 (예: Repository, 외부 API)
│
├── infrastructure            # 기술 세부 사항 (DB, 외부 API 등)
│   └── adapter
│       ├── out              # 출력 어댑터 (Repository 구현 등)
│       └── in               # 입력 어댑터 (Controller, 메시지 수신 등)
│
├── config                    # Spring 설정, Bean 등록 등
└── OnionArchitectureApplication.java     # 진입점 (SpringBootApplication)


```

## Dependency Flow
```text
infrastructure ───▶ application ───▶ domain
(adapters)         (use cases)       (model/rule)

```
* 도메인은 어떤 계층에도 의존하지 않음 (순수 자바)
* 어댑터는 유스케이스를 호출하고, 유스케이스는 도메인을 조작 
* 어플리케이션은 도메인에 의존하지만, 도메인은 외부에 대해 모름

## Example
```text
me.seungwon.onion
├── domain
│   └── model
│       └── User.java
├── application
│   ├── port
│   │   ├── in
│   │   │   └── RegisterUserUseCase.java
│   │   └── out
│   │       └── UserRepositoryPort.java
│   └── service
│       └── RegisterUserService.java
├── infrastructure
│   └── adapter
│       ├── in
│       │   └── web
│       │       └── UserController.java
│       └── out
│           └── persistence
│               ├── UserJpaEntity.java
│               ├── UserJpaRepository.java
│               └── UserRepositoryAdapter.java
└── OnionArchitectureApplication.java
```