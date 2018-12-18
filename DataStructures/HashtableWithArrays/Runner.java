public class Runner {
    public static void main(String[] args) {
        Hashtable<String, Integer> table = new Hashtable(); 
        table.put("this",1 ); 
        table.put("coder",2 ); 
        table.put("this",4 ); 
        table.put("hi",5 ); 
        System.out.println(table.size()); 
        System.out.println(table.get("this")); 
        System.out.println(table.remove("this")); 
        System.out.println(table.size()); 
        System.out.println(table.isEmpty());
    }
}