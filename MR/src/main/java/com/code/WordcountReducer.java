package com.code;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WordcountReducer extends Reducer {
  protected void reduce(Text key, Iterable<IntWritable> values, Context context) {
    Integer count =0;
    for (IntWritable value:values) {
      count+=value.get();
    }
    try {
      context.write(key,new IntWritable(count));
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

