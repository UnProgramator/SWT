package ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MainMenu {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainMenu window = new MainMenu();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	void changeLayout(int WinNumber) {
		
	}
	
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		var stack = new StackLayout();
		shell.setLayout(stack);
		
		Composite composite_1 = new OtherWindow(shell, SWT.NONE);
		
		Composite mm = new Composite(shell, SWT.NONE);
		//mm.setLayout(null);
		
		Button btnChangeWindow = new Button(mm, SWT.NONE);
		btnChangeWindow.setBounds(325, 226, 98, 25);
		btnChangeWindow.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mm.setVisible(!mm.isVisible());
				stack.topControl = composite_1;
				shell.layout();
			}
		});
		btnChangeWindow.setText("Change window");
		
		Button btnNewButton = new Button(mm, SWT.NONE);
		btnNewButton.setBounds(111, 81, 75, 25);
		btnNewButton.setText("New Button");
		
		Button btnRadioButton = new Button(mm, SWT.RADIO);
		btnRadioButton.setBounds(96, 125, 90, 16);
		btnRadioButton.setText("Radio Button");
		
		stack.topControl = mm;
	}
}
