# ToyLog

## Spec
- Spring Boot 2.3.0
- OpenJDK11

## Links
- Issue Tracker : https://trello.com/b/iZCFQJFg/toylog
- Github : https://github.com/dev-team-avengers/ToyLog

## Deployment
```shell script
deploy/{profile}/deploy.sh {profile}
```

## About Development
- OpenAPI(using docker) : http://localhost:9000/swagger-ui.html
- OpenAPI(using ide) : http://localhost:8080/swagger-ui.html
---
### Intellij Community Edition을 사용할 때 IDE에서 실행하는 법
1. Run - Edit Configurations 연다
2. Add New Configurations로 Application을 추가한다.
3. Main class를 team.avengers.toylog.ToyLogApplication로 지정
4. Program arguments에 --spring.profiles.active=dev 추가 (실행하려는 profile에 맞게 변경 가능)
5. Use classpath of module을 toylog-api.main으로 설정
6. JRE 사용할 JRE 지정(11 버전)