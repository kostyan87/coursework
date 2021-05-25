import data_structures.LinkedList;

import java.io.FileReader;
import java.io.IOException;

public class VertexRepository {

    private LinkedList<Character> vertexes = new LinkedList<>();

    private LinkedList<Character> vertexesFrom = new LinkedList<>();

    private LinkedList<Character> vertexesTo = new LinkedList<>();

    private int[] numVertexesFrom;

    private int[] numVertexesTo;

    private LinkedList<Integer> capacity = new LinkedList<>();

    public VertexRepository(String fileName) {
        try {
            FileReader file = new FileReader(fileName);
            String stringFromFile = FileUtils.readTextFromFile(file);
            setAll(stringFromFile);
        }
        catch (IOException e) {
            e.getMessage();
        }
    }

    public int[] getNumVertexesFrom() {
        return numVertexesFrom;
    }

    public int[] getNumVertexesTo() {
        return numVertexesTo;
    }

    public LinkedList<Integer> getCapacity() {
        return capacity;
    }

    public LinkedList<Character> getVertexes() {
        return this.vertexes;
    }

    private void setAll(String s) {

        char vertexFrom;
        char vertexTo;
        char capacity;

        for (int i = 0; i < s.length(); i++) {
            vertexFrom = s.charAt(i);
            i += 2;

            vertexTo = s.charAt(i);
            i += 2;

            capacity = s.charAt(i);
            i += 1;

            this.vertexesFrom.pushBack(vertexFrom);
            this.vertexesTo.pushBack(vertexTo);

            this.capacity.pushBack(Character.getNumericValue(capacity));
        }

        setVertexes();
    }

    private void setVertexes() {
        for (int i = 0; i < this.vertexesFrom.getSize(); i++) {

            char vertexFrom = this.vertexesFrom.get(i);
            char vertexTo = this.vertexesTo.get(i);

            if (!this.vertexes.has(vertexFrom))
                this.vertexes.pushBack(vertexFrom);

            if (!this.vertexes.has(vertexTo))
                this.vertexes.pushBack(vertexTo);
        }

        setNumVertexes();
    }

    public void setNumVertexes() {
        this.numVertexesFrom = new int[this.vertexesFrom.getSize()];
        this.numVertexesTo = new int[this.vertexesFrom.getSize()];

        for (int i = 0; i < this.vertexesFrom.getSize(); i++) {
            this.numVertexesFrom[i] = searchIndexInVertexes(this.vertexesFrom.get(i));
            this.numVertexesTo[i] = searchIndexInVertexes(this.vertexesTo.get(i));
        }
    }

    public int searchIndexInVertexes(char vertex) {
        for (int i = 0; i < this.vertexes.getSize(); i++) {
            if (this.vertexes.get(i) == vertex) return i;
        }
        return -1;
    }

    public int getCapacity(char from, char to) {

        for (int i = 0; i < this.vertexesFrom.getSize(); i++) {

            if (this.vertexesFrom.get(i).equals(from)
                    && this.vertexesTo.get(i).equals(to)) {
                return this.capacity.get(i);
            }
        }

        return 0;
    }

    public void printRepository() {

        System.out.print("vertexes: ");
        vertexes.printList();

        System.out.print("vertexesFrom: ");
        vertexesFrom.printList();

        System.out.print("vertexesTo: ");
        vertexesTo.printList();

        System.out.print("numVertexesFrom: ");
        for (int i = 0; i < numVertexesFrom.length; i++) {
            System.out.print(numVertexesFrom[i] + " ");
        }

        System.out.print("numVertexesTo: ");
        for (int i = 0; i < numVertexesTo.length; i++) {
            System.out.print(numVertexesTo[i] + " ");
        }

        System.out.print("capacity: ");
        capacity.printList();

    }
}
