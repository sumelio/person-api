clear
while ! nc -z mongo-db 27017 ; do
    echo "Waiting for Mongo nexos ⏰ "
    sleep 2
done
java -Djava.security.egd=file:/dev/./urandom -jar /person-0.0.1-SNAPSHOT.jar
