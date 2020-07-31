import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.geom.*;
import org.jfree.data.category.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;

public class Imagen extends Component
{
    BufferedImage   img;
    int [][]     matrizImg;           //matrizImg de la imagen en escala de grises
    int [][]     matrizImg_R;         //matrizImg de la imagen en R
    int [][]     matrizImg_G;         //matriz de la imagen en G
    int [][]     matrizImg_B;         //matriz de la imagen en B
    int             columnas;         //numero de  columnas
    int             filas;            //numero de filas
  //  int []          M;              //matriz del histograma
    String paths;
    Imagen ima;
    int [][] matrizImg_1;
    int [][] matrizImg_2;
    int [][] matrizImg_3;
    int [] matrizHisto;
    int [][] matrizDilatacion;
    int [][] matrizMsk;
    int [][] gradiente1;
    int [][] gradiente2;
public Imagen(String nombreImagen)
{
        try
        {
            img = ImageIO.read(new File(nombreImagen));
            //System.out.println(nombreImagen);
            convertirImagenAMatriz();
        }
        catch (IOException e) {}
}
public Imagen(int [][]matriz)
{
         convertirMatrizAImagen(matriz);
}
public Imagen(int [][]Red,int[][]Green,int[][]Blue)
{
         convertirMatrizAImagenColor(Red,Green,Blue);
}
public void convertirImagenAMatriz()
{
        filas = img.getHeight();
    	columnas = img.getWidth();

    	matrizImg 	= new int [filas][columnas];
    	matrizImg_R	= new int [filas][columnas];
     	matrizImg_G     = new int [filas][columnas];
    	matrizImg_B	= new int [filas][columnas];
    	int r;
    	int g;
    	int b;

    	WritableRaster raster=img.getRaster();
    	int numBandas=raster.getNumBands(); 

    	for (int i=0;i<filas;i++) 
    	{
            for(int j=0;j<columnas;j++) 
            {
                if (numBandas==3)
                {   r=raster.getSample(j,i,0);    //canal 0
                    g=raster.getSample(j,i,1);    //canal 1
                    b=raster.getSample(j,i,2);    //canal 2
                     
                    matrizImg[i][j]=(r+g+b)/3;
                    //matrizImg[i][j]=r;
                    //matrizImg[i][j]=(20*r+30*g+50*b)/100;
                    matrizImg_R[i][j]=r;
                    matrizImg_G[i][j]=g;
                    matrizImg_B[i][j]=b;
                }
                if (numBandas==1)
                {   matrizImg[i][j]=raster.getSample(j,i,0);
                    matrizImg_R[i][j]=255;
                    matrizImg_G[i][j]=255;
                    matrizImg_B[i][j]=255;
                }
            }
        }
 }
// convertir matriz a imagen a escala de grises
public void convertirMatrizAImagen(int [][] matriz)
{
        int alto = matriz.length;
	int ancho = matriz[0].length;

        img = new BufferedImage(ancho,alto,BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster wr = img.getRaster();

        for (int i=0;i<alto;i++)
        {
            for(int j=0;j<ancho;j++)
            {
                wr.setSample(j,i,0,matriz[i][j]);
            }
        }
        img.setData(wr);
    }
// convertir las tres matricesa a una  imagen con tres colores
public void convertirMatrizAImagenColor(int [][] matrizR,int [][]matrizG,int [][]matrizB )
{

        int alto = matrizR.length;
	int ancho = matrizR[0].length;

        img = new BufferedImage(ancho,alto,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = img.getRaster();


        for (int i=0;i<alto;i++)
        {
            for(int j=0;j<ancho;j++)
            {
                wr.setSample(j,i,0,matrizR[i][j]);
                wr.setSample(j,i,1,matrizG[i][j]);
                wr.setSample(j,i,2,matrizB[i][j]);
            }
        }
        img.setData(wr);
    }
//Convertir Imagen a Negativo
public void convertirMatrizAImagenNegativo(int [][] matrizR,int [][]matrizG,int [][]matrizB )
{
            int alto = matrizR.length;
	    int ancho = matrizR[0].length;

        img = new BufferedImage(ancho,alto,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = img.getRaster();


        for (int i=0;i<alto;i++)
        {
            for(int j=0;j<ancho;j++)
            {
                wr.setSample(j,i,0,255-matrizR[i][j]);
                wr.setSample(j,i,1,255-matrizG[i][j]);
                wr.setSample(j,i,2,255-matrizB[i][j]);
            }
        }
        img.setData(wr);
    }
public void guardarImagen(int [][]matriz, String path)
{       
        BufferedImage img = new BufferedImage(matriz[0].length,matriz.length,BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster wr = img.getRaster();

        for (int i=0;i<matriz.length;i++)
        {            for(int j=0;j<matriz[0].length;j++)
            {
                wr.setSample(j,i,0,matriz[i][j]);
            }
        }

        img.setData(wr);

        try
        {
            ImageIO.write(img, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
}
public void guardarImagen(int [][]matriz_R, int [][]matriz_G, int [][]matriz_B,String path)
 {
        BufferedImage imgn = new BufferedImage(matriz_R[0].length,matriz_R.length,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();

        for (int i=0;i<matriz_R.length;i++)
        {   for(int j=0;j<matriz_R[0].length;j++)
            {
                wr.setSample(j,i,0,matriz_R[i][j]);
                wr.setSample(j,i,1,matriz_G[i][j]);
                wr.setSample(j,i,2,matriz_B[i][j]);
            }
        }

        img.setData(wr);
        try
        {
            ImageIO.write(img, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
}
public void guardarImagenNxM(int [][]matriz_R, int [][]matriz_G, int [][]matriz_B,String path)
 {
        BufferedImage imgn = new BufferedImage(matriz_R[0].length,matriz_R.length,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();

        for (int i=0;i<matriz_R.length;i++)
        {   for(int j=0;j<matriz_R[0].length;j++)
            {
                wr.setSample(j,i,0,matriz_R[i][j]);
                wr.setSample(j,i,1,matriz_G[i][j]);
                wr.setSample(j,i,2,matriz_B[i][j]);
            }
        }

        imgn.setData(wr);
        try
        {
            ImageIO.write(imgn, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
    }
public void guardarImagenNegativo(int [][]matriz_R, int [][]matriz_G, int [][]matriz_B,String path)
 {
        BufferedImage imgn = new BufferedImage(matriz_R[0].length,matriz_R.length,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();
        
        for (int i=0;i<matriz_R.length;i++)
        {   for(int j=0;j<matriz_R[0].length;j++)
            {
                wr.setSample(j,i,0,255-matriz_R[i][j]);
                wr.setSample(j,i,1,255-matriz_G[i][j]);
                wr.setSample(j,i,2,255-matriz_B[i][j]);
            }
        }   
        img.setData(wr);
        
        try
        {
            ImageIO.write(img, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
    }
public void ImagenANegativo(int [][]matriz_R, int [][]matriz_G, int [][]matriz_B,String path)
{
        WritableRaster wr = img.getRaster();
        for (int i=0;i<matriz_R.length;i++)
        {   for(int j=0;j<matriz_R[0].length;j++)
            {
                wr.setSample(j,i,0,255-matriz_R[i][j]);
                wr.setSample(j,i,1,255-matriz_G[i][j]);
                wr.setSample(j,i,2,255-matriz_B[i][j]);
            }
        }
}
public void ImagenAumento(int [][]Matriz_R, int [][]Matriz_G, int [][]Matriz_B,String path)
{
        int alto2x= Matriz_R.length*2;
        int ancho2x= Matriz_R[0].length*2;
        BufferedImage imgn = new BufferedImage(ancho2x,alto2x,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();
        int jp, ip,pR,pG,pB;
        matrizImg_1=new int [alto2x][ancho2x];
        matrizImg_2=new int [alto2x][ancho2x];
        matrizImg_3=new int [alto2x][ancho2x];
        for(int j= 0; j< Matriz_R[0].length; j++)
        {
            jp = 2*j;
            for(int i=0; i<Matriz_R.length; i++)
            {
                ip = 2*i;                
                    //matrizImgB[i][j]=(matrizImg_R[i][j]+matrizImg_G[i][j]+matrizImg_B[i][j])/3;
                    matrizImg_1[ip][jp]=matrizImg_R[i][j];
                    matrizImg_1[ip][jp+1]=matrizImg_R[i][j];
                    matrizImg_1[ip+1][jp]=matrizImg_R[i][j];
                    matrizImg_1[ip+1][jp+1]=matrizImg_R[i][j];
                    
                    matrizImg_2[ip][jp]=matrizImg_G[i][j];
                    matrizImg_2[ip][jp+1]=matrizImg_G[i][j];
                    matrizImg_2[ip+1][jp]=matrizImg_G[i][j];
                    matrizImg_2[ip+1][jp+1]=matrizImg_G[i][j];
                    
                    matrizImg_3[ip][jp]=matrizImg_B[i][j];
                    matrizImg_3[ip][jp+1]=matrizImg_B[i][j];
                    matrizImg_3[ip+1][jp]=matrizImg_B[i][j];
                    matrizImg_3[ip+1][jp+1]=matrizImg_B[i][j];
            }
        }
       ventana1(matrizImg_1, matrizImg_2, matrizImg_3, null);    
}
public void ImagenAumentoNxM(int [][]Matriz_R, int [][]Matriz_G, int [][]Matriz_B,String path, int n, int m, boolean activado)
{
        int altoMx= Matriz_R.length*m;
        int anchoNx= Matriz_R[0].length*n;
        int xp, yp;
        matrizImg_1=new int [altoMx][anchoNx];
        matrizImg_2=new int [altoMx][anchoNx];
        matrizImg_3=new int [altoMx][anchoNx];    
        for(int j= 0; j< Matriz_R[0].length; j++){
            xp = n*j;
            for(int i=0; i<Matriz_R.length; i++)
            {
                yp = m*i;
                for(int c=0; c<3; c++){
                    if(c==0){
                        for(int ai=0; ai<n; ai++){
                            for(int ay=0; ay<m; ay++){
                                matrizImg_1[yp+ay][xp+ai]=matrizImg_R[i][j];
                            }
                        }
                    }
                    if(c==1){
                        for(int ai=0; ai<n; ai++){
                            for(int ay=0; ay<m; ay++){
                                matrizImg_2[yp+ay][xp+ai]=matrizImg_G[i][j];
                            }
                        }
                    }
                    if(c==2){
                        for(int ai=0; ai<n; ai++)
                        {
                            for(int ay=0; ay<m; ay++)
                            {
                                matrizImg_3[yp+ay][xp+ai]=matrizImg_B[i][j];
                            }
                        }
                    }                    
                }
            }
        }
   
        if(activado==true)
        {
            ventana1(matrizImg_1, matrizImg_2, matrizImg_3, null);
            guardarImagen(matrizImg_1, matrizImg_2, matrizImg_3, path);
        }
}
public void ImagenReduccionMitad(int [][]Matriz_R, int [][]Matriz_G, int [][]Matriz_B,String path)
{
        int altoMx= Matriz_R.length/2;//crea los parametros diviendo a la canditand de reduccion
        int anchoNx= Matriz_R[0].length/2;//crea los parametros diviendo a la canditand de reduccion
        BufferedImage imgn = new BufferedImage(anchoNx,altoMx,BufferedImage.TYPE_INT_RGB);
        matrizImg_1=new int [altoMx][anchoNx];
        matrizImg_2=new int [altoMx][anchoNx];
        matrizImg_3=new int [altoMx][anchoNx];
        WritableRaster wr = imgn.getRaster();
        //int numnRaster = raster.getNumbBands().
        int xp, yp,pR,pG,pB;
        for(int j= 0; j< anchoNx; j++){//j ira en x desde incio hasta el fin del nuevo tamaño creado
            xp = j;//asignamos los valores a xp que serviarn al pintado
            for(int i=0; i<altoMx; i++){//i ira en y desde el inicio hasta el fin del nuevo tamaño creado
                yp = i;//asignamos los valores a yp que serviran al pintado
                for(int c=0; c<3; c++){//recorrido de los canales
                    if(c==0){
                        pR = Matriz_R[i*2][j*2];//a la matriz a los valores hacemos el salto de lo s puntos en n y m
                        wr.setSample(xp, yp, c, pR);
                        matrizImg_1[yp][xp]=matrizImg_R[i*2][j*2];
                    }
                    if(c==1){
                        pG = Matriz_G[i*2][j*2];
                        wr.setSample(xp, yp, c, pG);
                        matrizImg_2[yp][xp]=matrizImg_G[i*2][j*2];
                    }
                    if(c==2){
                        pB = Matriz_B[i*2][j*2];
                        wr.setSample(xp, yp, c, pB);
                        matrizImg_3[yp][xp]=matrizImg_B[i*2][j*2];                        
                    }                    
                }
            }
        }
        ventana1(matrizImg_1, matrizImg_2, matrizImg_3, null);
        imgn.setData(wr);
        try
        {
            ImageIO.write(imgn, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
}
public void ImagenReduccion(int [][]Matriz_R, int [][]Matriz_G, int [][]Matriz_B,String path, int n, int m, boolean activado)
{
        int altoMx= Matriz_R.length/m;//crea los parametros diviendo a la canditand de reduccion
        int anchoNx= Matriz_R[0].length/n;//crea los parametros diviendo a la canditand de reduccion
        //int numnRaster = raster.getNumbBands().
        int xp, yp,pR,pG,pB;
        matrizImg_1=new int [altoMx][anchoNx];
        matrizImg_2=new int [altoMx][anchoNx];
        matrizImg_3=new int [altoMx][anchoNx];
        
        for(int j= 0; j< anchoNx; j++){//j ira en x desde incio hasta el fin del nuevo tamaño creado
            xp = j;//asignamos los valores a xp que serviarn al pintado
            for(int i=0; i<altoMx; i++){//i ira en j desde el inicio hasta el fin del nuevo tamaño creado
                yp = i;//asignamos los valores a yp que serviran al pintado
                for(int c=0; c<3; c++){//recorrido de los canales
                    if(c==0){
                        pR = Matriz_R[i*m][j*n];//a la matriz a los valores hacemos el salto de lo s puntos en n y m
                        matrizImg_1[yp][xp]=matrizImg_R[i*m][j*n];
                    }
                    if(c==1){
                        pG = Matriz_G[i*m][j*n];
                        matrizImg_2[yp][xp]=matrizImg_G[i*m][j*n];
                    }
                    if(c==2){
                        pB = Matriz_B[i*m][j*n];
                        matrizImg_3[yp][xp]=matrizImg_B[i*m][j*n];
                    }                    
                }
            }
        }
        if(activado==true)
        {
            ventana1(matrizImg_1, matrizImg_2, matrizImg_3, null);
            guardarImagen(matrizImg_1, matrizImg_2, matrizImg_3, path);
        }
}
public void ImagenRotacion90Derecha(int [][]Matriz_R, int [][]Matriz_G, int [][]Matriz_B,String path)
{
        int altoM= Matriz_R[0].length;//X pasa a Y'
        int anchoN= Matriz_R.length;//Y pasa a X'
        BufferedImage imgn = new BufferedImage(altoM,anchoN,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();
        int xp, yp,pR,pG,pB;
        matrizImg_1=new int [altoM][anchoN];
        matrizImg_2=new int [altoM][anchoN];
        matrizImg_3=new int [altoM][anchoN];
        //System.out.println(anchoN);
        //System.out.println(altoM);
        for(int i= 0; i<anchoN; i++)
        {
            //System.out.println(i);
            for(int j=0; j<altoM; j++)
            {
                //System.out.println(j);
                for(int c=0; c<3;c++)
                {
                    
                    if(c==0){
                        pR = Matriz_R[anchoN-1-i][j];//a la matriz a los valores hacemos el salto de lo s puntos en n y m
                        wr.setSample(j, i, c, pR);
                        matrizImg_1[j][i]=Matriz_R[anchoN-1-i][j];
                    }
                    if(c==1){
                        pG = Matriz_G[anchoN-1-i][j];
                        wr.setSample(j, i, c, pG);
                        matrizImg_2[j][i]=Matriz_G[anchoN-1-i][j];
                    }
                    if(c==2){
                        pB = Matriz_B[anchoN-1-i][j];
                        wr.setSample(j, i, c, pB);
                        matrizImg_3[j][i]=Matriz_B[anchoN-1-i][j];
                    }
                }
            }
        }
        ventana1(matrizImg_1, matrizImg_2, matrizImg_3, null);
        imgn.setData(wr);
        try
        {
            ImageIO.write(imgn, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
}
public void ImagenRotacion90Izquierda(int [][]Matriz_R, int [][]Matriz_G, int [][]Matriz_B,String path)
{
        int altoM= Matriz_R.length;//X
        int anchoN= Matriz_R[0].length;//Y
        BufferedImage imgn = new BufferedImage(altoM,anchoN,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();
        int xp, yp,pR,pG,pB;
        matrizImg_1=new int [anchoN][altoM];
        matrizImg_2=new int [anchoN][altoM];
        matrizImg_3=new int [anchoN][altoM];
        //System.out.println(anchoN);
        //System.out.println(altoM);
        for(int i= 0; i<altoM; i++)//y
        {
            //System.out.println(i);
            for(int j=0; j<anchoN; j++)//x
            {
                //System.out.println(j);
                for(int c=0; c<3;c++)//
                {
                    
                    if(c==0){
                        pR = Matriz_R[i][anchoN-1-j];//a la matriz a los valores hacemos el salto de lo s puntos en n y m
                        wr.setSample(i, j, c, pR);
                        matrizImg_1[j][i]=Matriz_R[i][anchoN-1-j];
                    }
                    if(c==1){
                        pG = Matriz_G[i][anchoN-1-j];
                        wr.setSample(i, j, c, pG);
                        matrizImg_2[j][i]=Matriz_G[i][anchoN-1-j];
                    }
                    if(c==2){
                        pB = Matriz_B[i][anchoN-1-j];
                        wr.setSample(i, j, c, pB);
                        matrizImg_3[j][i]=Matriz_B[i][anchoN-1-j];
                    }
                }
            }
        }
        ventana1(matrizImg_1, matrizImg_2, matrizImg_3, null);
        imgn.setData(wr);
        try
        {
            ImageIO.write(imgn, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
}
public void ImagenRotacion180(int [][]Matriz_R, int [][]Matriz_G, int [][]Matriz_B,String path)
{
        int altoMy= Matriz_R.length;//X
        int anchoNx= Matriz_R[0].length;//Y
        BufferedImage imgn = new BufferedImage(anchoNx,altoMy,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();
        int xp, yp,pR,pG,pB;
        matrizImg_1=new int [altoMy][anchoNx];
        matrizImg_2=new int [altoMy][anchoNx];
        matrizImg_3=new int [altoMy][anchoNx];
        //System.out.println(anchoN);
        //System.out.println(altoM);
        for(int i= 0; i<anchoNx; i++)
        {
            //System.out.println(i);
            for(int j=0; j<altoMy; j++)
            {
                //System.out.println(j);
                for(int c=0; c<3;c++)
                {
                    
                    if(c==0){
                        pR = Matriz_R[altoMy-1-j][anchoNx-1-i];//a la matriz a los valores hacemos el salto de lo s puntos en n y m
                        wr.setSample(i, j, c, pR);
                        matrizImg_1[j][i]=Matriz_R[altoMy-1-j][anchoNx-1-i];
                    }
                    if(c==1){
                        pG = Matriz_G[altoMy-1-j][anchoNx-1-i];
                        wr.setSample(i, j, c, pG);
                        matrizImg_2[j][i]=Matriz_G[altoMy-1-j][anchoNx-1-i];
                    }
                    if(c==2){
                        pB = Matriz_B[altoMy-1-j][anchoNx-1-i];
                        wr.setSample(i, j, c, pB);
                        matrizImg_3[j][i]=Matriz_B[altoMy-1-j][anchoNx-1-i];
                    }
                }
            }
        }
        ventana1(matrizImg_1, matrizImg_2, matrizImg_3, null);
        imgn.setData(wr);
        try
        {
            ImageIO.write(imgn, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
}
public void SumaImagen1(int [][]Matriz_R1, int [][]Matriz_G1, int [][]Matriz_B1,String path, int [][]Matriz_R2, int [][]Matriz_G2, int [][]Matriz_B2)
{
        int anchoN;
        int altoM;
        anchoN= Math.min(Matriz_R1[0].length,Matriz_R2[0].length);
        altoM= Math.min(Matriz_R1.length,Matriz_R2.length);
        int temp;
        BufferedImage imgn = new BufferedImage(anchoN,altoM,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();
        System.out.println(anchoN);
        System.out.println(altoM);
        matrizImg_1=new int [altoM][anchoN];
        matrizImg_2=new int [altoM][anchoN];
        matrizImg_3=new int [altoM][anchoN];
        for(int i= 0; i< anchoN; i++){
            //System.out.println(i);
            for(int j=0; j<altoM; j++)
            {
             
             for(int c=0; c<3; c++)
             {
                //System.out.println(Matriz_R2[j][i]);    
                
                if(c==0)
                {
                    temp=Matriz_R1[j][i]+ Matriz_R2[j][i];
                    if(temp>=255)
                    {
                        wr.setSample(i,j,c,255); //Setea los valores
                        matrizImg_1[j][i]=255;
                    }
                    else
                    {
                    wr.setSample(i,j,c,temp);//Setea los valores
                    matrizImg_1[j][i]=temp;
                    }
                }
                if(c==1)
                {
                       temp=Matriz_G1[j][i]+ Matriz_G2[j][i];
                       if(temp>=255){
                           wr.setSample(i,j,c,255); //Setea los valores
                            matrizImg_2[j][i]=255;
                       }
                       else{
                           wr.setSample(i,j,c,temp);//Setea los valores
                           matrizImg_2[j][i]=temp;
                       }
                }
                if(c==2)
                {
                       temp=Matriz_B1[j][i]+ Matriz_B2[j][i];
                       if(temp>=255){
                           wr.setSample(i,j,c,255); //Setea los valores
                           matrizImg_3[j][i]=255;
                       }
                       else{
                           wr.setSample(i,j,c,temp);//Setea los valores
                           matrizImg_3[j][i]=temp;
                        } 
                }
            }
        }
    }
    ventana1(matrizImg_1, matrizImg_2, matrizImg_3, null);
    imgn.setData(wr);
        try
        {
            ImageIO.write(imgn, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
}
public void SumaImagen2(int [][]Matriz_R1, int [][]Matriz_G1, int [][]Matriz_B1,String path, int [][]Matriz_R2, int [][]Matriz_G2, int [][]Matriz_B2, float alfa, float beta)
{
        int anchoN;
        int altoM;
        anchoN= Math.min(Matriz_R1[0].length,Matriz_R2[0].length);
        altoM= Math.min(Matriz_R1.length,Matriz_R2.length);
        int pintado;
        float temp;
        BufferedImage imgn = new BufferedImage(anchoN,altoM,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();
        System.out.println(anchoN);
        System.out.println(altoM);
        matrizImg_1=new int [altoM][anchoN];
        matrizImg_2=new int [altoM][anchoN];
        matrizImg_3=new int [altoM][anchoN];
        for(int i= 0; i< anchoN; i++){
            //System.out.println(i);
            for(int j=0; j<altoM; j++)
            {
             
             for(int c=0; c<3; c++)
             {
                //System.out.println(Matriz_R2[j][i]);    
                
                if(c==0)
                {
                    temp=(alfa*Matriz_R1[j][i])+ (beta*Matriz_R2[j][i]);
                    pintado=(int)temp;
                    wr.setSample(i,j,c,pintado);//Setea los valores
                    matrizImg_1[j][i]=pintado;
                    
                }
                if(c==1)
                {
                    temp=(alfa*Matriz_G1[j][i])+ (beta*Matriz_G2[j][i]);
                    pintado=(int)temp;
                    wr.setSample(i,j,c,pintado);//Setea los valores
                    matrizImg_2[j][i]=pintado;
                       
                }
                if(c==2)
                {
                    temp=(alfa*Matriz_B1[j][i])+ (beta*Matriz_B2[j][i]);
                    pintado=(int)temp;
                    wr.setSample(i,j,c,temp);//Setea los valores
                    matrizImg_3[j][i]=pintado;
                     
                }
            }
        }
    }
    ventana1(matrizImg_1, matrizImg_2, matrizImg_3, null);
    imgn.setData(wr);
        try
        {
            ImageIO.write(imgn, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
}
public void RestaImagen1(int [][]Matriz_R1, int [][]Matriz_G1, int [][]Matriz_B1,String path, int [][]Matriz_R2, int [][]Matriz_G2, int [][]Matriz_B2)
{
        int anchoN;
        int altoM;
        anchoN= Math.min(Matriz_R1[0].length,Matriz_R2[0].length);
        altoM= Math.min(Matriz_R1.length,Matriz_R2.length);
        int temp;
        BufferedImage imgn = new BufferedImage(anchoN,altoM,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();
        System.out.println(anchoN);
        System.out.println(altoM);
        matrizImg_1=new int [altoM][anchoN];
        matrizImg_2=new int [altoM][anchoN];
        matrizImg_3=new int [altoM][anchoN];
        for(int i= 0; i< anchoN; i++){
            //System.out.println(i);
            for(int j=0; j<altoM; j++)
            {
             
             for(int c=0; c<3; c++)
             {
                //System.out.println(Matriz_R2[j][i]);    
                
                if(c==0)
                {
                    temp=Matriz_R1[j][i]- Matriz_R2[j][i];
                    if(temp<=0)
                    {
                        wr.setSample(i,j,c,0); //Setea los valores
                        matrizImg_1[j][i]=0;
                    }
                    else
                    {
                    wr.setSample(i,j,c,temp);//Setea los valores
                    matrizImg_1[j][i]=temp;
                    }
                }
                if(c==1)
                {
                       temp=Matriz_G1[j][i]- Matriz_G2[j][i];
                       if(temp<=0){
                           wr.setSample(i,j,c,0); //Setea los valores
                            matrizImg_2[j][i]=0;
                       }
                       else{
                           wr.setSample(i,j,c,temp);//Setea los valores
                           matrizImg_2[j][i]=temp;
                       }
                }
                if(c==2)
                {
                       temp=Matriz_B1[j][i]- Matriz_B2[j][i];
                       if(temp<=0){
                           wr.setSample(i,j,c,255); //Setea los valores
                           matrizImg_3[j][i]=0;
                       }
                       else{
                           wr.setSample(i,j,c,temp);//Setea los valores
                           matrizImg_3[j][i]=temp;
                        } 
                }
            }
        }
    }
    ventana1(matrizImg_1, matrizImg_2, matrizImg_3, null);
    imgn.setData(wr);
        try
        {
            ImageIO.write(imgn, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
}
public void RestaImagen2(int [][]Matriz_R1, int [][]Matriz_G1, int [][]Matriz_B1,String path, int [][]Matriz_R2, int [][]Matriz_G2, int [][]Matriz_B2)
{
        int anchoN;
        int altoM;
        anchoN= Math.min(Matriz_R1[0].length,Matriz_R2[0].length);
        altoM= Math.min(Matriz_R1.length,Matriz_R2.length);
        int temp;
        BufferedImage imgn = new BufferedImage(anchoN,altoM,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();
        System.out.println(anchoN);
        System.out.println(altoM);
        matrizImg_1=new int [altoM][anchoN];
        matrizImg_2=new int [altoM][anchoN];
        matrizImg_3=new int [altoM][anchoN];
        for(int i= 0; i< anchoN; i++){
            //System.out.println(i);
            for(int j=0; j<altoM; j++)
            {
             
             for(int c=0; c<3; c++)
             {                
                if(c==0)
                {
                    temp=Math.abs(Matriz_R1[j][i]- Matriz_R2[j][i]);
                    wr.setSample(i,j,c,temp);//Setea los valores
                    matrizImg_1[j][i]=temp;
                    
                }
                if(c==1)
                {
                    temp=Math.abs(Matriz_G1[j][i]- Matriz_G2[j][i]);
                    wr.setSample(i,j,c,temp);//Setea los valores
                    matrizImg_2[j][i]=temp;
                }
                if(c==2)
                {
                    temp=Math.abs(Matriz_B1[j][i]- Matriz_B2[j][i]);
                   wr.setSample(i,j,c,temp);//Setea los valores
                   matrizImg_3[j][i]=temp;
                }
            }
        }
    }
    ventana1(matrizImg_1, matrizImg_2, matrizImg_3, null);
    imgn.setData(wr);
        try
        {
            ImageIO.write(imgn, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
}
public void RestaImagen3(int [][]Matriz_R1, int [][]Matriz_G1, int [][]Matriz_B1,String path, int [][]Matriz_R2, int [][]Matriz_G2, int [][]Matriz_B2)
{
        int anchoN;
        int altoM;
        anchoN= Math.min(Matriz_R1[0].length,Matriz_R2[0].length);
        altoM= Math.min(Matriz_R1.length,Matriz_R2.length);
        int temp;
        int k=256/2;
        BufferedImage imgn = new BufferedImage(anchoN,altoM,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();
        System.out.println(anchoN);
        System.out.println(altoM);
        matrizImg_1=new int [altoM][anchoN];
        matrizImg_2=new int [altoM][anchoN];
        matrizImg_3=new int [altoM][anchoN];
        for(int i= 0; i< anchoN; i++){
            //System.out.println(i);
            for(int j=0; j<altoM; j++)
            {
             
             for(int c=0; c<3; c++)
             {                
                if(c==0)
                {
                    temp=k+((Matriz_R1[j][i]- Matriz_R2[j][i])/2);
                    wr.setSample(i,j,c,temp);//Setea los valores
                    matrizImg_1[j][i]=temp;
                    
                }
                if(c==1)
                {
                    temp=k+((Matriz_G1[j][i]- Matriz_G2[j][i])/2);
                    wr.setSample(i,j,c,temp);//Setea los valores
                    matrizImg_2[j][i]=temp;
                }
                if(c==2)
                {
                    temp=k+((Matriz_B1[j][i]- Matriz_B2[j][i])/2);
                   wr.setSample(i,j,c,temp);//Setea los valores
                   matrizImg_3[j][i]=temp;
                }
            }
        }
    }
    ventana1(matrizImg_1, matrizImg_2, matrizImg_3, null);
    imgn.setData(wr);
        try
        {
            ImageIO.write(imgn, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
}
public void MultiplicacionImagen(int [][]Matriz_R1, int [][]Matriz_G1, int [][]Matriz_B1,String path, int [][]Matriz_R2, int [][]Matriz_G2, int [][]Matriz_B2)
{
        int anchoN;
        int altoM;
        anchoN= Math.min(Matriz_R1[0].length,Matriz_R2[0].length);
        altoM= Math.min(Matriz_R1.length,Matriz_R2.length);
        int temp;
        int k;
        k=255;
        BufferedImage imgn = new BufferedImage(anchoN,altoM,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();
        System.out.println(anchoN);
        System.out.println(altoM);
        matrizImg_1=new int [altoM][anchoN];
        matrizImg_2=new int [altoM][anchoN];
        matrizImg_3=new int [altoM][anchoN];
        for(int i= 0; i< anchoN; i++){
            //System.out.println(i);
            for(int j=0; j<altoM; j++)
            {
             
             for(int c=0; c<3; c++)
             {                
                if(c==0)
                {
                    temp=(int)(((Matriz_R1[j][i]* Matriz_R2[j][i]))/k);
                    wr.setSample(i,j,c,temp);//Setea los valores
                    matrizImg_1[j][i]=temp;
                    
                }
                if(c==1)
                {
                    temp=(int)(k*((Matriz_G1[j][i]* Matriz_G2[j][i]))/k);
                    wr.setSample(i,j,c,temp);//Setea los valores
                    matrizImg_2[j][i]=temp;
                }
                if(c==2)
                {
                    temp=(int)(k*((Matriz_B1[j][i]* Matriz_B2[j][i]))/k);
                   wr.setSample(i,j,c,temp);//Setea los valores
                   matrizImg_3[j][i]=temp;
                }
            }
        }
    }
    ventana1(matrizImg_1, matrizImg_2, matrizImg_3, null);
    imgn.setData(wr);
        try
        {
            ImageIO.write(imgn, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
}
public void DivisionImagen1(int [][]Matriz_R1, int [][]Matriz_G1, int [][]Matriz_B1,String path, int [][]Matriz_R2, int [][]Matriz_G2, int [][]Matriz_B2)
{
        int anchoN;
        int altoM;
        anchoN= Math.min(Matriz_R1[0].length,Matriz_R2[0].length);
        altoM= Math.min(Matriz_R1.length,Matriz_R2.length);
        int temp, min, max;
        BufferedImage imgn = new BufferedImage(anchoN,altoM,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();
        System.out.println(anchoN);
        System.out.println(altoM);
        matrizImg_1=new int [altoM][anchoN];
        matrizImg_2=new int [altoM][anchoN];
        matrizImg_3=new int [altoM][anchoN];
        for(int i= 0; i< anchoN; i++){
            //System.out.println(i);
            for(int j=0; j<altoM; j++)
            {
             for(int c=0; c<3; c++)
             {                
                if(c==0)
                {
                    min=Math.min(Matriz_R1[j][i],Matriz_R2[j][i]);
                    max=Math.max(Matriz_R1[j][i],Matriz_R2[j][i]);
                    temp=((256-1)-((256-1)*min))/(max+1);
                    wr.setSample(i,j,c,temp);//Setea los valores
                    matrizImg_1[j][i]=temp;
                    
                }
                if(c==1)
                {
                    min=Math.min(Matriz_G1[j][i],Matriz_G2[j][i]);
                    max=Math.max(Matriz_G1[j][i],Matriz_G2[j][i]);
                    temp=((256-1)-((256-1)*min))/(max+1);
                    wr.setSample(i,j,c,temp);//Setea los valores
                    matrizImg_2[j][i]=temp;
                }
                if(c==2)
                {
                   min=Math.min(Matriz_B1[j][i],Matriz_B2[j][i]);
                   max=Math.max(Matriz_B1[j][i],Matriz_B2[j][i]);
                   temp=((256-1)-((256-1)*min))/(max+1);
                   wr.setSample(i,j,c,temp);//Setea los valores
                   matrizImg_3[j][i]=temp;
                }
            }
        }
    }
    ventana1(matrizImg_1, matrizImg_2, matrizImg_3, null);
    
    imgn.setData(wr);
        try
        {
            ImageIO.write(imgn, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
}
public void DivisionImagen2(int [][]Matriz_R1, int [][]Matriz_G1, int [][]Matriz_B1,String path, int [][]Matriz_R2, int [][]Matriz_G2, int [][]Matriz_B2)
{
        int anchoN;
        int altoM;
        anchoN= Math.min(Matriz_R1[0].length,Matriz_R2[0].length);
        altoM= Math.min(Matriz_R1.length,Matriz_R2.length);
        int min, max, pintado;
        double k=(256-1)/Math.log(256);
        double temp;
        BufferedImage imgn = new BufferedImage(anchoN,altoM,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();
        System.out.println(anchoN);
        System.out.println(altoM);
        matrizImg_1=new int [altoM][anchoN];
        matrizImg_2=new int [altoM][anchoN];
        matrizImg_3=new int [altoM][anchoN];
        for(int i= 0; i< anchoN; i++){
            //System.out.println(i);
            for(int j=0; j<altoM; j++)
            {
             
             for(int c=0; c<3; c++)
             {                
                if(c==0)
                {
                    min=Math.min(Matriz_R1[j][i],Matriz_R2[j][i]);
                    max=Math.max(Matriz_R1[j][i],Matriz_R2[j][i]);
                    temp=k*Math.log((1+max)/(min+1));
                    pintado=(int)temp;
                    wr.setSample(i,j,c,pintado);//Setea los valores
                    matrizImg_1[j][i]=pintado;
                    
                }
                if(c==1)
                {
                    min=Math.min(Matriz_G1[j][i],Matriz_G2[j][i]);
                    max=Math.max(Matriz_G1[j][i],Matriz_G2[j][i]);
                    temp=((256-1)-((256-1)*min))/(max+1);
                    pintado=(int)temp;
                    wr.setSample(i,j,c,pintado);//Setea los valores
                    matrizImg_2[j][i]=pintado;
                }
                if(c==2)
                {
                   min=Math.min(Matriz_B1[j][i],Matriz_B2[j][i]);
                   max=Math.max(Matriz_B1[j][i],Matriz_B2[j][i]);
                   temp=((256-1)-((256-1)*min))/(max+1);
                   pintado=(int)temp;
                   wr.setSample(i,j,c,pintado);//Setea los valores
                   matrizImg_3[j][i]=pintado;
                }
            }
        }
    }
    ventana1(matrizImg_1, matrizImg_2, matrizImg_3, null);
    
    imgn.setData(wr);
        try
        {
            ImageIO.write(imgn, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
}
public void AndImagen(int [][]Matriz_R1, int [][]Matriz_G1, int [][]Matriz_B1,String path, int [][]Matriz_R2, int [][]Matriz_G2, int [][]Matriz_B2)
{
        int anchoN;
        int altoM;
        anchoN= Math.min(Matriz_R1[0].length,Matriz_R2[0].length);
        altoM= Math.min(Matriz_R1.length,Matriz_R2.length);
        int temp;
        BufferedImage imgn = new BufferedImage(anchoN,altoM,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();
        System.out.println(anchoN);
        System.out.println(altoM);
        matrizImg_1=new int [altoM][anchoN];
        matrizImg_2=new int [altoM][anchoN];
        matrizImg_3=new int [altoM][anchoN];
        for(int i= 0; i< anchoN; i++){
            //System.out.println(i);
            for(int j=0; j<altoM; j++)
            {
             
             for(int c=0; c<3; c++)
             {
                //System.out.println(Matriz_R2[j][i]);    
                
                if(c==0)
                {
                    temp=(Matriz_R1[j][i]& Matriz_R2[j][i]);
                    wr.setSample(i,j,c,temp);//Setea los valores
                    matrizImg_1[j][i]=temp;
                    
                }
                if(c==1)
                {
                    temp=(Matriz_G1[j][i]& Matriz_G2[j][i]);
                    wr.setSample(i,j,c,temp);//Setea los valores
                    matrizImg_2[j][i]=temp;
                }
                if(c==2)
                {
                    temp=(Matriz_B1[j][i]& Matriz_B2[j][i]);
                    wr.setSample(i,j,c,temp);//Setea los valores
                    matrizImg_3[j][i]=temp;
                }
            }
        }
    }
    ventana1(matrizImg_1, matrizImg_2, matrizImg_3, null);
    imgn.setData(wr);
        try
        {
            ImageIO.write(imgn, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
}
public void OrImagen(int [][]Matriz_R1, int [][]Matriz_G1, int [][]Matriz_B1,String path, int [][]Matriz_R2, int [][]Matriz_G2, int [][]Matriz_B2)
{
        int anchoN;
        int altoM;
        anchoN= Math.min(Matriz_R1[0].length,Matriz_R2[0].length);
        altoM= Math.min(Matriz_R1.length,Matriz_R2.length);
        int temp;
        BufferedImage imgn = new BufferedImage(anchoN,altoM,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();
        System.out.println(anchoN);
        System.out.println(altoM);
        matrizImg_1=new int [altoM][anchoN];
        matrizImg_2=new int [altoM][anchoN];
        matrizImg_3=new int [altoM][anchoN];
        for(int i= 0; i< anchoN; i++){
            //System.out.println(i);
            for(int j=0; j<altoM; j++)
            {
             
             for(int c=0; c<3; c++)
             {
                //System.out.println(Matriz_R2[j][i]);    
                
                if(c==0)
                {
                    temp=(Matriz_R1[j][i]|Matriz_R2[j][i]);
                    wr.setSample(i,j,c,temp);//Setea los valores
                    matrizImg_1[j][i]=temp;
                    
                }
                if(c==1)
                {
                    temp=(Matriz_G1[j][i]|Matriz_G2[j][i]);
                    wr.setSample(i,j,c,temp);//Setea los valores
                    matrizImg_2[j][i]=temp;
                }
                if(c==2)
                {
                    temp=(Matriz_B1[j][i]| Matriz_B2[j][i]);
                    wr.setSample(i,j,c,temp);//Setea los valores
                    matrizImg_3[j][i]=temp;
                }
            }
        }
    }
    ventana1(matrizImg_1, matrizImg_2, matrizImg_3, null);
    imgn.setData(wr);
        try
        {
            ImageIO.write(imgn, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
}
public void NotImagen(int [][]Matriz_R, int [][]Matriz_G, int [][]Matriz_B,String path)
{
        int altoMx= Matriz_R.length;
        int anchoNx= Matriz_R[0].length;
        BufferedImage imgn = new BufferedImage(anchoNx,altoMx,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();
        int xp, yp,pR,pG,pB;
        matrizImg_1=new int [altoMx][anchoNx];
        matrizImg_2=new int [altoMx][anchoNx];
        matrizImg_3=new int [altoMx][anchoNx];
        for(int j= 0; j< anchoNx; j++){//j ira en x desde incio hasta el fin del nuevo tamaño creado
            xp = j;//asignamos los valores a xp que serviarn al pintado
            for(int i=0; i<altoMx; i++){//i ira en y desde el inicio hasta el fin del nuevo tamaño creado
                yp = i;//asignamos los valores a yp que serviran al pintado
                for(int c=0; c<3; c++){//recorrido de los canales
                    if(c==0){
                        pR = ~Matriz_R[i][j];//a la matriz a los valores hacemos el salto de lo s puntos en n y m
                        wr.setSample(j, i, c, pR);
                        matrizImg_1[i][j]=pR;
                    }
                    if(c==1){
                        pG = ~Matriz_G[i][j];
                        wr.setSample(j, i, c, pG);
                        matrizImg_2[i][j]=pG;
                    }
                    if(c==2){
                        pB = ~Matriz_B[i][j];
                        wr.setSample(j, i, c, pB);
                        matrizImg_3[i][j]=pB;                        
                    }                    
                }
            }
        }
        ventana1(matrizImg_1, matrizImg_2, matrizImg_3, null);
        imgn.setData(wr);
        try
        {
            ImageIO.write(imgn, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
}
public void NandImagen(int [][]Matriz_R1, int [][]Matriz_G1, int [][]Matriz_B1,String path, int [][]Matriz_R2, int [][]Matriz_G2, int [][]Matriz_B2)
{
        int anchoN;
        int altoM;
        anchoN= Math.min(Matriz_R1[0].length,Matriz_R2[0].length);
        altoM= Math.min(Matriz_R1.length,Matriz_R2.length);
        int temp;
        BufferedImage imgn = new BufferedImage(anchoN,altoM,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();
        System.out.println(anchoN);
        System.out.println(altoM);
        matrizImg_1=new int [altoM][anchoN];
        matrizImg_2=new int [altoM][anchoN];
        matrizImg_3=new int [altoM][anchoN];
        for(int i= 0; i< anchoN; i++){
            //System.out.println(i);
            for(int j=0; j<altoM; j++)
            {
             
             for(int c=0; c<3; c++)
             {
                //System.out.println(Matriz_R2[j][i]);    
                
                if(c==0)
                {
                    temp=~(Matriz_R1[j][i]& Matriz_R2[j][i]);
                    wr.setSample(i,j,c,temp);//Setea los valores
                    matrizImg_1[j][i]=temp;
                    
                }
                if(c==1)
                {
                    temp=~(Matriz_G1[j][i]& Matriz_G2[j][i]);
                    wr.setSample(i,j,c,temp);//Setea los valores
                    matrizImg_2[j][i]=temp;
                }
                if(c==2)
                {
                    temp=~(Matriz_B1[j][i]& Matriz_B2[j][i]);
                    wr.setSample(i,j,c,temp);//Setea los valores
                    matrizImg_3[j][i]=temp;
                }
            }
        }
    }
    ventana1(matrizImg_1, matrizImg_2, matrizImg_3, null);
    imgn.setData(wr);
        try
        {
            ImageIO.write(imgn, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
}
public void XORImagen(int [][]Matriz_R1, int [][]Matriz_G1, int [][]Matriz_B1,String path, int [][]Matriz_R2, int [][]Matriz_G2, int [][]Matriz_B2)
{
        int anchoN;
        int altoM;
        anchoN= Math.min(Matriz_R1[0].length,Matriz_R2[0].length);
        altoM= Math.min(Matriz_R1.length,Matriz_R2.length);
        int temp;
        BufferedImage imgn = new BufferedImage(anchoN,altoM,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();
        System.out.println(anchoN);
        System.out.println(altoM);
        matrizImg_1=new int [altoM][anchoN];
        matrizImg_2=new int [altoM][anchoN];
        matrizImg_3=new int [altoM][anchoN];
        for(int i= 0; i< anchoN; i++){
            //System.out.println(i);
            for(int j=0; j<altoM; j++)
            {
             
             for(int c=0; c<3; c++)
             {
                //System.out.println(Matriz_R2[j][i]);    
                
                if(c==0)
                {
                    temp=(Matriz_R1[j][i]^ Matriz_R2[j][i]);
                    wr.setSample(i,j,c,temp);//Setea los valores
                    matrizImg_1[j][i]=temp;
                    
                }
                if(c==1)
                {
                    temp=(Matriz_G1[j][i]^ Matriz_G2[j][i]);
                    wr.setSample(i,j,c,temp);//Setea los valores
                    matrizImg_2[j][i]=temp;
                }
                if(c==2)
                {
                    temp=(Matriz_B1[j][i]^ Matriz_B2[j][i]);
                    wr.setSample(i,j,c,temp);//Setea los valores
                    matrizImg_3[j][i]=temp;
                }
            }
        }
    }
    ventana1(matrizImg_1, matrizImg_2, matrizImg_3, null);
    imgn.setData(wr);
        try
        {
            ImageIO.write(imgn, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
}
public void BinarizacionImagenColor(int [][]Matriz_R, int [][]Matriz_G, int [][]Matriz_B,String path)
{
        int altoMx= Matriz_R.length;
        int anchoNx= Matriz_R[0].length;
        BufferedImage imgn = new BufferedImage(anchoNx,altoMx,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();
        int tempR=0, tempG=0, tempB=0, compR, compG, compB, compT, valorR, valorG, valorB, pintado;
        matrizImg_1=new int [altoMx][anchoNx];
        matrizImg_2=new int [altoMx][anchoNx];
        matrizImg_3=new int [altoMx][anchoNx];
        for(int j= 0; j< anchoNx; j++){//j ira en x desde incio hasta el fin del nuevo tamaño creado
            for(int i=0; i<altoMx; i++){//i ira en y desde el inicio hasta el fin del nuevo tamaño creado
                tempR=tempR+Matriz_R[i][j];
                tempG=tempG+Matriz_G[i][j];
                tempB=tempB+Matriz_B[i][j];
            }
        }
        compR=tempR/(altoMx*anchoNx);
        compG=tempG/(altoMx*anchoNx);
        compB=tempB/(altoMx*anchoNx);
        compT=(compR+compG+compB)/3;
        
        for(int j= 0; j< anchoNx; j++){//j ira en x desde incio hasta el fin del nuevo tamaño creado
            for(int i=0; i<altoMx; i++){//i ira en y desde el inicio hasta el fin del nuevo tamaño creado
                valorR=Matriz_R[i][j];
                valorG=Matriz_G[i][j];
                valorB=Matriz_B[i][j];
                pintado=(valorR+valorG+valorB)/3;
                if(pintado>=compT)
                {
                    wr.setSample(j, i, 0, 255);
                    matrizImg_1[i][j]=255;
                    wr.setSample(j, i, 1, 255);
                    matrizImg_2[i][j]=255;
                    wr.setSample(j, i, 2, 255);
                    matrizImg_3[i][j]=255;
                }
                else
                {
                    wr.setSample(j, i, 0, 0);
                    matrizImg_1[i][j]=0;
                    wr.setSample(j, i, 1, 0);
                    matrizImg_2[i][j]=0;
                    wr.setSample(j, i, 2, 0);
                    matrizImg_3[i][j]=0;  
                }
            }
        }
        
        ventana1(matrizImg_1, matrizImg_2, matrizImg_3, null);
        imgn.setData(wr);
        try
        {
            ImageIO.write(imgn, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
}
public void BinarizacionImagenGris(int [][]matriz, String path)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        BufferedImage imgn = new BufferedImage(anchoNx,altoMx,BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster wr = imgn.getRaster();
        int pR, tempR=0, compR, valor=0;
        matrizImg_1=new int [altoMx][anchoNx];
        matrizHisto= new int [256];
        for(int j= 0; j< anchoNx; j++){
            for(int i=0; i<altoMx; i++){
                tempR=tempR+matriz[i][j];
            }
        }
        for(int j= 0; j< altoMx; j++){
            for(int i=0; i<anchoNx; i++)
            {
                valor=matriz[j][i];
                matrizHisto[valor]+=1;
            }
        }
        compR=tempR/(altoMx*anchoNx);
        
        for(int j= 0; j< anchoNx; j++){
            for(int i=0; i<altoMx; i++){
                if(matriz[i][j]>=compR)
                {
                    pR=255;
                }
                else
                {
                    pR=0;
                }
                wr.setSample(j, i, 0, pR);
                matrizImg_1[i][j]=pR;
            }
        }
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        for(int i=0;i<matrizHisto.length;i++)
        {
            datos.addValue(matrizHisto[i], "", " "+i+" ");
        }
        JFreeChart chart = ChartFactory.createBarChart("Histograma", null, null, datos, PlotOrientation.VERTICAL, false, false, false);
        CategoryPlot catPlot= chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) catPlot.getRenderer();
//        renderer.setSeriesPaint(0, Color.black);
//        chart.setAntiAlias(true);
//        chart.setBackgroundPaint(new Color(214, 217, 223)); 
        catPlot.setRangeGridlinePaint(Color.BLACK);
        
       ChartPanel frame = new ChartPanel(chart);
       JFrame ventana= new JFrame("Muestra de Histograma");
       ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       ventana.add(frame);
       ventana.setSize(800,600);
       ventana.setVisible(true);
       ventana.setLocationRelativeTo(null);
       ventana.repaint();
       ventana.setLayout(new java.awt.BorderLayout());
       //ventana.add(new ChartPanel(chart));
       ventana.validate();  
       
        // prueba1
        /*
        ChartFrame muestra = new ChartFrame("Muestra Histograma", chart);
        muestra.pack();
        muestra.setVisible(true);
        */
        ventana(matrizImg_1,null);
        imgn.setData(wr);
        try
        {
            ImageIO.write(imgn, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
}
public void HistogramaImagenColor(int [][]Matriz_R, int [][]Matriz_G, int [][]Matriz_B)
{
        int altoMx= Matriz_R.length;
        int anchoNx= Matriz_R[0].length;
        matrizImg_1=new int [3][256];
        
        for(int j= 0; j< altoMx; j++){
            for(int i=0; i<anchoNx; i++)
            {
                matrizImg_1[0][Matriz_R[j][i]]+=1;
                matrizImg_1[1][Matriz_G[j][i]]+=1;
                matrizImg_1[2][Matriz_B[j][i]]+=1;
            }
        }
        
        
        for(int m=0; m<3; m++)
        {
            if(m==0)
            {
                DefaultCategoryDataset datos1 = new DefaultCategoryDataset();
                for(int i=0;i<matrizImg_1[0].length;i++)
                {

                    datos1.addValue(matrizImg_1[0][i], "", " "+i+" ");
                }    

                JFreeChart rojo = ChartFactory.createBarChart("Histograma Rojo", null, null, datos1, PlotOrientation.VERTICAL, false, false, false);
                CategoryPlot catPlotR= rojo.getCategoryPlot();
                BarRenderer rendererR = (BarRenderer) catPlotR.getRenderer();
                rendererR.setSeriesPaint(0, Color.red);

                ChartFrame ventana1 = new ChartFrame("Muestra Histograma ROJO ", rojo);
                ventana1.pack();
                ventana1.setVisible(true);
            }
        
        if(m==1)
        {
            DefaultCategoryDataset datos2 = new DefaultCategoryDataset();
            for(int i=0;i<matrizImg_1[0].length;i++)
            {

                datos2.addValue(matrizImg_1[1][i], "", " "+i+" ");
            }
            for(int i=0;i<matrizImg_1[1].length;i++)
            {

                datos2.addValue(matrizImg_1[1][i], "", " "+i+" ");
            }

            JFreeChart azul = ChartFactory.createBarChart("Histograma Azul", null, null, datos2, PlotOrientation.VERTICAL, false, false, false);
            CategoryPlot catPlotA= azul.getCategoryPlot();
            BarRenderer rendererA = (BarRenderer) catPlotA.getRenderer();
            rendererA.setSeriesPaint(0, Color.blue);

            ChartFrame ventana2 = new ChartFrame("Muestra Histograma AZUL", azul);
            ventana2.pack();
            ventana2.setVisible(true);
        }
        if(m==2)
        {
        DefaultCategoryDataset datos3 = new DefaultCategoryDataset();
        for(int i=0;i<matrizImg_1[0].length;i++)
        {
            
            datos3.addValue(matrizImg_1[2][i], "", " "+i+" ");
        }
        for(int i=0;i<matrizImg_1[2].length;i++)
        {
            datos3.addValue(matrizImg_1[2][i], "", " "+i+" ");
        }
        
        JFreeChart verde = ChartFactory.createBarChart("Histograma Verde", null, null, datos3, PlotOrientation.VERTICAL, false, false, false);
        CategoryPlot catPlot= verde.getCategoryPlot();
        BarRenderer rendererV = (BarRenderer) catPlot.getRenderer();
        rendererV.setSeriesPaint(0, Color.green);
       
        ChartFrame ventana3 = new ChartFrame("Muestra Histograma VERDE", verde);
        ventana3.pack();
        ventana3.setVisible(true);
        }
        }
        
}
public void pruebaAumentoN(int [][]Matriz_R, int [][]Matriz_G, int [][]Matriz_B,String path, float n, float m)
{
        int altoMx= (int)(Matriz_R.length*m);
        int anchoNx=(int)(Matriz_R[0].length*n);
        BufferedImage imgn = new BufferedImage(anchoNx,altoMx,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();
        int xp, yp,pR,pG,pB, xpalma=0;
        matrizImg_1=new int [altoMx][anchoNx];
        matrizImg_2=new int [altoMx][anchoNx];
        matrizImg_3=new int [altoMx][anchoNx];
        System.out.println(altoMx);
        System.out.println(anchoNx);
        for(int j= 0; j< Matriz_R[0].length; j++){
            xp = (int)((j*n)-(n/10));
            //System.out.println(xp);
            for(int i=0; i<Matriz_R.length; i++)
            {
                for(int c=0; c<3; c++){
                    if(c==0){
                        pR = Matriz_R[i][j];
                        for(int ai=xpalma; ai<=xp; ai++){
                                //wr.setSample(j+ai, i, c, pR);
                                System.out.println(ai);
                                matrizImg_1[i][j+ai]=matrizImg_R[i][j];
                        }
                        xpalma=xp+1;
                    }
                    if(c==1){
                        pG = Matriz_G[i][j];
                        for(int ai=0; ai<xp; ai++){
                                //wr.setSample(j+ai, i, c, pG);
                                matrizImg_2[i][j+ai]=matrizImg_G[i][j];
                            
                        }
                    }
                    if(c==2){
                        pB = Matriz_B[i][j];
                        for(int ai=0; ai<xp; ai++)
                        {
                            //wr.setSample(j+ai, i, c, pB);
                            matrizImg_3[i][j+ai]=matrizImg_B[i][j];
                        }
                    }                    
                }
            }
        }
        ventana1(matrizImg_1, matrizImg_2, matrizImg_3, null);
        imgn.setData(wr);
        try
        {
            ImageIO.write(imgn, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
        
}
public void rotarLibreDerecha(int [][]Matriz_R, int [][]Matriz_G, int [][]Matriz_B, float angulo2, String path)
{
        
        double angulo = angulo2 * 2.0 * Math.PI/360.0;
        
        int anchoI = Matriz_R[0].length; // N
        int altoI = Matriz_R.length; // M
        
        int centroAncho = (int)(anchoI/2); // N2
        int centroAlto = (int)(altoI/2); // M2
        
        System.out.println("AnchoI = "+ anchoI + "  centroAncho= " + centroAncho);
        System.out.println("AltoI = "+ altoI + "  centroAlto= " + centroAlto);
        System.out.println("AnguloRotacion= " + angulo);
        
        int esquinaX[] ={0,anchoI-1,0,anchoI-1}; // x
        int esquinaY[] ={0,0,altoI-1,altoI-1}; // y
        
        int esquinaX2[] = new int[4]; // p
        int esquinaY2[] = new int[4]; // q
                
        int xp,yp,xr,yr;
        
        for (int k = 0; k < 4; k++) {
            xp = esquinaX[k]-centroAncho;
            yp = esquinaY[k]-centroAlto;
            xr = (int) Math.round( (xp*Math.cos(angulo)) + (yp*Math.sin(angulo)) );
            yr = (int) Math.round( (-xp*Math.sin(angulo)) + (yp*Math.cos(angulo)) );
            esquinaX2[k] = xr + centroAncho;
            esquinaY2[k] = yr + centroAlto;
        }
        
        int pMin = Math.min(Math.min(esquinaX2[0],esquinaX2[1]),Math.min(esquinaX2[2],esquinaX2[3])); // p1
        int pMax = Math.max(Math.max(esquinaX2[0],esquinaX2[1]),Math.max(esquinaX2[2],esquinaX2[3])); // p2
        int qMin = Math.min(Math.min(esquinaY2[0],esquinaY2[1]),Math.min(esquinaY2[2],esquinaY2[3])); // q1
        int qMax = Math.max(Math.max(esquinaY2[0],esquinaY2[1]),Math.max(esquinaY2[2],esquinaY2[3])); // q2
        
        for (int i = 0; i < 4; i++) {
            System.out.println("esquinaX2["+i+"]= "+esquinaX2[i] + "   esquinaY2["+i+"]= "+esquinaY2[i] );
        }
        
        System.out.println("pMin= " + pMin +"  pMax= " + pMax);
        System.out.println("qMin= " + qMin +"  qMax= " + qMax);
        
        // Imagen nueva
        int anchoNuevo = pMax - pMin + 1;
        int altoNuevo = qMax - qMin + 1;
        System.out.println("AnchoNuevo= "+anchoNuevo+"   AltoNuevo= " + altoNuevo);
        
        int dimMayor = Math.max(anchoNuevo, altoNuevo);
        anchoNuevo = altoNuevo = dimMayor;
        
        BufferedImage imgn = new BufferedImage(anchoNuevo,altoNuevo,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();
        
        
        
        //Color de fondo
        for (int i = 0; i < altoNuevo; i++) {
            for (int j = 0; j < anchoNuevo; j++) {
                for (int k = 0; k < 3; k++) {
                    if (k == 0) {
                        wr.setSample(j,i,0,255);
                    }
                    if (k == 1) {
                        wr.setSample(j,i,1,255);
                    }
                    if (k == 2) {
                        wr.setSample(j,i,2,255);
                    }
                }
            }
        }
        
        // sx y sy son los corrimientos acumulados
        int xP,yP,xR,yR,jp,ip;
        int sx = (-1*pMin) + centroAncho;
        int sy = (-1*qMin) + centroAlto;
        
        for (int i = 0; i < altoI; i++) {
            xP = i - centroAlto;
            for (int j = 0; j < anchoI; j++) {
                yP = j - centroAncho;
                
                xR = (int) Math.round( (xP*Math.cos(angulo)) + (yP*Math.sin(angulo)) );
                yR = (int) Math.round( (-xP*Math.sin(angulo)) + (yP*Math.cos(angulo)) );
                
                ip = xR + sx;
                jp = yR + sy;
                
                for (int k = 0; k < 3; k++) {
                    //R’[ip, jp , c] = R[i, j, c];
                    if (k == 0) {
                        wr.setSample(jp,ip,0,Matriz_R[i][j]);
                    }
                    if (k == 1) {
                        wr.setSample(jp,ip,1,Matriz_G[i][j]);
                    }
                    if (k == 2) {
                        wr.setSample(jp,ip,2,Matriz_B[i][j]);
                    }
                }
            }
        }
        
        imgn.setData(wr);
        
        try{
            ImageIO.write(imgn, "JPG", new File(path+".jpg"));
        }catch(IOException e){
            
        }
        
    }
public int [][] DilatacionBinario(int [][]matriz, String path, boolean activado)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        int pR, tempR=0, compR, valor=0;
        matrizImg_1=new int [altoMx][anchoNx];
        matrizImg_2=new int [altoMx][anchoNx];
        //Elemento Estructurante
        matrizDilatacion = new int [3][3];
        matrizDilatacion[0][0]=0;
        matrizDilatacion[0][1]=255;
        matrizDilatacion[0][2]=0;
        matrizDilatacion[1][0]=255;
        matrizDilatacion[1][1]=255;
        matrizDilatacion[1][2]=255;
        matrizDilatacion[2][0]=0;
        matrizDilatacion[2][1]=255;
        matrizDilatacion[2][2]=0;
        /*
        for(int j= 0; j< anchoNx; j++){
            for(int i=0; i<altoMx; i++){
                tempR=tempR+matriz[i][j];
            }
        }

        compR=tempR/(altoMx*anchoNx);
        
        for(int j= 0; j< anchoNx; j++){
            for(int i=0; i<altoMx; i++){
                if(matriz[i][j]>=compR)
                {
                    pR=255;
                }
                else
                {
                    pR=0;
                }
                //wr.setSample(j, i, 0, pR);
                matrizImg_1[i][j]=pR;
            }
        }*/
        int dx=3,dy=3;
        for(int j= 0; j< anchoNx-dx; j++){
            for(int i=0; i<altoMx-dy; i++){
                if(matrizImg_1[i][j]==matrizDilatacion[0][0])
                {
                    for(int Cdx=0; Cdx<dx; Cdx++)
                    {
                        for(int Cdy=0; Cdy<dy; Cdy++)
                        {
                            matrizImg_2[i+Cdy][j+Cdx]=matrizDilatacion[Cdx][Cdy];
                            //wr.setSample(j+Cdx, i+Cdy, 0, matrizImg_2[i+Cdy][j+Cdx]);   
                        }
                    }
                    
                }
            }
        }
        if(activado==true)
        {
            ventana(matrizImg_2,"Dilatacion Binario");
            guardarImagen(matrizImg_2,path);
        }
        return matrizImg_2;
}
public int [][] DilatacionGries(int [][]matriz, String path, boolean activado)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        int pR, tempR=0, compR, valor=0;
        matrizImg_1=new int [altoMx][anchoNx];
        //Elemento Estructurante
        matrizDilatacion = new int [3][3];
        matrizDilatacion[0][0]=105;
        matrizDilatacion[0][1]=105;
        matrizDilatacion[0][2]=105;
        matrizDilatacion[1][0]=105;
        matrizDilatacion[1][1]=105;
        matrizDilatacion[1][2]=205;
        matrizDilatacion[2][0]=105;
        matrizDilatacion[2][1]=115;
        matrizDilatacion[2][2]=55;

        int dx=3,dy=3;
        
        for(int Cdx=0;Cdx<dx; Cdx++)
        {
            for(int Cdy=0; Cdy<dy; Cdy++)
            {
                for(int j= 0; j< anchoNx; j++){
                    for(int i=0; i<altoMx; i++){
                        if(matriz[i][j]>=matrizDilatacion[Cdy][Cdx])
                        {
                            matrizImg_1[i][j]=matriz[i][j];
                        }
                        else
                        {
                            matrizImg_1[i][j]=matrizDilatacion[Cdy][Cdx];
                        }
                    //wr.setSample(j+Cdx, i+Cdy, 0, matrizImg_2[i+Cdy][j+Cdx]);   
                    }
                }
            }
        }

        ventana(matriz,null);
        //ventana(matrizImg_2,null);
        if(activado==true)
        {
            ventana(matrizImg_1,null);
            guardarImagen(matrizImg_1,path);
        }
        return matrizImg_1;
}
public int [][] DilatacionColor(int [][]Matriz_R, int [][]Matriz_G, int [][]Matriz_B,String path, boolean activado)
{
        int altoMx= Matriz_R.length;
        int anchoNx= Matriz_R[0].length;
        int sumaTotalColor;
        matrizImg_1=new int [altoMx][anchoNx];
        //Elemento Estructurante
        matrizDilatacion = new int [3][3];
        matrizDilatacion[0][0]=105;
        matrizDilatacion[0][1]=105;
        matrizDilatacion[0][2]=105;
        matrizDilatacion[1][0]=105;
        matrizDilatacion[1][1]=105;
        matrizDilatacion[1][2]=205;
        matrizDilatacion[2][0]=105;
        matrizDilatacion[2][1]=115;
        matrizDilatacion[2][2]=55;

        int dx=3,dy=3;
        
        for(int Cdx=0;Cdx<dx; Cdx++)
        {
            for(int Cdy=0; Cdy<dy; Cdy++)
            {
                for(int j= 0; j< anchoNx; j++){
                    for(int i=0; i<altoMx; i++){
                        sumaTotalColor=Matriz_R[i][j]+Matriz_G[i][j]+Matriz_B[i][j];
                        
                        
                        if(sumaTotalColor>=matrizDilatacion[Cdy][Cdx])
                        {
                            matrizImg_1[i][j]=Matriz_R[i][j];
                            matrizImg_2[i][j]=Matriz_G[i][j];
                            matrizImg_3[i][j]=Matriz_B[i][j];
                        }
                        else
                        {
                            matrizImg_1[i][j]=matrizDilatacion[Cdy][Cdx];
                            matrizImg_2[i][j]=Matriz_G[i][j];
                            matrizImg_3[i][j]=Matriz_B[i][j];
                        }
                    //wr.setSample(j+Cdx, i+Cdy, 0, matrizImg_2[i+Cdy][j+Cdx]);   
                    }
                }
            }
        }

        ventana1(matrizImg_1,matrizImg_2,matrizImg_3,null);
        //ventana(matrizImg_2,null);
        if(activado==true)
        {
            ventana(matrizImg_1,null);
            guardarImagen(matrizImg_1,path);
        }
        return matrizImg_1;
}
public int [][] ErosionBinario(int [][]matriz, String path, boolean activado)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        int pR, tempR=0, compR, valor=0;
        matrizImg_1=new int [altoMx][anchoNx];
        matrizImg_2=new int [altoMx][anchoNx];
        int dx=3,dy=3, contador=0;
        //Elemento Estructurante
        matrizDilatacion = new int [3][3];
        matrizDilatacion[0][0]=255;
        matrizDilatacion[0][1]=255;
        matrizDilatacion[0][2]=255;
        matrizDilatacion[1][0]=255;
        matrizDilatacion[1][1]=255;
        matrizDilatacion[1][2]=255;
        matrizDilatacion[2][0]=255;
        matrizDilatacion[2][1]=255;
        matrizDilatacion[2][2]=255;
        //Cantidad de datos de erosion
        int cantidad=9;
        /*for(int j= 0; j< anchoNx; j++){
            for(int i=0; i<altoMx; i++){
                tempR=tempR+matriz[i][j];
            }
        }

        compR=tempR/(altoMx*anchoNx);
        
        for(int j= 0; j< anchoNx; j++){
            for(int i=0; i<altoMx; i++){
                if(matriz[i][j]>=compR)
                {
                    pR=255;
                }
                else
                {
                    pR=0;
                }
                //wr.setSample(j, i, 0, pR);
                matrizImg_1[i][j]=pR;
            }
        }
        */
        for(int j= 0; j< anchoNx; j++)
        {
            for(int i=0; i<altoMx; i++)
            {
                if(i==0||i==altoMx-1)
                {
                    matrizImg_2[i][j]=matriz[i][j];
                }
                else
                {
                    if(j==0||j==anchoNx-1)
                    {
                        matrizImg_2[i][j]=matriz[i][j];
                    }
                    else
                    {
                        if(matriz[i][j]==matrizDilatacion[1][1])
                        {
                            for(int Cdx=-1,n=0; Cdx<2;n++,Cdx++)
                            {
                                for(int Cdy=-1,m=0; Cdy<2;m++,Cdy++)
                                {
                                    if(matriz[i+Cdy][j+Cdx]==matrizDilatacion[m][n])
                                    {
                                       contador++; 
                                    }

                                }
                            }
                            if(contador==cantidad)
                            {
                                matrizImg_2[i][j]=matrizDilatacion[1][1];
                            }
                            else
                            {
                                matrizImg_2[i][j]=0;
                            }
                            contador=0;
                        }
                    }
                }
            }
        }
        if(activado==true)
        {
            ventana(matrizImg_2,null);
            guardarImagen(matrizImg_2,path);
        }
        return matrizImg_2;
}
public int [][] ErosionGries(int [][]matriz, String path, boolean activado)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        matrizImg_1=new int [altoMx][anchoNx];
        //Elemento Estructurante
        matrizDilatacion = new int [3][3];
        matrizDilatacion[0][0]=105;
        matrizDilatacion[0][1]=105;
        matrizDilatacion[0][2]=105;
        matrizDilatacion[1][0]=105;
        matrizDilatacion[1][1]=105;
        matrizDilatacion[1][2]=205;
        matrizDilatacion[2][0]=105;
        matrizDilatacion[2][1]=115;
        matrizDilatacion[2][2]=105;

        int dx=3,dy=3;
        
        for(int Cdx=0;Cdx<dx; Cdx++)
        {
            for(int Cdy=0; Cdy<dy; Cdy++)
            {
                for(int j= 0; j< anchoNx; j++){
                    for(int i=0; i<altoMx; i++){
                        if(matriz[i][j]<=matrizDilatacion[Cdy][Cdx])
                        {
                            matrizImg_1[i][j]=matriz[i][j];
                        }
                        else
                        {
                            matrizImg_1[i][j]=matrizDilatacion[Cdy][Cdx];
                        }
                    //wr.setSample(j+Cdx, i+Cdy, 0, matrizImg_2[i+Cdy][j+Cdx]);   
                    }
                }
            }
        }

        ventana(matriz,null);
        //ventana(matrizImg_2,null);
        if(activado==true)
        {
            ventana(matrizImg_1,null);
            guardarImagen(matrizImg_1,path);
        }
        return matrizImg_1;
}
public int [][] GradienteErosionBinario(int [][]matrizErosionada,int [][]matrizOriginal, String path, boolean activado)
{
        int altoMx= matrizErosionada.length;
        int anchoNx= matrizErosionada[0].length;
        matrizImg_3=new int [altoMx][anchoNx];
        
        for(int j= 0; j< anchoNx; j++)
        {
            for(int i=0; i<altoMx; i++)
            {
                if(matrizOriginal[i][j]==255)
                {
                    if(matrizOriginal[i][j]==matrizErosionada[i][j])
                    {
                        matrizImg_3[i][j]=0;
                    }
                    else
                    {
                      matrizImg_3[i][j]=matrizOriginal[i][j];
                    }
                    //matrizImg_1[i][j]=matrizErosionada[i][j];
                }
                else
                {
                    matrizImg_3[i][j]=matrizOriginal[i][j];
                }
                    //wr.setSample(j+Cdx, i+Cdy, 0, matrizImg_2[i+Cdy][j+Cdx]);   
            }
        }
        ventana(matrizOriginal,null);
        ventana(matrizErosionada,null);
        //ventana(matrizImg_2,null);
        if(activado==true)
        {
            ventana(matrizImg_3,"Gradiente Erosion Binaria");
            guardarImagen(matrizImg_3,path);
        }
        return matrizImg_3;
}
public int [][] GradienteDilatacionBinario(int [][]matrizDilatada,int [][]matrizOriginal, String path, boolean activado)
{
         int altoMx= matrizDilatada.length;
        int anchoNx= matrizDilatada[0].length;
        matrizImg_3=new int [altoMx][anchoNx];
        
        for(int j= 0; j< anchoNx; j++)
        {
            for(int i=0; i<altoMx; i++)
            {
                if(matrizDilatada[i][j]==255)
                {
                    if(matrizDilatada[i][j]==matrizOriginal[i][j])
                    {
                        matrizImg_3[i][j]=0;
                    }
                    else
                    {
                      matrizImg_3[i][j]=matrizDilatada[i][j];
                    }
                    //matrizImg_1[i][j]=matrizErosionada[i][j];
                }
                else
                {
                    matrizImg_3[i][j]=matrizDilatada[i][j];
                }
                    //wr.setSample(j+Cdx, i+Cdy, 0, matrizImg_2[i+Cdy][j+Cdx]);   
            }
        }
        ventana(matrizOriginal,null);
        ventana(matrizDilatada,null);
        //ventana(matrizImg_2,null);
        if(activado==true)
        {
            ventana(matrizImg_3,null);
            guardarImagen(matrizImg_3,path);
        }
        return matrizImg_3;
} 
public int [][] GradienteSimetricaBinario(int [][]matrizDilatada,int [][]matrizErosionada, String path, boolean activado)
{
         int altoMx= matrizDilatada.length;
        int anchoNx= matrizDilatada[0].length;
        matrizImg_3=new int [altoMx][anchoNx];
        
        for(int j= 0; j< anchoNx; j++)
        {
            for(int i=0; i<altoMx; i++)
            {
                if(matrizDilatada[i][j]==255)
                {
                    if(matrizDilatada[i][j]==matrizErosionada[i][j])
                    {
                        matrizImg_3[i][j]=0;
                    }
                    else
                    {
                      matrizImg_3[i][j]=matrizDilatada[i][j];
                    }
                    //matrizImg_1[i][j]=matrizErosionada[i][j];
                }
                else
                {
                    matrizImg_3[i][j]=matrizDilatada[i][j];
                }
                    //wr.setSample(j+Cdx, i+Cdy, 0, matrizImg_2[i+Cdy][j+Cdx]);   
            }
        }
        ventana(matrizErosionada,null);
        ventana(matrizDilatada,null);
        //ventana(matrizImg_2,null);
        if(activado==true)
        {
            ventana(matrizImg_3,null);
            guardarImagen(matrizImg_3,path);
        }
        return matrizImg_3;
} 
public int [][] FiltroMaximo(int [][]matriz, String path, boolean activado)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        matrizImg_1=new int [altoMx][anchoNx];
        int Max=0;

        for(int j= 0; j< anchoNx; j++)
        {
            for(int i=0; i<altoMx; i++)
            {
                if(i==0||i==altoMx-1)
                {
                    matrizImg_1[i][j]=matriz[i][j];
                }
                else
                {
                    if(j==0||j==anchoNx-1)
                    {
                        matrizImg_1[i][j]=matriz[i][j];
                    }
                    else
                    {
                        Max=matriz[i][j];
                        for(int Mx=-1;Mx<2;Mx++)
                        {
                            for(int My=-1;My<2;My++)
                            {
                                if(matriz[i+My][j+Mx]>=Max)
                                {
                                    Max=matriz[i+My][j+Mx];
                                }
                            }
                        }
                        matrizImg_1[i][j]=Max;
                    }
                }
            }
        }
        ventana(matriz,null);
        //ventana(matrizImg_2,null);
        if(activado==true)
        {
            ventana(matrizImg_1,null);
            guardarImagen(matrizImg_1,path);
        }
        return matrizImg_1;
}
public int [][] FiltroMedia(int [][]matriz, String path, boolean activado)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        matrizImg_1=new int [altoMx][anchoNx];
        int EC=0;
        //Elemento Estructurante
        matrizMsk = new int [3][3];
        matrizMsk[0][0]=1;
        matrizMsk[0][1]=0;
        matrizMsk[0][2]=1;
        matrizMsk[1][0]=0;
        matrizMsk[1][1]=1;
        matrizMsk[1][2]=0;
        matrizMsk[2][0]=1;
        matrizMsk[2][1]=0;
        matrizMsk[2][2]=1;

        int TM=9;
        for(int j= 0; j< anchoNx; j++)
        {
            for(int i=0; i<altoMx; i++)
            {
                if(i==0||i==altoMx-1)
                {
                    matrizImg_1[i][j]=matriz[i][j];
                }
                else
                {
                    if(j==0||j==anchoNx-1)
                    {
                        matrizImg_1[i][j]=matriz[i][j];
                    }
                    else
                    {
                        EC=((matriz[i-1][j-1]*matrizMsk[0][0])+(matriz[i-1][j]*matrizMsk[0][1])+(matriz[i-1][j+1]*matrizMsk[0][2])+
                           (matriz[i][j-1]*matrizMsk[1][0])+(matriz[i][j]*matrizMsk[1][1])+(matriz[i][j+1]*matrizMsk[1][2])+
                           (matriz[i+1][j-1]*matrizMsk[2][0])+(matriz[i+1][j]*matrizMsk[2][1])+(matriz[i+1][j+1]*matrizMsk[2][2]))/TM;
                        matrizImg_1[i][j]=EC;
                    }
                }
            }
        }
        ventana(matriz,null);
        //ventana(matrizImg_2,null);
        if(activado==true)
        {
            ventana(matrizImg_1,null);
            guardarImagen(matrizImg_1,path);
        }
        return matrizImg_1;
}
public int [][] FiltroMinimo(int [][]matriz, String path, boolean activado)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        matrizImg_1=new int [altoMx][anchoNx];
        int Min=0;

        for(int j= 0; j< anchoNx; j++)
        {
            for(int i=0; i<altoMx; i++)
            {
                if(i==0||i==altoMx-1)
                {
                    matrizImg_1[i][j]=matriz[i][j];
                }
                else
                {
                    if(j==0||j==anchoNx-1)
                    {
                        matrizImg_1[i][j]=matriz[i][j];
                    }
                    else
                    {
                        Min=matriz[i][j];
                        for(int Mx=-1;Mx<2;Mx++)
                        {
                            for(int My=-1;My<2;My++)
                            {
                                if(matriz[i+My][j+Mx]<=Min)
                                {
                                    Min=matriz[i+My][j+Mx];
                                }
                            }
                        }
                        matrizImg_1[i][j]=Min;
                    }
                }
            }
        }
        ventana(matriz,null);
        //ventana(matrizImg_2,null);
        if(activado==true)
        {
            ventana(matrizImg_1,null);
            guardarImagen(matrizImg_1,path);
        }
        return matrizImg_1;
}
public int ordenamiento(int []msk)
{
    int mediana=0, temp,valor; 
    
    for(int i=0; i<9;i++)
    {
        for(int x=0; x<9-1;x++)
        {
            if(msk[x]>msk[x+1])
            {
                temp=msk[x];
                msk[x]=msk[x+1];
                msk[x+1]=temp;
            }
        }
    }
    valor=(9+1)/2;
    mediana=msk[valor];
    return mediana;
}
public int [][] FiltroMediana(int [][]matriz, String path, boolean activado)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        matrizImg_1=new int [altoMx][anchoNx];
        int msk[]= new int [9];
        int Mediana=0;

        for(int j= 0; j< anchoNx; j++)
        {
            for(int i=0; i<altoMx; i++)
            {
                if(i==0||i==altoMx-1)
                {
                    matrizImg_1[i][j]=matriz[i][j];
                }
                else
                {
                    if(j==0||j==anchoNx-1)
                    {
                        matrizImg_1[i][j]=matriz[i][j];
                    }
                    else
                    {
                        msk[0]=matriz[i-1][j-1];
                        msk[1]=matriz[i-1][j];
                        msk[2]=matriz[i-1][j+1];
                        msk[3]=matriz[i][j-1];
                        msk[4]=matriz[i][j];
                        msk[5]=matriz[i][j+1];
                        msk[6]=matriz[i+1][j-1];
                        msk[7]=matriz[i+1][j];
                        msk[8]=matriz[i+1][j+1];
                        
                        Mediana=ordenamiento(msk);
                        matrizImg_1[i][j]=Mediana;
                    }
                }
            }
        }
        ventana(matriz,null);
        //ventana(matrizImg_2,null);
        if(activado==true)
        {
            ventana(matrizImg_1,null);
            guardarImagen(matrizImg_1,path);
        }
        return matrizImg_1;
}
public int [][] FiltroMediaGaussiana(int [][]matriz, String path, boolean activado)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        matrizImg_1=new int [altoMx][anchoNx];
        int contador=0;
        //Elemento Estructurante
        matrizMsk = new int [5][5];

        matrizMsk[0][0]=1;
        matrizMsk[0][1]=4;
        matrizMsk[0][2]=7;
        matrizMsk[0][3]=4;
        matrizMsk[0][4]=1;
        matrizMsk[1][0]=4;
        matrizMsk[1][1]=16;
        matrizMsk[1][2]=26;
        matrizMsk[1][3]=16;
        matrizMsk[1][4]=4;
        matrizMsk[2][0]=7;
        matrizMsk[2][1]=26;
        matrizMsk[2][2]=41;
        matrizMsk[2][3]=26;
        matrizMsk[2][4]=7;
        matrizMsk[3][0]=4;
        matrizMsk[3][1]=16;
        matrizMsk[3][2]=26;
        matrizMsk[3][3]=16;
        matrizMsk[3][4]=4;
        matrizMsk[4][0]=1;
        matrizMsk[4][1]=4;
        matrizMsk[4][2]=7;
        matrizMsk[4][3]=4;
        matrizMsk[4][4]=1;
        int TM=213;
        
        for(int j= 0; j< anchoNx; j++)
        {
            for(int i=0; i<altoMx; i++)
            {
                if(i==0||i==1||i==altoMx||i==altoMx-1||i==altoMx-2)
                {
                    matrizImg_1[i][j]=matriz[i][j];
                }
                
                else
                {
                    if(j==0||j==1||j==anchoNx||j==anchoNx-1||j==anchoNx-2)
                    {
                        matrizImg_1[i][j]=matriz[i][j];
                    }
                    else
                    {
                        //contador=0;
                        for(int k=-2,m=0;k<3;m++,k++)
                        {
                            //System.out.println(i+k);
                            for(int l=-2,n=0; l<3;n++,l++)
                            {
                                //System.out.println(j+l);
                                contador=contador+(matriz[i+l][j+k]*matrizMsk[n][m]);
                            }
                        }
                        matrizImg_1[i][j]= (int)(contador/TM);
                        contador=0;
                    }
                }
            }
        }
        if(activado==true)
        {
            ventana(matrizImg_1,null);
            guardarImagen(matrizImg_1,path);
        }
        return matrizImg_1;
}
public int [][] FiltroRoberts(int [][]matriz, String path, boolean activado)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        matrizImg_1=new int [altoMx][anchoNx];
        matrizImg_2=new int [altoMx][anchoNx];
        matrizImg_3=new int [altoMx][anchoNx];
        int contador=0, resultado=0;
        //Gradiente1
        gradiente1 = new int [2][2];
        gradiente1[0][0]=-1;
        gradiente1[0][1]=0;
        gradiente1[1][0]=0;
        gradiente1[1][1]=1;
        
        //Gradiente2
        gradiente2 = new int [2][2];
        gradiente2[0][0]=0;
        gradiente2[0][1]=-1;
        gradiente2[1][0]=1;
        gradiente2[1][1]=0;

        //gradiente1
        for(int j= 0; j< anchoNx; j++)
        {
            for(int i=0; i<altoMx; i++)
            {
                if(i==0||i==altoMx-1)
                {
                    matrizImg_1[i][j]=matriz[i][j];
                }
                else
                {
                    if(j==0||j==anchoNx-1)
                    {
                        matrizImg_1[i][j]=matriz[i][j];
                    }
                    else
                    {
                        contador=0;
                        for(int k=-1,m=0; k<1;m++, k++)
                       {
                           for(int l=-1,n=0; l<1; n++,l++)
                           {
                               contador=contador+(matriz[i+l][j+k]*gradiente1[n][m]);
                           }
                       }
                       if(contador>=255)
                       {
                           contador=255;
                       }
                       if(contador<0)
                       {
                           contador=0;
                       }
                       matrizImg_1[i][j]=contador;   
                    }    
                }
            }
        }
        //Gradiente2
        for(int j= 0; j< anchoNx; j++)
        {
            for(int i=0; i<altoMx; i++)
            {
                if(i==altoMx-1)
                {
                    matrizImg_2[i][j]=matriz[i][j];
                }
                else
                {
                    if(j==anchoNx-1)
                    {
                        matrizImg_2[i][j]=matriz[i][j];
                    }
                    else
                    {
                        contador=0;
                        for(int k=0; k<2; k++)
                       {
                           for(int l=0; l<2; l++)
                           {
                               contador=contador+ (matriz[i+l][j+k]*gradiente2[l][k]);
                           }
                       }
                       if(contador>=255)
                       {
                           contador=255;
                       }
                       if(contador<0)
                       {
                           contador=0;
                       }
                       matrizImg_2[i][j]=contador;   
                    }    
                }
            }
        }
        
        //SumaDeMsk
        for(int j= 0; j< anchoNx; j++)
        {
            for(int i=0; i<altoMx; i++)
            {
                resultado=matrizImg_1[i][j]+matrizImg_2[i][j];
                if(resultado>255)
                {
                    resultado=255;
                }
                matrizImg_3[i][j]=resultado;
            }
        }
        if(activado==true)
        {
            ventana(matrizImg_3,"Robert");
            guardarImagen(matrizImg_3,path);
        }
        return matrizImg_1;
}
public int [][] FiltroLaplaciano(int [][]matriz, String path, boolean activado)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        matrizImg_1=new int [altoMx][anchoNx];
        int contador=0;
        //MatrizMsk
        matrizMsk = new int [3][3];
        matrizMsk[0][0]=-1;
        matrizMsk[0][1]=-1;
        matrizMsk[0][2]=-1;
        matrizMsk[1][0]=-1;
        matrizMsk[1][1]=8;
        matrizMsk[1][2]=-1;
        matrizMsk[2][0]=-1;
        matrizMsk[2][1]=-1;
        matrizMsk[2][2]=-1;
        
        
        for(int j= 0; j< anchoNx; j++)
        {
            for(int i=0; i<altoMx; i++)
            {
                if(i==0||i==altoMx-1||i==altoMx-2)
                {
                    matrizImg_1[i][j]=matriz[i][j];
                }
                else
                {
                    if(j==0||j==anchoNx-1||j==anchoNx-2)
                    {
                        matrizImg_1[i][j]=matriz[i][j];
                    }
                    else
                    {
                        contador=0;
                        for(int k=0; k<3; k++)
                       {
                           for(int l=0; l<3; l++)
                           {
                               contador=contador+(matriz[i+l][j+k]*matrizMsk[l][k]);
                           }
                       }
                       if(contador>=255)
                       {
                           contador=255;
                       }
                       if(contador<0)
                       {
                           contador=0;
                       }
                       matrizImg_1[i][j]=contador;   
                    }    
                }
            }
        }
      
        if(activado==true)
        {
            ventana(matrizImg_1,"Laplaciano");
            guardarImagen(matrizImg_1,path);
        }
        return matrizImg_1;
}
public int [][] FiltroSobel(int [][]matriz, String path, boolean activado)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        matrizImg_1=new int [altoMx][anchoNx];
        matrizImg_2=new int [altoMx][anchoNx];
        matrizImg_3=new int [altoMx][anchoNx];
        int contador=0, resultado=0;
        //Gradiente1
        gradiente1 = new int [3][3];
        gradiente1[0][0]=1;
        gradiente1[0][1]=2;
        gradiente1[0][2]=1;
        gradiente1[1][0]=0;
        gradiente1[1][1]=0;
        gradiente1[1][2]=0;
        gradiente1[2][0]=-1;
        gradiente1[2][1]=-2;
        gradiente1[2][2]=-1;
        
        //Gradiente2
        gradiente2 = new int [3][3];
        gradiente2[0][0]=-1;
        gradiente2[0][1]=0;
        gradiente2[0][2]=1;        
        gradiente2[1][0]=-2;
        gradiente2[1][1]=0;
        gradiente2[1][2]=2;        
        gradiente2[2][0]=-1;
        gradiente2[2][1]=0;
        gradiente2[2][2]=1;

        //gradiente1
        for(int j= 0; j< anchoNx; j++)
        {
            for(int i=0; i<altoMx; i++)
            {
                if(i==0||i==altoMx-1||i==altoMx-2)
                {
                    matrizImg_1[i][j]=matriz[i][j];
                }
                else
                {
                    if(j==0||j==anchoNx-1||j==anchoNx-2)
                    {
                        matrizImg_1[i][j]=matriz[i][j];
                    }
                    else
                    {
                        contador=0;
                       for(int k=-1,n=0; k<2; n++,k++)
                       {
                           for(int l=-1,m=0; l<2; m++,l++)
                           {
                               contador=contador +(matriz[i+l][j+k]*gradiente1[m][n]);
                           }
                       }
                       if(contador>=255)
                       {
                           contador=255;
                       }
                       if(contador<0)
                       {
                           contador=0;
                       }
                       matrizImg_1[i][j]=contador;   
                    }    
                }
            }
        }
        //Gradiente2
        for(int j= 0; j< anchoNx; j++)
        {
            for(int i=0; i<altoMx; i++)
            {
                if(i==0||i==altoMx-1||i==altoMx-2)
                {
                    matrizImg_2[i][j]=matriz[i][j];
                }
                else
                {
                    if(j==0||j==anchoNx-1||j==anchoNx-2)
                    {
                        matrizImg_2[i][j]=matriz[i][j];
                    }
                    else
                    {
                        contador=0;
                       for(int k=-1,n=0; k<2; n++,k++)
                       {
                           for(int l=-1,m=0; l<2; m++,l++)
                           {
                               contador=contador+(matriz[i+l][j+k]*gradiente2[m][n]);
                           }
                       }
                       if(contador>=255)
                       {
                           contador=255;
                       }
                       if(contador<0)
                       {
                           contador=0;
                       }
                       matrizImg_2[i][j]=contador;   
                    }    
                }
            }
        }
        
        //SumaDeMsk
        for(int j= 0; j< anchoNx; j++)
        {
            for(int i=0; i<altoMx; i++)
            {
                resultado=matrizImg_1[i][j]+matrizImg_2[i][j];
                if(resultado>255)
                {
                    resultado=255;
                }
                matrizImg_3[i][j]=resultado;
            }
        }
        if(activado==true)
        {
            ventana(matrizImg_3,"Sobel");
            guardarImagen(matrizImg_3,path);
        }
        return matrizImg_1;
}
public int [][] FiltroGradienteDigital(int [][]matriz, String path, boolean activado)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        matrizImg_1=new int [altoMx][anchoNx];
        matrizImg_2=new int [altoMx][anchoNx];
        matrizImg_3=new int [altoMx][anchoNx];
        int contador=0, resultado=0;
        //Gradiente1
        gradiente1 = new int [3][3];
        gradiente1[0][0]=0;
        gradiente1[0][1]=0;
        gradiente1[0][2]=0;
        gradiente1[1][0]=-1;
        gradiente1[1][1]=1;
        gradiente1[1][2]=0;
        gradiente1[2][0]=0;
        gradiente1[2][1]=0;
        gradiente1[2][2]=0;
        
        //Gradiente2
        gradiente2 = new int [3][3];
        gradiente2[0][0]=0;
        gradiente2[0][1]=-1;
        gradiente2[0][2]=0;        
        gradiente2[1][0]=0;
        gradiente2[1][1]=1;
        gradiente2[1][2]=0;        
        gradiente2[2][0]=0;
        gradiente2[2][1]=0;
        gradiente2[2][2]=0;

        //gradiente1
        for(int j= 0; j< anchoNx; j++)
        {
            for(int i=0; i<altoMx; i++)
            {
                if(i==0||i==altoMx-1||i==altoMx-2)
                {
                    matrizImg_1[i][j]=matriz[i][j];
                }
                else
                {
                    if(j==0||j==anchoNx-1||j==anchoNx-2)
                    {
                        matrizImg_1[i][j]=matriz[i][j];
                    }
                    else
                    {
                        contador=0;
                       for(int k=-1,n=0; k<2; n++,k++)
                       {
                           for(int l=-1,m=0; l<2; m++,l++)
                           {
                               contador=contador +(matriz[i+l][j+k]*gradiente1[m][n]);
                           }
                       }
                       if(contador>=255)
                       {
                           contador=255;
                       }
                       if(contador<0)
                       {
                           contador=0;
                       }
                       matrizImg_1[i][j]=contador;   
                    }    
                }
            }
        }
        //Gradiente2
        for(int j= 0; j< anchoNx; j++)
        {
            for(int i=0; i<altoMx; i++)
            {
                if(i==0||i==altoMx-1||i==altoMx-2)
                {
                    matrizImg_2[i][j]=matriz[i][j];
                }
                else
                {
                    if(j==0||j==anchoNx-1||j==anchoNx-2)
                    {
                        matrizImg_2[i][j]=matriz[i][j];
                    }
                    else
                    {
                        contador=0;
                       for(int k=-1,n=0; k<2; n++,k++)
                       {
                           for(int l=-1,m=0; l<2; m++,l++)
                           {
                               contador=contador+(matriz[i+l][j+k]*gradiente2[m][n]);
                           }
                       }
                       if(contador>=255)
                       {
                           contador=255;
                       }
                       if(contador<0)
                       {
                           contador=0;
                       }
                       matrizImg_2[i][j]=contador;   
                    }    
                }
            }
        }
        
        //SumaDeMsk
        for(int j= 0; j< anchoNx; j++)
        {
            for(int i=0; i<altoMx; i++)
            {
                resultado=matrizImg_1[i][j]+matrizImg_2[i][j];
                if(resultado>255)
                {
                    resultado=255;
                }
                matrizImg_3[i][j]=resultado;
            }
        }
        if(activado==true)
        {
            ventana(matrizImg_3,"Gradiente Digital");
            guardarImagen(matrizImg_3,path);
        }
        return matrizImg_1;
}
public void DerivadaXBinario(int [][]matriz, String path, boolean activado)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        int pR, tempR=0, compR, valor=0;
        matrizImg_1=new int [altoMx][anchoNx];
        matrizImg_2=new int [altoMx][anchoNx];

        for(int j= 0; j< anchoNx; j++){
            for(int i=0; i<altoMx; i++){
                tempR=tempR+matriz[i][j];
            }
        }

        compR=tempR/(altoMx*anchoNx);
        
        for(int j= 0; j< anchoNx; j++){
            for(int i=0; i<altoMx; i++){
                if(matriz[i][j]>=compR)
                {
                    pR=255;
                }
                else
                {
                    pR=0;
                }
                //wr.setSample(j, i, 0, pR);
                matrizImg_1[i][j]=pR;
            }
        }
        
        for(int j= 0; j< anchoNx-1; j++){
            for(int i=0; i<altoMx; i++){
                valor=Math.abs(matrizImg_1[i][j+1]-matrizImg_1[i][j]);
                matrizImg_2[i][j]=valor;
            }
        }
        
        if(activado==true)
        {
            ventana(matrizImg_2,"Derivada X Binario");
            guardarImagen(matrizImg_2,path);
        }
}
public void DerivadaXGries(int [][]matriz, String path, boolean activado)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        int valor=0;
        matrizImg_1=new int [altoMx][anchoNx];

        for(int j= 0; j< anchoNx-1; j++){
            for(int i=0; i<altoMx; i++){
                valor=Math.abs(matriz[i][j+1]-matriz[i][j]);
                matrizImg_1[i][j]=valor;
            }
        }
        
        if(activado==true)
        {
            ventana(matrizImg_1,"Derivada X Gries");
            guardarImagen(matrizImg_1,path);
        }
}
public void DerivadaYBinario(int [][]matriz, String path, boolean activado)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        int pR, tempR=0, compR, valor=0;
        matrizImg_1=new int [altoMx][anchoNx];
        matrizImg_2=new int [altoMx][anchoNx];

        for(int j= 0; j< anchoNx; j++){
            for(int i=0; i<altoMx; i++){
                tempR=tempR+matriz[i][j];
            }
        }

        compR=tempR/(altoMx*anchoNx);
        
        for(int j= 0; j< anchoNx; j++){
            for(int i=0; i<altoMx; i++){
                if(matriz[i][j]>=compR)
                {
                    pR=255;
                }
                else
                {
                    pR=0;
                }
                //wr.setSample(j, i, 0, pR);
                matrizImg_1[i][j]=pR;
            }
        }
        
        for(int j= 0; j< anchoNx; j++){
            for(int i=0; i<altoMx-1; i++){
                valor=Math.abs(matrizImg_1[i+1][j]-matrizImg_1[i][j]);
                matrizImg_2[i][j]=valor;
            }
        }
        
        if(activado==true)
        {
            ventana(matrizImg_2,"Derivada Y Binario");
            guardarImagen(matrizImg_2,path);
        }
}
public void DerivadaYGries(int [][]matriz, String path, boolean activado)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        int valor=0;
        matrizImg_1=new int [altoMx][anchoNx];

        for(int j= 0; j< anchoNx; j++){
            for(int i=0; i<altoMx-1; i++){
                valor=Math.abs(matriz[i+1][j]-matriz[i][j]);
                matrizImg_1[i][j]=valor;
            }
        }
        
        if(activado==true)
        {
            ventana(matrizImg_1,"Derivada Y");
            guardarImagen(matrizImg_1,path);
        }
}
public int [][] DerivadaMutuaBinaria(int [][]matriz, String path, boolean activado)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        int pR, tempR=0, compR, valor1=0, valor2=0;
        matrizImg_1=new int [altoMx][anchoNx];
        matrizImg_2=new int [altoMx][anchoNx];
        
        for(int j= 0; j< anchoNx; j++){
            for(int i=0; i<altoMx; i++){
                tempR=tempR+matriz[i][j];
            }
        }

        compR=tempR/(altoMx*anchoNx);
        
        for(int j= 0; j< anchoNx; j++){
            for(int i=0; i<altoMx; i++){
                if(matriz[i][j]>=compR)
                {
                    pR=255;
                }
                else
                {
                    pR=0;
                }
                //wr.setSample(j, i, 0, pR);
                matrizImg_1[i][j]=pR;
            }
        }
        
        for(int j= 0; j< anchoNx-1; j++){
            for(int i=0; i<altoMx-1; i++){
                valor1=Math.abs(matrizImg_1[i+1][j]-matrizImg_1[i][j]);
                valor2=Math.abs(matrizImg_1[i][j+1]-matrizImg_1[i][j]);
                matrizImg_2[i][j]=Math.max(valor1,valor2);
            }
        }
        
        if(activado==true)
        {
            ventana(matrizImg_2,"Derivada Mutua Binaria");
            guardarImagen(matrizImg_2,path);
        }
        return matrizImg_2;
}
public int [][] DerivadaMutuaGries(int [][]matriz, String path, boolean activado)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        int valor1=0, valor2=0;
        matrizImg_1=new int [altoMx][anchoNx];
        //System.out.println(anchoNx);
        for(int j= 0; j< anchoNx-2; j++){
            //System.out.println("//////// Ancho= "+j+" ////");
            for(int i=0; i<altoMx-2; i++){
                valor1=Math.abs(matriz[i+1][j]-matriz[i][j]);
                valor2=Math.abs(matriz[i][j+1]-matriz[i][j]);
                //System.out.println(valor1);
                //System.out.println(valor2);
                matrizImg_2[i][j]=Math.max(valor1,valor2);
            }
        }
        
        if(activado==true)
        {
            ventana(matrizImg_2,"Derivada Mutua Gries");
            guardarImagen(matrizImg_2,path);
        }
        return matrizImg_2;
}
public void DerivadaCuadraticaBinaria(int [][]matriz, String path, boolean activado)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        int pR, tempR=0, compR, valor1=0, valor2=0, Nvalor1, Nvalor2;
        matrizImg_1=new int [altoMx][anchoNx];
        matrizImg_2=new int [altoMx][anchoNx];
        
        for(int j= 0; j< anchoNx; j++){
            for(int i=0; i<altoMx; i++){
                tempR=tempR+matriz[i][j];
            }
        }
        compR=tempR/(altoMx*anchoNx);
        
        for(int j= 0; j< anchoNx; j++){
            for(int i=0; i<altoMx; i++){
                if(matriz[i][j]>=compR)
                {
                    pR=255;
                }
                else
                {
                    pR=0;
                }
                //wr.setSample(j, i, 0, pR);
                matrizImg_1[i][j]=pR;
            }
        }

        for(int j= 0; j< anchoNx-1; j++){
            for(int i=0; i<altoMx-1; i++){
                valor1=Math.abs(matrizImg_1[i][j+1]-matrizImg_1[i][j]);
                valor2=Math.abs(matrizImg_1[i+1][j]-matrizImg_1[i][j]);
                Nvalor1= (int)(Math.pow(valor1, 2));
                Nvalor2= (int)(Math.pow(valor2, 2));
                matrizImg_2[i][j]= (int) (Math.sqrt(Nvalor1+Nvalor2)/2);
            }
        }
        
        if(activado==true)
        {
            ventana(matrizImg_2,"Derivada Cuadratica");
            guardarImagen(matrizImg_2,path);
        }
}
public void DerivadaCuadraticaGries(int [][]matriz, String path, boolean activado)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        int pR, tempR=0, compR, valor1=0, valor2=0, Nvalor1, Nvalor2;
        matrizImg_1=new int [altoMx][anchoNx];
        
        for(int j= 0; j< anchoNx-1; j++){
            for(int i=0; i<altoMx-1; i++){
                valor1=Math.abs(matriz[i][j+1]-matriz[i][j]);
                valor2=Math.abs(matriz[i+1][j]-matriz[i][j]);
                Nvalor1= (int)(Math.pow(valor1, 2));
                Nvalor2= (int)(Math.pow(valor2, 2));
                matrizImg_1[i][j]= (int) (Math.sqrt(Nvalor1+Nvalor2));
            }
        }
        
        if(activado==true)
        {
            ventana(matrizImg_1,"Derivada Cuadratica");
            guardarImagen(matrizImg_1,path);
        }
}
public void DerivadaVariableBinaria(int [][]matriz, String path, boolean activado)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        int pR, tempR=0, compR, valor1=0, valor2=0;
        matrizImg_1=new int [altoMx][anchoNx];
        matrizImg_2=new int [altoMx][anchoNx];
        
        for(int j= 0; j< anchoNx; j++){
            for(int i=0; i<altoMx; i++){
                tempR=tempR+matriz[i][j];
            }
        }
        compR=tempR/(altoMx*anchoNx);
        
        for(int j= 0; j< anchoNx; j++){
            for(int i=0; i<altoMx; i++){
                if(matriz[i][j]>=compR)
                {
                    pR=255;
                }
                else
                {
                    pR=0;
                }
                //wr.setSample(j, i, 0, pR);
                matrizImg_1[i][j]=pR;
            }
        }

        for(int j= 0; j< anchoNx-1; j++){
            for(int i=0; i<altoMx-1; i++){
                valor1=Math.abs(matrizImg_1[i][j+1]-matrizImg_1[i][j]);
                valor2=Math.abs(matrizImg_1[i+1][j]-matrizImg_1[i][j]);
                matrizImg_2[i][j]= (int)(Math.abs(valor1+valor2)/2);
            }
        }
        
        if(activado==true)
        {
            ventana(matrizImg_2,"Derivada Variable");
            guardarImagen(matrizImg_2,path);
        }
}
public void DerivadaVariableGries(int [][]matriz, String path, boolean activado)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        int valor1=0, valor2=0;
        matrizImg_1=new int [altoMx][anchoNx];
        
        for(int j= 0; j< anchoNx-1; j++){
            for(int i=0; i<altoMx-1; i++){
                valor1=Math.abs(matriz[i][j+1]-matriz[i][j]);
                valor2=Math.abs(matriz[i+1][j]-matriz[i][j]);
                matrizImg_1[i][j]= (int)(Math.abs(valor1+valor2)/2);
            }
        }
        
        if(activado==true)
        {
            ventana(matrizImg_1,"Derivada Variable");
            guardarImagen(matrizImg_1,path);
        }
}
public void GradienteAproximadaBinaria(int [][]matriz, String path, boolean activado)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        int pR, tempR=0, compR, valor1=0, valor2=0;
        matrizImg_1=new int [altoMx][anchoNx];
        matrizImg_2=new int [altoMx][anchoNx];
        
        for(int j= 0; j< anchoNx; j++){
            for(int i=0; i<altoMx; i++){
                tempR=tempR+matriz[i][j];
            }
        }
        compR=tempR/(altoMx*anchoNx);
        
        for(int j= 0; j< anchoNx; j++){
            for(int i=0; i<altoMx; i++){
                if(matriz[i][j]>=compR)
                {
                    pR=255;
                }
                else
                {
                    pR=0;
                }
                //wr.setSample(j, i, 0, pR);
                matrizImg_1[i][j]=pR;
            }
        }

        for(int j= 0; j< anchoNx-1; j++){
            for(int i=0; i<altoMx-1; i++){
                valor1=Math.abs(matrizImg_1[i+1][j+1]-matrizImg_1[i][j]);
                valor2=Math.abs(matrizImg_1[i+1][j]-matrizImg_1[i][j+1]);
                matrizImg_2[i][j]= (int)(Math.abs(valor1+valor2));
            }
        }
        
        if(activado==true)
        {
            ventana(matrizImg_2,"Gradiente Aproximada");
            guardarImagen(matrizImg_2,path);
        }
}
public void GradienteAproximadaGries(int [][]matriz, String path, boolean activado)
{
        int altoMx= matriz.length;
        int anchoNx= matriz[0].length;
        int valor1=0, valor2=0;
        matrizImg_1=new int [altoMx][anchoNx];
       
        for(int j= 0; j< anchoNx-1; j++){
            for(int i=0; i<altoMx-1; i++){
                valor1=Math.abs(matriz[i+1][j+1]-matriz[i][j]);
                valor2=Math.abs(matriz[i+1][j]-matriz[i][j+1]);
                matrizImg_1[i][j]= (int)(Math.abs(valor1+valor2));
            }
        }
        
        if(activado==true)
        {
            ventana(matrizImg_1,"Gradiente Aproximada");
            guardarImagen(matrizImg_1,path);
        }
}
public int [][] TophatApertura(int [][]matrizOriginal,int [][]matrizApertura, String path, boolean activado)
{
        int altoMx= matrizOriginal.length;
        int anchoNx= matrizOriginal[0].length;
        int comp=0, temp=0, p;
        matrizImg_1=new int [altoMx][anchoNx];
        matrizImg_3=new int [altoMx][anchoNx];
        
                for(int j= 0; j< anchoNx; j++){
            for(int i=0; i<altoMx; i++){
                temp=temp+matrizOriginal[i][j];
            }
        }

        comp=temp/(altoMx*anchoNx);
        
        for(int j= 0; j< anchoNx; j++){
            for(int i=0; i<altoMx; i++){
                if(matrizOriginal[i][j]>=comp)
                {
                    p=255;
                }
                else
                {
                    p=0;
                }
                matrizImg_1[i][j]=p;
            }
        }
        
        for(int j= 0; j< anchoNx; j++)
        {
            for(int i=0; i<altoMx; i++)
            {
                if(matrizImg_1[i][j]==255)
                {
                    if(matrizImg_1[i][j]==matrizApertura[i][j])
                    {
                        matrizImg_3[i][j]=0;
                    }
                    else
                    {
                      matrizImg_3[i][j]=matrizImg_1[i][j];
                    }
                    //matrizImg_1[i][j]=matrizErosionada[i][j];
                }
                else
                {
                    matrizImg_3[i][j]=matrizImg_1[i][j];
                }
                    //wr.setSample(j+Cdx, i+Cdy, 0, matrizImg_2[i+Cdy][j+Cdx]);   
            }
        }
        
        if(activado==true)
        {
            ventana(matrizImg_3,"Top Hat Apertura");
            guardarImagen(matrizImg_3,path);
        }
        return matrizImg_3;
}
public int [][] TophatCierre(int [][]matrizOriginal,int [][]matrizcierre, String path, boolean activado)
{
        int altoMx= matrizOriginal.length;
        int anchoNx= matrizOriginal[0].length;
        int comp=0, temp=0, p;
        matrizImg_1=new int [altoMx][anchoNx];
        matrizImg_3=new int [altoMx][anchoNx];
        
                for(int j= 0; j< anchoNx; j++){
            for(int i=0; i<altoMx; i++){
                temp=temp+matrizOriginal[i][j];
            }
        }

        comp=temp/(altoMx*anchoNx);
        
        for(int j= 0; j< anchoNx; j++){
            for(int i=0; i<altoMx; i++){
                if(matrizOriginal[i][j]>=comp)
                {
                    p=255;
                }
                else
                {
                    p=0;
                }
                matrizImg_1[i][j]=p;
            }
        }
        
        for(int j= 0; j< anchoNx; j++)
        {
            for(int i=0; i<altoMx; i++)
            {
                if(matrizImg_1[i][j]==255)
                {
                    if(matrizcierre[i][j]==matrizImg_1[i][j])
                    {
                        matrizImg_3[i][j]=0;
                    }
                    else
                    {
                      matrizImg_3[i][j]=matrizcierre[i][j];
                    }
                    //matrizImg_1[i][j]=matrizErosionada[i][j];
                }
                else
                {
                    matrizImg_3[i][j]=matrizcierre[i][j];
                }
                    //wr.setSample(j+Cdx, i+Cdy, 0, matrizImg_2[i+Cdy][j+Cdx]);   
            }
        }
        
        if(activado==true)
        {
            ventana(matrizImg_3,"Top Hat Apertura");
            guardarImagen(matrizImg_3,path);
        }
        return matrizImg_3;
}
public void RellenoRegiones(int [][]matrizBordes, String path, boolean activado)
{
        int altoMx= matrizBordes.length;
        int anchoNx= matrizBordes[0].length;
        int  valor1=0, valor2=0, Nvalor1, Nvalor2,Px=0,Py=0;
        matrizImg_1=new int [altoMx][anchoNx];
        matrizImg_2=new int [altoMx][anchoNx];
        matrizImg_3=new int [altoMx][anchoNx];
        ventana(matrizBordes,"Bordes");
        //Negativo
        for(int j= 0; j< anchoNx-1; j++){
            for(int i=0; i<altoMx-1; i++){
                if(matrizBordes[i][j]==255)
                {
                    matrizImg_1[i][j]=0;
                }
                else{
                    matrizImg_1[i][j]=255;
                }
            }
        }
        ventana(matrizImg_1,"Complemento");
        //Xp=0
        for(int j= 0; j< anchoNx; j++){
            for(int i=0; i<altoMx; i++){
                matrizImg_2[i][j]=0;
            }
        }
        
        int bx=0, by=0;
        while(by<altoMx)
        {  
            while(bx<anchoNx)
            {
                if(matrizBordes[by][bx]==255)
                {
                    Px=bx;
                    Py=by;
                }
                bx++;
            }
            by++;
            break;
        }
        matrizImg_2[Py][Px]=255;
        
        
        
        

        if(activado==true)
        {
            ventana(matrizImg_2,"Derivada Cuadratica");
            guardarImagen(matrizImg_2,path);
        }
        
}
public boolean Comparacion(int [][]matriz1)
{
    int altoMx= matriz1.length;
    int anchoNx= matriz1[0].length;
    int Total=altoMx*anchoNx,contador=0,pixeles=0;
    for(int j= 0; j< anchoNx; j++)
    {
        for(int i=0; i<altoMx; i++){
            if(matriz1[i][j]==0)
            {
                contador++;
            }
            else
            {
                pixeles++;
            }
        }
    }
    System.out.println("Total "+Total);
    System.out.println("Contador "+contador);
    System.out.println("Pixeles blancos "+pixeles);
    if((contador+120)>=Total)
    {
        return true;
    }
    else
    {
        return false;
    }
}
public void Esqueleto(int [][]matrizOriginal, String path, boolean activado)
{
    int altoMx= matrizOriginal.length;
    int anchoNx= matrizOriginal[0].length;
    int temp=0,comp, p;
    matrizImg_1=new int [altoMx][anchoNx];
    matrizImg_2=new int [altoMx][anchoNx];
    matrizImg_3=new int [altoMx][anchoNx];
    
    for(int j= 0; j< anchoNx; j++){
        for(int i=0; i<altoMx; i++){
            temp=temp+matrizOriginal[i][j];
        }
    }

    comp=temp/(altoMx*anchoNx);
        
    for(int j= 0; j< anchoNx; j++){
        for(int i=0; i<altoMx; i++){
           if(matrizOriginal[i][j]>=comp)
            {
                p=255;
            }
            else
            {
                p=0;
            }
            matrizImg_2[i][j]=p;
        }
    }
    int l=0;
    while(Comparacion(matrizImg_2)==false)
    {
        l++;
        System.out.println("Prueba "+l);
        for(int j= 0; j< anchoNx; j++)
        {
            for(int i=0; i<altoMx; i++){
                matrizImg_3[i][j]=matrizImg_2[i][j];
            }
        }
        matrizImg_2=ErosionBinario(this.matrizImg_2,path,false);

    }
    if(activado==true)
    {
        ventana(matrizImg_3,"Esqueleto");
        guardarImagen(matrizImg_3,path);
    }
}

@Override
    public void paint(Graphics g) {
        int x=0;
        int y=200;  //valor estandar de y
        int p=0;
        int q=0;
        
        x = img.getWidth(null);// * y/img.getHeight(null);
        y = img.getHeight(null);// * y/img.getHeight(null);
        
//        g.drawImage(img, 100, 100, null);
        g.drawImage(img, 0, 0, x, y, 0, 0, img.getWidth(null), img.getHeight(null), null);
        Graphics2D g2 = (Graphics2D) g;

                for(int i=0;i<1;i++)
            {
                g2.setStroke(new BasicStroke(2.0f));
                p=(int)Math.ceil(200*Math.random());
                q=(int)Math.ceil(200*Math.random());
                g2.draw(new Rectangle2D.Double(p, q,10,10));
                g2.setStroke(new BasicStroke(3.0f));
                p=(int)Math.ceil(200*Math.random());
                q=(int)Math.ceil(200*Math.random());
                g2.draw(new Ellipse2D.Double(p, q,10,10));
            }
      
}
    @Override
    public Dimension getPreferredSize()
    {
        int x=0;
    	int y=200;
        if (img == null)
        {
             return new Dimension(100,100);
        }
        else
        {
             x = img.getWidth(null) ;//* y/img.getHeight(null);
             y = img.getHeight(null);// * y/img.getHeight(null);
             return new Dimension(x, y);
          }
    }
   
     /*Coloca una imagen en una ventana*/
    public static void ventana(int matriz[][],String nombre)
    {
        Imagen imagen=new Imagen(matriz);

    	try
        {
            JFrame f = new JFrame(nombre);
            f.addWindowListener(new WindowAdapter()
            {
                @Override
               public void windowClosing(WindowEvent e)
               {}
            }
         );
             f.add(imagen);
        	 f.pack();
        	 f.setVisible(true);
             f.repaint();
        }
        catch (Exception e)
        {
        }
    }

public static void ventana1(int matrizR[][],int matrizG[][],int matrizB[][],String nombre)
    {
        Imagen imagen=new Imagen(matrizR,matrizG,matrizB);

    	try
        {
            JFrame f = new JFrame(nombre);
            f.addWindowListener(new WindowAdapter()
            {
                @Override
               public void windowClosing(WindowEvent e)
               {}
            }
         );
             f.add(imagen);
        	 f.pack();
        	 f.setVisible(true);
             f.repaint();
        }
        catch (Exception e)
        {
        }
    }

public static void ventana2(int matrizR[][],int matrizG[][],int matrizB[][],String nombre)
{
        Imagen imagen=new Imagen(matrizR,matrizG,matrizB);

    	try
        {
            JFrame f = new JFrame(nombre);
            f.addWindowListener(new WindowAdapter()
            {
                @Override
               public void windowClosing(WindowEvent e)
               {}
            }
         );
             f.add(imagen);
        	 f.pack();
        	 f.setVisible(true);
             f.repaint();
        }
        catch (Exception e)
        {
        }
 }
 /*   public int[] gethistograma(){

        return M;
    }
    
    public void sethistograma(int []matriz){
    this.M=matriz;
    }
*/
    public int[][] getMatrizImg() {

        return matrizImg;
    }
    public int getColumnas() {
        return columnas;
    }
    public int getFilas() {
        return filas;
    }
    public BufferedImage getImg() {
        return img;
    }
    public int[][] getMatrizImg_B() {
        return matrizImg_B;
    }
    public int[][] getMatrizImg_G() {
        return matrizImg_G;
    }
    public int[][] getMatrizImg_R() {
        return matrizImg_R;
    }
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
    public void setFilas(int filas) {
        this.filas = filas;
    }
    public void setMatrizImg(int[][] matrizImg) {
        this.matrizImg = matrizImg;
    }
    public void setImg(BufferedImage img) {
        this.img=img;
    }
    public void setMatrizImg_B(int[][] matrizImg_B) {
        this.matrizImg_B = matrizImg_B;
    }
    public void setMatrizImg_G(int[][] matrizImg_G) {
        this.matrizImg_G = matrizImg_G;
    }
    public void setMatrizImg_R(int[][] matrizImg_R) {
        this.matrizImg_R = matrizImg_R;
    }

}
