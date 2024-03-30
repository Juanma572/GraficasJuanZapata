
package Ejercicio;

import java.awt.Color;
import java.awt.Graphics;


public class Graficas {
    
    public static void Linea(Graphics g, int x, int y, int x1, int y1){
        
        g.setColor(Color.white);
        g.drawLine(x, y, x1, y1);
        
    }
    
    public static void Circulo(Graphics g, int x, int y, int width, int height){
        
        g.setColor(Color.white);
        g.drawOval(x, y, width, height);
        
    }
    
    public static void Rectangulo(Graphics g, int x, int y, int width, int height){
        
        g.setColor(Color.white);
        g.drawRect(x, y, width, height);
        
    }
    
}
