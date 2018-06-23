@echo off
set workspace=C:\Users\CEST\Documents\Software\Chat-en-LAN-Cliente
::Las variables de entorno se pueden configurar directamente en Windows cuando se tienen los permisos necesarios
echo -----------------------------------------
echo . (C) MIW -UPM
echo -----------------------------------------
echo .
echo Workspace --- %workspace%
echo JAVA_HOME --- %JAVA_HOME%
echo M2_HOME   --- %M2_HOME%
echo .
cd %workspace%
echo ============ mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent verify --settings settings.xml ... ==================
echo . Se prepara cobertura
call mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent verify --settings settings.xml

echo ============ mvn sonar:sonar ... =======================================================
echo . Se analiza y sube a sonar cloud
call mvn sonar:sonar -Dsonar.organization=c1e1s1t-github -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=e37a52d43ba2a131df41497226702e1f5f26c066 --settings settings.xml
pause
