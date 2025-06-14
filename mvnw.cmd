
@echo off

set MAVEN_CMD=mvn

if exist "%~dp0\maven\bin\mvn.cmd" set MAVEN_CMD=%~dp0\maven\bin\mvn.cmd

"%MAVEN_CMD%" %*

