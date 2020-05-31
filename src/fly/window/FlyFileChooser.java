package fly.window;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import fly.window.widget.FlyWidget;


/**
 * @file FlyFileChooser.java
 * @author Fly
 */


/**
 * 文件选择器类
 * */
public class FlyFileChooser
{
	private JFileChooser file_chooser;///< 文件选择器
	private ArrayList<FileFilter> file_filter = new ArrayList<FileFilter>();///< 文件过滤器

	public static final int APPROVE_OPTION = JFileChooser.APPROVE_OPTION;
	public static final int CANCEL_OPTION = JFileChooser.CANCEL_OPTION;
	public static final int ERROR_OPTION = JFileChooser.ERROR_OPTION;

	public FlyFileChooser()
	{
		file_chooser = new JFileChooser();
		file_filter.add(new FileNameExtensionFilter("*"));

		file_chooser.addChoosableFileFilter(file_filter.get(0));
	}


	/**
	 * 弹出带有自定义确定按钮的自定义文件选择器对话框。
	 *
	 * 弹出时文件选择器的返回状态:
	 * FlyFileChooser.APPROVE_OPTION
	 * FlyFileChooser.CANCEL_OPTION
	 * FlyFileChooser.ERROR_OPTION 如果发生错误或对话框被关闭
	 *
	 *
	 * @param button_text 确定按钮的文本
	 *
	 * @return 返回状态
	 * */
	public int ShowDialog(String button_text)
	{return this.file_chooser.showDialog(null, button_text);}

	/**
	 * 弹出“打开文件”文件选择器对话框
	 *
	 * @return 返回状态
	 * */
	public int ShowOpenDialog()
	{return this.file_chooser.showOpenDialog(null);}

	/**
	 * 弹出“保存文件”文件选择器对话框。
	 *
	 * @return 返回状态
	 * */
	public int ShowSaveDialog()
	{return this.file_chooser.showSaveDialog(null);}


	/**
	 * 弹出带有自定义确定按钮的自定义文件选择器对话框。
	 *
	 * 弹出时文件选择器的返回状态:
	 * FlyFileChooser.APPROVE_OPTION
	 * FlyFileChooser.CANCEL_OPTION
	 * FlyFileChooser.ERROR_OPTION 如果发生错误或对话框被关闭
	 *
	 * @param window 打开对话框所依赖的框架和放置对话框时应考虑其外观位置的组件。
	 * @param button_text 确定按钮的文本
	 *
	 * @return 返回状态
	 * */
	public int ShowDialog(Window window,String button_text)
	{return this.file_chooser.showDialog(window.GetFrame(), button_text);}


	/**
	 * 弹出带有自定义批准按钮的自定义文件选择器对话框。
	 *
	 * 弹出时文件选择器的返回状态:
	 * FlyFileChooser.APPROVE_OPTION
	 * FlyFileChooser.CANCEL_OPTION
	 * FlyFileChooser.ERROR_OPTION 如果发生错误或对话框被关闭
	 *
	 * @param widget 打开对话框所依赖的框架和放置对话框时应考虑其外观位置的组件。
	 * @param button_text 确定按钮的文本
	 *
	 * @return 返回状态
	 * */
	public int ShowDialog(FlyWidget widget,String button_text)
	{return this.file_chooser.showDialog(widget.Get(), button_text);}


	/**
	 * 弹出“打开文件”文件选择器对话框
	 *
	 * @param window 打开对话框所依赖的框架和放置对话框时应考虑其外观位置的组件。
	 *
	 * @return 返回状态
	 * */
	public int ShowOpenDialog(Window window)
	{return this.file_chooser.showOpenDialog(window.GetFrame());}


	/**
	 * 弹出“打开文件”文件选择器对话框
	 *
	 * @param widget 打开对话框所依赖的框架和放置对话框时应考虑其外观位置的组件。
	 *
	 * @return 返回状态
	 * */
	public int ShowOpenDialog(FlyWidget widget)
	{return this.file_chooser.showOpenDialog(widget.Get());}


