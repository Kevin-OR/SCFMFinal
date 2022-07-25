@echo off
call mvn clean package
call docker build -t com/SCFM .
call docker rm -f SCFM
call docker run -d -p 9080:9080 -p 9443:9443 --name SCFM com/SCFM