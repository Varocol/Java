package org.example.Learn;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;



public class LayoutBox extends JPanel
{
	private Color bgColor;
	
	public LayoutBox()
	{
		this.setOpaque(false);
	}
	
	public LayoutBox layout(LayoutManager lm)
	{
		this.setLayout(lm);
		return this;
	}
	
	/** 内边距 
	 * 
	 */
	public LayoutBox padding( int size)
	{
		return padding(size, size, size, size);
	}
	
	public LayoutBox padding( int top, int left, int bottom, int right)
	{
		// 创建一个空白边框 (用作内边距设置)
		Border newBorder = BorderFactory.createEmptyBorder(top, left, bottom, right);
		
		// 如果已经有了边框，则创建复合边框
		Border border = this.getBorder();
		if(border != null)
			newBorder = BorderFactory.createCompoundBorder(border, newBorder);
		
		this.setBorder( newBorder );
		
		return this;
	}
	
	/** 控件尺寸 Preferred Size 
	 * 
	 */
	public LayoutBox preferredSize(int w, int h)
	{
		this.setPreferredSize(new Dimension(w, h));
		return this;
	}
	
	public LayoutBox preferredWidth(int w)
	{
		Dimension size = this.getPreferredSize();
		if(size == null)
			size = new Dimension(0,0);
		size.width = w;
		this.setPreferredSize( size);
		return this;
	}
	
	public LayoutBox preferredHeight(int h)
	{
		Dimension size = this.getPreferredSize();
		if(size == null)
			size = new Dimension(0,0);
		size.height = h;
		this.setPreferredSize( size);
		return this;
	}

	// 背景色设置
	public LayoutBox bgColor(Color color)
	{
		this.bgColor = color;
		this.repaint();
		return this;
	}
	
	// 背景色绘制
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		// 绘制背景色
		if( bgColor != null)
		{			
			g.setColor(bgColor);
			g.fillRect(0, 0, getWidth(), getHeight());
		}	
	}
}
