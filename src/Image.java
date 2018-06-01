import java.io.PrintWriter;
import java.util.Scanner;

public class Image {
    int numRows;
    int numCols;
    int minValue;
    int maxValue;
    Scanner infile;
    PrintWriter outfile;
    int [][] imgMatrix;
    Image(Scanner in_infile, PrintWriter in_outfile, int in_numRows, int in_numCols,
          int in_minValue, int in_maxValue){
        numRows=in_numRows;
        numCols=in_numCols;
        minValue=in_minValue;
        maxValue=in_maxValue;
        infile = in_infile;
        outfile=in_outfile;
        imgMatrix=new int [numRows][numCols];
    }
    void writeToFile(){
        for (int i=0; i<numRows; i++){
            for (int j=0; j<numCols; j++){
                outfile.print(imgMatrix[i][j]+" ");
            }
            outfile.println();
        }
    }
}
