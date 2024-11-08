import java.util.*;

class Word implements Comparable<Word> {
   String s;
   
   Word( String n ){
      s = n;
   }
   
   public int compareTo( Word o ) {
      if( s.length() > o.s.length() )
         return 1;
      if( o.s.length() > s.length() )
         return -1;
      return s.compareTo( o.s );   
   }
    
   public String toString() {
     return s;
   } 
}

public class Comparable_Example {   
   public static void main(String[] args) {
      Set<Word> s = new TreeSet<Word>();
      s.add( new Word( "fun" ) );
      s.add( new Word( "ant" ) );
      s.add( new Word( "jump" ) );
      s.add( new Word( "alice" ) );
      s.add( new Word( "B" ) );
      s.add( new Word( "1010" ) );
      s.add( new Word( "freddy" ) );
      System.out.println( s );
   }
}
