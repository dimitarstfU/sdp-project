import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class City
{
    String name;
    List<City> neighbors;

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        City other = (City) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<City> getNeighbors()
    {
        return neighbors;
    }
    public void setNeighbors(List<City> neighbors)
    {
        this.neighbors = neighbors;
    }
    public City(String name)
    {
        this.name = name;
        this.neighbors = new ArrayList<>();
    }

    public static void shortestPath(City source, City destination, List<City> path)
    {
        Queue<City> queue = new ArrayDeque<>();
        List<City> visited = new ArrayList<>();
        Map<City, City> parentOf = new HashMap<>();

        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty())
        {
            City current = queue.peek();
            queue.remove();
            if (current == destination)
            {
                break;
            }
            for (City neighbor : current.getNeighbors())
            {
                if (!visited.contains(neighbor))
                {
                    parentOf.put(neighbor, current);
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        List<City> currentPath = new ArrayList<>();

        City current = destination;
        while (current != null)
        {
            currentPath.add(current);
            current = parentOf.get(current);
        }

        path.addAll(currentPath.reversed());
    }   
    
}
