package ui;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;

public class Confirmation extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text txtYouAgreeTo;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public Confirmation(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(450, 300);
		shell.setText(getText());
		
		Button btnYes = new Button(shell, SWT.NONE);
		btnYes.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				result = true;
				shell.close();
			}
		});
		btnYes.setBounds(65, 193, 75, 25);
		btnYes.setText("Yes");
		
		Button btnNo = new Button(shell, SWT.NONE);
		btnNo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				result = false;
				shell.close();
			}
		});
		btnNo.setBounds(288, 193, 75, 25);
		btnNo.setText("No");
		
		txtYouAgreeTo = new Text(shell, SWT.BORDER);
		txtYouAgreeTo.setText("You agree to save files on your computer?");
		txtYouAgreeTo.setBounds(65, 35, 298, 99);

	}
}
