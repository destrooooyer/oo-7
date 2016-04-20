package texi;

import java.io.File;
import java.io.FileReader;

/**
 * Created by DESTR on 2016/4/20.
 */
public class map
{
	private int map[][];
	private String str_in;

	public map()
	{
		this.map = new int[82][82];
		this.str_in = "";
	}

	public boolean read_file(String path)
	{
		try
		{
			File file_temp = new File(path);
			if (file_temp.exists() && file_temp.isFile())
			{
				FileReader fr = new FileReader(file_temp);

				String str_temp="";


				return true;
			}
			else
			{
				System.out.println("文件不存在或是目录");
				return false;
			}
		}
		catch (Exception e)
		{
			System.out.println("请输入正确的参数，读取输入文件失败");
			return false;
		}
	}

}
