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
	Composite[] layouts;
	int crtActive;
	StackLayout stack;
	
	private static MainMenu instance;
	
	public static MainMenu getInstance() {
		if(instance == null) {
			instance = new MainMenu();
		}
		return instance;
	}
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainMenu window = MainMenu.getInstance();
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
	
	void changeLayout(int winNumber) {
		layouts[crtActive].setVisible(!layouts[crtActive].isVisible());
		stack.topControl = layouts[winNumber];
		crtActive = winNumber;
		shell.layout();
	}
	
	
	
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		stack = new StackLayout();
		shell.setLayout(stack);
		
		boolean response[] = new boolean[1];
		
		layouts = new Composite[10];
		
		OtherWindow otherWindow = new OtherWindow(shell, SWT.NONE);
		layouts[0] = otherWindow;
		
		
		var x = new Composite(shell, SWT.NONE);
		layouts[1] = x;
		crtActive = 0;
		
		Button btnChangeWindow = new Button(x, SWT.NONE);
		btnChangeWindow.setBounds(325, 226, 98, 25);
		btnChangeWindow.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				changeLayout(0);
			}
		});
		btnChangeWindow.setText("Change window");
		
		Button btnNewButton = new Button(x, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//response[0] = (boolean) new Confirmation(shell, SWT.NONE).open();
				System.out.println(response[0]);
			}
		});
		btnNewButton.setBounds(111, 81, 75, 25);
		btnNewButton.setText("New Button");
		
		Button btnRadioButton = new Button(x, SWT.RADIO);
		btnRadioButton.setBounds(96, 125, 90, 16);
		btnRadioButton.setText("Radio Button");
		
		Button btnOpen = new Button(x, SWT.NONE);
		btnOpen.setLocation(10, 226);
		btnOpen.setSize(75, 25);
		btnOpen.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new ThirdWindow().open();
			}
		});
		btnOpen.setText("open");
		
		stack.topControl = layouts[1];
	}
}
