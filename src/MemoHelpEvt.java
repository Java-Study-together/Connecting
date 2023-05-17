
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MemoHelpEvt extends WindowAdapter implements ActionListener{

	//Has - A ���� �α� ���� Instance ����
	private MemoHelp mh;

	//Has - A ���� �α�
	public MemoHelpEvt(MemoHelp jmi) {
		this.mh = jmi;
	}//JavaMemoInfoEvt
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == mh.getJbtnClose()) {
			mh.dispose();
		}//end if
	}//actionPerformed

	@Override
	public void windowClosing(WindowEvent we) {
		mh.dispose();
	}//windowClosing
	
}//JavaMemoInfoEvt
