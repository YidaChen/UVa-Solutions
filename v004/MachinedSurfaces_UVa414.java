package v004;
	
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 

	
public class MachinedSurfaces_UVa414{
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	    int t;
		while((t=Integer.parseInt(br.readLine()))!=0)
		{
			int[] rowXs = new int[t]; int max = 0;
			for(int i = 0; i < t; i++)
			{
				int count = 0;
				String s = br.readLine();
				for(int j = 0; j < 25; j++)
					if(s.charAt(j)=='X')
						count++;
				if(count > max)
					max = count;
				rowXs[i] = count;
			}
			int spaces = 0;
			for(int i = 0; i < t; i++)
				spaces += max - rowXs[i];
			sb.append(spaces+"\n");
		}
		System.out.print(sb);
		
	}
	
	
	
}	