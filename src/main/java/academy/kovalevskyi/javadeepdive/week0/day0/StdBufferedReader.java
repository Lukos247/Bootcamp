package academy.kovalevskyi.javadeepdive.week0.day0;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;


public class StdBufferedReader implements Closeable {


    private char[] charsBuffer;
    private Reader reader;
    private static int defaultCharBufferSize = 5000;
    private int value = 0;
    private int symbolCount = 0;
    private boolean isAvailableNextLine = true;
    private int bz = 100;
    private int bufferCursor = 0;
    private int leng;
    private char[] tempfinal;

    public StdBufferedReader(Reader reader, int bufferSize) {

        this.reader = reader;


         if(reader == null){
             throw new NullPointerException("Null exception");
         }
         if (bufferSize < 0) {
             throw new IllegalArgumentException("can't be negative");
         }
        try {
            if(!reader.ready()){
                isAvailableNextLine = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

       // bufferSize = defaultCharBufferSize;
       bufferSize = 500;
        this.charsBuffer = new char[bufferSize];
   //     charsBuffer = fillna(charsBuffer);
/*
        try {
          //  leng = reader.read(charsBuffer,0,charsBuffer.length);
            tempfinal = new char[leng];
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

    }

    public StdBufferedReader(Reader reader) {

            this(reader, defaultCharBufferSize);

    }



    // Returns true if there is something to read from the reader.
    // False if nothing is there
    public boolean hasNext() throws IOException {
        return isAvailableNextLine;

      //  BufferedReader
    }


 //  public char[] readLine() throws IOException {

 //          for (int i = 0; symbolCount < leng; i++) {
 //              value = charsBuffer[symbolCount];
 //              symbolCount++;
 //              if (value != 10) {
 //                  charsBuffer[i] = (char) value;
 //              } else {
 //                  break;
 //              }
 //          }
 //          charsBuffer = fillna(charsBuffer);


 //      return charsBuffer;

 //  }


    public char[] readLine() throws IOException {
        char[] temp = new char[0];

        while (value != -1) {
                value = reader.read();
                if (value != -1 && value != 10) {
                    if(charsBuffer.length > symbolCount) {
                        char charValue = (char) value;
                        charsBuffer[symbolCount] = charValue;
                    }

                } else {
                    temp = charsBuffer;
                    temp = fillna(temp);
                    charsBuffer = new char[bz];
                    if (symbolCount >= bz) {
                        isAvailableNextLine = false;
                        break;
                    }
                    symbolCount = 0;
                    break;
                }
                bufferCursor++;
                symbolCount++;
        }

        if(value == -1){
            isAvailableNextLine = false;
        }

        return temp;

    }


    // Returns a line (everything till the next line)
   // public char[] readLine() throws IOException {
   //     char[] temp = new char[0];
//
   //     for (int i = 0; i<charsBuffer.length;i++) {
   //         value = charsBuffer[i];
   //         symbolCount++;
   //         if(value != 10) {
   //             tempfinal[i] = (char) value;
   //         }
   //         else {
   //             temp = fillna(tempfinal);
   //             break;
   //         }
   //     }
//
   //     if(value == -1){
   //         isAvailableNextLine = false;
   //     }
//
   //     return temp;

       // for (int i=symbolCount;i<leng;i++) {
       //     value = tempfinal[i];
       //     if (value != 10) {
       //         if(charsBuffer.length > symbolCount) {
       //             char charValue = (char) value;
       //             tempfinal[symbolCount] = charValue;
       //         }
       //     } else {
       //         temp = tempfinal;
       //         temp = fillna(temp);
       //         tempfinal = new char[bz];
       //         if (symbolCount >= bz) {
       //             isAvailableNextLine = false;
       //             break;
       //         }
       //       //  symbolCount = 0;
       //         break;
       //     }
       //     bufferCursor++;
       //     symbolCount++;

        //  System.out.println(symbolCount);


   // }

    private char[] fillna(char[] value){


        // ['A','B',' ',' ',' ']
            char[] tempNew;
           // symbolCount = 0;
            int read = 0;
            for(int i=0;i<value.length;i++){
                if(value[i] != 0){
                    read++;
                }
            }
            tempNew = new char[read];
            for(int i = 0;i<tempNew.length;i++){
                tempNew[i] += value[i];
            }

        return tempNew;


    }




    // close
    public void close() throws IOException {

        defaultCharBufferSize = 0;

        if(reader == null){
            return;
        }
       try {
          reader.close();
       }
       finally {
           charsBuffer = null;
           reader = null;
       }


    }
}
