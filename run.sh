classpath="."
for file in lib/*.jar; do
  classpath="$classpath;$file"
done

javac -cp "$classpath" ./src/*.java -d ./out

echo "Start running"

echo "Running input file: 1"
java -cp "$classpath;./out" Main ./inputs/demo1_inp.json ./outputs/demo1_output.json
java -cp "$classpath;./out" Main ./inputs/demo2_inp.json ./outputs/demo2_output.json
