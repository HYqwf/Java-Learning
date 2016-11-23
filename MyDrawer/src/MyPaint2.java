

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

public class MyPaint2 extends JFrame implements ActionListener{

	JButton btn1 = new JButton("铅            笔");
	JButton btn2 = new JButton("直            线");
	JButton btn3 = new JButton("矩            形");
	JButton btn4 = new JButton("圆            形");
	JButton btn5 = new JButton("椭            圆");
	JButton btn6 = new JButton("圆角  矩 形");
	JButton btn7 = new JButton("橡            皮");
	JButton btn8 = new JButton("颜           料");	
	JButton btn9 = new JButton("多    边   形");	
	JButton btn10 = new JButton("喷       枪");
	JButton btn11 = new JButton("画      笔1");
	JButton btn12 = new JButton("画     笔2");
	JButton btn13 = new JButton("画      笔3");
	JButton btn14 = new JButton("画    笔4");
	JLabel label = new JLabel();
	JPanel jp2 = new JPanel();
	
	JMenuBar mb = new JMenuBar(), mb2 = new JMenuBar();//菜单栏
	JMenu wj = new JMenu("文件(F)");//菜单
	JMenu ys = new JMenu("颜色(C)");
	JMenu bz = new JMenu("帮助(H)");
	JMenuItem  openfile, save, saveas, exit, help, about,coloredit;//菜单内容
	
	Box box = Box.createVerticalBox();//从上到下显示其组件的Box
	
	JPopupMenu pmu = new JPopupMenu();//弹出式菜单
	JSeparator spt1 = new JSeparator(), spt2 = new JSeparator();//下划线
	
	MyJPanel2 jp = new MyJPanel2(this);
	Color selectColor = Color.black;
	//int size = 4;
	
