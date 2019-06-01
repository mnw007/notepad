import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.regex.*;
import java.util.*;
class Notepad implements ActionListener
{
	JFrame fr;
	JMenuBar bar;
	JMenu m1,m2,m3,m4,m5;
	static JTextArea tf;
	JMenuItem f1,f2,f3,f4,f5,f6,f7,e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,fm1,fm2,fm3,v1,h1,h2;
	JScrollPane sp1;
	JToolBar tb;
	JFrame fontFr;
	JButton fontB1,fontB2;
	JDialog fontd;
	JComboBox fontCb1,fontCb2,fontCb3;
	String font[]={"Times New Roman","jokerman","verdana","Monotype Corsiva","Old English Text MT"};
	String style[]={"Regular","Bold","Italic"};
	String size[]={"24","16","18","20","22","26"};
	String str1,str2,str3,str4,str5,str7=" ",str8="",str9="",str6="";
	int len,len1;
	String months[]={
        "Jan","Feb","Mar","Apr",
        "May","Jun","Jul","Aug",
        "Sep","Oct","Nov","Dec"};
	GregorianCalendar gcalendar;
	Notepad()
	{ 
	fr=new JFrame("Notepad");
	fr.setSize(800,500);
	tf=new JTextArea();
	fr.add(tf);
	fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//tf.setBounds(0,0,fr.getWidth(),fr.getHeight());
	 sp1=new JScrollPane(tf);
	fr.getContentPane().add(sp1);
	 tb=new JToolBar();
	bar=new JMenuBar();
	fr.setJMenuBar(bar);
	m1=new JMenu("File");
 	m2=new JMenu("Edit");
	m3=new JMenu("Format");
 	m4=new JMenu("View"); 
 	m5=new JMenu("Help");
	
	bar.add(m1);
	bar.add(m2);
	bar.add(m3);
	bar.add(m4);
	bar.add(m5);
	f1=new JMenuItem("New");
	f2=new JMenuItem("Open");
	f3=new JMenuItem("Save");
	f4=new JMenuItem("Save As");
	f5=new JMenuItem("Page Setup...");
	f6=new JMenuItem("Print...");
	f7=new JMenuItem("Exit");
	//e1=new JMenuItem("Undo");
	e2=new JMenuItem("Cut");
	e3=new JMenuItem("Copy");
	e4=new JMenuItem("Paste");
	e5=new JMenuItem("Delete");
	e6=new JMenuItem("Find...");
	e7=new JMenuItem("Find Next");
	e8=new JMenuItem("Replace...");
	//e9=new JMenuItem("Go to");
	e10=new JMenuItem("Select All");
	e11=new JMenuItem("Time/Date");
	fm1=new JMenuItem("Word Wrap");
	fm3=new JMenuItem("Notepad Wrap");
	fm2=new JMenuItem("Font...");
	v1=new JMenuItem("Status Bar");
	h1=new JMenuItem("View Help");
	h2=new JMenuItem("About Notepad");
	m1.add(f1);
	m1.add(f2);
	m1.add(f3);
	m1.add(f4);
	m1.add(new JSeparator());
	m1.add(f5);
	m1.add(f6);
	m1.add(new JSeparator());
	m1.add(f7);
	//m2.add(e1);
	//m2.add(new JSeparator());
	m2.add(e2);
	m2.add(e3);
	m2.add(e4);
	m2.add(e5);
	m2.add(new JSeparator());
	m2.add(e6);
	m2.add(e7);
	m2.add(e8);
	//m2.add(e9);
	m2.add(new JSeparator());
	m2.add(e10);
	m2.add(e11);
	m3.add(fm1);
	m3.add(fm2);
	m3.add(fm3);
	m4.add(v1);
	m5.add(h1);
	m5.add(h2);
	KeyStroke ks1=KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_MASK);
	f1.setAccelerator(ks1);
	KeyStroke ks2=KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_MASK);
	f2.setAccelerator(ks2);
	KeyStroke ks3=KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_MASK);
	f3.setAccelerator(ks3);
	KeyStroke ks4=KeyStroke.getKeyStroke(KeyEvent.VK_F4,KeyEvent.ALT_MASK);
	f7.setAccelerator(ks4);
	 
	KeyStroke ks5=KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_MASK);
	e10.setAccelerator(ks5);
	KeyStroke ks6=KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_MASK);
	e2.setAccelerator(ks6);
	KeyStroke ks7=KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_MASK);
	e3.setAccelerator(ks7);
	KeyStroke ks8=KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_MASK);
	e4.setAccelerator(ks8);
	KeyStroke ks9=KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,KeyEvent.CTRL_MASK);
	e5.setAccelerator(ks9);
	KeyStroke ks10=KeyStroke.getKeyStroke(KeyEvent.VK_F,KeyEvent.CTRL_MASK);
	e6.setAccelerator(ks10);
	KeyStroke ks11=KeyStroke.getKeyStroke(KeyEvent.VK_F,KeyEvent.ALT_MASK);
	fm2.setAccelerator(ks11);
	f1.addActionListener(this);
	f2.addActionListener(this);
 	f3.addActionListener(this);
	f4.addActionListener(this);
	
	f5.addActionListener(this);
	f7.addActionListener(this);
	//e1.addActionListener(this);
	e2.addActionListener(this);
	e3.addActionListener(this);
	e4.addActionListener(this);
	e5.addActionListener(this);
	e6.addActionListener(this);
	e7.addActionListener(this);
	e8.addActionListener(this);
	//e9.addActionListener(this);
	e10.addActionListener(this);
	e11.addActionListener(this);
	fm1.addActionListener(this);
	fm2.addActionListener(this);
	fm3.addActionListener(this);
	v1.addActionListener(this);
	h1.addActionListener(this);
	h2.addActionListener(this);
	
	//fontB2.addActionListener(this);

	fr.setVisible(true);
	}	
		public void actionPerformed(ActionEvent e)
		{
		if(e.getSource()==f1)
		{
			 fr.setTitle("Untitled-Notepad");
			tf.setText(" ");
		}
try
{	
	
		if(e.getSource()==f3||e.getSource()==f4)
		{
			
			 FileDialog dialog1=new FileDialog(fr,"Save As",FileDialog.SAVE);
        			dialog1.setVisible(true);

			 str7=dialog1.getDirectory();
 		      	 str8=dialog1.getFile();
 	       		 str9=str7+str8;
       	 		str6=tf.getText();
         			 len1=str6.length();
	        		byte buf[]=str6.getBytes();

	       		File f1=new File(str9);
      			FileOutputStream fobj1=new FileOutputStream(f1);
    	  	  	for(int k=0;k<len1;k++)
      			{
       				 fobj1.write(buf[k]);
      	 		}
        			fobj1.close(); fr.setTitle(str8);
			 
         		}

      		 
		
}
catch(Exception eb)
{}	
try
{	if(e.getSource()==f2)
		{	
			 str4=" ";
     			   FileDialog dialog=new FileDialog(fr,"Open");
    			    dialog.setVisible(true);

       			 str1=dialog.getDirectory();
      			  str2=dialog.getFile();
        			str3=str1+str2;

        			File f=new File(str3);
        			FileInputStream fobj=new FileInputStream(f);
        			len=(int)f.length();
        			for(int j=0;j<len;j++)
        			{
          				char str5=(char)fobj.read();
            				str4=str4 + str5;

        			}

        			tf.setText(str4); 
			fr.setTitle(str2);
		}
}
catch(Exception eb)
{}


		if(e.getSource()==f7)
		fr.dispose();
		if(e.getSource()==e2)
			tf.cut();
		if(e.getSource()==e3)
			tf.copy();
		if(e.getSource()==e4)
			tf.paste();
		if(e.getSource()==e5)
		{	String wholeText=tf.getText();
			String text=tf.getSelectedText();
			int len=text.length();
			int ind=wholeText.indexOf(text);
			tf.replaceRange(" ",ind,ind+len);
		}
		if(e.getSource()==fm1)
		{
			tf.setLineWrap(true);
		}
		if(e.getSource()==fm3)
		{
			tf.setLineWrap(false);
		}
		if(e.getSource()==fm2)
		{
			fontFr=new JFrame("Font");
			fontFr.setSize(500,500);
			fontFr.setLayout(null);
			fontCb1=new JComboBox(font);
			fontCb1.setBounds(20,20,100,30);
			fontFr.add(fontCb1);	

			fontCb2=new JComboBox(style);
			fontCb2.setBounds(150,20,100,30);
			fontFr.add(fontCb2);

			fontCb3=new JComboBox(size);
			fontCb3.setBounds(280,20,100,30);
			fontFr.add(fontCb3);
			
			fontB1=new JButton("OK");
			fontB1.setBounds(50,200,100,30);
			fontFr.add(fontB1);
			fontB1.addActionListener(this);
			fontFr.setVisible(true);	
			fontFr.setResizable(false);
		}

		if(e.getSource()==e6||e.getSource()==e7)
		{
		 new Find();                 	
		}
		if(e.getSource()==e8)
		{
			new Replace();
		}
		if(e.getSource()==e10)
		{
					String str=tf.getText();		
					len=str.length();
					 tf.select(0, len);	 
		}
		if(e.getSource()==e11)
        		{
			tf.setFont(new Font("Monotype Corsiva",Font.ITALIC,30) );
    			gcalendar=new GregorianCalendar();
        			String h=String.valueOf(gcalendar.get(Calendar.HOUR));
        			String m=String.valueOf(gcalendar.get(Calendar.MINUTE));
        			String s=String.valueOf(gcalendar.get(Calendar.SECOND));
        			String date=String.valueOf(gcalendar.get(Calendar.DATE));
        			String mon=months[gcalendar.get(Calendar.MONTH)];
			//String mon=String.valueOf(gcalendar.get(Calendar.MONTH));
        			String year=String.valueOf(gcalendar.get(Calendar.YEAR));
        			String hms="Time :   "+h+":"+m+":"+s+"  	     Date"+"  :  "+date+" - "+mon+" - "+year;
        			int loc=tf.getCaretPosition();
        			tf.insert(hms,loc);
	
		/*
		Date d=new Date();
		//String d1=(String)d;
		//tf.setText(d);
		System.out.println("Today's Date is :\n"+d);
		*/
        }
		if(e.getSource()==fontB1)
		{
			fontFr.dispose();
			String font1=(String)fontCb1.getSelectedItem();
 
			String style1=(String)fontCb2.getSelectedItem();
			String siz=(String)fontCb3.getSelectedItem();	
			int size1=Integer.parseInt(siz);
			if(style1=="Bold")
			{
				Font f=new Font(font1,Font.BOLD,size1);
				tf.setFont(f);
			}
			else if(style1=="Italic")
			{
				Font f=new Font(font1,Font.ITALIC,size1);
				tf.setFont(f);
			}
			else
			{
				Font f=new Font(font1,Font.PLAIN,size1);
				tf.setFont(f);
			}
		}
		if(e.getSource()==h1)
		{
			JOptionPane.showMessageDialog(fr,"Mail your query to:\nmnwcse@gmail.com\n","HELP",JOptionPane.INFORMATION_MESSAGE); 
			
		}
		if(e.getSource()==h2)
		{
			new AboutNotepad();
			
		}	
	}

		public static void main(String[] a) 
		{
		new Notepad();
		}
}
 
