/*
 * RetanguloEnvolvente.java
 *
 * Created on 7 de Janeiro de 2002, 19:48
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package moduledefault.classify.c45.rafael.view.jpanel.graph;

import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author cccasagrande
 */
public class RetanguloEnvolvente {
    
    /** Creates a new instance of RetanguloEnvolvente */
    public RetanguloEnvolvente() {
    }
    
    public static Rectangle getRetanguloEnvolvente(Point a,Point b){
        Rectangle rect=null;
        int maxX,maxY,minX,minY;
        if(a.getX()>b.getX()){
            maxX=(int)a.getX();
            minX=(int)b.getX();
        }else{
            maxX=(int)b.getX();
            minX=(int)a.getX();
        }
        
        if(a.getY()>b.getY()){
            maxY=(int)a.getY();
            minY=(int)b.getY();
        }else{
            maxY=(int)b.getY();
            minY=(int)a.getY();
        }
        int w=maxX-minX;
        int h=maxY-minY;
        if(w==0){
            w=5;
        }
        if(h==0){
            h=5;
        }
        rect=new Rectangle(minX,minY,w,h);
        return rect;
    }
    
    
    public static Rectangle getRetanguloEnvolvente(Rectangle r,Point p){
        Rectangle rect=null;
        
        Point rPmin=new Point((int)r.getX(),(int)r.getY());
        Point rPmax=new Point((int)(r.getWidth()+r.getX()),(int)(r.getHeight()+r.getY()));
        
        int maxX,maxY,minX,minY;
        
        
        //ponto canto superior esquerdo
        if(p.getX()<rPmin.getX()){
            minX=(int)p.getX();
        }else{
            minX=(int)rPmin.getX();
        }
        
        
        if(p.getY()<rPmin.getY()){
            minY=(int)p.getY();
        }else{
            minY=(int)rPmin.getY();
        }
        
        
        //ponto canto inferior direito
        
        if(p.getX()>rPmax.getX()){
            maxX=(int)p.getX();
        }else{
            maxX=(int)rPmax.getX();
        }
        
        
        if(p.getY()>rPmax.getY()){
            maxY=(int)p.getY();
        }else{
            maxY=(int)rPmax.getY();
        }
        
        int w=maxX-minX;
        int h=maxY-minY;
        if(w==0){
            w=5;
        }
        if(h==0){
            h=5;
        }
        rect=new Rectangle(minX,minY,w,h);
        return rect;
    }
    
     public static Rectangle getRetanguloEnvolvente(Rectangle r1,Rectangle r2){
         Rectangle rect=null;
        
         
         Point p1=new Point((int)r2.getX(),(int)r2.getY());
         
         Point p2=new Point((int)(r2.getWidth()+r2.getX()),(int)(r2.getHeight()+r2.getY()));
         
         Rectangle aux=getRetanguloEnvolvente(r1,p1);
         
         rect=getRetanguloEnvolvente(aux,p2);
         
         return rect;
     }
}
