package com.code;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class WCMR {
  public static void main(String[] args) {
    Configuration conf = new Configuration();
    Job job = null;
    try {
      job = new Job(conf, "wordcount");
    } catch (IOException e) {
      e.printStackTrace();
    }
    job.setJarByClass(WCMR.class);
    job.setMapperClass(WordcountMapper.class);
    job.setReducerClass(WordcountReducer.class);
    job.setMapOutputKeyClass(Text.class);
    job.setMapOutputValueClass(IntWritable.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    try {
      FileInputFormat.setInputPaths(job, new Path(args[0]));
      FileOutputFormat.setOutputPath(job, new Path(args[1]));
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      boolean b = job.waitForCompletion(true);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

  }
}