	/**
	 * 弹出“保存文件”文件选择器对话框。
	 *
	 * @param window 打开对话框所依赖的框架和放置对话框时应考虑其外观位置的组件。
	 *
	 * @return 返回状态
	 * */
	public int ShowSaveDialog(Window window)
	{return this.file_chooser.showSaveDialog(window.GetFrame());}


	/**
	 * 弹出“保存文件”文件选择器对话框。
	 *
	 * @param widget 打开对话框所依赖的框架和放置对话框时应考虑其外观位置的组件。
	 *
	 * @return 返回状态
	 * */
	public int ShowSaveDialog(FlyWidget widget)
	{return this.file_chooser.showSaveDialog(widget.Get());}



	/**
	 * 获取选中的文件
	 *
	 * @return 返回选中的文件
	 * */
	public File GetSelectedFile(){return this.file_chooser.getSelectedFile();}

	/**
	 * 获取选择的文件
	 *
	 * @return 返回选择的文件
	 * */
	public File[] GetSelectedFiles(){return this.file_chooser.getSelectedFiles();}

	/**
	 * 获取选中文件的文件名
	 *
	 * @return 返回选中的文件的文件名
	 * */
	public String GetSelectedFileName(){return this.file_chooser.getSelectedFile().getName();}

	/**
	 * 获取选择文件的文件名
	 *
	 * @return 返回选择的文件的文件名
	 * */
	public String[] GetSelectedFilesName()
	{
		final long n = this.file_chooser.getSelectedFiles().length;
		String[] name = new String[(int) n];

		for(int i = 0;i < n;i++)
		{
			name[i] = this.file_chooser.getSelectedFiles()[i].getName();
		}

		return name;
	}

	/**
	 * 获取选中文件的路径
	 *
	 * @return 返回选中的文件的路径
	 * */
	public String GetSelectedFilePath(){return this.file_chooser.getSelectedFile().getPath();}

	/**
	 * 获取选择文件的路径
	 *
	 * @return 返回选择的文件的路径
	 * */
	public String[] GetSelectedFilesPath()
	{
		final long n = this.file_chooser.getSelectedFiles().length;
		String[] path = new String[(int) n];

		for(int i = 0;i < n;i++)
		{
			path[i] = this.file_chooser.getSelectedFiles()[i].getPath();
		}

		return path;
	}

	/**
	 * 设置过滤器,支持文件的格式 "*"，不用 "*.*"
	 *
	 * @param file_filter 要设置的过滤器
	 * */
	public void SetFileFilter(FileFilter file_filter)
	{
		this.file_filter.clear();
		this.file_filter.add(file_filter);
		this.file_chooser.addChoosableFileFilter(this.file_filter.get(0));
	}

	/**
	 * 设置过滤器,支持文件的格式 "*"，不用 "*.*"
	 *
	 * @param description textual description for the filter, may be null
	 * @param extensions accepted file name extensions
	 * */
	public void SetFileFilter(String description, String... extensions)
	{
		this.file_filter.clear();
		this.file_filter.add(new FileNameExtensionFilter(description,extensions));
		file_chooser.addChoosableFileFilter(this.file_filter.get(0));
	}


	/**
	 * 添加过滤器,支持文件的格式 "*"，不用 "*.*"
	 *
	 * @param file_filter 要设置的过滤器
	 * */
	public void AddFileFilter(FileFilter file_filter)
	{
		this.file_filter.add(file_filter);
		this.file_chooser.addChoosableFileFilter(this.file_filter.get(this.file_filter.size() - 1));
	}

	/**
	 * 添加过滤器,支持文件的格式 "*"，不用 "*.*"
	 *
	 * @param description textual description for the filter, may be null
	 * @param extensions accepted file name extensions
	 * */
	public void AddFileFilter(String description, String... extensions)
	{
		this.file_filter.add(new FileNameExtensionFilter(description,extensions));
		file_chooser.addChoosableFileFilter(this.file_filter.get(this.file_filter.size() - 1));
	}
}















