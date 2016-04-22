package texi;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
//		_map.print();

		disp _disp = new disp(_map);
		new Thread(_disp).start();

		for(int i=0;i<299;i++)
		{
			_disp.add_request(new Random().nextInt(80),new Random().nextInt(80),new Random().nextInt(80),new Random().nextInt(80));
		}

		for(int j=0;j<3;j++)
		{
			try
			{
				Thread.sleep(4000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			for (int i = 0; i < 100; i++)
			{
				System.out.println(i + " " + _disp.watcher.get_reputation(i) + " " + _disp.watcher.get_status(i));
			}
			try
			{
				Thread.sleep(10000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		while (sc.hasNext())
		{
			String temp_str = sc.nextLine();
			String pt = "^([1-7]?[0-9])\\s+([1-7]?[0-9])\\s+([1-7]?[0-9])\\s+([1-7]?[0-9])$";
			Matcher mt = Pattern.compile(pt).matcher(temp_str);
			if (mt.find())
			{
				try
				{
					int x1 = Integer.parseInt(mt.group(1));
					int y1 = Integer.parseInt(mt.group(2));
					int x2 = Integer.parseInt(mt.group(3));
					int y2 = Integer.parseInt(mt.group(4));
					_disp.add_request(x1, y1, x2, y2);
				}
				catch (Exception e)
				{
					System.out.println("输入无效");
				}
			}
			else
			{
				System.out.println("输入无效");
			}
		}
	}
}
