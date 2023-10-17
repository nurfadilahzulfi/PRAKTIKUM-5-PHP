import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author edd
 */
public class main {
    
        public void solve(double[][] A, double[] B)
        {
            int N = B.length;
            for (int k = 0; k < N; k++) 
            {
                /** mencari baris yang akan di putar **/
                int max = k;
                for (int i = k + 1; i < N; i++) 
                    if (Math.abs(A[i][k]) > Math.abs(A[max][k])) 
                        max = i;

                        /** menukar baris di matriks A **/  
                        double[] temp = A[k]; 
                        A[k] = A[max]; 
                        A[max] = temp;
 
                        /** tukar hasil yang sesuai di matriks konstanta **/
                        double t = B[k]; 
                        B[k] = B[max]; 
                        B[max] = t;
 
                        /** pivot dalam A dan B **/
                        for (int i = k + 1; i < N; i++) 
                        {
                            double factor = A[i][k] / A[k][k];
                            B[i] -= factor * B[k];
                            for (int j = k; j < N; j++) 
                            A[i][j] -= factor * A[k][j];
                        }
            }
 
        /** tampilkan baris eselon **/
        tampilBarisEselon(A, B);
 
        /** back substitution **/
        double[] solution = new double[N];
        for (int i = N - 1; i >= 0; i--) 
        {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++) 
                sum += A[i][j] * solution[j];
            solution[i] = (B[i] - sum) / A[i][i];
        }        
        /** Print solution **/
        printSolusi(solution);
    }

    /** fungsi untuk menampilkan bentuk eselon dalam baris **/
    public void tampilBarisEselon(double[][] A, double[] B)
    {
        int N = B.length;
        System.out.println("\nHasil matriks nya adalah : ");
        for (int i = 0; i < N; i++)
           {
               for (int j = 0; j < N; j++)
                   System.out.printf("%.3f ", A[i][j]);
               System.out.printf("| %.3f\n", B[i]);
           }
           System.out.println();
    }
    /** Fungsi untuk print hasilnya **/
    public void printSolusi(double[] sol)
    {
        int N = sol.length;
        System.out.println("\nHasil X nya adalah : ");
        for (int i = 0; i < N; i++) {
            System.out.print("X" + (i+1) + " = ");
            System.out.printf("%.3f ", sol[i]);
        }
        System.out.println();     
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        System.out.println("Program Eliminasi Gauss\n");
        /** Make an object of GaussianElimination class **/
        Main ge = new Main();
 
        System.out.print("Masukkan jumlah variabel: ");
        int N = scan.nextInt();
 
        double[] B = new double[N];
        double[][] A = new double[N][N];
 
        System.out.println("\nMasukkan "+ N +" angka koefisien persamaan: ");
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                A[i][j] = scan.nextDouble();
 
        System.out.println("\nMasukkan "+ N +" Solusi persamaan: ");
        for (int i = 0; i < N; i++)
            B[i] = scan.nextDouble();
 
        ge.solve(A,B);
    }
    
}