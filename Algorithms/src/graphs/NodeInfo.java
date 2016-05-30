package graphs;

/**
 * Created by vasant on 5/22/16.
 */
public class NodeInfo {

    public boolean visited;
    public String node;
    public double distanceTo;
    public String parentNode;

    public NodeInfo(String node) {
        this.node=node;
        this.visited=false;
        this.distanceTo=Double.POSITIVE_INFINITY;
        this.parentNode=null;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public double getDistanceTo() {
        return distanceTo;
    }

    public void setDistanceTo(double distanceTo) {
        this.distanceTo = distanceTo;
    }

    public String getParentNode() {
        return parentNode;
    }

    public void setParentNode(String parentNode) {
        this.parentNode = parentNode;
    }

    public void reset() {
        this.parentNode=null;
        this.visited=false;
        this.distanceTo=Double.POSITIVE_INFINITY;
    }
}
