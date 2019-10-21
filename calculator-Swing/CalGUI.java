package CalculatorSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class CalGUI extends JFrame {

    private class handler implements KeyListener, ActionListener{

        @Override
        public void keyTyped(KeyEvent e) {
        
        }

        @Override
        public void keyPressed(KeyEvent e) {
        
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 10 ; i++){
                if (e.getSource()==num[i]){
                    result += i ;
                    screen.setText(result);
                }
            }
            
            if(e.getSource()==ac){
                screen.setText("");
                result="";
            }
            
            if(e.getSource()==pn){
                String x = screen.getText();
                if(x.charAt(0)=='-'){
                    String y = x.substring(1);
                    screen.setText(y);
                } else {
                screen.setText("-"+x);
                }
            }
            
            if(e.getSource()==mod){
                result += "%" ;
                screen.setText(result);
            }
            
            if(e.getSource()==div){
                result += "/" ;
                screen.setText(result);
            }
            
            if(e.getSource()==mul){
                result += "*" ;
                screen.setText(result);
            }
            
            if(e.getSource()==sum){
                result += "+" ;
                screen.setText(result);
            }
            
            if(e.getSource()==min){
                result += "-" ;
                screen.setText(result);
            }
            
            if(e.getSource()==dot){
                result += "." ;
                screen.setText(result);
            }
            
            if(e.getSource()==eq){
                screen.setText(""+sum(result));
                result="";
            }
        }
        
        
    }
    
    handler h = new handler();
    String result = "";
    JButton ac = new JButton("AC");
    JButton pn = new JButton("+/-");
    JButton mod = new JButton("%");
    JButton div = new JButton("÷");
    JButton mul = new JButton("×");
    JButton sum = new JButton("+");
    JButton min = new JButton("-");
    JButton eq = new JButton("=");
    JButton dot = new JButton(".");

    JButton num[] = new JButton[10];

    JPanel main = new JPanel(new BorderLayout());
    JPanel p = new JPanel(new GridLayout(5, 1));
    JPanel numP1 = new JPanel(new GridLayout(1, 4, 0, 0));
    JPanel numP2 = new JPanel(new GridLayout(1, 4));
    JPanel numP3 = new JPanel(new GridLayout(1, 4));
    JPanel P4 = new JPanel(new GridLayout(1, 4));
    JPanel P5 = new JPanel(new GridLayout(1, 2));
    JPanel P51 = new JPanel(new GridLayout(1, 2));
    JPanel P6 = new JPanel(new BorderLayout());

    JTextArea screen = new JTextArea(2, 1);
    JMenuBar menu = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenuItem exit = new JMenuItem("Exit");

    public CalGUI() {
        menu.add(file);
        file.add(exit);
        menu.setBorder(new LineBorder(Color.BLACK));
        menu.setBackground(Color.BLACK);
        file.setForeground(Color.WHITE);
        //screen.setEditable(false);
        screen.setBackground(Color.BLACK);
        screen.setForeground(Color.WHITE);
        screen.setColumns(30);
        screen.setFont(new Font("Tohama", Font.BOLD, 30));

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        num[0] = new JButton("0");
        for (int i = 1; i < 10; i++) {
            num[i] = new JButton("" + i);
            num[i].addActionListener(h);
            num[i].setBackground(Color.DARK_GRAY);
            num[i].setForeground(Color.WHITE);
            num[i].setFont(new Font("Tohama", Font.BOLD, 20));
            num[i].setBorder(new LineBorder(Color.BLACK));
            if (i < 4) {
                numP1.add(num[i]);
            } else if (i < 7) {
                numP2.add(num[i]);
            } else {
                numP3.add(num[i]);
            }
        }

        ac.addActionListener(h);
        ac.setBorder(new LineBorder(Color.BLACK));
        ac.setFont(new Font("Tohama", Font.BOLD, 20));
        ac.setBackground(Color.LIGHT_GRAY);
        
        pn.addActionListener(h);
        pn.setBorder(new LineBorder(Color.BLACK));
        pn.setFont(new Font("Tohama", Font.BOLD, 20));
        pn.setBackground(Color.LIGHT_GRAY);
        
        mod.addActionListener(h);
        mod.setBorder(new LineBorder(Color.BLACK));
        mod.setFont(new Font("Tohama", Font.BOLD, 20));
        mod.setBackground(Color.LIGHT_GRAY);
        
        num[0].addActionListener(h);
        num[0].setBorder(new LineBorder(Color.BLACK));
        num[0].setFont(new Font("Tohama", Font.BOLD, 20));
        num[0].setBackground(Color.DARK_GRAY);
        num[0].setForeground(Color.white);
               
        dot.addActionListener(h);
        dot.setBorder(new LineBorder(Color.BLACK));
        dot.setFont(new Font("Tohama", Font.BOLD, 20));
        dot.setBackground(Color.DARK_GRAY);
        dot.setForeground(Color.white);
        
        div.addActionListener(h);
        div.setBorder(new LineBorder(Color.BLACK));
        div.setFont(new Font("Tohama", Font.BOLD, 20));
        div.setBackground(Color.ORANGE);
        div.setForeground(Color.WHITE);
        
        mul.addActionListener(h);
        mul.setBorder(new LineBorder(Color.BLACK));
        mul.setFont(new Font("Tohama", Font.BOLD, 20));
        mul.setBackground(Color.ORANGE);
        mul.setForeground(Color.WHITE);
        
        min.addActionListener(h);
        min.setBorder(new LineBorder(Color.BLACK));
        min.setFont(new Font("Tohama", Font.BOLD, 20));
        min.setBackground(Color.ORANGE);
        min.setForeground(Color.WHITE);
        
        sum.addActionListener(h);
        sum.setBorder(new LineBorder(Color.BLACK));
        sum.setFont(new Font("Tohama", Font.BOLD, 20));
        sum.setBackground(Color.ORANGE);
        sum.setForeground(Color.WHITE);
        
        eq.addActionListener(h);
        eq.setBorder(new LineBorder(Color.BLACK));
        eq.setFont(new Font("Tohama", Font.BOLD, 20));
        eq.setBackground(Color.ORANGE);
        eq.setForeground(Color.WHITE);
        
        numP1.add(sum);
        numP2.add(min);
        numP3.add(mul);

        P4.add(ac);
        P4.add(pn);
        P4.add(mod);
        P4.add(div);

        P5.add(num[0]);
        P5.add(P51);
        
        P51.add(dot);
        P51.add(eq);

        P6.add(screen, BorderLayout.CENTER);
        P6.add(menu, BorderLayout.NORTH);
        
        p.add(P4);
        p.add(numP3);
        p.add(numP2);
        p.add(numP1);
        p.add(P5);
        p.setBackground(Color.BLACK);

        main.add(p, BorderLayout.CENTER);
        main.add(P6, BorderLayout.NORTH);
        add(main);
    }

    void display() {
        CalGUI frame = new CalGUI();
        frame.setSize(300, 350);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

    }
    
    public double sum(String s) {
        double ans = 0;
        while (!s.isEmpty()) {
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                    int j = i-1;
                    while (j > 0 && !(s.charAt(j) == '*' || s.charAt(j) == '/' || s.charAt(j) == '+' || s.charAt(j) == '-')) {
                        --j;
                    }
                    int se = i + 1;
                    while (se < s.length() && !(s.charAt(se) == '*' || s.charAt(se) == '/' || s.charAt(se) == '+' || s.charAt(se) == '-')) {
                        ++se;
                    }
                    double temp;
                    int sign = 1 ;
                    if( s.charAt(j) == '-')
                        sign = -1 ;
                    
                    int sign2 = 1 ;
                    if(s.charAt( i + 1 ) == '-' )
                        sign2 = -1 ;
                    if (s.charAt(i) == '*') {
                        temp = sign*(Double.parseDouble(s.substring(j , i)) * Double.parseDouble(s.substring(i + 1, se)));
                    } else {
                        temp = sign2 *(Double.parseDouble(s.substring(j , i)) / Double.parseDouble(s.substring(i + 1, se)));
                    }
                    if( temp >= 0 )
                        s = s.substring(0, j) + '+' + temp + s.substring(se, s.length());
                    else
                        s = s.substring(0, j) + temp + s.substring(se, s.length());
                    i = s.length();
                }
            }
            boolean flag = true;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                    flag = false;
                }
            }

            int beg = 0;
            for (int i = 1; i < s.length() && flag; ++i) {
                if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                    ans += Double.parseDouble(s.substring(beg, i));
                    beg = i ;
                }
            }
            if( flag ){
                ans += Double.parseDouble(s.substring(beg, s.length() ) );
                break ;
            }
        }
        return ans;
    }
}
