import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        
        String[] cityNames = line.split(" ");
        List<City> cities = new ArrayList<>();
        List<City> targets = new ArrayList<>();

        for(int i=0; i<cityNames.length; i++)
        {
            cities.add(new City(cityNames[i]));
        }
        int skips = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<skips;i++)
        {
            line = scanner.nextLine();
            cityNames = line.split(" ");
            for (City cityFrom : cities)
            {
                for (City cityTo : cities)
                {    
                    if(cityFrom.name.equals(cityNames[0]) && cityTo.name.equals(cityNames[1]))
                    {
                        cityFrom.neighbors.add(cityTo);
                    }    
                }
            }
        }
        line = scanner.nextLine();
        scanner.close();

        cityNames = line.split(" ");
        targets.add(cities.getFirst());
        for(int i=0; i<cityNames.length; i++)
        {
            for (City city : cities)
            {
                if (city.getName().equals(cityNames[i]))
                {
                    targets.add(city);
                    break;
                }
            }
        }
        targets.add(cities.getLast());

        List<City> path = new ArrayList<>();

        for(int i=0; i < targets.size() - 1; i++)
        {
            City.shortestPath(targets.get(i), targets.get(i+1), path);
        }

        for (City city : path)
        {
            System.out.print(city.getName() + " ");
        }
    }
}