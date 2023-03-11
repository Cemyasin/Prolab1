import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmFirstProblem extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JPanel panel = new JPanel();
	firstMaze m;
//	int[][] matrix = null;
	 int[][] absMaze=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmFirstProblem frame = new frmFirstProblem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public frmFirstProblem() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1320, 756);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		m = new firstMaze();
		panel = m;
		panel.setBounds(23, 43, 784, 631);
		contentPane.add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(878, 43, 354, 28);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("URL :");
		lblNewLabel.setBounds(837, 43, 66, 28);
		contentPane.add(lblNewLabel);

		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer> mazeList = new ArrayList();	
				URL url ; 
		        BufferedReader read ; 
		        String line;
		        int arrayY=0,arrayX=0;
		        String uurl = textField.getText();
		        
		        try {
					url= new URL(uurl);
			
		          read= new BufferedReader(
				        new InputStreamReader(url.openStream()));
		        
		        
		        while ((line = read.readLine()) != null){
		        	for(int j=0; j<line.length();j++) {
//		        		System.out.println(Integer.parseInt(String.valueOf(line.charAt(j))));
		        		mazeList.add(Integer.parseInt(String.valueOf(line.charAt(j))));
		        		arrayY = line.length();
		        	}
		        	arrayX+=1;
		        }
		        
		        read.close();
		        
		        } catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		      
		        

		        
		        int[][] maze = new int[arrayX][arrayY];
		        int counter=0;
		        
		        for(int i=0; i<mazeList.size();i++) {
//		        	System.out.println(mazeList.get(i));
		        }
		        
		        for(int j=0;j<arrayX;j++) {
		    		for(int k=0;k<arrayY;k++) {
		    			maze[j][k] = mazeList.get(counter);
		    			counter++;
		    		}
		    	}
		        
		        absMaze = new int[arrayX+2][arrayY+2];
		        
		        for(int i=0;i<arrayX+2;i++) {
		        	for(int j=0;j<arrayY+2;j++) {
		        		if((i==0 || i==arrayX+1) || (j==0 || j==arrayY+1)) {
		        			absMaze[i][j] = 1;
		        		}
		        	}
		        }
		        
		        for(int i=0;i<arrayX;i++) {
		        	for(int j=0;j<arrayY;j++) {
		        		absMaze[i+1][j+1] = maze[i][j];
		        	}
		        }
		        
		        for(int i=0;i<arrayX+2;i++) {
		        	for(int j=0; j<arrayY+2;j++) {
		        		System.out.print(absMaze[i][j]);
		        	}
		        	System.out.println();
		        }


			}

		});
		btnGo.setBounds(1242, 46, 52, 23);
		contentPane.add(btnGo);

		JButton btnNewButton = new JButton("Generate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int width = absMaze[0].length;
				int height = absMaze.length;
				m.load(width, height, absMaze);
			}
		});
		btnNewButton.setBounds(878, 91, 101, 33);
		contentPane.add(btnNewButton);

		JButton btnStart = new JButton("Solve");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnStart.setBounds(878, 149, 101, 33);
		contentPane.add(btnStart);

		JButton btnShowPath = new JButton("Show Path");
		btnShowPath.setBounds(878, 211, 101, 33);
		contentPane.add(btnShowPath);

		btnShowPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

	}
}