	public MyPaint2(){
		super("画板");
		
		//给按钮设置背景图片(通过setIcon或者构造函数均可)
		btn1.setIcon(new ImageIcon("D:\\画图程序\\铅笔.jpg"));
		btn2.setIcon(new ImageIcon("D:\\画图程序\\直线.jpg"));
		btn3.setIcon(new ImageIcon("D:\\画图程序\\矩形.jpg"));
		btn4.setIcon(new ImageIcon("D:\\画图程序\\圆.jpg"));
		btn5.setIcon(new ImageIcon("D:\\画图程序\\椭圆.jpg"));
		btn6.setIcon(new ImageIcon("D:\\画图程序\\圆角矩形.jpg"));
		btn7.setIcon(new ImageIcon("D:\\画图程序\\橡皮擦.jpg"));
		btn8.setIcon(new ImageIcon("D:\\画图程序\\选择颜色.jpg"));
		btn9.setIcon(new ImageIcon("D:\\画图程序\\多边形.jpg"));
		btn10.setIcon(new ImageIcon("D:\\画图程序\\喷枪.jpg"));
		btn11.setIcon(new ImageIcon("D:\\画图程序\\画笔1.jpg"));
		btn12.setIcon(new ImageIcon("D:\\画图程序\\画笔2.jpg"));
		btn13.setIcon(new ImageIcon("D:\\画图程序\\画笔3.jpg"));
		btn14.setIcon(new ImageIcon("D:\\画图程序\\画笔4.jpg"));
		
		
		openfile = new JMenuItem("打开(O)",KeyEvent.VK_O);//打开操作对应O键(键盘助记符)，下同
		save = new JMenuItem("保存(S)",KeyEvent.VK_S);
		saveas = new JMenuItem("另存为(D)",KeyEvent.VK_D);
		exit = new JMenuItem("退出(X)",KeyEvent.VK_F4);
		coloredit = new JMenuItem("编辑颜色(E)",KeyEvent.VK_E); 
		help = new JMenuItem("帮助主题(H)",KeyEvent.VK_H);
		about = new JMenuItem("关于画图(M)",KeyEvent.VK_M);
		
		//文件菜单
		mb.add(wj);
		wj.add(openfile);
		wj.add(save);
		wj.add(saveas);
		wj.add(spt1);// 加入分割线
		wj.add(exit);
		
		//颜色菜单
		mb.add(ys);
		ys.add(coloredit);
		
		//帮助菜单
		mb.add(bz);
		bz.add(help);
		bz.add(spt2);
		bz.add(about);
		
		//弹出菜单
		pmu.add("制作者：");
		pmu.add("薛明, 秦文芳");
		//setVisible(true);
		
		setBounds(200, 80, 840, 700);
		setBackground(jp.getBackground());// 设置窗口背景颜色
		setJMenuBar(mb);// 将菜单栏加入到窗口
		
		//box添加组件	
		jp2.setBackground(Color.gray);
		jp2.setBounds(1, 5, 120, 600);
		jp2.add(box);
		box.add(btn1);
		box.add(new JSeparator());
		box.add(btn2);
		box.add(new JSeparator());
		box.add(btn3);
		box.add(new JSeparator());
		box.add(btn4);
		box.add(new JSeparator());
		box.add(btn5);
		box.add(new JSeparator());
		box.add(btn6);
		box.add(new JSeparator());
		box.add(btn7);
		box.add(new JSeparator());
		box.add(btn8);
		box.add(new JSeparator());
		//box.add(btn9);
		//box.add(new JSeparator());
		//box.add(btn10);
		//box.add(new JSeparator());
		box.add(btn11);
		box.add(new JSeparator());
		box.add(btn12);
		box.add(new JSeparator());
		box.add(btn13);
		box.add(new JSeparator());
		box.add(btn14);
		box.add(new JSeparator());
		this.add(jp2,BorderLayout.WEST);
		setLayout(null);
		setVisible(true);
		//box.add(btn9);
		
		//设置快捷键
		wj.setMnemonic(KeyEvent.VK_F);
		ys.setMnemonic(KeyEvent.VK_C);
		bz.setMnemonic(KeyEvent.VK_H);
		//exit.setMnemonic(KeyEvent.VK_F4);//同下句作用一样
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,ActionEvent.ALT_MASK));
		openfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		saveas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
		coloredit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
				
		
		// 增加监视器
		openfile.addActionListener(this);
		save.addActionListener(this);
		saveas.addActionListener(this);
		exit.addActionListener(this);
		coloredit.addActionListener(this);
		about.addActionListener(this);
		help.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btn10.addActionListener(this);
		btn11.addActionListener(this);
		btn12.addActionListener(this);
		btn13.addActionListener(this);
		btn14.addActionListener(this);
		
		jp.setBackground(Color.white);
		jp.setBounds(130, 5, 660, 600);
		this.add(jp);
		
		this.setLayout(null);
		//this.setSize(850, 660);
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1){
			jp.setType(1);
		}else if(e.getSource()==btn2){
			jp.setType(2);
		}else if(e.getSource()==btn3){
			jp.setType(3);
		}else if(e.getSource()==btn4){
			jp.setType(4);
		}else if(e.getSource()==btn5){
			jp.setType(5);
		}else if(e.getSource()==btn6){
			jp.setType(6);
		}else if(e.getSource()==btn7){
			jp.setType(7);
		}else if(e.getSource()==btn8){
			JColorChooser jc = new JColorChooser();
			selectColor = jc.showDialog(this, "调色板",selectColor);
		   // selectColor=newColor;
		    btn8.setBackground(selectColor);
		    //jp.setType(1);
		}else if(e.getSource()==btn9){
			jp.setType(9);
		}else if(e.getSource()==btn10){
			jp.setType(10);
		}else if(e.getSource()==btn11){
			jp.setSize(2);
		}else if(e.getSource()==btn12){
			jp.setSize(4);
		}else if(e.getSource()==btn13){
			jp.setSize(6);
		}else if(e.getSource()==btn14){
			jp.setSize(8);
		}else if(e.getSource()==exit){
			// 获取事件源
			int result = JOptionPane.showConfirmDialog(this, "將更改保存到 未命名？", "画图",
					JOptionPane.YES_NO_OPTION);
			switch (result) {
			case JOptionPane.YES_OPTION:
				JFileChooser jf = new JFileChooser();
				jf.showSaveDialog(this);
				jp.save(jf.getSelectedFile());
				break;
			case JOptionPane.NO_OPTION:
				System.exit(0);
				break;
			}					
		}else if(e.getSource()==openfile){
			FileDialog FD1 = new FileDialog(this, "打开", FileDialog.LOAD);
			FD1.setVisible(true);
			if (FD1.getFile() != null){
				
			}
			/*JFileChooser jf = new JFileChooser();
			jf.showOpenDialog(this);
			if(jf.getSelectedFile() != null){
				jp.openfile(jf.getSelectedFile());
			}else{
				jp.openfile(null);
			}*/
		}else if(e.getSource()==save || e.getSource()==saveas){
			JFileChooser jf = new JFileChooser();
			jf.showSaveDialog(this);
			jp.save(jf.getSelectedFile());
		}else if(e.getSource()==coloredit){
			Color newColor = JColorChooser.showDialog(this, "调色板",jp.getBackground());
			if (jp.getBackground() != null) {
				jp.setBackground(newColor);
			}
		}else if(e.getSource()==about){
			JDialog D = new JDialog(this, "关于画图");//新的完整的窗口
			((JComponent) D.getContentPane()).setOpaque(false);//获取面板并把背景设置为透明 这样就不会遮住后面的背景 
			ImageIcon img = new ImageIcon("D:\\画图程序\\about.jpg"); 
			JLabel background = new JLabel(img);
			D.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE)); //把JLabel(background)添加到JDialog容器中的指定位置
			background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight()); 
			D.setBounds(400, 250, img.getIconWidth(), img.getIconHeight());
			D.setResizable(false);
			D.setVisible(true);
		}else if(e.getSource()==help){
			try {
				//Runtime.getRuntime().exec("C:\\Program Files\\Kingsoft\\WPS Office School\\office6\\wps.exe c:\\help.doc");
				Runtime.getRuntime().exec("cmd.exe /c start D:\\画图程序\\help.chm");//打开帮助文档
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "无法打开文档");
			}
		}
	}
	
	public static void main(String[] args){
		new MyPaint2();
	}
	
}
