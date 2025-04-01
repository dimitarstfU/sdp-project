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

        for(int i=0; i<cityNames.length; i++)
        {
            //suzdavaash gradovete i gi dobavqsh v spisuka
        }

        while(scanner.hasNextLine())
        {
            line = scanner.nextLine();
            cities = line.split(" ");
            if(cities.length == 2)
            {
                
            }
        }

        scanner.close();
    }
}