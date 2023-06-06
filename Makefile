run :  runInterface runAE runDW runBD runF

runTests: runDataWranglerTests runAlgorithmEngineerTests runFrontendDeveloperTests

runDataWranglerTests: DataWranglerTests.class
	java --module-path ./lib1 --add-modules javafx.controls --add-exports javafx.graphics/com.sun.javafx.application=ALL-UNNAMED -jar junit5.jar -cp .:JavaFXTester.jar -c DataWranglerTests

DataWranglerTests.class: ./Testers/DataWranglerTests.java
	javac --module-path ./lib1 --add-modules javafx.controls -cp .:junit5.jar:JavaFXTester.jar -d ./ ./Testers/DataWranglerTests.java 
	
runDW: ./Backend/AirportDW.java ./Backend/EdgeDW.java ./PlaceHolders/FileReaderDW.java ./Reader/CSVReader.java
	javac -d ./ ./Backend/AirportDW.java 
	javac -d ./ ./Backend/EdgeDW.java 
	javac -d ./ ./PlaceHolders/FileReaderDW.java 
	javac -d ./ ./Reader/CSVReader.java 
runBD: ./Backend/FlightPathBackendBD.java
	javac -d ./ ./Backend/FlightPathBackendBD.java 
	javac -d ./ ./Backend/FlightPathBackendInterface.java
runFrontendDeveloperTests: ./Testers/FrontendDeveloperTests.class
	java --module-path ./lib1 --add-modules javafx.controls --add-exports javafx.graphics/com.sun.javafx.application=ALL-UNNAMED -jar junit5.jar -cp .:JavaFXTester.jar -c FrontendDeveloperTests

FrontendDeveloperTests.class:runAE runDW ./Testers/FrontendDeveloperTests.java FrontendFD.class placeHolders.class
	javac --module-path ./lib1 --add-modules javafx.controls -cp .:junit5.jar:JavaFXTester.jar -d ./ ./Testers/FrontendDeveloperTests.java 
	
runF: placeHolders.class FrontendFD.class
	java --module-path ./lib1 --add-modules javafx.controls FrontendFD FrontendInterface
FrontendFD.class: ./Frontend/FrontendFD.java ./Frontend/FrontendInterface.java
	javac --module-path ./lib1 --add-modules javafx.controls -d ./ ./Frontend/FrontendInterface.java
	javac --module-path ./lib1 --add-modules javafx.controls -d ./ ./Frontend/FrontendFD.java 

runAlgorithmEngineerTests: AlgorithmEngineerTests.class
	java -jar junit5.jar -cp . --select-class=AlgorithmEngineerTests
AlgorithmEngineerTests.class: ./Testers/AlgorithmEngineerTests.java runAE
	javac -cp .:junit5.jar -d ./ ./Testers/AlgorithmEngineerTests.java
runInterface: ./Backend/AirportInterface.java ./Backend/GraphADT.java  ./Backend/DijkstraWithMinTransferInterface.java ./Backend/EdgeInterface.java ./PlaceHolders/fileReaderInterface.java ./Backend/FlightPathBackendInterface.java
	javac -d ./ ./Backend/AirportInterface.java
	javac -d ./ ./Backend/EdgeInterface.java
	javac -d ./ ./Backend/GraphADT.java
	javac -d ./ ./Backend/DijkstraWithMinTransferInterface.java
	javac -d ./ ./PlaceHolders/fileReaderInterface.java
	javac -d ./ ./Backend/FlightPathBackendInterface.java
runAE: ./PlaceHolders/AirportAE.java ./Backend/BaseGraph.java ./Backend/DijkstraGraph.java ./Backend/DijkstraWithMinTransfer.java
	javac -d ./ ./PlaceHolders/AirportAE.java
	javac -d ./ ./Backend/BaseGraph.java 
	javac -d ./ ./Backend/DijkstraGraph.java 
	javac -d ./ ./Backend/DijkstraWithMinTransfer.java 

placeHolders.class:
	javac -d ./ ./PlaceHolders/FlightPathBackendFD.java 
	javac -d ./ ./PlaceHolders/fileReaderInterface.java 
	javac -d ./ ./PlaceHolders/fileReaderFD.java 
	javac -d ./ ./Backend/EdgeInterface.java 
	javac -d ./ ./PlaceHolders/EdgeFD.java 
	javac -d ./ ./Backend/DijkstraWithMinTransferInterface.java 
	javac -d ./ ./Backend/AirportInterface.java 
	javac -d ./ ./PlaceHolders/AirportFD.java
	javac -d ./ ./Backend/FlightPathBackendInterface.java
	
clean: 
	rm *.class
