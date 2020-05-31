package fly.h5.graphics;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.Window;

import fly.shared.graphics.Event;


public class FlyScene
{
	private com.google.gwt.dom.client.CanvasElement canvas = null;
	private FlyRenderer2D renderer = null;
	
	private static long delay_time = 1000/60;
	
	/**场景渲染事件*/
	private Event<FlyRenderer2D> render_event =
			new Event<FlyRenderer2D>(){@Override public void invoke(FlyRenderer2D renderer) {}};
	
	public FlyScene()
	{
		this("layer");
	}
	
	/**
	 * 
	 * @param id
	 */
	public FlyScene(String id)
	{
		canvas = Document.get().createCanvasElement();
		canvas.setId(id);
		canvas.setWidth(Window.getClientWidth());
		canvas.setHeight(Window.getClientHeight());
		
		renderer = new FlyRenderer2D(canvas.getContext2d());
		this.paint();
	}
	
	/**
	 * 
	 * @param div
	 */
	public FlyScene(DivElement div)
	{
		this(div,"layer");
	}
	
	/**
	 * 
	 * @param div
	 * @param id
	 */
	public FlyScene(DivElement div,String id)
	{
		this(id);
		div.appendChild(canvas);
	}
	
	
	@SuppressWarnings("static-access")
	private void paint()
	{
		if(render_event != null)
			this.render_event.invoke(this.renderer);
		
		try {Thread.sleep(this.delay_time);}
		catch (InterruptedException e) {e.printStackTrace();}
		
		this.paint();
	}
	
	
	/**
	 * 
	 * @param str
	 */
	private static native void print(String str)
	/*-{ print(str); }-*/;
	
	
	/**
	 * 设置渲染事件
	 * */
	public void SetRenderEvent(Event<FlyRenderer2D> event)
	{
		this.render_event = event;
	}



	/**
	 * 设置场景使用的渲染器
	 *
	 * @param renderer 给场景的渲染器
	 * */
	public void SetRenderer(FlyRenderer2D renderer) {this.renderer = renderer;}

	/**
	 * 获取场景使用的渲染器
	 * */
	public FlyRenderer2D GetRenderer() {return this.renderer;}

	/**
	 * 设置鼠标监听器
	 *
	 * @param listener 要设置的监听器
	 * */
	public void SetMouseListener()
	{
		
	}


	/**
	 * 设置key监听器
	 *
	 * @param listener 要设置的监听器
	 * */
	public void SetKeyListener(){}

	/**
	 * 设置鼠标监听器和key监听器
	 *
	 * @param listener 要设置的监听器
	 * */
	public void SetMouseAndKeyListener()
	{
		
	}


	/**
	 * 将场景添加至div
	 *
	 * @param div 场景要添加到的div
	 * */
	public void AddToDiv(DivElement div){div.appendChild(this.canvas);}
}








