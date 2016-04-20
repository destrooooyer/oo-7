package texi;

import java.util.LinkedList;

/**
 * Created by DESTR on 2016/4/20.
 */
public class disp implements Runnable
{
	private car[] cars;
	private map _map;
	private int run_flag;
	private LinkedList<request> requests;

	public disp(map _map)
	{
		this._map = _map;
		cars = new car[100];
		for (int i = 0; i < 100; i++)
			cars[i] = new car(this._map);
		this.run_flag = 1;
		requests = new LinkedList<request>();
	}

	@Override
	public void run()
	{
		while (run_flag == 1)
		{
			try
			{
				Thread.sleep(100);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			for (int i = 0; i < 100; i++)
			{
				cars[i].move();
				cars[i].update_status();
			}
		}
	}
}
