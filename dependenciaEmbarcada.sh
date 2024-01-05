mkdir /home/superBits/dependenciaEmbarcada/ -p
cd /home/superBits/dependenciaEmbarcada/
git clone https://github.com/salviof/Matrix-ClientServer-API-java.git
cd /home/superBits/dependenciaEmbarcada/Matrix-ClientServer-API-java
mvn -DskipTests=true --fail-at-end install
