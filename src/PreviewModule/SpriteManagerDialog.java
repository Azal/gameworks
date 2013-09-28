package PreviewModule;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SpriteManagerDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JFrame owner;
	
	public SpriteManagerDialog(JFrame owner) {
		this.owner = owner;
		owner.setEnabled(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			List list = new List();
			list.setBounds(314, 25, 110, 161);
			contentPanel.add(list);
		}
		
		Button importSpriteBtn = new Button("Import");
		importSpriteBtn.setBounds(231, 10, 70, 22);
		contentPanel.add(importSpriteBtn);
		
		Panel panel = new Panel();
		panel.setBounds(10, 10, 192, 208);
		contentPanel.add(panel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						enableOwnerAndClose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						enableOwnerAndClose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void enableOwnerAndClose(){
		owner.setEnabled(true);
		this.dispose();
	}
}
