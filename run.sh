libraries="lib/*"

javac -cp "$libraries" -d Runnable src/*.java

java -cp "Runnable:$libraries" Main