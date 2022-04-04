package ui;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class OtherWindow extends Composite {
	private Text txtThisIsA;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public OtherWindow(Composite parent, int style) {
		super(parent, style);
		
		Button btnClose = new Button(this, SWT.NONE);
		btnClose.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MainMenu.getInstance().changeLayout(1);
			}
		});
		btnClose.setBounds(303, 196, 75, 25);
		btnClose.setText("Close");
		
		txtThisIsA = new Text(this, SWT.BORDER);
		txtThisIsA.setText("This is a test window\r\nTreat as so");
		txtThisIsA.setBounds(76, 40, 254, 134);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
