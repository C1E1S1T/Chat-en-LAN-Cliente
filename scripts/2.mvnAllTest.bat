@echo off
set workspace=C:\Users\CEST\Documents\Software\Chat-en-LAN-Cliente
::Las variables de entorno se pueden configurar directamente en Windows cuando se tienen los permisos necesarios
echo -----------------------------------------
echo . (C) CEST
echo -----------------------------------------
echo .
echo Workspace --- %workspace%
echo JAVA_HOME --- %JAVA_HOME%
echo M2_HOME   --- %M2_HOME%
echo .
cd %workspace%

echo ============ mvn clean verify (profile: develop) =======================================================
echo .
call mvn clean verify --settings settings.xml
pause

