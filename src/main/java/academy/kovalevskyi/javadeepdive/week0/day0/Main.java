package academy.kovalevskyi.javadeepdive.week0.day0;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args){


        String text = new String("sadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sd");
        final byte[] bytes = text.getBytes(StandardCharsets.UTF_8);

        Reader reader = new InputStreamReader(new ByteArrayInputStream(bytes));

        StdBufferedReader bufferedReader = new StdBufferedReader(reader,4);

        try {
           char[] chars = bufferedReader.readLine();
            System.out.println(chars);
            System.out.println(bufferedReader.hasNext());
            chars = bufferedReader.readLine();
            System.out.println(chars);
            System.out.println(bufferedReader.hasNext());

        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
