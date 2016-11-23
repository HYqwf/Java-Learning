

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Random;
import java.util.Vector;
import java.util.prefs.BackingStoreException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyJPanel2 extends JPanel implements ActionListener, MouseMotionListener,MouseListener{

	public class Info{
		int x,y;
		int x1,y1;
		Color c;
		int type;
		int size;
	}
	
	
	private MyPaint2 p;
	private int type;
	private int x, y, x1, y1;
	private int startx, starty;
	private int size;
	private boolean flag;
	Vector<Info> infos = new Vector<Info>();
	
	public void setType(int type){
		this.type = type;
	}
	
	public void setSize(int size){
		this.size = size;
	}
	
	public MyJPanel2(MyPaint2 p){
		this.p = p;
		this.type = 1;
		this.size = 2;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		switch (type) {
		case 1: // 铅笔
			p.label.setText("                    用画任意形状的线条");
			break;
		case 2: // 直线
			p.label.setText("                    画一条直线");
			break;
		case 3://矩形
			p.label.setText("                    画一个矩形");
		    break;
		case 4: //圆形
			p.label.setText("                    画一个圆");
			break;
		case 5: // 椭圆
			p.label.setText("                    画一个椭圆");
			break;
		case 6: // 圆角矩形
			p.label.setText("                    画一个圆角矩形");
			break;
		case 7: // 橡皮
			p.label.setText("                    使用橡皮擦擦去图片的一部分");
			break;
		case 8: // 颜色
			p.label.setText("                    选择画笔颜色");
			break;
		case 9: // 多边形
			p.label.setText("                    画一个多边形");
			break;
		default:
			p.label.setText("                    欢迎使用！");
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			if(e.getSource()==p.btn9){
				this.setType(2);
				if(!flag){
					startx = x = e.getX();
					starty = y = e.getY();
					flag = true;
				}
			}	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//建立绘画对象
		Graphics2D g = (Graphics2D) this.getGraphics();
		Info info = new Info();
		g.setColor(p.selectColor);	//默认为黑色
		g.setStroke(new BasicStroke(size));
		info.c = p.selectColor;
		info.type = type;
		info.size = size;
		x1 = e.getX();
		y1 = e.getY();
		
		
		
		/*if(type.equalsIgnoreCase("直线")){
			Line2D line2 = new Line2D.Double(x, y, x1, y1);
			g.draw(line2);
			info.x = x;
			info.y = y;
			info.x1 = x1;
			info.y1 = y1;
		}else if(type.equalsIgnoreCase("矩形")){
			Rectangle2D rect = new Rectangle2D.Double(x, y,Math.abs(x1 - x), Math.abs(y1 - y));
			g.draw(rect);
			info.x = x;
			info.y = y;
			info.x1 = x1 - x;
			info.y1 = y1 - y;
		}else if(type.equalsIgnoreCase("圆形")){
			Arc2D circle = new Arc2D.Double(x, y,Math.abs(x1 - x), Math.abs(x1 - x),0,360,Arc2D.OPEN);
			g.draw(circle);
			info.x = x;
			info.y = y;
			info.x1 = x1 - x;
			info.y1 = y1 - y;
		}else if(type.equalsIgnoreCase("椭圆")){
			Ellipse2D ellipse = new Ellipse2D.Double(x, y,Math.abs(x1 - x), Math.abs(y1 - y));
			g.draw(ellipse);
			info.x = x;
			info.y = y;
			info.x1 = x1 - x;
			info.y1 = y1 - y;
		}else if(type.equalsIgnoreCase("圆角矩形")){
			RoundRectangle2D rect_round = new RoundRectangle2D.Double(x, y, Math.abs(x1 - x), Math.abs(y1- y), 20, 10);
			g.draw(rect_round);
			info.x = x;
			info.y = y;
			info.x1 = x1 - x;
			info.y1 = y1 - y;
		}*/
		
		
		switch (type){
			case 2://直线
				Line2D line2 = new Line2D.Double(x, y, x1, y1);
				g.setStroke(new BasicStroke(size));
				g.draw(line2);
				info.x = x;
				info.y = y;
				info.x1 = x1;
				info.y1 = y1;
				break;
			case 3://矩形
				Rectangle2D rect = new Rectangle2D.Double(x, y,Math.abs(x1 - x), Math.abs(y1 - y));
				g.setStroke(new BasicStroke(size));
				g.draw(rect);
				info.x = x;
				info.y = y;
				info.x1 = Math.abs(x1 - x);
				info.y1 = Math.abs(y1 - y);
				break;
			case 4://圆形
				Arc2D circle = new Arc2D.Double(x, y,Math.abs(x1 - x), Math.abs(x1 - x),0,360,Arc2D.OPEN);
				g.setStroke(new BasicStroke(size));
				g.draw(circle);
				//g.drawOval(x, y,Math.abs(x - y),Math.abs(x - y) );
				info.x = x;
				info.y = y;
				info.x1 = Math.abs(x1 - x);
				info.y1 = Math.abs(x1 - x);
				break;
			case 5://椭圆
				Ellipse2D ellipse = new Ellipse2D.Double(x, y,Math.abs(x1 - x), Math.abs(y1 - y));
				g.setStroke(new BasicStroke(size));
				g.draw(ellipse);
				info.x = x;
				info.y = y;
				info.x1 = Math.abs(x1 - x);
				info.y1 = Math.abs(y1 - y);
				break;
			case 6://圆角矩形
				RoundRectangle2D rect_round = new RoundRectangle2D.Double(x, y, Math.abs(x1 - x), Math.abs(y1- y), 20, 10);
				g.setStroke(new BasicStroke(size));
				g.draw(rect_round);
				info.x = x;
				info.y = y;
				info.x1 = Math.abs(x1 - x);
				info.y1 = Math.abs(y1 - y);
				break;
			case 9://多边形
				info.x = x;
				info.y = y;
				if((x1 - startx) * (x1 - startx) + (y1 - starty) * (y1 - starty) <= 64){
					info.x1 = x1 = startx;
					info.y1 = y1 = starty;
					flag = false;
				}
				infos.add(info);
	            x = x1;  
	            y = y1;
				break;
			case 10://喷枪
				x = e.getX();
			    y = e.getY();
			    Random random = new Random();
			    for (int i = 0; i < 180; i++) {
			    	x1 = random.nextInt(25) - 12;
			        y1 = random.nextInt(25) - 12;
			    if (x1 * x1 + y1 * y1 > 121) {
			    	continue;// 如果生成的点不在以点击的位置为圆心以11为半径的圆内那么直接跳过这个点
			    }else{
			    	info.x = x1 + x;
			    	info.y = y1 + y;
			    	info.x1 = x1 + x;
			    	info.y1 = y1 + y;
			    	info.c = p.selectColor;
			    	info.type = 10;
			    	infos.add(info);
			    	g.drawLine(x1 + x, y1 + y, x1 + x, y1 + y);
			    }          		    
			   }
				break;
		}
		if(type!=9 && type!=10){
			infos.add(info);
		}	
	}

	@Override
	public void mouseDragged(MouseEvent e) {	
		Graphics2D g = (Graphics2D) this.getGraphics();
		Info info = new Info();
		info.x = x;
		info.y = y;
		info.x1 = x1 = e.getX();
		info.y1 = y1 = e.getY();
		info.size = size;
		info.type = type;
		switch(type){
			case 1:
				info.c = p.selectColor;
				g.setColor(p.selectColor);
				g.setStroke(new BasicStroke(size));
				g.drawLine(x, y, x1, y1);
				infos.add(info);
				x = x1;
				y = y1;
				break;
			case 7:		
				info.c = getBackground();
				g.setStroke(new BasicStroke(size));
				g.setColor(getBackground());
				g.drawLine(x, y, x1, y1);
				
				infos.add(info);
				x = x1;
				y = y1;
				break;
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
	
	public void paint(Graphics g){
		super.paint((Graphics2D)g);
		Graphics2D grap = (Graphics2D)g;
		for(Info i:infos){
			grap.setColor(i.c);
			grap.setStroke(new BasicStroke(i.size));
			if(i.type==1 || i.type==2 || i.type==7){//铅笔,直线,橡皮
				Line2D line = new Line2D.Double(i.x, i.y, i.x1, i.y1);
				grap.draw(line);
			}else if(i.type==3){//矩形
				Rectangle2D rect = new Rectangle2D.Double(i.x, i.y, i.x1, i.y1);
				grap.draw(rect);
			}else if(i.type==4){//圆形
				Arc2D circle = new Arc2D.Double(i.x, i.y, i.x1, i.y1,0,360,Arc2D.OPEN);
				grap.draw(circle);
				//grap.drawOval(i.x, i.y,Math.abs(i.x - i.y),Math.abs(i.x - i.y) );
			}else if(i.type==5){//椭圆
				Ellipse2D ellipse = new Ellipse2D.Double(i.x, i.y, i.x1, i.y1);
				grap.draw(ellipse);
			}else if(i.type==6){//圆角矩形
				RoundRectangle2D rect_round = new RoundRectangle2D.Double(i.x, i.y, i.x1, i.y1, 20, 10);
				grap.draw(rect_round);
			}else if(i.type==9){//多边形
				
			}else if(i.type==10){//喷枪
				grap.drawLine(i.x, i.y, i.x1, i.y1);				
			}
		}
			
			/*switch (i.type){
				case 2:
					grap.drawLine(i.x, i.y, i.x1, i.y1);
					break;
				case 3:
					grap.drawRect(i.x, i.y, i.x1, i.y1);
					break;
				case 4:
					grap.drawOval(i.x, i.y, i.x1, i.y1);
					break;
				case 5:
					Ellipse2D ellipse = new Ellipse2D.Double(x, y,Math.abs(x1 - x), Math.abs(y1 - y));
					grap.draw(ellipse);
					break;
				case 6:
					RoundRectangle2D rect_round = new RoundRectangle2D.Double(x, y, Math.abs(x1 - x), Math.abs(y1- y), 20, 10);
					grap.draw(rect_round);
					break;
			}*/
		}
	
	
	public void save(File f){
		BufferedImage image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D grap = (Graphics2D) image.getGraphics();
		grap.setColor(Color.white);
		grap.fillRect(0, 0, this.getWidth()+1, this.getHeight()+1);
		
		for(Info i:infos){
			grap.setColor(i.c);
			grap.setStroke(new BasicStroke(i.size));
			if(i.type==1 || i.type==7 || i.type==2){//直线
				Line2D line2 = new Line2D.Double(i.x, i.y, i.x1, i.y1);
				grap.draw(line2);
			}else if(i.type==3){//矩形
				Rectangle2D rect = new Rectangle2D.Double(i.x, i.y, i.x1, i.y1);
				grap.draw(rect);
			}else if(i.type==4){//圆形
				Arc2D circle = new Arc2D.Double(i.x, i.y, i.x1, i.y1,0,360,Arc2D.OPEN);
				grap.draw(circle);
			}else if(i.type==5){//椭圆
				Ellipse2D ellipse = new Ellipse2D.Double(i.x, i.y, i.x1, i.y1);
				grap.draw(ellipse);
			}else if(i.type==6){//圆角矩形
				RoundRectangle2D rect_round = new RoundRectangle2D.Double(i.x, i.y, i.x1, i.y1, 20, 10);
				grap.draw(rect_round);
			}else if(i.type==10){//喷枪
				Line2D line4 = new Line2D.Double(i.x, i.y, i.x1, i.y1);
				grap.draw(line4);
			}
		}
		
		try {
			ImageIO.write(image, "jpeg", f);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void openfile(File f){
		BufferedImage image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
			if(f != null){
				repaint();
				try{
					infos.removeAllElements();
					FileInputStream fin = new FileInputStream(f);
					ObjectInputStream oin = new ObjectInputStream(fin);
					infos = (Vector) oin.readObject();
					//image = oin.readObject();
					oin.close();
					repaint();
				}
				catch (IOException e1) {
					repaint();
					//flag = tempflag;
//					int result = JOptionPane.showConfirmDialog(this, "此文件无法读取！", "警告",
//							JOptionPane.CANCEL_OPTION);
//					if(result==JOptionPane.CANCEL_OPTION) {
//						return;
//					}
				} 
				catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					repaint();
					e.printStackTrace();
				}
			}
		}
	
	public void update(Graphics g){
		paint(g);
	}
	
}
