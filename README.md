# STOMP 기반 채팅 서비스

![](https://velog.velcdn.com/images/raycho521/post/30d46981-8154-4a20-b781-3e213bb2c97c/image.png)

## 기술 스택

- NginX
- Java, Spring
- AWS EC2, S3, RDS
- MySQL
- Kafka

## 세부기능

- 카프카를 활용하여 다수의 서버에서 동시에 채팅이 공유될 수 있도록 구현하였습니다.
- 채팅 전송과 DB 저장 작업을 비동기적으로 처리하기 위해 채팅 내역을 DB에 저장하기 위한 서버를 별도로 생성하였습니다.

### 서버 관리

- API 서버, DB 서버, 카프카 서버 등 관리
- Nginx를 이용한 로드 밸런싱

### STOMP를 이용한 채팅 구현

- stomp 프로토콜
- spring 내장 메시지 브로커 
- Kafka를 이용해 서버 간 메시지 공유