import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class RevEng {

	public static Map<String,Integer> getCombination(List<String> order,int[] ratio,Map<String,Integer> values){
		boolean arr[]=new boolean[10000];
		for(String temp:order){
			if(values.containsKey("next"))
			{
				int x=values.get("next");	
			}
			else{
				if(temp==order.get(0))
					values.put(temp, 1);
				else{
					int x=2;
					
				}
			}
				
		}
		return values;
	}
	
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		List<String> pattern=new ArrayList<String>(Arrays.asList("b","bc","ab","bc","b","abc","b"));
		List<String> order=new ArrayList<>();
		//Map<Integer,String> ord=new HashMap<>();
		/*while(sc.hasNext())
		{
			pattern.add(sc.next());
		}*/
		
		Map<String,Integer> map=new HashMap<String,Integer>();
		int ratio[]=new int[pattern.size()];
		int j=0;
		for(String temp: pattern)
		{
			int len=temp.length();
			int i=0;
			while(i<len)
			{
				if(!map.containsKey(Character.toString(temp.charAt(i))))
				{
					map.put(Character.toString(temp.charAt(i)), 1);
					order.add(Character.toString(temp.charAt(i)));
					//ord.put(j,Character.toString(temp.charAt(i)));
					if(!temp.contains(order.get(0)))
						ratio[j]=(map.get(order.get(0))+1)*-1;
					else if(temp.contains(order.get(0)) && Character.toString(temp.charAt(i))!= order.get(0))
					{
						if(temp.indexOf(order.get(0))<temp.indexOf(temp.charAt(i)))
							ratio[j]=map.get(order.get(0));
						else
							ratio[j]=map.get(order.get(0))+1;
					}
					j++;
				}
				else
				{
					if(Character.toString(temp.charAt(i))==order.get(0))
					{
						int x=map.get(Character.toString(temp.charAt(i)));
						map.replace(Character.toString(temp.charAt(i)),x+1);
					}
				}
				i++;
			}
		}
		boolean found=true;
		List<String> alphabets=order;
		Collections.sort(alphabets);
		Map<String,Integer> values=new HashMap<>();
		while(found){
			boolean match=true;
			int index=0;
			int x=1;
			values=getCombination(order,ratio,values);
			while(match){
				String s="";
				for(String temp: alphabets)
				{
					if(x%values.get(temp)==0)
						s=s+temp;
				}
				if(!s.isEmpty() && s!=pattern.get(index))
					match=false;
				else if(!s.isEmpty())
					index++;
				if(index==pattern.size())
				{
					match=false;
					found=false;
				}
				x++;
		}
		}
		System.out.println("yo");
	}
}
