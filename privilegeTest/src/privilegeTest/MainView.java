package privilegeTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.SWTObservables;

public class MainView {
	private MainPresenter presenter = new MainPresenter();
	Map<Integer, Text> textMap=new HashMap<Integer, Text>();
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;
	private Text text_10;
	private Text text_11;
	private Text text_12;
	private Text text_13;
	private Text text_14;
	private Text text_15;
	private Text text_16;
	private Text text_17;
	private Text text_18;
	private Text text_19;
	private Text text_20;
	private Text text_21;
	private Text text_22;
	private Text text_23;
	private Text text_24;
	private Text text_25;
	private Text text_26;
	private Text text_27;
	private Text text_28;
	private Text text_29;
	private Text text_30;
	private Text text_31;
	private Text text_32;
	private Button button_40;
	private Button button_43;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.open();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		presenter.go();
		shell = new Shell();
		shell.setSize(745, 684);
		shell.setText("\u4E1C\u9646\u6743\u9650\u6D4B\u8BD5");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		Group group_2 = new Group(composite, SWT.NONE);
		GridData gd_group_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_group_2.exclude = true;
		group_2.setLayoutData(gd_group_2);

		Group group = new Group(composite, SWT.NONE);
		group.setText("\u521D\u59CB\u5316\u5361\u7247");
		group.setLayout(new GridLayout(4, false));
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));

		Label lblNewLabel = new Label(group, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("\u5361\u7247");

		text_20 = new Text(group, SWT.BORDER);
		text_20.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		Button btnNewButton_1 = new Button(group, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				try {
					Integer integer = Integer.parseInt(text_20.getText());
					presenter.initCard(integer.intValue());
				} catch (Exception e) {

				}

			}
		});
		btnNewButton_1.setText("\u521D\u59CB\u5316");

		Button button_41 = new Button(group, SWT.NONE);
		button_41.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.clearCard();
			}
		});
		button_41.setText("\u6E05\u9664");

		Composite composite_2 = new Composite(composite, SWT.NONE);
		composite_2.setLayout(new GridLayout(2, false));
		GridData gd_composite_2 = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_composite_2.heightHint = 443;
		composite_2.setLayoutData(gd_composite_2);

		Composite composite_4 = new Composite(composite_2, SWT.NONE);
		composite_4.setLayout(new GridLayout(1, false));
		GridData gd_composite_4 = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_composite_4.heightHint = 448;
		composite_4.setLayoutData(gd_composite_4);

		Composite composite_1 = new Composite(composite_4, SWT.NONE);
		composite_1.setLayout(new GridLayout(9, false));
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_composite_1.heightHint = 30;
		gd_composite_1.widthHint = 117;
		composite_1.setLayoutData(gd_composite_1);

		Label label = new Label(composite_1, SWT.NONE);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label.setText("01");

		text = new Text(composite_1, SWT.BORDER);
		text.setText("192.168.1.242");
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text.widthHint = 87;
		text.setLayoutData(gd_text);

		Button button = new Button(composite_1, SWT.RADIO);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(1, 1);
			}
		});

		button.setText("\u4E0B\u8F7D");

		Button button_1 = new Button(composite_1, SWT.RADIO);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(1, 2);
			}
		});
		button_1.setText("\u5220\u9664");

		Button button_2 = new Button(composite_1, SWT.RADIO);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(1, 3);
			}
		});
		button_2.setText("\u5BF9\u6BD4");

		Button button_3 = new Button(composite_1, SWT.RADIO);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(1, 4);
			}
		});
		button_3.setText("\u521D\u59CB\u5316");
		
		Button button_44 = new Button(composite_1, SWT.RADIO);
		button_44.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				presenter.getRunMap().put(1, 5);
			}
		});
		button_44.setText("\u65E0");

		text_1 = new Text(composite_1, SWT.BORDER);
		text_1.setEnabled(false);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		text_22 = new Text(composite_1, SWT.BORDER);
		text_22.setEnabled(false);
		text_22.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		Composite composite_5 = new Composite(composite_4, SWT.NONE);
		composite_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		composite_5.setLayout(new GridLayout(9, false));

		Label label_1 = new Label(composite_5, SWT.NONE);
		label_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_1.setText("02");

		text_2 = new Text(composite_5, SWT.BORDER);
		text_2.setText("192.168.1.0");
		GridData gd_text_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_text_2.widthHint = 87;
		text_2.setLayoutData(gd_text_2);

		Button button_4 = new Button(composite_5, SWT.RADIO);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(2, 1);
			}
		});
		button_4.setText("\u4E0B\u8F7D");

		Button button_5 = new Button(composite_5, SWT.RADIO);
		button_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(2, 2);
			}
		});
		button_5.setText("\u5220\u9664");

		Button button_6 = new Button(composite_5, SWT.RADIO);
		button_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(2, 3);
			}
		});
		button_6.setText("\u5BF9\u6BD4");

		Button button_7 = new Button(composite_5, SWT.RADIO);
		button_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(2, 4);
			}
		});
		button_7.setText("\u521D\u59CB\u5316");
		
		Button button_45 = new Button(composite_5, SWT.RADIO);
		button_45.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				presenter.getRunMap().put(2, 5);
			}
		});
		button_45.setText("\u65E0");

		text_3 = new Text(composite_5, SWT.BORDER);
		text_3.setEnabled(false);
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		text_23 = new Text(composite_5, SWT.BORDER);
		text_23.setEnabled(false);
		text_23.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		Composite composite_6 = new Composite(composite_4, SWT.NONE);
		composite_6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		composite_6.setLayout(new GridLayout(9, false));

		Label label_2 = new Label(composite_6, SWT.NONE);
		label_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_2.setText("03");

		text_4 = new Text(composite_6, SWT.BORDER);
		text_4.setText("192.168.1.0");
		GridData gd_text_4 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text_4.widthHint = 87;
		text_4.setLayoutData(gd_text_4);

		Button button_8 = new Button(composite_6, SWT.RADIO);
		button_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(3, 1);
			}
		});
		button_8.setText("\u4E0B\u8F7D");

		Button button_9 = new Button(composite_6, SWT.RADIO);
		button_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(3, 2);
			}
		});
		button_9.setText("\u5220\u9664");

		Button button_10 = new Button(composite_6, SWT.RADIO);
		button_10.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(3, 3);
			}
		});
		button_10.setText("\u5BF9\u6BD4");

		Button button_11 = new Button(composite_6, SWT.RADIO);
		button_11.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(3, 4);
			}
		});
		button_11.setText("\u521D\u59CB\u5316");
		
		Button button_46 = new Button(composite_6, SWT.RADIO);
		button_46.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				presenter.getRunMap().put(3, 5);
			}
		});
		button_46.setText("\u65E0");

		text_5 = new Text(composite_6, SWT.BORDER);
		text_5.setEnabled(false);
		text_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		text_24 = new Text(composite_6, SWT.BORDER);
		text_24.setEnabled(false);
		text_24.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		Composite composite_7 = new Composite(composite_4, SWT.NONE);
		composite_7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		composite_7.setLayout(new GridLayout(9, false));

		Label label_3 = new Label(composite_7, SWT.NONE);
		label_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_3.setText("04");

		text_6 = new Text(composite_7, SWT.BORDER);
		text_6.setText("192.168.1.0");
		GridData gd_text_6 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text_6.widthHint = 87;
		text_6.setLayoutData(gd_text_6);

		Button button_12 = new Button(composite_7, SWT.RADIO);
		button_12.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(4, 1);
			}
		});
		button_12.setText("\u4E0B\u8F7D");

		Button button_13 = new Button(composite_7, SWT.RADIO);
		button_13.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(4, 2);
			}
		});
		button_13.setText("\u5220\u9664");

		Button button_14 = new Button(composite_7, SWT.RADIO);
		button_14.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(4, 3);
			}
		});
		button_14.setText("\u5BF9\u6BD4");

		Button button_15 = new Button(composite_7, SWT.RADIO);
		button_15.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(4, 4);
			}
		});
		button_15.setText("\u521D\u59CB\u5316");
		
		Button button_47 = new Button(composite_7, SWT.RADIO);
		button_47.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				presenter.getRunMap().put(4, 5);
			}
		});
		button_47.setText("\u65E0");

		text_7 = new Text(composite_7, SWT.BORDER);
		text_7.setEnabled(false);
		text_7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		text_25 = new Text(composite_7, SWT.BORDER);
		text_25.setEnabled(false);
		text_25.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		Composite composite_8 = new Composite(composite_4, SWT.NONE);
		composite_8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		composite_8.setLayout(new GridLayout(9, false));

		Label label_4 = new Label(composite_8, SWT.NONE);
		label_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_4.setText("05");

		text_8 = new Text(composite_8, SWT.BORDER);
		text_8.setText("192.168.1.0");
		GridData gd_text_8 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text_8.widthHint = 87;
		text_8.setLayoutData(gd_text_8);

		Button button_16 = new Button(composite_8, SWT.RADIO);
		button_16.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(5, 1);
			}
		});
		button_16.setText("\u4E0B\u8F7D");

		Button button_17 = new Button(composite_8, SWT.RADIO);
		button_17.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(5, 2);
			}
		});
		button_17.setText("\u5220\u9664");

		Button button_18 = new Button(composite_8, SWT.RADIO);
		button_18.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(5, 3);
			}
		});
		button_18.setText("\u5BF9\u6BD4");

		Button button_19 = new Button(composite_8, SWT.RADIO);
		button_19.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(5, 4);
			}
		});
		button_19.setText("\u521D\u59CB\u5316");
		
		Button button_48 = new Button(composite_8, SWT.RADIO);
		button_48.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				presenter.getRunMap().put(5, 5);
			}
		});
		button_48.setText("\u65E0");

		text_9 = new Text(composite_8, SWT.BORDER);
		text_9.setEnabled(false);
		text_9.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		text_26 = new Text(composite_8, SWT.BORDER);
		text_26.setEnabled(false);
		text_26.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		Composite composite_9 = new Composite(composite_4, SWT.NONE);
		composite_9.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		composite_9.setLayout(new GridLayout(9, false));

		Label label_5 = new Label(composite_9, SWT.NONE);
		label_5.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_5.setText("06");

		text_10 = new Text(composite_9, SWT.BORDER);
		text_10.setText("192.168.1.0");
		GridData gd_text_10 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text_10.widthHint = 87;
		text_10.setLayoutData(gd_text_10);

		Button button_20 = new Button(composite_9, SWT.RADIO);
		button_20.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(6, 1);
			}
		});
		button_20.setText("\u4E0B\u8F7D");

		Button button_21 = new Button(composite_9, SWT.RADIO);
		button_21.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(6, 2);
			}
		});
		button_21.setText("\u5220\u9664");

		Button button_22 = new Button(composite_9, SWT.RADIO);
		button_22.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(6, 3);
			}
		});
		button_22.setText("\u5BF9\u6BD4");

		Button button_23 = new Button(composite_9, SWT.RADIO);
		button_23.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(6, 4);
			}
		});
		button_23.setText("\u521D\u59CB\u5316");
		
		Button button_49 = new Button(composite_9, SWT.RADIO);
		button_49.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				presenter.getRunMap().put(6, 5);
			}
		});
		button_49.setText("\u65E0");

		text_11 = new Text(composite_9, SWT.BORDER);
		text_11.setEnabled(false);
		text_11.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		text_27 = new Text(composite_9, SWT.BORDER);
		text_27.setEnabled(false);
		text_27.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		Composite composite_10 = new Composite(composite_4, SWT.NONE);
		composite_10.setLayout(new GridLayout(9, false));

		Label label_6 = new Label(composite_10, SWT.NONE);
		label_6.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_6.setText("07");

		text_12 = new Text(composite_10, SWT.BORDER);
		text_12.setText("192.168.1.0");
		GridData gd_text_12 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text_12.widthHint = 87;
		text_12.setLayoutData(gd_text_12);

		Button button_24 = new Button(composite_10, SWT.RADIO);
		button_24.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(7, 1);
			}
		});
		button_24.setText("\u4E0B\u8F7D");

		Button button_25 = new Button(composite_10, SWT.RADIO);
		button_25.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(7, 2);
			}
		});
		button_25.setText("\u5220\u9664");

		Button button_26 = new Button(composite_10, SWT.RADIO);
		button_26.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(7, 3);
			}
		});
		button_26.setText("\u5BF9\u6BD4");

		Button button_27 = new Button(composite_10, SWT.RADIO);
		button_27.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(7, 4);
			}
		});
		button_27.setText("\u521D\u59CB\u5316");
		
		Button button_50 = new Button(composite_10, SWT.RADIO);
		button_50.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				presenter.getRunMap().put(7, 5);
			}
		});
		button_50.setText("\u65E0");

		text_13 = new Text(composite_10, SWT.BORDER);
		text_13.setEnabled(false);
		text_13.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		text_28 = new Text(composite_10, SWT.BORDER);
		text_28.setEnabled(false);
		text_28.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		Composite composite_11 = new Composite(composite_4, SWT.NONE);
		composite_11.setLayout(new GridLayout(9, false));

		Label label_7 = new Label(composite_11, SWT.NONE);
		label_7.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_7.setText("08");

		text_14 = new Text(composite_11, SWT.BORDER);
		text_14.setText("192.168.1.0");
		GridData gd_text_14 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text_14.widthHint = 87;
		text_14.setLayoutData(gd_text_14);

		Button button_28 = new Button(composite_11, SWT.RADIO);
		button_28.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(8, 1);
			}
		});
		button_28.setText("\u4E0B\u8F7D");

		Button button_29 = new Button(composite_11, SWT.RADIO);
		button_29.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(8, 2);
			}
		});
		button_29.setText("\u5220\u9664");

		Button button_30 = new Button(composite_11, SWT.RADIO);
		button_30.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(8, 3);
			}
		});
		button_30.setText("\u5BF9\u6BD4");

		Button button_31 = new Button(composite_11, SWT.RADIO);
		button_31.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(8, 4);
			}
		});
		button_31.setText("\u521D\u59CB\u5316");
		
		Button button_51 = new Button(composite_11, SWT.RADIO);
		button_51.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				presenter.getRunMap().put(8, 5);
			}
		});
		button_51.setText("\u65E0");

		text_15 = new Text(composite_11, SWT.BORDER);
		text_15.setEnabled(false);
		text_15.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		text_29 = new Text(composite_11, SWT.BORDER);
		text_29.setEnabled(false);
		text_29.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		Composite composite_12 = new Composite(composite_4, SWT.NONE);
		composite_12.setLayout(new GridLayout(9, false));

		Label label_8 = new Label(composite_12, SWT.NONE);
		label_8.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_8.setText("09");

		text_16 = new Text(composite_12, SWT.BORDER);
		text_16.setText("192.168.1.0");
		GridData gd_text_16 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text_16.widthHint = 87;
		text_16.setLayoutData(gd_text_16);

		Button button_32 = new Button(composite_12, SWT.RADIO);
		button_32.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(9, 1);
			}
		});
		button_32.setText("\u4E0B\u8F7D");

		Button button_33 = new Button(composite_12, SWT.RADIO);
		button_33.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(9, 2);
			}
		});
		button_33.setText("\u5220\u9664");

		Button button_34 = new Button(composite_12, SWT.RADIO);
		button_34.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(9, 3);
			}
		});
		button_34.setText("\u5BF9\u6BD4");

		Button button_35 = new Button(composite_12, SWT.RADIO);
		button_35.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(9, 4);
			}
		});
		button_35.setText("\u521D\u59CB\u5316");
		
		Button button_52 = new Button(composite_12, SWT.RADIO);
		button_52.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				presenter.getRunMap().put(9, 5);
			}
		});
		button_52.setText("\u65E0");

		text_17 = new Text(composite_12, SWT.BORDER);
		text_17.setEnabled(false);
		text_17.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		text_30 = new Text(composite_12, SWT.BORDER);
		text_30.setEnabled(false);
		text_30.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		Composite composite_13 = new Composite(composite_4, SWT.NONE);
		composite_13.setLayout(new GridLayout(9, false));

		Label label_9 = new Label(composite_13, SWT.NONE);
		label_9.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_9.setText("10");

		text_18 = new Text(composite_13, SWT.BORDER);
		text_18.setText("192.168.1.0");
		GridData gd_text_18 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text_18.widthHint = 87;
		text_18.setLayoutData(gd_text_18);

		Button button_36 = new Button(composite_13, SWT.RADIO);
		button_36.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(10, 1);
			}
		});
		button_36.setText("\u4E0B\u8F7D");

		Button button_37 = new Button(composite_13, SWT.RADIO);
		button_37.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(10, 2);
			}
		});
		button_37.setText("\u5220\u9664");

		Button button_38 = new Button(composite_13, SWT.RADIO);
		button_38.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(10, 3);
			}
		});
		button_38.setText("\u5BF9\u6BD4");

		Button button_39 = new Button(composite_13, SWT.RADIO);
		button_39.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				presenter.getRunMap().put(10, 4);
			}
		});
		button_39.setText("\u521D\u59CB\u5316");
		
		Button button_53 = new Button(composite_13, SWT.RADIO);
		button_53.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				presenter.getRunMap().put(10, 5);
			}
		});
		button_53.setText("\u65E0");

		text_19 = new Text(composite_13, SWT.BORDER);
		text_19.setEnabled(false);
		text_19.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		text_31 = new Text(composite_13, SWT.BORDER);
		text_31.setEnabled(false);
		text_31.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		Group group_1 = new Group(composite_4, SWT.NONE);
		group_1.setLayout(new GridLayout(3, false));
		group_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		group_1.setText("\u64CD\u4F5C");

		button_40 = new Button(group_1, SWT.NONE);
		button_40.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				button_40.setEnabled(false);
				button_43.setEnabled(true);
				presenter.setRunstatus(true);
				Map<Integer, String> deviceMap = presenter.getDeviceMap();
				deviceMap.put(1, text.getText());
				deviceMap.put(2, text_2.getText());
				deviceMap.put(3, text_4.getText());
				deviceMap.put(4, text_6.getText());
				deviceMap.put(5, text_8.getText());
				deviceMap.put(6, text_10.getText());
				deviceMap.put(7, text_12.getText());
				deviceMap.put(8, text_14.getText());
				deviceMap.put(9, text_16.getText());
				deviceMap.put(10, text_18.getText());
				presenter.run();
				
			}
		});
		button_40.setText("\u8FD0\u884C");
		
		button_43 = new Button(group_1, SWT.NONE);
		button_43.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				button_40.setEnabled(true);
				button_43.setEnabled(false);
				presenter.setRunstatus(false);
			}
		});
		button_43.setText("\u505C\u6B62");
		button_43.setEnabled(false);

		Button btnNewButton = new Button(group_1, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Map<Integer, String> deviceMap = presenter.getDeviceMap();
				deviceMap.put(1, text.getText());
				deviceMap.put(2, text_2.getText());
				deviceMap.put(3, text_4.getText());
				deviceMap.put(4, text_6.getText());
				deviceMap.put(5, text_8.getText());
				deviceMap.put(6, text_10.getText());
				deviceMap.put(7, text_12.getText());
				deviceMap.put(8, text_14.getText());
				deviceMap.put(9, text_16.getText());
				deviceMap.put(10, text_18.getText());
				setNumText("ʧ��","ʧ��","ʧ��","ʧ��","ʧ��","ʧ��","ʧ��","ʧ��","ʧ��","ʧ��");
				presenter.summayAllDevice();
			}
		});
		btnNewButton.setText("\u8BFB\u6570");
		
		Composite composite_14 = new Composite(composite_2, SWT.NONE);
		composite_14.setLayout(new GridLayout(1, false));
		composite_14.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		
		text_32 = new Text(composite_14, SWT.BORDER | SWT.V_SCROLL);
		GridData gd_text_32 = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_text_32.heightHint = 386;
		text_32.setLayoutData(gd_text_32);
		
		Button button_42 = new Button(composite_14, SWT.NONE);
		button_42.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				presenter.setCardList();
			}
		});
		button_42.setText("\u5237\u65B0");
						
								Composite composite_3 = new Composite(composite, SWT.NONE);
								composite_3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
										composite_3.setLayout(new GridLayout(1, false));
								
										text_21 = new Text(composite_3, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
										GridData gd_text_21 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
										gd_text_21.heightHint = 114;
										text_21.setLayoutData(gd_text_21);
		presenter.setView(this);
		initTextMap();

	}

	private void initTextMap() {
		textMap.put(1, text_22);
		textMap.put(2, text_23);
		textMap.put(3, text_24);
		textMap.put(4, text_25);
		textMap.put(5, text_26);
		textMap.put(6, text_27);
		textMap.put(7, text_28);
		textMap.put(8, text_29);
		textMap.put(9, text_30);
		textMap.put(10, text_31);
		
	}

	public void setNumText(Object... strings) {
		if (strings.length != 10) {
			return;
		} else {
			text_1.setText(strings[0] + "");
			text_3.setText(strings[1] + "");
			text_5.setText(strings[2] + "");
			text_7.setText(strings[3] + "");
			text_9.setText(strings[4] + "");
			text_11.setText(strings[5] + "");
			text_13.setText(strings[6] + "");
			text_15.setText(strings[7] + "");
			text_17.setText(strings[8] + "");
			text_19.setText(strings[9] + "");
		}
	}
	
	public void setLog(final String log){
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				if(log==null){
					text_21.setText("");
					return;
				}
				text_21.append(log+"\n");
			}
		});
		
	}
	
	public void setText22(final String msg){
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				text_22.setText(msg);
			}
		});
		
	}

	public Text getText_22() {
		return text_22;
	}

	public void setText(final int num, final int i) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				textMap.get(num).setText(i+"");
			}
		});
		
	}

	public void setCardList(final List<Card> listc) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				StringBuilder sb=new StringBuilder("��"+listc.size()+"�ſ�Ƭ\n");
				for (Card card : listc) {
					sb.append(card.getIdentifire().toUpperCase()+"\n");
				}
				text_32.setText(sb.toString());
			}
		});
		
	}
}
