runDataWranglerTests: DataWranglerTests.class
	java -jar junit5.jar -cp . --select-class=DataWranglerTests

DataWranglerTests.class: DataWranglerTests.java
	javac -cp .:junit5.jar DataWranglerTests.java

runDW: AirportDW.java EdgeDW.java FileReaderDW.java
	javac AirportDW.java EdgeDW.java FileReaderDW.java

clean:
	rm *.class
