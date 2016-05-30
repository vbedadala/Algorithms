package graphs;

/**
 * Created by vasant on 5/22/16.
 */
public  class WeightedEdge implements Comparable<WeightedEdge>{
    Double weight;
    int node1;
    int node2;

    public WeightedEdge( int node1, int node2,Double weight) {

        this.node1 =node1;
        this.node2=node2;
        this.weight=weight;

    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }


    public int getNode1() {
        return node1;
    }

    public void setNode1(int node1) {
        this.node1 = node1;
    }

    public int getNode2() {
        return node2;
    }

    public void setNode2(int node2) {
        this.node2 = node2;
    }

    public int other(int node) {
        if(node==node1)
            return node2;
        else
            return node1;
    }

    @Override
    public int compareTo(WeightedEdge o) {
        return this.getWeight().compareTo(o.getWeight());
    }
}
