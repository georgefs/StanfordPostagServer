#!/bin/sh

wget http://nlp.stanford.edu/software/stanford-postagger-full-2015-12-09.zip
unzip stanford-postagger-full-2015-12-09.zip
rm -f stanford-postagger-full-2015-12-09.zip
cp -r stanford-postagger-full-2015-12-09/*.jar lib
rm -rf stanford-postagger-full-2015-12-09


sh make.sh
