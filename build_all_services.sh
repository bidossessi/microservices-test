#!/bin/bash

cd billing && gradle bootJar && cd ..
cd customers && gradle bootJar && cd ..
cd warehouse && gradle bootJar && cd ..
docker-compose build
