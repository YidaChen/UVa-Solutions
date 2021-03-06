package v001;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class StacksOfFlapjacks_UVa120 {

	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder sb = new StringBuilder();
		
		while(sc.ready())
		{
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			int n = st.countTokens();
			int[] A = new int[n];
			for(int i = 0; i < n; ++i)
				sb.append(A[i] = Integer.parseInt(st.nextToken())).append(i == n - 1 ? "\n" : " ");
			
			int pos = n - 1;
			while(pos > 0)
			{
				int max = 0, idx = -1;
				for(int i = 0; i < pos; ++i)
					if(A[i] > max)
						max = A[idx = i];
				if(A[pos] < max)
				{
					if(idx != 0)
					{
						sb.append(n - idx + " ");
						for(int i = 0, j = idx; i < j; ++i, --j)
						{
							int tmp = A[i]; A[i] = A[j]; A[j] = tmp;
						}
					}
					
					sb.append(n - pos + " ");
					for(int i = 0, j = pos; i < j; ++i, --j)
					{
						int tmp = A[i]; A[i] = A[j]; A[j] = tmp;
					}
				}
				--pos;
			}
			sb.append("0\n");
		}
		out.print(sb);
		out.flush();
		out.close();
	}
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){    br = new BufferedReader(new InputStreamReader(s));}

		public Scanner(FileReader r){    br = new BufferedReader(r);}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}

		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}

		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}

		public boolean ready() throws IOException {return br.ready();}


	}
}