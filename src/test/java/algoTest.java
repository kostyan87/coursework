import data_structures.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class algoTest {

    @Test
    void test() {
        VertexRepository vertexRepository = new VertexRepository("src/main/java/test.txt");
        LinkedList<Edge>[] graph = Algo.createGraph(vertexRepository.getVertexes().getSize() + 1);
        Algo.fillGraph(graph, vertexRepository.getNumVertexesFrom(),
                vertexRepository.getNumVertexesTo(), vertexRepository.getCapacity());

        assertEquals(Algo.EdmonsKarpAlgo(graph, 0, vertexRepository.getVertexes().getSize() - 1), 5);
    }
}
