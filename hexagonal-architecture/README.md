
## Package Structure
```text
me.seungwon.hexagonal
├── domain                 # 도메인 모델 (순수 Java)
│   ├── model             # Entity, Value Object
│   └── service           # 도메인 서비스 (비즈니스 규칙)
│
├── application            # 유스케이스 (비즈니스 흐름)
│   ├── port
│   │   ├── in            # 외부에서 호출할 포트 (입력)
│   │   └── out           # 외부를 호출할 포트 (출력)
│   └── service           # 유스케이스 구현 (포트 구현체)
│
├── adapter                # 어댑터
│   ├── in                # 입력 어댑터 (Web, CLI 등)
│   │   └── web           # Controller, REST API
│   └── out               # 출력 어댑터 (Persistence, API 등)
│       └── persistence   # JPA, DB, 외부 시스템 연동
│
├── config                 # 설정 (빈 등록 등)
└── HexagonalApplication.java

```

## Dependency Flow
```text
adapter in (web/controller) ──▶ port in ──▶ application service ──▶ port out ──▶ adapter out (DB, API)
                                        ▲                           │
                                        └────── domain <────────────┘

```
* 어댑터는 포트를 사용하고, 포트는 도메인 객체와 유스케이스 서비스를 사용합니다. 
* 도메인은 절대 어댑터나 Spring 같은 기술에 의존하지 않습니다.

## Example
```text
me.seungwon.hexagonal
├── domain
│   └── model
│       └── User.java
├── application
│   ├── port
│   │   ├── in
│   │   │   └── RegisterUserUseCase.java
│   │   └── out
│   │       └── SaveUserPort.java
│   └── service
│       └── RegisterUserService.java
├── adapter
│   ├── in
│   │   └── web
│   │       └── UserController.java
│   └── out
│       └── persistence
│           ├── UserJpaEntity.java
│           ├── UserJpaRepository.java
│           └── UserPersistenceAdapter.java
│ 
└── HexagonalApplication.java
```