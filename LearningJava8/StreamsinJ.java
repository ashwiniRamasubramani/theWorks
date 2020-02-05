
//a simple program to demonstrate the use of stream in java 
import java.util.*; 
import java.util.stream.*; 
  
class StreamsinJ 
{ 
  public static void main(String args[]) 
  { 
  
    // create a list of integers 
    List<Integer> number = Arrays.asList(2,3,4,5); 
  
    // demonstration of map method 
    List<Integer> square = number.stream().map(x -> x*x). 
                           collect(Collectors.toList()); 
    System.out.println("Square od number using map()"+square); 
  
    // create a list of String 
    List<String> names = 
                Arrays.asList("Reflection","Collection","Stream"); 
  
    // demonstration of filter method 
    List<String> result = names.stream().filter(s->s.startsWith("S")). 
                          collect(Collectors.toList()); 
    System.out.println(result); 
  
    // demonstration of sorted method 
    List<String> show = 
            names.stream().sorted().collect(Collectors.toList()); 
    System.out.println(show); 
  
    // create a list of integers 
    List<Integer> numbers = Arrays.asList(2,3,4,5,2); 
  
    // collect method returns a set 
    Set<Integer> squareSet = 
         numbers.stream().map(x->x*x).collect(Collectors.toSet()); 
    System.out.println(squareSet); 
  
    // demonstration of forEach method 
    number.stream().map(x->x*x).forEach(y->System.out.println(y)); 
  
    // demonstration of reduce method 
    int even = 
       number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i); 
  
    System.out.println(even); 
    
    // Create a String with no repeated keys 
    Stream<String[]> 
        str = Stream 
                  .of(new String[][] { { "GFG", "GeeksForGeeks" }, 
                                       { "g", "geeks" }, 
                                       { "G", "Geeks" } }); 

    // Convert the String to Map 
    // using toMap() method 
    Map<String, String> 
        map = str.collect( 
            Collectors.toMap(p -> p[0], p -> p[1])); 

    // Print the returned Map 
    System.out.println("Map:" + map); 
  } 
} 