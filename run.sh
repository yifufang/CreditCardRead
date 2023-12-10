destination_dir="Runnable"
libraries="lib/*"

mkdir -p "$destination_dir"

javac -cp "$libraries:src" -d "$destination_dir" src/Main.java

java -cp "$destination_dir:$libraries" Main