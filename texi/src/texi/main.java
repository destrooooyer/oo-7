package texi;

import java.util.Scanner;

/**
 * Created by DESTR on 2016/4/20.
 */
public class main
{
	public static void main(String argv[])
	{
		map _map=new map();
		String path=new String();
		Scanner sc =new Scanner(System.in);
		if(sc.hasNextLine())
			path=sc.nextLine();
		else
			System.exit(0);

		_map.read_file(path);
		_map.init();
		_map.print();

	}
}
