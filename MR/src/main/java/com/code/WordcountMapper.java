package com.code;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordcountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
  protected void map(LongWritable key, Text value, Context context) {
    String line = value.toString();
    String[] words = line.split(" ");
    for (String word : words) {
      try {
        context.write(new Text(word), new IntWritable(1));
      } catch (IOException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
