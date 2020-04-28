package graphiques;

import javax.swing.JPanel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class C_verif_format_int extends PlainDocument {
    private static final long serialVersionUID = 2967526196981748424L;
    private int limit;
    
    public C_verif_format_int(int limit) {
           super();
           this.limit = limit;  
           }
    
    public void insertString( int offset, String  str, AttributeSet attr) throws BadLocationException {
        if (str == null) return;
        if ((getLength() + str.length()) <= limit) {
          super.insertString(offset, str, attr);
        }
        try{
            Integer.parseInt(str);
        }
        catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(new JPanel(), "Erreur dans le format. Pas de lettres.");   
        }  
    }
}