class AboutNotepad implements ActionListener
{
JFrame fr;
JPanel p1,p2,p3;
JLabel lb1,lb2,lb3;
JTextArea ar;
JButton b1;
AboutNotepad()
{
fr=new JFrame("About Nptepad");
fr.setSize(500,500);
fr.setLayout(null);
p1=new JPanel();
p1.setBounds(100,-10,300,100);
//p1.setLayout(null);
p2=new JPanel();
p2.setBounds(0,80,480,380);
lb2=new JLabel(new ImageIcon("n1.png"));
lb2.setBounds(5,0,60,60);
ar=new JTextArea("This is a Notepad developed in Java.");
ar.setBounds(67,10,400,220);
ar.setEditable(false);
ar.setBackground(Color.cyan);
 b1=new JButton("OK");
b1.setBounds(320,300,90,30);
p2.add(lb2);
p2.add(ar);
p2.add(b1);
p2.setLayout(null);
//p2.setBackground(Color.red);
fr.add(p1);
fr.add(p2);

lb1=new JLabel(new ImageIcon("n.png"));
lb1.setBounds(50,0,400,70);
p1.add(lb1);
b1.addActionListener(this);
fr.setVisible(true);
}
public void actionPerformed(ActionEvent e)
{
fr.dispose();
}
}

