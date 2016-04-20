package texi;

import java.util.Scanner;

/**
 * Created by DESTR on 2016/4/20.
 */
public class main
{
	public static void main(String argv[])
	{
		map _map = new map();
		String path = new String();
		Scanner sc = new Scanner(System.in);

		System.out.println("请输入地图数据所在的文件的绝对路径");
		if (sc.hasNextLine())
			path = sc.nextLine();
		else
			System.exit(0);

		if (!_map.read_file(path))
		{
			System.out.println("读取文件失败");
			System.exit(0);
		}
		_map.init();
		_map.print();

	}
}
