package PreviewModule;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
-Class description goes here.-
	-Reference to external code-
*
*	@version  0.1
@created_by @group1/fjsandov
@update_log
	23/09/2013 - @group8/maxfindel
	dd/mm/yyyy - @groupX/author[,author2,...]          
*/

/**  
main documentation comment */

public class CharacterEditionFrame extends JFrame {
	CharacterEditionFrame characterEditionFrame;
	
	public CharacterEditionFrame() {
		characterEditionFrame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		
		JButton loadSpriteBtn = new JButton("Load Sprite");
		loadSpriteBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SpriteManagerDialog spriteManager = new SpriteManagerDialog(characterEditionFrame);			
				spriteManager.setVisible(true);
			}
		});
		loadSpriteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton saveBtn = new JButton("Save");
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_2 = new JButton("New button");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		
		JButton button = new JButton("New button");
		
		JButton button_1 = new JButton("New button");
		
		JButton button_2 = new JButton("New button");
		
		JButton button_3 = new JButton("New button");
		
		JButton button_4 = new JButton("New button");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(button_1)
							.addGap(15))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(loadSpriteBtn)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
							.addGap(70)))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(button_2)
							.addGap(34)
							.addComponent(btnNewButton_2)
							.addGap(167))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(71)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(button)
								.addComponent(saveBtn))
							.addContainerGap(231, Short.MAX_VALUE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(115)
					.addComponent(button_4)
					.addGap(75)
					.addComponent(button_3)
					.addContainerGap(327, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(47, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button_3)
							.addGap(31))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button_4)
							.addGap(18)))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(61)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_2)
								.addComponent(button_2))
							.addGap(63)
							.addComponent(saveBtn))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(loadSpriteBtn)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		getContentPane().setLayout(groupLayout);
	}
}