class Find implements ActionListener
{
	JFrame fr;
	JTextField tf1;
	JButton b1,b2;
	JLabel lb1;
	int len;
static int index;
	Find()
	{
			fr=new JFrame("Find");
			fr.setSize(350,175);
			fr.setLayout(null);
			lb1=new JLabel("Find what");
			lb1.setBounds(10,30,90,20);
			tf1=new JTextField();
			tf1.setBounds(90,30,130,20);
			b1=new JButton("Find Next");
			b1.setBounds(235,30,95,20);
			b2=new JButton("Cancel");
			b2.setBounds(240,80,80,25);
			b1.addActionListener(this);
			b2.addActionListener(this);
			fr.add(lb1);
			fr.add(tf1);
			fr.add(b1);
			fr.add(b2);
			fr.setVisible(true); fr.setResizable(false);
	}
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource()==b1)
				{
					String str=tf1.getText();
					String str1=Notepad.tf.getText();
				/*	Pattern pat = Pattern.compile(str);
				
					Matcher mat = pat.matcher(str1);
					//System.out.println("Looking for  "+str);
					if(mat.find())
					{
					//System.out.println("test found at index " +mat.start());
					 lb2.setText(str+" Found at index "+mat.start());
					Notepad.tf.select(3,6);
					}
					else
				 	 lb2.setText(str+" not Found");
				*/  
				
			
				index=str1.indexOf(str,index+len);
				len=str.length();
				 if(index!=-1)
				Notepad.tf.select(index,index+len);
				else
				JOptionPane.showMessageDialog(fr,"Can not Found   \""+str+"\"","Find",JOptionPane.INFORMATION_MESSAGE); 
				
 
			}
				if(e.getSource()==b2)
				{
				fr.dispose();
				}
			}

	
}

