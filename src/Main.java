//Proj7.2 Run-length decoder
//Shawn Yang
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    static Scanner infile=null;
    static PrintWriter outfile=null;
    static int numRows=0;
    static int numCols=0;
    static int minValue=0;
    static int maxValue=0;
    static int methodUsed=0;
    static int row=0;
    static int col=0;
    static int count;
    static int greyScale=0;
    static Image image=null;

    public static void main(String[] args) {

        if (args.length<2){
            System.out.println("Please provide correct input and output files");
            System.exit(1);
        }
        try{
            infile =new Scanner (new FileReader(args[0]));
            outfile = new PrintWriter(args[1]);
            numRows = infile.nextInt();
            numCols = infile.nextInt();
            minValue = infile.nextInt();
            maxValue = infile.nextInt();
            methodUsed = infile.nextInt();
        } catch (IOException e){
            System.out.println(e);
            System.exit(1);
        }
        outfile.println(numRows+" "+numCols+" "+minValue+" "+maxValue);
        //instantiating data structure
        image = new Image(infile, outfile, numRows, numCols, minValue, maxValue);
        //decoding
        if (methodUsed ==1) {
            System.out.println("Decoding method:"+methodUsed);
            decodeMethod1();
        }
        else if (methodUsed==2){
            System.out.println("Decoding method:"+methodUsed);
            decodeMethod2();
        }
        else if (methodUsed ==3){
            System.out.println("Decoding method:"+methodUsed);
            decodeMethod3();
        }
        else if (methodUsed ==4){
            System.out.println("Decoding method:"+methodUsed);
            decodeMethod4();
        }
        else {
            System.out.println("Wrong Method number.");
            System.exit(1);
        }

        infile.close();
        outfile.close();
    }

    static void decodeMethod1(){
        while (infile.hasNext()) {
            //1 read runlength
        row = infile.nextInt();
        col = infile.nextInt();
        greyScale = infile.nextInt();
        count = infile.nextInt();

        while (count != 0 && col<numCols) {
            //2
            image.imgMatrix[row][col] = greyScale;
            count--;
            col++;
        }//3 repeat 2 until count is 0
    }//4 repeat 1-3 until the end of file.
    //5 output to file
        image.writeToFile();
    }
    //without zero and use wrap-around
    static void decodeMethod2(){
        while (infile.hasNext()) {
            //1 read runlength
            row = infile.nextInt();
            col = infile.nextInt();
            greyScale = infile.nextInt();
            count = infile.nextInt();

            while (count != 0 && col<numCols) {
                //2
                image.imgMatrix[row][col] = greyScale;
                count--;
                col++;
                if (col==numCols){
                    col=0;
                    row++;
                }
            }//3 repeat 2 until count is 0
        }//4 repeat 1-3 until the end of file.
        //5 output to file
        image.writeToFile();

    }
    //with zero, no wrap-around
    static void decodeMethod3(){
        while (infile.hasNext()) {
            //1 read runlength
            row = infile.nextInt();
            col = infile.nextInt();
            greyScale = infile.nextInt();
            count = infile.nextInt();

            while (count != 0 && col<numCols) {
                //2
                image.imgMatrix[row][col] = greyScale;
                count--;
                col++;
            }//3 repeat 2 until count is 0
        }//4 repeat 1-3 until the end of file.
        //5 output to file
        image.writeToFile();
    }
    static void decodeMethod4(){
        while (infile.hasNext()) {
            //1 read runlength
            row = infile.nextInt();
            col = infile.nextInt();
            greyScale = infile.nextInt();
            count = infile.nextInt();

            while (count != 0 && col<numCols) {
                //2
                image.imgMatrix[row][col] = greyScale;
                count--;
                col++;
                if (col==numCols){
                    col=0;
                    row++;
                }
            }//3 repeat 2 until count is 0
        }//4 repeat 1-3 until the end of file.
        //5 output to file
        image.writeToFile();
    }
}
