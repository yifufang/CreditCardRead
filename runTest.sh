classpath="."
for file in lib/*.jar; do
  classpath="$classpath;$file"
done

echo "compling"
javac -cp "$classpath" ./src/*.java -d ./out

echo "credit card test"
java -cp "$classpath;./out" org.junit.runner.JUnitCore CreditCardTest

echo "chain of responsibility test"
java -cp "$classpath;./out" org.junit.runner.JUnitCore ChainTest

echo "CardFactoryTest"
java -cp "$classpath;./out" org.junit.runner.JUnitCore CardFactoryTest

echo "TypeParseTest"
java -cp "$classpath;./out" org.junit.runner.JUnitCore TypeParseTest