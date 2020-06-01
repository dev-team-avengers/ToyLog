#!/usr/bin/env bash
SPRING_PROFILE=$1

echo "SPRING_PROFILE - ${SPRING_PROFILE}"

## DOCKER PUSH
## DOCKER LOGIN
# docker image build -t team-avengers/toylog-api:latest deploy/${SPRING_PROFILE}/Dockerfile -e SPRING_PROFILE=${SPRING_PROFILE}
# docker image build -t team-avengers/toylog-api:latest . --build-arg SPRING_PROFILE=dev
docker build --no-cache -t team-avengers/toylog-api:latest .
docker run --rm -t -p 9000:8080 --name toylog-api team-avengers/toylog-api:latest
# docker run --rm -t -p 9000:8080 -e "TZ=Asia/Seoul" --name toylog-api team-avengers/toylog-api:latest <- windows
# docker run --rm -t -p 9000:8080 -v /etc/localtime:/etc/localtime:ro --name toylog-api team-avengers/toylog-api:latest <- Linux or MacOS