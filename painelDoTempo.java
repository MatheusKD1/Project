
import javax.swing.JOptionPane;

import java.io.IOException;
import java.util.Scanner;

@SuppressWarnings("unused")
public class painelDoTempo {
	static String std="shutdown -s -t ";
	static String str="shutdown -a";
	public static void main(String[] args) {
		executar(comando());
	}
	public static String comando() {
		String cmd;
		cmd=JOptionPane.showInputDialog(null, "Tempo").toUpperCase();
		return cmd;
	}
	public static void executar(String cmd) {
		// CMD = Concatenar std + cmd
		if (cmd.substring(0, cmd.length()).equals("REINICIAR")) {
			try {
				JOptionPane.showConfirmDialog(null, "reiniciar?", cmd, 0);
				
				Runtime.getRuntime().exec(" ");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			Runtime.getRuntime().exec(std+cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
