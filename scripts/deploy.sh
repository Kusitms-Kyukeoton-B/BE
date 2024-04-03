#!/bin/bash

IS_GREEN_EXIST=$(docker ps | grep green)
DEFAULT_CONF=" /etc/nginx/nginx.conf"

# blue가 실행 중이면 green을 up합니다.
if [ -z $IS_GREEN_EXIST ];then
  sudo echo "### BLUE => GREEN ####"
  sudo echo ">>> green image를 pull합니다."
  sudo docker-compose pull green
  sudo echo ">>> green container를 up합니다."
  sudo docker-compose up -d green
  while [ 1 = 1 ]; do
    sudo echo ">>> green health check 중..."
    sleep 3
    REQUEST=$(curl http://127.0.0.1:8081)
    if [ -n "$REQUEST" ]; then
      sudo echo ">>> 🍃 health check success !"
      break;
    fi
  done;
  sleep 3
  sudo echo ">>> nginx를 다시 실행 합니다."
  sudo cp /etc/nginx/nginx.green.conf /etc/nginx/nginx.conf
  sudo nginx -s reload
  sudo echo ">>> blue container를 down합니다."
  sudo docker-compose stop blue

# green이 실행 중이면 blue를 up합니다.
else
  sudo echo "### GREEN => BLUE ###"
  sudo echo ">>> blue image를 pull합니다."
  sudo docker-compose pull blue
  sudo echo ">>> blue container up합니다."
  sudo docker-compose up -d blue
  while [ 1 = 1 ]; do
    sudo echo ">>> blue health check 중..."
    sleep 3
    REQUEST=$(curl http://127.0.0.1:8080)
    if [ -n "$REQUEST" ]; then
      sudo echo ">>> 🍃 health check success !"
      break;
    fi
  done;
  sleep 3
  sudo echo ">>> nginx를 다시 실행 합니다."
  sudo cp /etc/nginx/nginx.blue.conf /etc/nginx/nginx.conf
  sudo nginx -s reload
  sudo echo ">>> green container를 down합니다."
  sudo docker-compose stop green
fi
