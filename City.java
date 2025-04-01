import java.util.List;

public class City
{
    String name;
    List<City> neighbors;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<City> getNeighbors() {
        return neighbors;
    }
    public void setNeighbors(List<City> neighbors) {
        this.neighbors = neighbors;
    }
    public City(String name) {
        this.name = name;
    }
    
    
}
