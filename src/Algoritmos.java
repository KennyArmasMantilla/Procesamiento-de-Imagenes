
public class Algoritmos
{
    int []H= new int[768];
    static int  [][] matriz_R;
    static int  [][] matriz_G;
    static int  [][] matriz_B;

    public static int [][] operadorUmbral(int I[][], int m,int n,int umbral)
    {
        int i,j;
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {   
                if(I[i][j]<=umbral){
                    I[i][j]=0;
                   }

                else{
                    I[i][j]=255;
        
                }
             
            }
        }
        
        return I;
    }
    public static int [][] operadorUmbral2(int I[][], int m,int n,int umbral)
    {
        int i,j;
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                if(I[i][j]<=umbral){
                    I[i][j]=255;
                   }

                else{
                    I[i][j]=0;

                }

            }
        }

        return I;
    }
}
