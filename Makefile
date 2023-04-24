runDataWranglerTests: DataWranglerTests.class
	java -jar junit5.jar -cp . --select-class=DataWranglerTests

DataWranglerTests.class: DataWranglerTests.java
	javac -cp .:junit5.jar DataWranglerTests.java

clean:
	rm *.class
