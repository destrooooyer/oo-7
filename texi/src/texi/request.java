package texi;

/**
 * Created by DESTR on 2016/4/20.
 */
public class request implements Runnable
{
	private int _x;
	private int _y;
	private int dest_x;
	private int dest_y;

	public request(int _x, int _y, int dest_x, int dest_y)
	{
		this._x = _x;
		this._y = _y;
		this.dest_x = dest_x;
		this.dest_y = dest_y;
	}

	@Override
	public void run()
	{

	}
}
