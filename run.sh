classpath="."
for file in lib/*.jar; do
  classpath="$classpath;$file"
done

javac -cp "$classpath" ./src/*.java -d ./out
java -cp "$classpath;./out" Main