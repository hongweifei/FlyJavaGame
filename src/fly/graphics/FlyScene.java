package fly.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import fly.shared.Event;
import fly.window.Window;
import fly.window.listener.FlyKeyListener;
import fly.window.listener.FlyMouseListener;
import fly.window.listener.FlyWindowListener;


/**
 * @file FlyScene.java
 * @author Fly
 */


/**
 * 场景类
 * */
@SuppressWarnings("serial")
public class FlyScene extends JPanel
{
	private FlyRenderer2D renderer;///< 渲染器
	private boolean renderer_init = false;

	/**场景渲染事件*/
	private Event<FlyRenderer2D> render_event_a = null;
	private RenderEvent render_event_b = null;

	private boolean auto_repaint = false;

	public FlyScene()
	{
		this(null);
	}

	public FlyScene(Window w)
	{
		//renderer = new FlyRenderer2D();
		
		render_event_a =new Event<FlyRenderer2D>() {
			@Override public void invoke(FlyRenderer2D renderer) {}
		};
		
		render_event_b = new RenderEvent() {
			@Override public void Init(FlyRenderer2D renderer) {}
			@Override public void Render(FlyRenderer2D renderer) {}
		};
		
		if(w != null)
			this.AddToWindow(w);
	}

	/*
	绘制组件的边框。
	@Override public void paintBorder(Graphics g) {super.paintBorder(g);}

	绘制此组件的子组件。
	@Override public void paintChildren(Graphics g){super.paintChildren(g);}

	如果UI委托为非空，则调用UI委托的绘制方法。
	@Override public void paintComponent(Graphics g)
	{super.paintComponent(g);}

	绘制此组件及其所有子组件。
	@Override public void paintAll(Graphics g){super.paintAll(g);}
	*/

	/**
	 * 由Swing调用以绘制组件。这个方法实际上将绘画工作委托给三个受保护的方法：paintComponent、paintBorder和paintChildren。
	 *
	 * @param g
	 * */
	@Override public void paint(Graphics g)
	{
		super.paint(g);

		if(!renderer_init)
		{
			renderer = new FlyRenderer2D((Graphics2D)g);
			render_event_b.Init(renderer);
		}

		render_event_a.invoke(renderer);
		render_event_b.Render(renderer);

		if(this != null && auto_repaint)
			super.repaint();
	}

	
	
	/**
	 * 设置渲染事件
	 * */
	public void SetRenderEvent(Event<FlyRenderer2D> event)
	{
		this.render_event_a = event;
	}

	/**
	 * 设置渲染事件
	 * */
	public void SetRenderEvent(Event<FlyRenderer2D> event,boolean repaint)
	{
		this.render_event_a = event;
		this.auto_repaint = repaint;
	}
	
	
	/**
	 * 设置渲染事件
	 * */
	public void SetRenderEvent(RenderEvent event)
	{
		this.render_event_b = event;
	}

	/**
	 * 设置渲染事件
	 * */
	public void SetRenderEvent(RenderEvent event,boolean repaint)
	{
		this.render_event_b = event;
		this.auto_repaint = repaint;
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
	public void SetMouseListener(FlyMouseListener listener)
	{
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
		this.addMouseWheelListener(listener);
	}


	/**
	 * 设置key监听器
	 *
	 * @param listener 要设置的监听器
	 * */
	public void SetKeyListener(FlyKeyListener listener){this.addKeyListener(listener);}

	/**
	 * 设置鼠标监听器和key监听器
	 *
	 * @param listener 要设置的监听器
	 * */
	public void SetMouseAndKeyListener(FlyWindowListener listener)
	{
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
		this.addMouseWheelListener(listener);
		this.addKeyListener(listener);
	}


	/**
	 * 将场景添加至窗口
	 *
	 * @param w 场景要添加到的窗口
	 * */
	public void AddToWindow(Window w){w.GetFrame().add(this);w.SetVisible(true);}
}











