package academy.kovalevskyi.javadeepdive.week0.day0;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;


public class StdBufferedReader implements Closeable {


  //
    private Reader reader;
    private int n = 0;
    private int startNewLine = 0;
    private boolean isAvailableNextLine = false;
    private char[] cbuf;


   // private static int defaultCharBufferSize = 40;



  //  private int value = 0;
  //  private int symbolCount = 0;
  //
  //  private int bz = 100;
  //  private int bufferCursor = 0;
  //  private int leng;
  //  private char[] tempfinal;




    public StdBufferedReader(Reader reader, int bufferSize) {




        if(reader == null){
            throw new NullPointerException("Null exception");
        }
        if (bufferSize < 0) {
            throw new IllegalArgumentException("can't be negative");
        }

        this.reader = reader;
        cbuf = new char[bufferSize];


    }

    public StdBufferedReader(Reader reader) {
        this(reader, 100);


    }



    // Returns true if there is something to read from the reader.
    // False if nothing is there
    public boolean hasNext() throws IOException {
        return isAvailableNextLine || reader.ready();

      //  BufferedReader
    }

    public char[] readLine() throws IOException {
        char[] beforeSeparator;
        char[] tempLine = new char[]{};
        char[] result = new char[]{};


        while (n!=-1){
            if(!isAvailableNextLine){
                if(this.hasNext()){
                    n = reader.read(cbuf,0,cbuf.length);
                    startNewLine = 0;
                }
                else {
                    result =tempLine;
                    return  result;
                }
            }

            for(int i = startNewLine; i<n;i++){
                if(cbuf[i] == 10){
                    isAvailableNextLine = true;
                    beforeSeparator = new char[i - startNewLine];
                    System.arraycopy(cbuf, startNewLine, beforeSeparator,0,beforeSeparator.length);
                    result = (String.valueOf(tempLine) + String.valueOf(beforeSeparator)).toCharArray();
                    startNewLine=i+1;
                    return result;
                }


            }
            isAvailableNextLine = false;
            beforeSeparator = new char[n - startNewLine];
            System.arraycopy(cbuf, startNewLine, beforeSeparator,0,beforeSeparator.length);
            tempLine = (String.valueOf(tempLine) + String.valueOf(beforeSeparator)).toCharArray();
            result = tempLine;
        }

        return result;

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


  // public char[] readLine() throws IOException {
  //     char[] temp = new char[0];

  //     while (value != -1) {
  //             value = reader.read();
  //             if (value != -1 && value != 10) {
  //                 if(charsBuffer.length > symbolCount) {
  //                     char charValue = (char) value;
  //                     charsBuffer[symbolCount] = charValue;
  //                 }

  //             } else {
  //                 temp = charsBuffer;
  //                 temp = fillna(temp);
  //                 charsBuffer = new char[bz];
  //                 if (symbolCount >= bz) {
  //                     isAvailableNextLine = false;
  //                     break;
  //                 }
  //                 symbolCount = 0;
  //                 break;
  //             }
  //             bufferCursor++;
  //             symbolCount++;
  //     }

  //     if(value == -1){
  //         isAvailableNextLine = false;
  //     }

  //     return temp;

  // }


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

        reader.close();

    }
}
