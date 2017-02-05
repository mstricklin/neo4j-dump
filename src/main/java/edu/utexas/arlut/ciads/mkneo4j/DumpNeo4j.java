
package edu.utexas.arlut.ciads.mkneo4j;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.impls.neo4j.Neo4jGraph;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class DumpNeo4j {

    public static void main(String[] args) {
        String graphDir = args.length >0 ? args[0] : "graph";
        Graph g = new Neo4jGraph(graphDir);
        log.info("Graph {}", g);

        log.info("======= Vertices ==========");
        for (Vertex v: g.getVertices()) {
            log.info(v.toString());
            for (Edge e: v.getEdges(Direction.OUT)) {
                log.info("\t{}", e);
            }
            for (String k: v.getPropertyKeys()) {
                log.info("\t{} => {}", k, v.getProperty(k));
            }
        }

        log.info("======= Edges ==========");
        for (Edge e: g.getEdges()) {
            log.info(e.toString());
            for (String k: e.getPropertyKeys()) {
                log.info("\t{} => {}", k, e.getProperty(k));
            }
        }
        g.shutdown();

    }

}

