# 2026_PBL_BE_SpringBoot

멋쟁이사자처럼 대학 **백엔드(Spring Boot) 커리큘럼**을 위한 실습 레포지토리입니다.
본 레포지토리는 **REST API 설계, JPA, 연관관계, 전역 예외 처리, 프론트엔드 연동**을 중심으로 구성되어 있으며,
순수 Java 프로젝트(1~5주차)를 Spring Boot로 전환하여 **웹 백엔드 개발의 핵심**을 다루는 것을 목표로 합니다.

---

## 📌 레포지토리 목적

- Spring Boot 기반의 REST API 설계와 구현을 직접 코드로 구현해봅니다.
- JPA를 활용한 데이터베이스 연동과 연관관계 매핑을 학습합니다.
- 프론트엔드와 백엔드가 JSON으로 통신하는 전체 흐름을 경험합니다.

> 본 레포지토리는 **Spring Boot 단계**의 커리큘럼을 포함하며,
> **6~10주차 과정**까지 진행됩니다.
> 1~5주차 순수 Java 커리큘럼은 [2026_PBL_BE_Java](https://github.com/Likelion-PBL/2026_PBL_BE_Java) 레포지토리를 참고하세요.

---

## 🗂 브랜치 구조 안내

각 주차별 학습 내용을 **브랜치 단위**로 분리해 관리합니다.

| 브랜치 | 주차 | 주제 |
|--------|------|------|
| `week6` | 6주차 | Spring Boot 전환, 첫 REST API |
| `week7` | 7주차 | REST API 설계 (CRUD) |
| `week7-bonus` | 7주차 보너스 | 전체 조회, 이름 검색, 예외 처리, Swagger |
| `week8` | 8주차 | JPA 기초 & 영속성 컨텍스트 |
| `week9` | 9주차 | 연관관계 & 트랜잭션 |
| `week10` | 10주차 | 개인 미니 프로젝트 (전역 예외 처리 & 프론트엔드 연동) |

---

## 🎯 주차별 학습 내용

### 6주차 (week6)
- Spring Boot 프로젝트 생성
- `@RestController`, `@GetMapping`
- 첫 REST API 엔드포인트 구현

### 7주차 (week7)
- REST API 설계 원칙
- CRUD 엔드포인트 구현 (GET, POST, PUT, DELETE)
- `@RequestBody`, `@PathVariable`
- DTO를 활용한 요청/응답 분리

### 8주차 (week8)
- Spring Data JPA 기초
- `@Entity`, `@Id`, `@GeneratedValue`
- `JpaRepository` 인터페이스
- MySQL 연동 및 영속성 컨텍스트

### 9주차 (week9)
- `@ManyToOne` / `@OneToMany` 연관관계 매핑
- `@Transactional`과 트랜잭션 관리
- Assignment 도메인 추가 (Member ↔ Assignment)
- RESTful 계층 구조 API 설계

### 10주차 (week10)
- `@RestControllerAdvice` 전역 예외 처리
- 커스텀 예외 클래스 (`MemberNotFoundException`, `DuplicateMemberException` 등)
- 통일된 에러 응답 (`ErrorResponse` DTO)
- Service/Controller 리팩토링 (null 반환 → 예외 던지기)
- 파트별 필터링, 과제 검색 API 추가
- 프론트엔드 연동 및 HTTP 통신 흐름 탐구

---

## 🗂 프로젝트 구조 (week10 기준)

```text
src/main/java/com/lielion/PBL/
├── PblApplication.java                    # 메인 클래스
├── member/                                # Member 도메인
│   ├── controller/
│   │   └── MemberController.java          # Member REST API
│   ├── service/
│   │   └── MemberService.java             # 비즈니스 로직
│   ├── repository/
│   │   └── MemberRepository.java          # 데이터 접근 (JPA)
│   ├── domain/                            # 엔티티, 도메인 객체
│   └── dto/                               # 요청/응답 DTO
├── assignment/                            # Assignment 도메인
│   ├── controller/
│   │   └── AssignmentController.java      # Assignment REST API
│   ├── service/
│   │   └── AssignmentService.java         # 비즈니스 로직
│   ├── repository/
│   │   └── AssignmentRepository.java      # 데이터 접근 (JPA)
│   ├── domain/                            # 엔티티
│   └── dto/                               # 요청/응답 DTO
└── global/                                # 전역 설정
    ├── exception/
    │   ├── GlobalExceptionHandler.java    # @RestControllerAdvice
    │   ├── MemberNotFoundException.java
    │   ├── AssignmentNotFoundException.java
    │   └── DuplicateMemberException.java
    └── dto/
        └── ErrorResponse.java             # 공통 에러 응답

src/main/resources/
└── static/                                # 프론트엔드
    ├── index.html
    ├── css/
    │   └── style.css
    └── js/
        ├── member.js
        └── assignment.js
```

---

## 📡 API 목록 (week10 기준)

### Member API

| HTTP 메서드 | URI | 설명 |
|-------------|-----|------|
| POST | `/members/lions` | Lion 등록 |
| POST | `/members/staffs` | Staff 등록 |
| GET | `/members` | 전체 멤버 조회 |
| GET | `/members?part=백엔드` | 파트별 멤버 필터링 |
| GET | `/members/{id}` | 멤버 단건 조회 |
| PUT | `/members/lions/{id}` | Lion 수정 |
| PUT | `/members/staffs/{id}` | Staff 수정 |
| DELETE | `/members/{id}` | 멤버 삭제 |

### Assignment API

| HTTP 메서드 | URI | 설명 |
|-------------|-----|------|
| POST | `/members/{memberId}/assignments` | 과제 등록 |
| GET | `/assignments` | 전체 과제 조회 |
| GET | `/members/{memberId}/assignments` | 멤버별 과제 조회 |
| GET | `/assignments/{id}` | 과제 단건 조회 |
| GET | `/assignments/search?keyword=Java` | 과제 제목 검색 |
| PUT | `/assignments/{id}` | 과제 수정 |
| DELETE | `/assignments/{id}` | 과제 삭제 |

---

## 🛠 빌드 및 실행

**JDK 버전**: 17
**Spring Boot 버전**: 3.x
**데이터베이스**: MySQL

```bash
# 빌드
./gradlew build

# 실행
./gradlew bootRun

# 테스트
./gradlew test

# 빌드 정리
./gradlew clean
```

브라우저에서 `http://localhost:8080` 접속 시 프론트엔드 화면이 표시됩니다.
