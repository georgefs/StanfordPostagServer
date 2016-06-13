#!/bin/sh

unzip -o stanford-postagger.jar
unzip -o slf4j-api.jar
unzip -o slf4j-simple.jar

mkdir -p service/impl
mkdir -p service/endp
