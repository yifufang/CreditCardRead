classpath="."
for file in lib/*.jar; do
  classpath="$classpath;$file"
done

javac -cp "$classpath" ./src/*.java -d ./out

echo "Start running"

echo "Running input file: 1"
java -cp "$classpath;./out" Main ./data/input_file.csv