# ToyLog

## Requirements
- Login
    - [ ] token이나 session 기반 로그인(jwt 등)
    - [ ] third-party 로그인은 고려
- Registration
    - [ ] email 인증 
    - [ ] 회원정보 update 가능
- Board
    - list
        - [ ] pin 기능
        - [ ] 페이지 네비게이션(페이징 처리)
        - [ ] 정렬
    - write
        - [ ] 파일 업로드는 고려
    - update
- Comment
    - [ ] 댓글의 depth는 2-depth (대댓글)
    - [ ] pin 기능
- Search
- Favorite

## Spec
- Spring Boot 2.3.0
- OpenJDK11

## Links
- Issue Tracker : https://trello.com/b/iZCFQJFg/toylog
- Github : https://github.com/dev-team-avengers/ToyLog
- UI Design : https://ovenapp.io/view/NPO10Hs4UK6unOK4k4Yd9LM6r0IY52Gk
- Front Main Page : http://localhost:3000 (프론트 서버 배포 전까지)

## Deployment
```shell script
deploy/{profile}/deploy.sh {profile}
```

## About Development
- OpenAPI(using docker) : http://localhost:9000/swagger-ui.html
- OpenAPI(using ide) : http://localhost:8080/swagger-ui.html
- Ping Test(Health Check) : http://localhost:8080/health
- h2 Console URL : http://localhost:8080/h2-console
    - Driver Class : org.h2.Driver
    - JDBC URL : jdbc:h2:mem:toylog
    - User Name : toylogadmin
    - Password : toylogpass
---
### Lombok 추가
1. File - Settings - Plugins에서 Lombok 설치 (IDE Restart)
2. File - Settings - Build, Execution, Deployment > Compiler > Annotation Processors에서 Enable annotation processor 체크
---
### Intellij Community Edition을 사용할 때 IDE에서 실행하는 법
1. Run - Edit Configurations 연다
2. Add New Configurations로 Application을 추가한다.
3. Main class를 team.avengers.toylog.ToyLogApplication로 지정
4. Program arguments에 --spring.profiles.active=dev 추가 (실행하려는 profile에 맞게 변경 가능)
5. Use classpath of module을 toylog-api.main으로 설정
6. JRE 사용할 JRE 지정(11 버전)
7. OK
8. 상단 메뉴 아래 Select Run/Debug Configuration에서 ToyLogApplication 선택
9. 바로 오른쪽에 ▶(Run 'ToyLogApplication') 클릭
10. 하단 로깅 목록에 'Started ToyLogApplication in OO.OO seconds (JVM running for OO.OOO)' 문구가 나오고 프로세스가 종료되지 않고 계속 돌면 성공
    - 중간에 방화벽으로 Java 실행 문구 나오면 방화벽 허용(Windows 경우)