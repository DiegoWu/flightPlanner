
runFrontendDeveloperTests: FrontendDeveloperTests.class
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