class Replace implements ActionListener
{
	JFrame fr;
	JTextField tf1,tf2;
	JButton b1,b2,b3,b4;
	JLabel lb1,lb2;
	int len;
static int index;
	Replace()
	{
			fr=new JFrame("Replace");
			fr.setSize(380,200);
			fr.setLayout(null);
			lb1=new JLabel("Find what :");
			lb1.setBounds(10,20,90,20);
			lb2=new JLabel("Replace with");
			lb2.setBounds(10,50,100,20);
			tf1=new JTextField();
			tf1.setBounds(90,20,130,20);
			tf2=new JTextField();
			tf2.setBounds(90,50,130,20);
			b1=new JButton("Find");
			b1.setBounds(240,20,100,20);
			b2=new JButton("Replace");
			b2.setBounds(240,50,100,20);
			//b3=new JButton("Replace All");
			//b3.setBounds(240,80,100,20);
			b4=new JButton("Cancel");
			b4.setBounds(250,120,80,23);
			b1.addActionListener(this);
			b2.addActionListener(this);
			//b3.addActionListener(this);
			b4.addActionListener(this);
			fr.add(lb1);
			fr.add(tf1);
			fr.add(tf2);
			fr.add(b1);
			fr.add(b2);
			//fr.add(b3);
			fr.add(b4);
			fr.add(lb2);
			fr.setResizable(false);
			fr.setVisible(true); 
	}
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource()==b1)
				{
					 
					String str=tf1.getText();
					String str1=Notepad.tf.getText();
					index=str1.indexOf(str,index+len);			
					len=str.length();
					if(index!=-1)
						Notepad.tf.select(index,index+len);
					else
						JOptionPane.showMessageDialog(fr,"Can not Found   \""+str+"\"","Replace",JOptionPane.INFORMATION_MESSAGE); 
						
				}
				if(e.getSource()==b2)
				{
					String str=tf2.getText();
					Notepad.tf.replaceRange(str,index,index+len);
//System.out.println(str);
				}
				if(e.getSource()==b4)
				{
				fr.dispose();
				}
			}

	
}