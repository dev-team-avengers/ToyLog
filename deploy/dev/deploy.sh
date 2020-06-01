#!/usr/bin/env bash
SPRING_PROFILE=$1

echo "SPRING_PROFILE - ${SPRING_PROFILE}"

## DOCKER PUSH
## DOCKER LOGIN
# docker image build -t team-avengers/toylog-api:latest deploy/${SPRING_PROFILE}/Dockerfile -e SPRING_PROFILE=${SPRING_PROFILE}
# docker image build -t team-avengers/toylog-api:latest . --build-arg SPRING_PROFILE=dev
docker image build -t team-avengers/toylog-api:latest .
docker container run -t -p 9000:8080 team-avengers/toylog-api:latest