package trashcash;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class TrashCashLoginFrame extends JFrame implements ActionListener{
	
	final String registeredUser = "user123";
	final String registeredPassword = "123456";
	final int FRAME_SIZE_WIDTH = 833;
	final int FRAME_SIZE_HEIGHT = 653;
	private String usernameVar = " ", passwordVar = " ";	
	
	// Main Panels
	JPanel loginPanelLeft = new JPanel();
	JPanel loginPanelRight = new JPanel();
	
	//ImageIcon
	ImageIcon TrashCashlogo = new ImageIcon("TrashCashLogo.png");
	//ImageIcon Background = new ImageIcon("trashCashBG.jpg");
	int desiredWidth = 900; // Set your desired width
	int desiredHeight = 660; // Set your desired height
	ImageIcon Background = resizeImageIcon("trashCashBG.jpg", desiredWidth, desiredHeight);
      
   //Resize the background image
   public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage(); // transform it
        Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // scale it the smooth way
        return new ImageIcon(newImage); // transform it back
    }
	//JLabel for Right Panel
	JLabel logo = new JLabel();
	JLabel BackgroundPic = new JLabel();
	JLabel usernameLabel = new JLabel("USERNAME");
	JLabel passwordLabel = new JLabel("PASSWORD");
	JLabel registerHere = new JLabel("New Account? Register ");
	Border empty = new EmptyBorder(0, 0, 0, 0);
	

	//JLabel for Left Panel
	JLabel title = new JLabel("TrashCash");
	JLabel shadowTitle = new JLabel("TrashCash");
	JLabel logo2 = new JLabel();
	JLabel quote = new JLabel();

	JButton loginButton = new RoundJButton("Login");
	
	JTextField username = new RoundJTextField(15); // Sets the username input border to roundish in the RoundJTextField class
	JPasswordField password = new RoundJPasswordField(15); // Sets the password input border to roundish in the RoundJTextField class
	
	TrashCashLoginFrame(){
		this.setSize(FRAME_SIZE_WIDTH, FRAME_SIZE_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("TrashCash");
		this.setIconImage(TrashCashlogo.getImage());
		this.setVisible(true);	
		this.setLayout(new BorderLayout());
		this.add(leftPanel(), BorderLayout.WEST);
		this.add(rightPanel(), BorderLayout.EAST);
		this.setLocationRelativeTo(null);;
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent evt) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Program", JOptionPane.YES_OPTION);
				if(confirm == JOptionPane.YES_OPTION) {
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} else {
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
	}

	public JPanel leftPanel() {
		// Left Panel for Log-in Interface
		loginPanelLeft.setLayout(new BorderLayout());
		loginPanelLeft.setPreferredSize(new Dimension(524,626));
		loginPanelLeft.setBackground(new Color(0, 0, 0, 45));
		loginPanelLeft.add(title);
		loginPanelLeft.add(shadowTitle);
		loginPanelLeft.add(quote);
		loginPanelLeft.add(BackgroundPic);
		
		// Trash Cash Logo in the Left Panel of Log-in Interface
		logo2.setIcon(TrashCashlogo);
		logo2.setBounds(154, 45, 171, 160);

		// Main TrashCash Heading in Left Panel
		title.setFont(new Font("Segoe UI", Font.BOLD, 80));
		title.setBounds(30, 465, 387, 92);
		title.setForeground(new Color(245, 245, 245));
		shadowTitle.setFont(new Font("Segoe UI", Font.BOLD, 80));
		shadowTitle.setBounds(28, 467, 387, 92);
		shadowTitle.setForeground(new Color(35, 66, 30));
		// Quote Under Main Heading TrashCash Left panel
		quote.setText("\"Transform Waste, Earn Green: Your Trash, Your Cash!\"");
		quote.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		quote.setBounds(36, 545, 355, 50	);
		quote.setForeground(new Color(222, 213, 213));
		
		// Resize Background in left panel
		loginPanelLeft.setLayout(null);
		int backgroundX = -190;  // Set your desired X coordinate
	    int backgroundY = -45;  // Set your desired Y coordinate
	    BackgroundPic.setIcon(Background);
	    BackgroundPic.setBounds(backgroundX, backgroundY, desiredWidth, desiredHeight);
	      
	    loginPanelLeft.add(BackgroundPic);

		return loginPanelLeft;
	}
	
	// Right Panel for Log-in Interface
    public JPanel rightPanel() {
        loginPanelRight.add(logo);
        logo.setIcon(TrashCashlogo);
        logo.setBounds(110, 45, 171, 160);

        loginPanelRight.setLayout(new FlowLayout());
        loginPanelRight.setPreferredSize(new Dimension(352, 626));
        loginPanelRight.setLayout(null);

        // USERNAME LABEL
        // This sets letter spacing to our JLabel Texts, I got this from stack overflow. Feel free to utilize this code snippet
        SwingUtilities.invokeLater(() -> {
            Map<TextAttribute, Object> attributes = new HashMap<TextAttribute, Object>();
            attributes.put(TextAttribute.TRACKING, 0.25);

            usernameLabel.setFont(usernameLabel.getFont().deriveFont(attributes));
        });
        loginPanelRight.add(usernameLabel);
        usernameLabel.setBounds(83, 258, 110, 40);
        usernameLabel.setForeground(new Color(62,56,56));    // change color on user name label me 
        usernameLabel.setFont(new Font("Actor", Font.PLAIN, 12));

        // USERNAME TEXTFIELD
        loginPanelRight.add(username);
        username.setBounds(80, 290, 233, 41); // adjust spacing
        username.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        // PASSWORD LABEL
        // This sets letter spacing to our JLabel Texts, I got this from stack overflow. Feel free to utilize this code snippet
        SwingUtilities.invokeLater(() -> {
            Map<TextAttribute, Object> attributes = new HashMap<TextAttribute, Object>();
            attributes.put(TextAttribute.TRACKING, 0.25);

            passwordLabel.setFont(passwordLabel.getFont().deriveFont(attributes));
        });
        loginPanelRight.add(passwordLabel);
        passwordLabel.setBounds(83, 338, 111, 40);
        passwordLabel.setForeground(new Color(62,56,56));      // Change color on password label  me
        passwordLabel.setFont(new Font("Actor", Font.PLAIN, 12)); // change into Plain color me size it for 15

        // PASSWORD TEXTFIELD
        loginPanelRight.add(password);
        password.setBounds(80, 370, 233, 41);
        password.setFont(new Font("Segoe UI", Font.PLAIN, 15));
     // If user enters ENTER button, username and password will be stored and compares it if it's the same as the registeredUser and pass
    	// if it is then the program proceeds to output a demo main interface, else it displays invalid user/pass
        password.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent e) {
        		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
        			usernameVar = username.getText();
        			passwordVar = password.getText();
        			if(usernameVar.equals(registeredUser) && passwordVar.equals(registeredPassword)) {
        				JOptionPane.showMessageDialog(null, "Login Successful! Welcome " + usernameVar);
        			}
        			else {
        				JOptionPane.showMessageDialog(null,"Login Unsuccessful! New Account? Register now!","TrashCash", JOptionPane.ERROR_MESSAGE);
        			}
        		}
        	}
        });

        // LOGIN BUTTON
        loginPanelRight.add(loginButton);
        loginButton.setBounds(125, 450, 148, 40);
        loginButton.setBackground(new Color(25, 122, 46));
        loginButton.setForeground(new Color(245, 245, 245));
        loginButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);;
        
     // New Account? Register here
        JLabel greenHere = new JLabel("here");
        greenHere.setForeground(new Color(61,189,112));
        greenHere.setBounds(268,540,40,40);
        greenHere.setFont(new Font("Segoe UI", Font.BOLD, 15));
        loginPanelRight.add(registerHere);
        loginPanelRight.add(greenHere);
        registerHere.setBounds(110, 460, 200, 200);
        registerHere.setForeground(new Color(62,56,56));
        registerHere.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        greenHere.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		if(e.getSource() == greenHere) {
        			JOptionPane.showMessageDialog(null, "Register User Interface", "TrashCash", JOptionPane.QUESTION_MESSAGE);
        		}
        	}
        		// if user hovers over highlighted "here" button it will change cursor to hand
        	 @Override
             public void mouseEntered(MouseEvent e) {
                 setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
             }
        	// if user stops hover over highlighted "here" button it will change hand cursor to default
             @Override
             public void mouseExited(MouseEvent e) {
                 setCursor(Cursor.getDefaultCursor());
             }
        });
        
        Border greenLineBorder = new LineBorder(new Color(25, 122, 46), 2, true);
        Border emptyBorder = new EmptyBorder(0, 5, 0, 5); // adjust padding on up and down. >>>>>>>>>>>>>>>>>>>
        Border compoundBorder = new CompoundBorder(greenLineBorder, emptyBorder);
        username.setBorder(compoundBorder);
        password.setBorder(compoundBorder);
        
        // Add placeholder text for username field
        username.setForeground(new Color(61,189,112));
        username.setFont(new Font("Segoe UI", Font.PLAIN, 15)); // Set font size
        username.setText("Enter username");

        // Add placeholder text for password field
        password.setForeground(new Color(61,189,112));
        password.setFont(new Font("Segoe UI", Font.PLAIN, 15)); // Set font size
        password.setEchoChar((char) 0); // Set echo char to zero to show plain text
        password.setText("Enter password");
        
     // Add focus listeners to the text fields
        username.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            if (username.getText().equals("Enter username")) { // if ma click na ang field, mawala ang placeholder
                username.setText("");
                username.setForeground(Color.BLACK);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (username.getText().isEmpty()) { // If di ma click ang field, display placeholder
                username.setText("Enter username");
                username.setForeground(new Color(61,189,112)); // Color sa placeholder
            }
        }
        });
        password.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) { // If ma click na gali ang input field mawala ang placeholder
                if (password.getText().equals("Enter password")) {
                    password.setText("");
                    password.setForeground(Color.BLACK);
                    password.setEchoChar('*'); // Ang echoChar e set nato balik og '*' kay para ma encrypted ang pass sa user
                }							   // gi EchoChar(0) man nato sya pag declare sa taas para di ma encrypt and placeholder
            }

            @Override
            public void focusLost(FocusEvent e) { // If di ma click ang input field, mo display ang "Enter password" na placeholder
                if (password.getText().isEmpty()) {
                    password.setForeground(new Color(61,189,112)); // Color sa placeholder
                    password.setEchoChar((char)0);		// This sets the encrypted text of the JPasswordField to a plain/readable text
                    password.setText("Enter password");
                }
            }
        });
        return loginPanelRight; 
    }

	

	// If user clicks button, username and password will be stored and compares it if it's the same as the registeredUser and pass
	// if it is then the program proceeds to output a demo main interface, else it displays invalid user/pass
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source==loginButton) {
			usernameVar = username.getText();
			passwordVar = password.getText();
			if(usernameVar.equals(registeredUser) && passwordVar.equals(registeredPassword))
				JOptionPane.showMessageDialog(null, "Login Successful! Welcome " + usernameVar);
			else
				JOptionPane.showMessageDialog(null,"Invalid Username/Password! New Account? Register now!","TrashCash", JOptionPane.ERROR_MESSAGE);		
		}		
	}
}
