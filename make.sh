#!/bin/bash

javac -cp . PosService.java
mv -f PosService.class service/impl/

javac -cp . PosServiceImpl.java
mv -f PosServiceImpl.class service/impl/

javac PosServicePublisher.java
mv -f PosServicePublisher.class service/endp/
