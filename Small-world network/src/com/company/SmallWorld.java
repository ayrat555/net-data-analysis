package com.company;

/**
 * Created by ayrat on 10/30/15.
 */
public class SmallWorld {

    int n;
    int[][] graph;
    int[][] path;
    double avePath;
    double aveHarmPath;
    int infinity;

    public SmallWorld (int[][] graph, int n, int infinity){
        this.n = n;
        this.graph = graph;
        this.infinity = infinity;
        path = new int[n][n];

    }

    public void floydwarshall(){
        for ( int k = 0; k < n; k++ )
            for ( int i = 0; i < n; i++ )
                for ( int j = 0; j < n; j++ )
                    if (i!=j) {
                        path[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);
                    }
    }

    public void printPath(){
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.print(String.valueOf(path[i][j]) + ' ');
            }
            System.out.println();
        }

    }

    public void averagePath(){
        avePath = 0;
       for (int i=0; i<n;i++){
           for (int j=0; j<n; j++){
               if ((i!=j) || (path[i][j]!=infinity)) {
                   avePath = avePath + path[i][j];
               }
           }
       }
        avePath = avePath/(n*(n-1));
    }

    public void averageHarmonicPath(){
        aveHarmPath = 0;
        for (int i=0; i<n;i++){
            for (int j=0; j<n; j++){
                if ((i!=j) && (path[i][j]!=infinity)) {
                    aveHarmPath = aveHarmPath + 1.0/((double)path[i][j]);

                }
            }
        }
        aveHarmPath = n/aveHarmPath;
    }

    public int[][] getPath(){
        return path;
    }

    public double getAvePath(){
        return avePath;
    }

    public double getAveHarmPath(){
        return aveHarmPath;
    }
}
