package com.contentdata;

import java.util.List;
import java.util.stream.Collectors;

public class StreamApiTest
{

      public static void main(String args[])
      {

          String s1 = "BBB";
          String s2 = "cc";
          String s3 = "tttt";

          List<String>  data =    List.of(s1,s2,s3);

          List<String>  dataList =      data.stream().flatMap(S->S.lines()).collect(Collectors.toList());
          System.out.println(dataList);

      }

}
