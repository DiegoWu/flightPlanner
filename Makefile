# this example combines what we've learned about compiling and running java code
# that makes use of junit and javafx, along with the extra JavaFXTester.jar

# There is one new piece to the runTests command:
# --add-exports javafx.graphics/com.sun.javafx.application=ALL-UNNAMED
# You don't need to understand anything about this extra argument.  But for the
# curious, it allows the unnamed module with the provided JavaFXTester.jar to
# access code within the JavaFX modules to help run these tests

rrunTests: SampleTests.class
	java --module-path ./lib1 --add-modules javafx.controls --add-exports javafx.graphics/com.sun.javafx.application=ALL-UNNAMED -jar junit5.jar -cp .:JavaFXTester.jar -c SampleTests

SampleTests.class: SampleTests.java SampleMain.class
	javac --module-path ./lib1 --add-modules javafx.controls -cp .:junit5.jar:JavaFXTester.jar SampleTests.java
	
runProgram: SampleMain.class
	java --module-path ./lib1 --add-modules javafx.controls SampleMain

SampleMain.class: SampleMain.java
	javac --module-path ./lib1 --add-modules javafx.controls SampleMain.java

runTests: FrontendDeveloperTests.class
	java --module-path ./lib1 --add-modules javafx.controls --add-exports javafx.graphics/com.sun.javafx.application=ALL-UNNAMED -jar junit5.jar -cp .:JavaFXTester.jar -c FrontendDeveloperTests

FrontendDeveloperTests.class: FrontendDeveloperTests.java FrontendFD.class placeHolders.class
	javac --module-path ./lib1 --add-modules javafx.controls -cp .:junit5.jar:JavaFXTester.jar FrontendDeveloperTests.java 
	
runF: placeHolders.class FrontendFD.class
	java --module-path ./lib1 --add-modules javafx.controls FrontendFD FrontendInterface
FrontendFD.class: FrontendFD.java FrontendInterface.java
	javac --module-path ./lib1 --add-modules javafx.controls FrontendFD.java FrontendInterface.java       
placeHolders.class: 
	javac FlightPathBackendInterface.java  FlightPathBackendFD.java fileReaderInterface.java fileReaderFD.java EdgeInterface.java EdgeFD.java DijkstraWithMinTransferInterface.java AirportInterface.java AirportFD.java 
clean:
	rm *.class
