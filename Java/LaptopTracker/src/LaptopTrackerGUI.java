import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JToolBar;


public class LaptopTrackerGUI {
//static String laptopSStrings[]= null;
	static JFrame mainWindow = new JFrame("LaptopTracker");
	/**
	 * @param args filename
	 */
	public static void main(String[] args) {
Cart laptopCart = new Cart();

		//TODO if loaded from file load laptops and people here
		
setupWindowParameters();

addComponentsToForm(laptopCart);

mainWindow.setVisible(true);
	}
	private static void addComponentsToForm(Cart lcart) {
		//adding stuff to form
		Container contentPane = mainWindow.getContentPane();
		
		
		addLeftFormComponents(contentPane,lcart);
		
		addRightFormComponents(contentPane,lcart);
		
		addMenu(contentPane,lcart);
	}
	private static void addMenu(Container contentPane, final Cart lcart) {
		JToolBar menus = new JToolBar();
			menus.setFloatable(false);
		JButton bSave = new JButton("Save");
		bSave.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				FileDialog saveDialog = new FileDialog(new Frame(),"Save",FileDialog.SAVE);
				saveDialog.setVisible(true);
				
				if (saveDialog.getFile() != null){
					if (!saveDialog.getFile().contains(".cart")){
						saveDialog.setFile(saveDialog.getFile() + ".cart");
					}
					
					File fileToSaveTo = new File(saveDialog.getDirectory()  + saveDialog.getFile());
				
				try {
					BufferedWriter stringWriter =new BufferedWriter(new FileWriter(fileToSaveTo));
					
					stringWriter.write(lcart.toString());
					stringWriter.flush();
				} catch (IOException e) {

					e.printStackTrace();
				}
				}
				
				 
				
				arg0.consume();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			
				
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
			
		});
	
		JButton bLoad = new JButton("Load");
		bLoad.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				arg0.consume();
				FileDialog loadDialog = new FileDialog(new JFrame(),"Load",FileDialog.LOAD);
				loadDialog.setVisible(true);
				
				if (loadDialog.getFile() != null){
					String filePath = loadDialog.getDirectory() + loadDialog.getFile();
					 try {
						BufferedReader readFile = new BufferedReader(new FileReader(filePath));
						try {
							String file = readFile.readLine();
							lcart.AssembleFromString(file);
							readFile.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}

					
					
					
					
					
					
					
					
					
					
					
					
					
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			
				
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
		});
		
		JButton bAddLap = new JButton("New Laptop");
		bAddLap.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO write as a form
				
				 String laptopNumber = JOptionPane.showInputDialog(null, "What is the Laptops Number");
				 String laptopBrand = JOptionPane.showInputDialog(null,"What is the Laptops Brand");
				 Laptop holderLaptop = new Laptop();
				 holderLaptop.setLaptopID(laptopNumber);
				 holderLaptop.setLaptopBrand(laptopBrand);
				 lcart.addLaptop(holderLaptop);
				// UpdateJList(lcart);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
	@Override
			public void mouseExited(MouseEvent e) {
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
		});
			menus.add(bSave);
			menus.add(bLoad);
			menus.add(bAddLap);
		contentPane.add(menus,BorderLayout.NORTH);
	}
	private static void addRightFormComponents(Container contentPane, Cart lcart) {
		JPanel rightForm = new JPanel();
		
		JRadioButton LLaptops = new JRadioButton();
		
		rightForm.add(LLaptops,BorderLayout.CENTER);
		
		contentPane.add(rightForm,BorderLayout.CENTER);
	}
	private static void addLeftFormComponents(Container contentPane, Cart lcart) {
		JPanel leftForm = new JPanel();
		leftForm.setLayout(new BoxLayout(leftForm, BoxLayout.Y_AXIS));
		
		JButton bSignIn = new JButton("Sign In");
		bSignIn.setAlignmentX(Component.LEFT_ALIGNMENT);
		bSignIn.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JButton bSignOut = new JButton("Sign Out");
		bSignOut.setAlignmentX(Component.LEFT_ALIGNMENT);
		bSignOut.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		JLabel LStudentName = new JLabel("Student Name");
		LStudentName.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JComboBox CStudentNames = new JComboBox();
		CStudentNames.setEditable(true);
		CStudentNames.setAlignmentX(Component.LEFT_ALIGNMENT);

		//TODO add load student names
		
		JLabel LStudentID = new JLabel("Student ID");
		LStudentID.setAlignmentX(Component.LEFT_ALIGNMENT);

		JTextArea TStudentID = new JTextArea();
				//TODO add auto fill on student ID
		TStudentID.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		leftForm.add(bSignIn);
		leftForm.add(bSignOut);
		leftForm.add(LStudentName);
		leftForm.add(CStudentNames);
		leftForm.add(LStudentID);
		leftForm.add(TStudentID);
		contentPane.add(leftForm,BorderLayout.WEST);
	}
	private static void setupWindowParameters() {
		//Toolkit kit = mainWindow.getToolkit();
		//Sets the JFrames Size and State
		mainWindow.setSize(100,200);
		mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		 //Moves the frame to the top left hand corner of the screen
		mainWindow.setLocation(0,0);
	}
private static void UpdateJList(Cart lcart){

	}
	
}

