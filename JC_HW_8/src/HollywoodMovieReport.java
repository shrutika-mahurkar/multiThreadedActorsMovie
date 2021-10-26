import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * class HollywoodMovieReport takes the movie related data from text file and sort it according them
 * on the basis of year in ascending order.
 */
public class HollywoodMovieReport {
    public static void main(String[] args) throws IOException {
        //Welcome message
        System.out.println("Welcome to the Hollywood Movie Report");
        System.out.println("Year\tMovie\t\t\tActors");
        //Connect to file
        Path filePath = Paths.get("imdb-output.tsv");
        File fileName = filePath.toFile();
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));

        ArrayList<HollywoodMovie> movieData2 = new ArrayList<>();  //ArrayList to store tokens
        movieData2 = getFileData("imdb.tsv");//Call getFileData Method and store each token in array movieData2
        HollywoodMovie[] array =  movieData2.toArray( new HollywoodMovie[movieData2.size()]); //convert ArrayList to array
        MergeSort.mergeSort(array); //call merge sort method

        int previousYear=0; //Variables to compare year and movies
        int currentYear=0;
        String previousMovie="";
        String currentMovie = "";
        ArrayList<String> alreadyPrinted=new ArrayList<String>();//Arraylist to check whether the movie is already printed
        for (int i=0;i< array.length;i++){//iterate using for loop
            if (alreadyPrinted.contains(array[i].getMovie())){//check if movie already exist
                continue;
            }
            currentMovie = array[i].getMovie();
            currentYear=array[i].getYear();
            if(currentYear!=previousYear){//check if years are different
                System.out.print(StringUtils.padWithSpaces(Integer.toString(currentYear),10));//if yes print that year on console and file
                out.print(StringUtils.padWithSpaces(Integer.toString(currentYear),10));
                previousYear=currentYear;//assign current year to previous year
            }else {
                System.out.print(StringUtils.padWithSpaces("",10));//if no,print blank space on console and file
                out.print(StringUtils.padWithSpaces("",10));

            }


            if(!currentMovie.equalsIgnoreCase(previousMovie)){//check if movies are different
                System.out.print(StringUtils.padWithSpaces(currentMovie,50));//if yes,print that movie on console and file
                out.print(StringUtils.padWithSpaces(currentMovie,50));

                previousMovie=currentMovie;//assign current movie to previous movie
            }else {
                System.out.print(StringUtils.padWithSpaces("",50));//if no,print blank space on console and file
                out.print(StringUtils.padWithSpaces("",50));

            }

            for (int j=i;j< array.length-i;j++) {
                if (currentMovie.equalsIgnoreCase(array[j].getMovie())){
                    if (!alreadyPrinted.contains(array[j].getMovie())){
                        alreadyPrinted.add(array[j].getMovie());
                    }
                    else {
                        System.out.print(StringUtils.padWithSpaces("",10));
                        out.print(StringUtils.padWithSpaces("",10));

                        System.out.print(StringUtils.padWithSpaces("",50));
                        out.print(StringUtils.padWithSpaces("",50));

                    }
                    System.out.println(StringUtils.padWithSpaces(array[j].getActors(),30));
                    out.println(StringUtils.padWithSpaces(array[j].getActors(),30));

                }
                if (array[j].getYear()>currentYear){
                    break;
                }
            }

        }
        System.out.println();
        out.close();
    }

    /**
     * getFileData Method connects to the Database and get all the content of it.
     * split the each and into tokens and stores the object of hollywoodmovie class in  ArrayList.
     * and returns an arraylist of objects.
     */

    public static ArrayList<HollywoodMovie> getFileData(String fileName) throws IOException {
        StringTokenizer strToken;

        ArrayList<HollywoodMovie> moviesData1 = new ArrayList<>();//ArrayList to store tokens
        //Connect to database
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String row = reader.readLine(); // Read first line.
        while (row != null) { //read until the file have data
            strToken = new StringTokenizer(row, "\t"); //Create StringTokenizer object
            //check if StringTokenizer has more tokens
            String actor = strToken.nextToken();
            String movie = strToken.nextToken();
            int year = Integer.parseInt(strToken.nextToken());

            HollywoodMovie movieObject = new HollywoodMovie(actor, movie, year);
            moviesData1.add(movieObject);
            row = reader.readLine();//Read new line

        }
        return moviesData1;
    }


}
