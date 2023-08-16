package week4.day3.jo_2543;

import java.util.Scanner;

public class Main_Answer {
	
	static int n,x,y,T[][] = new int[513][513];

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		
	    tile(1,1,n,n,x+1,y+1,0);

		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) 
				sb.append(T[i][j]).append(' ');
			
			sb.append('\n');
		}
			
		
		System.out.println(sb);
	}
	
	static void tile(int sx, int sy, int ex, int ey, int hx, int hy, int hc)
	{
	    int mx=(sx+ex)/2,my=(sy+ey)/2;
	    if(sx==ex)
	    {
	        T[sx][sy]=hc;
	        return;
	    }
	    if(hx>=sx&&hx<=mx&&hy>=sy&&hy<=my)
	    {
	        T[mx+1][my]=1;
	        T[mx][my+1]=1;
	        T[mx+1][my+1]=1;
	        tile(sx,sy,mx,my,hx,hy,hc);
	        tile(mx+1,sy,ex,my,mx+1,my,1);
	        tile(sx,my+1,mx,ey,mx,my+1,1);
	        tile(mx+1,my+1,ex,ey,mx+1,my+1,1);
	    }
	    else if(hx>=mx+1&&hx<=ex&&hy>=sy&&hy<=my)
	    {
	        T[mx][my]=2;
	        T[mx+1][my]=2;
	        T[mx+1][my+1]=2;
	        tile(sx,sy,mx,my,mx,my,3);
	        tile(mx+1,sy,ex,my,hx,hy,hc);
	        tile(sx,my+1,mx,ey,mx,my+1,3);
	        tile(mx+1,my+1,ex,ey,mx+1,my+1,3);
	    }
	    else if(hx>=sx&&hx<=mx&&hy>=my+1&&hy<=ey)
	    {
	        T[mx][my]=3;
	        T[mx][my+1]=3;
	        T[mx+1][my+1]=3;
	        tile(sx,sy,mx,my,mx,my,2);
	        tile(mx+1,sy,ex,my,mx+1,my,2);
	        tile(sx,my+1,mx,ey,hx,hy,hc);
	        tile(mx+1,my+1,ex,ey,mx+1,my+1,2);
	    }
	    else if(hx>=mx+1&&hx<=ex&&hy>=my+1&&hy<=ey)
	    {
	        T[mx][my]=4;
	        T[mx+1][my]=4;
	        T[mx][my+1]=4;
	        tile(sx,sy,mx,my,mx,my,4);
	        tile(mx+1,sy,ex,my,mx+1,my,4);
	        tile(sx,my+1,mx,ey,mx,my+1,4);
	        tile(mx+1,my+1,ex,ey,hx,hy,hc);
	    }
	}
}
