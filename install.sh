#!/bin/sh

wget http://nlp.stanford.edu/software/stanford-postagger-full-2015-12-09.zip
unzip stanford-postagger-full-2015-12-09.zip
rm -f stanford-postagger-full-2015-12-09.zip
cp stanford-postagger-full-2015-12-09/* .
rm -rf stanford-postagger-full-2015-12-09

unzip -o stanford-postagger.jar
unzip -o slf4j-api.jar
unzip -o slf4j-simple.jar

mkdir -p service/impl
mkdir -p service/endp

sh make.sh
