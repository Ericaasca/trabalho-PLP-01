import java.util.ArrayList;
import java.util.Scanner;
public class permutacao {
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
		if( a == null )
			throw new IllegalArgumentException( "A entrada não pode ser nula" );
		ArrayList<ArrayList<Integer>> toReturn = new ArrayList<ArrayList<Integer>>();
		if( a.size() == 1 ){
			toReturn.add( new ArrayList<Integer>(a) );
			return toReturn;
		}
		for( int i = 0 ; i < a.size(); i++ ){
			int current = a.get( i );
			ArrayList<Integer> tmp = new ArrayList<Integer>(a);
			tmp.remove( i );
		ArrayList<ArrayList<Integer>> res = permute(tmp);
			for( int j = 0 ; j < res.size() ; j++ ){
				ArrayList<Integer> toAdd = new ArrayList<Integer>();
				toAdd.add( current );
				toAdd.addAll( res.get( j ) );
				toReturn.add( toAdd );
			}
		}	 
		return toReturn;
	}
	public static void main(String[] args) throws Exception {
		permutacao t = new permutacao();
		ArrayList<Integer> a = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Quantos numeros quer permutar?");
		//String numero = scan.nextString(args[0]);
		int num = Integer.parseInt(args[0]);
		for(int i=0; i<num; i++){
			a.add(i+1);
		}
		System.out.println( "Arranjo inicial:" );
		System.out.println( a );
		ArrayList<ArrayList<Integer>> res = t.permute(a);
		System.out.println( "Resultado:" );
		for(ArrayList<Integer> c : res ){
				System.out.println( c );
		}
	}
}