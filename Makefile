run : runF runAE runDW runBD

runTests: runDataWranglerTests runAlgorithmEngineerTests runFrontendDeveloperTests

runDataWranglerTests: DataWranglerTests.class
	java --module-path ./lib1 --add-modules javafx.controls --add-exports javafx.graphics/com.sun.javafx.application=ALL-UNNAMED -jar junit5.jar -cp .:JavaFXTester.jar -c DataWranglerTests

DataWranglerTests.class: DataWranglerTests.java
	javac --module-path ./lib1 --add-modules javafx.controls -cp .:junit5.jar:JavaFXTester.jar DataWranglerTests.java 
	
runDW: AirportDW.java EdgeDW.java FileReaderDW.java
	javac AirportDW.java EdgeDW.java FileReaderDW.java
runBD: FlightPathBackendBD.java
	javac FlightPathBackendBD.java
runFrontendDeveloperTests: FrontendDeveloperTests.class
	java --module-path ./lib1 --add-modules javafx.controls --add-exports javafx.graphics/com.sun.javafx.application=ALL-UNNAMED -jar junit5.jar -cp .:JavaFXTester.jar -c FrontendDeveloperTests


FrontendDeveloperTests.class:runAE runDW FrontendDeveloperTests.java FrontendFD.class placeHolders.class
	javac --module-path ./lib1 --add-modules javafx.controls -cp .:junit5.jar:JavaFXTester.jar FrontendDeveloperTests.java 
	
runF: placeHolders.class FrontendFD.class
	java --module-path ./lib1 --add-modules javafx.controls FrontendFD FrontendInterface
FrontendFD.class: FrontendFD.java FrontendInterface.java
	javac --module-path ./lib1 --add-modules javafx.controls FrontendFD.java FrontendInterface.java

runAlgorithmEngineerTests: AlgorithmEngineerTests.class
	java -jar junit5.jar -cp . --select-class=AlgorithmEngineerTests
AlgorithmEngineerTests.class: AlgorithmEngineerTests.java runAE
	javac -cp .:junit5.jar AlgorithmEngineerTests.java
runAE:
	javac AirportAE.java BaseGraph.java DijkstraGraph.java DijkstraWithMinTransfer.java GraphADT.java
placeHolders.class:
	javac FlightPathBackendInterface.java FlightPathBackendFD.java fileReaderInterface.java fileReaderFD.java EdgeInterface.java EdgeFD.java DijkstraWithMinTransferInterface.java AirportInterface.java AirportFD.java
clean: 
	rm *.class
