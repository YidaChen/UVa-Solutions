package v106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheJackpot_UVa10684 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(!st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n==0)
				break;
			int max = 0; int cur = 0;
			st = new StringTokenizer(br.readLine());
			while(n-->0)
			{
				while(!st.hasMoreTokens())
					st = new StringTokenizer(br.readLine());
				cur += Integer.parseInt(st.nextToken());
				if(cur < 0) {cur = 0; continue;}
				max = Math.max(cur, max);
			}
			if(max>0)
				out.printf("The maximum winning streak is %d.\n",max);
			else
				out.println("Losing streak.");
		}
		out.flush();
		out.close();
	}
}
