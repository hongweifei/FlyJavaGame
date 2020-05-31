package fly.h5.graphics;


import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.ImageElement;

public class FlyRenderer2D extends FlyRenderer
{

	private Context2d context = null;
	
	public FlyRenderer2D()
	{
		super();
	}
	
	public FlyRenderer2D(Context2d context)
	{
		this();
		this.context = context;
	}

	/**获取Context2d*/
	public Context2d GetContext2d()
	{
		return this.context;
	}

	/**fill*/
	public void Fill()
	{
		context.fill();
	}
	
	/**stroke*/
	public void Stroke()
	{
		context.stroke();
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void MoveTo(double x,double y)
	{
		context.moveTo(x, y);
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void LineTo(double x,double y)
	{
		context.lineTo(x, y);
	}
	
	
	
	/**
	 * 画线
	 *
	 * @param context
	 * @param x1 绘制的第一个点的横坐标
	 * @param y1 绘制的第一个点的纵坐标
	 * @param x2 绘制的第二个点的横坐标
	 * @param y2 绘制的第二个点的纵坐标
	 * */
	public final void DrawLine(double x1,double y1,double x2,double y2)
	{
		context.moveTo(x1, y1);
		context.lineTo(x2, y2);
		context.fill();
	}

	/**
	 * 画矩形
	 *
	 * @param context
	 * @param x 绘制横坐标
	 * @param y 绘制纵坐标
	 * @param width 绘制宽度
	 * @param height 绘制高度
	 * */
	public final void DrawRect(double x,double y,double width,double height)
	{
		context.strokeRect(x, y, width, height);
	}


	/**
	 * 画文本
	 *
	 * @param context
	 * @param text 要绘制的文本
	 * @param x 绘制横坐标
	 * @param y 绘制纵坐标
	 * */
	public final void DrawText(String text,double x,double y)
	{
		context.fillText(text, x, y);
	}
	
	
	
	/**
	 * 绘制图片，不可设置绘制宽高
	 *
	 * @param path 要绘制的图像的路径
	 * @param x 绘制横坐标
	 * @param y 绘制纵坐标
	 *
	 * @return
	 * */
	public final void DrawImage(String path,double x,double y)
	{
		draw_image.setSrc(path);
		context.drawImage(draw_image, x, y);
	}

	

	/**
	 * 绘制图片，可设置绘制宽高
	 *
	 * @param path 要绘制的图像的路径
	 * @param x 绘制横坐标
	 * @param y 绘制纵坐标
	 * @param width 绘制宽度
	 * @param height 绘制高度
	 *
	 * @return
	 * */
	public final void DrawImage(String path,double x,double y,double width,double height)
	{
		draw_image.setSrc(path);
		context.drawImage(draw_image, x, y, width, height);
	}

	
	/**
	 * 绘制裁剪后的图片图片，可设置绘制宽高
	 *
	 * @param path 要绘制的图像的路径
	 * @param x 目标矩形第一个角的x坐标。
	 * @param y 目标矩形第一个角的y坐标。
	 * @param width 目标矩形的宽。
	 * @param height 目标矩形的高。
	 * @param sx 源矩形第一个角的x坐标。
	 * @param sy 源矩形第一个角的y坐标。
	 * @param swidth 源矩形的宽。
	 * @param sheight 源矩形的高。
	 *
	 * @return
	 * */
	public final void DrawImageA(String path,double x,double y,double width,double height,
			double sx,double sy,double swidth,double sheight)
	{
		draw_image.setSrc(path);
		context.drawImage(draw_image, sx, sy, swidth, sheight, x, y, width, height);
	}
	

	/**
	 * 绘制裁剪后的图片图片，可设置绘制宽高
	 *
	 * @param path 要绘制的图像的路径
	 * @param dx1 目标矩形第一个角的x坐标。
	 * @param dy1 目标矩形第一个角的y坐标。
	 * @param dx2 目标矩形第二个角的x坐标。
	 * @param dy2 目标矩形第二个角的y坐标。
	 * @param sx1 源矩形第一个角的x坐标。
	 * @param sy1 源矩形第一个角的y坐标。
	 * @param sx2 源矩形第二个角的x坐标。
	 * @param sy2 源矩形的第二个角点的y坐标。
	 *
	 * @return
	 * */
	public final void DrawImageB(String path,double dx1,double dy1,double dx2,double dy2,
			double sx1,double sy1,double sx2,double sy2)
	{
		draw_image.setSrc(path);
		context.drawImage(draw_image, sx1, sy1, sx2 - sx1, sy2 - sy1, dx1, dy1, dx2 - dx1, dy2 - dy1);
	}


	/**
	 * 绘制图片，可设置绘制宽高
	 *
	 * @param image 要绘制的图像
	 * @param x 绘制横坐标
	 * @param y 绘制纵坐标
	 * @param width 绘制宽度
	 * @param height 绘制高度
	 *
	 * @return
	 * */
	public final void DrawImage(ImageElement image,double x,double y,double width,double height)
	{
		context.drawImage(image, x, y, width, height);
	}

	
	/**
	 * 绘制裁剪后的图片图片，可设置绘制宽高
	 *
	 * @param image 要绘制的图像
	 * @param x 目标矩形第一个角的x坐标。
	 * @param y 目标矩形第一个角的y坐标。
	 * @param width 目标矩形的宽。
	 * @param height 目标矩形的高。
	 * @param sx 源矩形第一个角的x坐标。
	 * @param sy 源矩形第一个角的y坐标。
	 * @param swidth 源矩形的宽。
	 * @param sheight 源矩形的高。
	 *
	 * @return
	 * */
	public final void DrawImageA(ImageElement image,double x,double y,double width,double height,
			double sx,double sy,double swidth,double sheight)
	{
		context.drawImage(image, sx, sy, swidth, sheight, x, y, width, height);
	}
	

	/**
	 * 绘制裁剪后的图片图片，可设置绘制宽高
	 *
	 * @param image 要绘制的图像
	 * @param dx1 目标矩形第一个角的x坐标。
	 * @param dy1 目标矩形第一个角的y坐标。
	 * @param dx2 目标矩形第二个角的x坐标。
	 * @param dy2 目标矩形第二个角的y坐标。
	 * @param sx1 源矩形第一个角的x坐标。
	 * @param sy1 源矩形第一个角的y坐标。
	 * @param sx2 源矩形第二个角的x坐标。
	 * @param sy2 源矩形的第二个角点的y坐标。
	 *
	 * @return
	 * */
	public final void DrawImageB(ImageElement image,double dx1,double dy1,double dx2,double dy2,
			double sx1,double sy1,double sx2,double sy2)
	{
		context.drawImage(image, sx1, sy1, sx2 - sx1, sy2 - sy1, dx1, dy1, dx2 - dx1, dy2 - dy1);
	}
}













