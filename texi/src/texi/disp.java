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

	public void add_request(int x,int y,int dest_x,int dest_y)
	{
		request req=new request(x,y,dest_x,dest_y,this);
		requests.addLast(req);
		new Thread(req).start();
	}

	public void complete_req(request req)
	{
		synchronized (this)
		{
			//从队列中删除
			requests.remove(req);
			//选车
			car car_temp;
		}
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
			//向车门广播请求
			for (request i : requests)
			{
				for (int j = 0; j < 100; j++)
				{
					//在4*4的范围内
					if (cars[j].get_x() >= i.get_x() - 2 && cars[j].get_x() <= i.get_x() + 2 &&
							cars[j].get_y() >= i.get_y() - 2 && cars[j].get_y() <= i.get_y() + 2)
					{
						//没有抢过单
						if(i.getBo_car(j)==false)
						{
							i.setBo_car(j);
							cars[j].reputation_up(1);
						}
					}
				}
			}
		}
	}
}
