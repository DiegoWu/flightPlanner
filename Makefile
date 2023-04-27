runTests: AlgorithmEngineerTests.class
	java -jar junit5.jar -cp . --select-class=AlgorithmEngineerTests
AlgorithmEngineerTests.class: AlgorithmEngineerTests.java
	javac -cp .:junit5.jar AlgorithmEngineerTests.java
	javac AirportInterface.java AirportAE.java DijkstraWithMinTransferInterface.java DijkstraWithMinTransfer.java DijkstraGraph.java BaseGraph.java GraphADT.java
clean:
	rm *.class
