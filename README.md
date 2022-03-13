## Spring Batch Sample

---

Spring Boot 기반 Spring Batch Sample 코드입니다. 여러 가지 배치의 타입 예를 들어 File to DB 등의 예제를 간단한 방식으로 구현하였습니다.

### Getting started

---
```shell
./gradlew clean build
java -jar {argument} {spring property} /build/libs/spring-batch-sample.xxxxx.jar
```

### Tech. Stacks

---
* Spring Boot 2.6.4
* H2 Database
* MySQL


### 사전 준비

---

* MySQL Docker Installation (https://hub.docker.com/_/mysql)


### Features

---
* Batch Job - 1
  * 파일로부터 데이터를 조회한 뒤 데이터베이스에 저장
* Batch Job - 2
  * 데이터베이스로부터 데이터를 조회한 뒤 API 서버와 통신
* Scheduler: Quatz

---